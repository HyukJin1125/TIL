package com.study.free.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import com.study.exception.DaoException;
import com.study.freeboard.vo.FreeBoardSearchVO;
import com.study.freeboard.vo.FreeBoardVO;
public class FreeBoardDaoOracle implements IFreeBoardDao{
    
    @Override
    public int getTotalRowCount(FreeBoardSearchVO searchVO) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DriverManager.getConnection("jdbc:apache:commons:dbcp:study");
            StringBuffer sb = new StringBuffer();
            sb.append(" SELECT count(*)    ");
            sb.append(" FROM free_board        ");
            sb.append(" WHERE bo_del_yn='N'    ");
            
            // searchVO.getSearchWord()!=null && !searchVO.getSearchWord().isEmpty()
            if(StringUtils.isNotBlank(searchVO.getSearchWord())) {
                // 검색어가 있을 때만
                switch(searchVO.getSearchType()) {
                case"T":
                    sb.append(" AND bo_title LIKE '%' || ? || '%'");
                    break;
                case"W":
                    sb.append(" AND bo_writer LIKE '%' || ? || '%'");
                    break;
                case"C":
                    sb.append(" AND bo_content LIKE '%' || ? || '%'");
                    break;
                }
                //null도 아니고, ''도 아니고
                
                //isNull   null일 때만 true
                //isEmpty  '':true, '     ':false
                //isBlank  '':true, '     ':true
            }// 검색어가 있을 때...
            if(StringUtils.isNotBlank(searchVO.getSearchCategory())){
                sb.append(" AND bo_category = ? ");
            }
            
            ps = conn.prepareStatement(sb.toString());
            int index = 1;
            if(StringUtils.isNotBlank(searchVO.getSearchWord())) {
                ps.setString(index++, searchVO.getSearchWord());
            }
            if(StringUtils.isNotBlank(searchVO.getSearchCategory())) {
                ps.setString(index++, searchVO.getSearchCategory());
            }
            
            int count = 0;
            rs = ps.executeQuery();
            if(rs.next()) {
                //count=rs.getInt(count(*));
                count = rs.getInt(1);
            }
            return count;
        }catch(SQLException e) {
            throw new DaoException("getTotalRowCount : "+ e.getMessage());
        }finally{
            if(rs !=null) {try{ rs.close();}catch(Exception e){}}
            if(ps !=null) {try{ ps.close();}catch(Exception e){}}
            if(conn !=null) {try{ conn.close();}catch(Exception e){}}
        }
    }
    
    
    @Override
    public List<FreeBoardVO> getBoardList(FreeBoardSearchVO searchVO) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try{
            conn=DriverManager.getConnection("jdbc:apache:commons:dbcp:study");
            //쿼리문 만들기 StringBuffer
            StringBuffer sb = new StringBuffer();
            
            sb.append(" SELECT * FROM(                                                     ");
            sb.append(" SELECT ROWNUM AS rnum, a.* FROM(                                   ");
            sb.append(" SELECT                                                             ");
            sb.append("      bo_no,        bo_title,     bo_category                   ");
            sb.append("    , bo_writer,    bo_pass,      bo_content                    ");
            sb.append("    , bo_hit                                                            ");
            sb.append("    , to_char(bo_reg_date,'YYYY-MM-dd') AS bo_reg_date          ");
            sb.append("    , to_char(bo_mod_date,'YYYY-MM-dd') AS bo_mod_date          ");
            sb.append("    , bo_del_yn                                                     ");
            sb.append("    , b.comm_nm AS bo_category_nm                                   ");
            sb.append(" FROM   free_board a, comm_code b                                   ");
            sb.append(" WHERE a.bo_category = b.comm_cd                                    ");
            sb.append(" AND bo_del_yn='N'                                                  ");
            
            if (StringUtils.isNotBlank(searchVO.getSearchWord())) {
                switch (searchVO.getSearchType()) {
                case "T":
                    sb.append(" AND bo_title  LIKE '%' || ? || '%'");
                    break;
                case "W":
                    sb.append(" AND bo_writer  LIKE '%' || ? || '%'");
                    break;
                case "C":
                    sb.append(" AND bo_content  LIKE '%' || ? || '%'");
                    break;
                }
            }   // 검색어가 있을 때
            if(StringUtils.isNotBlank(searchVO.getSearchCategory())) {
                sb.append(" AND bo_category = ? ");
            }
            
            sb.append(" ORDER BY bo_no desc                                                    ");
            sb.append(" ) a                                                                    ");
            sb.append(" ) b                                                                    ");
            sb.append(" WHERE rnum between ? AND ?                                         ");
            
            // pstmt 만들기
            ps=conn.prepareStatement(sb.toString());
            // ? 세팅 (?가 있는 경우로)
            int cnt = 1;
            
            if(StringUtils.isNotBlank(searchVO.getSearchWord())) {
                ps.setString(cnt++, searchVO.getSearchWord());
            }
            if(StringUtils.isNotBlank(searchVO.getSearchCategory())) {
                ps.setString(cnt++, searchVO.getSearchCategory());
            }
            ps.setInt(cnt++, searchVO.getFirstRow());
            ps.setInt(cnt++, searchVO.getLastRow());
            
            // rs = pstmt.쿼리실행
            rs = ps.executeQuery();
            //rs가지고 객체 만들어서 req.setAttr
            List<FreeBoardVO> freeBoardList = new ArrayList<>();
            while(rs.next()){
                FreeBoardVO freeBoard = new FreeBoardVO();
                freeBoard.setBoNo(rs.getInt("bo_no"));
                freeBoard.setBoTitle(rs.getString("bo_title"));
                freeBoard.setBoCategory(rs.getString("bo_category"));
                freeBoard.setBoWriter(rs.getString("bo_writer"));
                freeBoard.setBoPass(rs.getString("bo_pass"));
                freeBoard.setBoContent(rs.getString("bo_content"));
                freeBoard.setBoHit(rs.getInt("bo_hit"));
                freeBoard.setBoRegDate(rs.getString("bo_reg_date"));
                freeBoard.setBoModDate(rs.getString("bo_mod_date"));
                freeBoard.setBoDelYn(rs.getString("bo_del_yn"));
                freeBoard.setBoCategoryNm(rs.getString("bo_category_nm"));
                freeBoardList.add(freeBoard);
            }
            return freeBoardList;
            
        }catch (SQLException e){
            // 1번. 아무것도 안함 -> 상사한테 불려감
            // 2번. //e.printStackTrace(); 콘솔에 찍히긴 하는데, 코드는 정상 실행?
            //      SQLException났는데 정상 실행되면 안되지 않나?.. 원래는 파란색화면^~^
            // 3번. 예외 전환 -> 파란화면 까짓거 띄우면 되징
            //SQLException을 DaoException으로 바꿔서 던지자
            //throw를 해도 메소드가 끝남 (=return)
            throw new DaoException("getBoardList : " + e.getMessage());
            
        }finally{
            //종료
            if(rs !=null) {try{ rs.close();}catch(Exception e){}}
            if(ps !=null) {try{ ps.close();}catch(Exception e){}}
            if(conn !=null) {try{ conn.close();}catch(Exception e){}}
        }
    }
    
    @Override
    public FreeBoardVO getBoard(int boNo) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try{
            conn=DriverManager.getConnection("jdbc:apache:commons:dbcp:study");
            StringBuffer sb = new StringBuffer();
            
            sb.append(" SELECT                                                             ");
            sb.append("      bo_no,        bo_title,     bo_category                   ");
            sb.append("    , bo_writer,    bo_pass,      bo_content                    ");
            sb.append("    , bo_hit                                                            ");
            sb.append("    , to_char(bo_reg_date,'YYYY-MM-dd') AS bo_reg_date          ");
            sb.append("    , to_char(bo_mod_date,'YYYY-MM-dd') AS bo_mod_date          ");
            sb.append("    , bo_del_yn                                                     ");
            sb.append("    , b.comm_nm AS bo_category_nm                                   ");
            sb.append(" FROM                                                                   ");
            sb.append("    free_board a, comm_code b                                       ");
            sb.append(" WHERE bo_no= ?                                                         ");
            sb.append(" AND a.bo_category = b.comm_cd                                      ");
            
            ps=conn.prepareStatement(sb.toString());
            ps.setInt(1, boNo);
            rs = ps.executeQuery();
            
            if(rs.next()){
                FreeBoardVO freeBoard = new FreeBoardVO();
                
                freeBoard.setBoNo(rs.getInt("bo_no"));
                freeBoard.setBoTitle(rs.getString("bo_title"));
                freeBoard.setBoCategory(rs.getString("bo_category"));
                freeBoard.setBoWriter(rs.getString("bo_writer"));
                freeBoard.setBoPass(rs.getString("bo_pass"));
                freeBoard.setBoContent(rs.getString("bo_content"));
                freeBoard.setBoHit(rs.getInt("bo_hit"));
                freeBoard.setBoRegDate(rs.getString("bo_reg_date"));
                freeBoard.setBoModDate(rs.getString("bo_mod_date"));
                freeBoard.setBoDelYn(rs.getString("bo_del_yn"));
                freeBoard.setBoCategoryNm(rs.getString("bo_category_nm"));
                return freeBoard;
            }
        }catch(SQLException e){
            throw new DaoException("getBoard : " + e.getMessage());
        }finally{
            if(rs !=null) {try{ rs.close();}catch(Exception e){}}
            if(ps !=null) {try{ ps.close();}catch(Exception e){}}
            if(conn !=null) {try{ conn.close();}catch(Exception e){}}
        }
        return null;
    }
    @Override
    public int increaseHit(int boNo) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn=DriverManager.getConnection("jdbc:apache:commons:dbcp:study");
            StringBuffer sb = new StringBuffer();
            sb.append(" UPDATE free_board SET   ");
            sb.append(" bo_hit = bo_hit+1       ");
            sb.append(" WHERE bo_no = ?             ");
            
            pstmt=conn.prepareStatement(sb.toString());
            pstmt.setInt(1, boNo);
            int cnt = pstmt.executeUpdate();
            return cnt;
            
        }catch (SQLException e){
            throw new DaoException("increaseHit: " + e.getMessage());
        }finally {
            if(rs !=null) {try{ rs.close();}catch(Exception e){}}
            if(pstmt !=null) {try{ pstmt.close();}catch(Exception e){}}
            if(conn !=null) {try{ conn.close();}catch(Exception e){}}
        }
    }
    @Override
    public int updateBoard(FreeBoardVO freeBoard) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        try{
            conn=DriverManager.getConnection("jdbc:apache:commons:dbcp:study");
            StringBuffer sb = new StringBuffer();
            
            sb.append(" UPDATE free_board              ");
            sb.append(" SET                            ");
            sb.append("         bo_title = ?               ");
            sb.append("        ,bo_category = ?            ");
            sb.append("        ,bo_content = ?             ");
            sb.append("        ,bo_mod_date=sysdate        ");
            sb.append(" WHERE bo_no = ?                    ");
            pstmt = conn.prepareStatement(sb.toString());
            int idx = 1;
            pstmt.setString(idx++, freeBoard.getBoTitle());
            pstmt.setString(idx++, freeBoard.getBoCategory());
            pstmt.setString(idx++, freeBoard.getBoContent());
            pstmt.setInt(idx++, freeBoard.getBoNo());
            
            int cnt = pstmt.executeUpdate(); // update이지만 update, delete, insert 다 가능
            return cnt;
            
            
        }catch (SQLException e){
            throw new DaoException("updateBoard : "+ e.getMessage());
        }finally{
            if(rs !=null) {try{ rs.close();}catch(Exception e){}}
            if(pstmt !=null) {try{ pstmt.close();}catch(Exception e){}}
            if(conn !=null) {try{ conn.close();}catch(Exception e){}}
        }
    }
    
    @Override
    public int deleteBoard(FreeBoardVO freeBoard) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DriverManager.getConnection("jdbc:apache:commons:dbcp:study");
            StringBuffer sb = new StringBuffer();
            sb.append("    UPDATE free_board SET                                                           ");
            sb.append("    bo_del_yn = 'Y'                                                                 ");
            sb.append("        WHERE bo_no = ?                                                                 ");
            
            ps = conn.prepareStatement(sb.toString());
            ps.setInt(1, freeBoard.getBoNo());
            
            int cnt = ps.executeUpdate();
            return cnt;
        } catch (SQLException e) {
            throw new DaoException("deleteBoard : "+ e.getMessage());
        } finally {
            // 4. 연결 종료
            if (rs != null) {   try {rs.close();} catch (Exception e) {}}
            if (ps != null) {try {ps.close();} catch (Exception e) {} }
            if (conn != null) {try {    conn.close();   } catch (Exception e) {} }
        }
    }
    @Override
    public int insertBoard(FreeBoardVO freeBoard) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try{
            // 연결
            conn = DriverManager.getConnection("jdbc:apache:commons:dbcp:study");
            
            // 쿼리문
            StringBuffer sb = new StringBuffer();
            sb.append(" INSERT INTO free_board (                               ");
            sb.append("     bo_no                                              ");
            sb.append("     , bo_title    , bo_category    , bo_writer     ");
            sb.append("     , bo_pass     , bo_content     , bo_hit            ");
            sb.append("     , bo_reg_date , bo_mod_date    , bo_del_yn     ");
            sb.append(" ) VALUES (                                             ");
            sb.append(" seq_free_board.nextval, ?  , ?                         ");
            sb.append("    ,   ?       ,   ?           ,   ?                   ");
            sb.append("    ,   0       ,   sysdate     ,   null                    ");
            sb.append("    ,   'N')                                                ");
            
            ps = conn.prepareStatement(sb.toString());
            // ? 세팅, 쿼리실행
            int i = 1;
            
            ps.setString(i++, freeBoard.getBoTitle());
            ps.setString(i++, freeBoard.getBoCategory());
            ps.setString(i++, freeBoard.getBoWriter());
            ps.setString(i++, freeBoard.getBoPass());
            ps.setString(i++, freeBoard.getBoContent());
            int cnt = ps.executeUpdate();
            
            return cnt;
        }catch(SQLException e){
            throw new DaoException("insertBoard : " + e.getMessage());
        }finally{
            if (rs != null) {   try {rs.close();} catch (Exception e) {}}
            if (ps != null) {try {ps.close();} catch (Exception e) {} }
            if (conn != null) {try {    conn.close();   } catch (Exception e) {} }
        }
    }
    @Override
    public List<FreeBoardVO> getBoardList() {
        // TODO Auto-generated method stub
        return null;
    }
}