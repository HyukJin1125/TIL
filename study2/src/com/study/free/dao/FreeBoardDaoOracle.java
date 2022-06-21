package com.study.free.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.study.exception.DaoException;
import com.study.free.service.FreeBoardServiceImpl;
import com.study.free.service.IFreeBoardService;
import com.study.freeboard.vo.FreeBoardVO;
public class FreeBoardDaoOracle implements IFreeBoardDao{
	
	
	@Override
	public List<FreeBoardVO> getBoardList() {
		// TODO Auto-generated method stub
		// ctrl shift o
		Connection conn = null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try{
			conn=DriverManager.getConnection("jdbc:apache:commons:dbcp:study");
			//쿼리문 만들기 StringBuffer
			StringBuffer sb=new StringBuffer();
			sb.append(" SELECT												    					");
			sb.append("    bo_no         , bo_title      , bo_category					");
			sb.append("    , bo_writer   , bo_pass       , bo_content 					");
			sb.append("    , bo_hit      								    				");
			sb.append("    , TO_CHAR(bo_reg_date,'YYYY-MM-dd') AS bo_reg_date 	    	");
			sb.append("    , TO_CHAR(bo_mod_date,'YYYY-MM-dd')	AS bo_mod_date   	   ");
			sb.append("    , bo_del_yn									    				");
			sb.append(" FROM												  					");
			sb.append("    free_board									    						");
			//pstmt 만들기
			pstmt=conn.prepareStatement(sb.toString());
			//? 세팅 (?가 있는경우만)
			
			//rs=pstmt.쿼리실행
			rs=pstmt.executeQuery();
			//rs가지고 객체 만들어서 req.setAttr
			List<FreeBoardVO> freeBoardList=new ArrayList<>();
			while(rs.next()){
				FreeBoardVO freeBoard=new FreeBoardVO();
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
				freeBoardList.add(freeBoard);
			}
			return freeBoardList;
			//request.setAttribute("freeBoardList", freeBoardList);
		}catch(SQLException e){
			//1번 아무것도 안함. =>불려간다.
			//2번 e.printStackTrace(); 콘솔에 찍히긴 하는데, 코드는 정상 실행??
			// SQLException 났는데 정상 실행 되면 안되지 않나?? 원래는 파란화면...
			//3번 예외 전환 => 파란화면
			//SQLException을 DaoException바꿔서 던지자.
			throw new DaoException("getBoardList "+e.getMessage());
		}finally{
			if(rs!=null){try{rs.close();}catch(Exception e){}}
			if(pstmt!=null){try{pstmt.close();}catch(Exception e){}}
			if(conn!=null){try{conn.close();}catch(Exception e){}}
		}
		
	}
	@Override
	public FreeBoardVO getBoard(int boNo) {
		// TODO Auto-generated method stub
//		int boNo=Integer.parseInt(request.getParameter("boNo"));
//		IFreeBoardService freeBoardService = new FreeBoardServiceImpl();
//		FreeBoardVO freeBoard = freeBoardService.getBoard(boNo);
//		request.setAttribute("freeBoard", freeBoard);
//		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try{
			conn=DriverManager.getConnection("jdbc:apache:commons:dbcp:study");
			StringBuffer sb=new StringBuffer();
			sb.append(" SELECT												    					");
			sb.append("    bo_no         , bo_title      , bo_category					");
			sb.append("    , bo_writer   , bo_pass       , bo_content 					");
			sb.append("    , bo_hit      								    				");
			sb.append("    , TO_CHAR(bo_reg_date,'YYYY-MM-dd') AS bo_reg_date 	    	");
			sb.append("    , TO_CHAR(bo_mod_date,'YYYY-MM-dd')	AS bo_mod_date   	   ");
			sb.append("    , bo_del_yn									    				");
			sb.append(" FROM												  					");
			sb.append("    free_board									    						");
			sb.append(" WHERE bo_no=	? ");
			
			pstmt=conn.prepareStatement(sb.toString());
			pstmt.setInt(1, boNo);
			rs=pstmt.executeQuery();
			
			if(rs.next()){
				FreeBoardVO freeBoard=new FreeBoardVO();
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
				
				return freeBoard;
			}
		}catch(SQLException e){
			throw new DaoException("get Board : "+ e.getMessage());
		}finally{
			if(rs!=null){try{rs.close();}catch(Exception e){}}
			if(pstmt!=null){try{pstmt.close();}catch(Exception e){}}
			if(conn!=null){try{conn.close();}catch(Exception e){}}
		}
		
		return null;
	
	}
	@Override
	public int increaseHit(int boNo) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			conn=DriverManager.getConnection("jdbc:apache:commons:dbcp:study");
			StringBuffer sb=new StringBuffer();
			sb.append(" UPDATE free_board SET 		");
			sb.append(" bo_hit = bo_hit+1		 	");
			sb.append(" WHERE bo_no = ? 			");
			pstmt=conn.prepareStatement(sb.toString());
			pstmt.setInt(1, boNo);
			int cnt = pstmt.executeUpdate();
			return cnt;
		}catch(SQLException e) {
			throw new DaoException("increaseHit : "+ e.getMessage());
		}finally{
			if(rs!=null){try{rs.close();}catch(Exception e){}}
			if(pstmt!=null){try{pstmt.close();}catch(Exception e){}}
			if(conn!=null){try{conn.close();}catch(Exception e){}}
		}
		
		
	}
	@Override
	public int updateBoard(FreeBoardVO freeBoard) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try{
			conn=DriverManager.getConnection("jdbc:apache:commons:dbcp:study");
			StringBuffer sb=new StringBuffer();
			sb.append(" UPDATE free_board SET		");
			sb.append("		 bo_title=?			");
			sb.append("		,bo_category=?		");
			sb.append("		,bo_content=?			");
			sb.append("		,bo_mod_date=sysdate	");
			sb.append("		WHERE bo_no=?			");
			
			pstmt=conn.prepareStatement(sb.toString());
			int i=1;
			pstmt.setString(i++, freeBoard.getBoTitle());
			pstmt.setString(i++, freeBoard.getBoCategory());
			pstmt.setString(i++, freeBoard.getBoContent());
			pstmt.setInt(i++, freeBoard.getBoNo());
			
			int cnt = pstmt.executeUpdate(); //update이지만 update,delete,insert 다 됨
			return cnt;
		}catch(SQLException e){
			throw new DaoException("updateBoard : " + e.getMessage());
		}finally{
			if(rs!=null){try{rs.close();}catch(Exception e){}}
			if(pstmt!=null){try{pstmt.close();}catch(Exception e){}}
			if(conn!=null){try{conn.close();}catch(Exception e){}}
		}
	}
	@Override
	public int deleteBoard(FreeBoardVO freeBoard) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try{
			conn=DriverManager.getConnection("jdbc:apache:commons:dbcp:study");
			StringBuffer sb=new StringBuffer();
			sb.append(" UPDATE free_board SET		");
			sb.append("		 bo_del_yn='Y'			");
			sb.append("		WHERE bo_no=?			");
			
			pstmt=conn.prepareStatement(sb.toString());
			pstmt.setInt(1, freeBoard.getBoNo());
			
			int cnt = pstmt.executeUpdate(); //update이지만 update,delete,insert 다 됨
			return cnt;
		}catch(SQLException e){
			throw new DaoException("deleteBoard : " + e.getMessage());
		}finally{
			if(rs!=null){try{rs.close();}catch(Exception e){}}
			if(pstmt!=null){try{pstmt.close();}catch(Exception e){}}
			if(conn!=null){try{conn.close();}catch(Exception e){}}
		}
	}
	@Override
	public int insertBoard(FreeBoardVO freeBoard) {
		Connection conn= null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try{
			// 연결
			conn=DriverManager.getConnection("jdbc:apache:commons:dbcp:study");
			// 쿼리문 만들기 StringBuffer
			StringBuffer sb = new StringBuffer();
			// 쿼리
			sb.append(" INSERT INTO free_board (     						");
			sb.append("      bo_no  , bo_title  , bo_category    		");
			sb.append("    , bo_writer  , bo_pass    , bo_content		");
			sb.append("    , bo_hit  , bo_reg_date  , bo_mod_date     	");
			sb.append("    , bo_del_yn     									");
			sb.append("    )     											");
			sb.append("    VALUES(               							");
			sb.append("    seq_free_board.nextval  ,?            ,?     ");
			sb.append("           , ?     	, ?       ,  ?            	");
		    sb.append("         	,0      ,sysdate     ,null  			"); 
		    sb.append("			,'N'     									");
		    sb.append("		)           									");

			pstmt=conn.prepareStatement(sb.toString());
			// ? 세팅 , 쿼티실행
			
			int i =1 ;
			pstmt.setString(i++,freeBoard.getBoTitle());
			pstmt.setString(i++,freeBoard.getBoCategory());
			pstmt.setString(i++,freeBoard.getBoWriter());
			pstmt.setString(i++,freeBoard.getBoPass());
			pstmt.setString(i++,freeBoard.getBoContent());
			int cnt = pstmt.executeUpdate();

return cnt;
		}catch(SQLException e){
			throw new DaoException("insertBoard : " + e.getMessage());
			}finally{
				//종료
				if(rs!=null){try{rs.close();}catch(Exception e){}}
				if(pstmt!=null){try{pstmt.close();}catch(Exception e){}}
				if(conn!=null){try{conn.close();}catch(Exception e){}}
			}

	}
}







