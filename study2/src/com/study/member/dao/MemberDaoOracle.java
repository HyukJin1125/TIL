package com.study.member.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.study.exception.DaoException;
import com.study.member.vo.MemberVO;
import com.study.member.service.MemberServiceImpl;
import com.study.member.service.IMemberService;

public class MemberDaoOracle implements IMemberDao{

	@Override
	public List<MemberVO> getMemberList() {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try{
			conn=DriverManager.getConnection("jdbc:apache:commons:dbcp:study");
			
			StringBuffer sb = new StringBuffer();
			sb.append(" SELECT													");
			sb.append("     mem_id			 , mem_pass   , mem_name			");							
			sb.append("     ,TO_CHAR(mem_bir,'YYYY-MM-dd') AS mem_bir		");
			sb.append("     , mem_zip   , mem_add1   , mem_add2				");
			sb.append("     , mem_hp   , mem_mail   , mem_job				");
			sb.append("     , mem_hobby   , mem_mileage   , mem_del_yn		");
			sb.append(" FROM														");
			sb.append("     member    											");
			
			pstmt=conn.prepareStatement(sb.toString());
			rs=pstmt.executeQuery();
			List<MemberVO> memberList=new ArrayList<>();
			while(rs.next()){
				MemberVO member =new MemberVO();
				member.setMemId(	rs.getString("mem_id"));
				member.setMemPass(	rs.getString("mem_pass"));
				member.setMemName(	rs.getString("mem_name"));
				member.setMemBir(	rs.getString("mem_bir"));
				member.setMemZip(	rs.getString("mem_zip"));
				member.setMemAdd1(	rs.getString("mem_add1"));
				member.setMemAdd2(	rs.getString("mem_add2"));
				member.setMemHp(	rs.getString("mem_hp"));
				member.setMemMail(	rs.getString("mem_mail"));
				member.setMemJob(	rs.getString("mem_job"));
				member.setMemHobby(	rs.getString("mem_hobby"));
				member.setMemMileage(	rs.getInt("mem_mileage"));
				member.setMemDelYn(	rs.getString("mem_del_yn"));
	
			return memberList;
			}
		}catch(SQLException e){
		
			throw new DaoException("getmemberList "+e.getMessage());
		}finally{
			if(rs!=null){try{rs.close();}catch(Exception e){}}
			if(pstmt!=null){try{pstmt.close();}catch(Exception e){}}
			if(conn!=null){try{conn.close();}catch(Exception e){}}
		}
		return null;
	}
			
	@Override
	public MemberVO getMember(String memId) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try{
			conn=DriverManager.getConnection("jdbc:apache:commons:dbcp:study");
			
			StringBuffer sb = new StringBuffer();
			sb.append(" SELECT													");
			sb.append("     mem_id			 , mem_pass   , mem_name			");							
			sb.append("     ,TO_CHAR(mem_bir,'YYYY-MM-dd') AS mem_bir		");
			sb.append("     , mem_zip   , mem_add1   , mem_add2				");
			sb.append("     , mem_hp   , mem_mail   , mem_job				");
			sb.append("     , mem_hobby   , mem_mileage   , mem_del_yn		");
			sb.append(" FROM														");
			sb.append("     member    											");
			sb.append(" WHERE mem_id= ?											");     

			pstmt=conn.prepareStatement(sb.toString());
			pstmt.setString(1, memId);
			rs=pstmt.executeQuery();
			
			if(rs.next()){
				MemberVO member =new MemberVO();
				member.setMemId(	rs.getString("mem_id"));
				member.setMemPass(	rs.getString("mem_pass"));
				member.setMemName(	rs.getString("mem_name"));
				member.setMemBir(	rs.getString("mem_bir"));
				member.setMemZip(	rs.getString("mem_zip"));
				member.setMemAdd1(	rs.getString("mem_add1"));
				member.setMemAdd2(	rs.getString("mem_add2"));
				member.setMemHp(	rs.getString("mem_hp"));
				member.setMemMail(	rs.getString("mem_mail"));
				member.setMemJob(	rs.getString("mem_job"));
				member.setMemHobby(	rs.getString("mem_hobby"));
				member.setMemMileage(	rs.getInt("mem_mileage"));
				member.setMemDelYn(	rs.getString("mem_del_yn"));
				
				return member;
			}
		}catch (SQLException e){
			throw new DaoException("get member : "+ e.getMessage());
		}finally{
			if(rs!=null)  {  try{rs.close();}   catch(Exception e){}}
			if(pstmt!=null){try{pstmt.close();} catch(Exception e){}}
			if(conn!=null){try{conn.close();} catch(Exception e){}}
		}	
				
		return null;
	}

	@Override
	public int updateMember(MemberVO member) {
		Connection conn= null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try{
			conn=DriverManager.getConnection("jdbc:apache:commons:dbcp:study");
			
			StringBuffer sb = new StringBuffer();
			sb.append(" UPDATE                   	");
			sb.append("        member    			");
			sb.append(" SET		                 	");
			sb.append("	 mem_pass = ?				");
			sb.append("	,mem_name = ?				");
			sb.append("	,mem_bir = ?		    	");
			sb.append("	,mem_zip = ?				");
			sb.append("	,mem_add1	= ?				");
			sb.append("	,mem_add2	= ?				");
			sb.append("	,mem_hp	= ?				");
			sb.append("	,mem_mail	= ?				");
			sb.append("	,mem_job	= ?				");
			sb.append("	,mem_hobby	= ?				");
			sb.append("		WHERE mem_id=?			");
			
			pstmt=conn.prepareStatement(sb.toString());
			int i=1;
			pstmt.setString(i++,member.getMemPass());
			pstmt.setString(i++,member.getMemName());
			pstmt.setString(i++,member.getMemBir());
			pstmt.setString(i++,member.getMemZip());
			pstmt.setString(i++,member.getMemAdd1());
			pstmt.setString(i++,member.getMemAdd2());
			pstmt.setString(i++,member.getMemHp());
			pstmt.setString(i++,member.getMemMail());
			pstmt.setString(i++,member.getMemJob());
			pstmt.setString(i++,member.getMemHobby());
			pstmt.setString(i++,member.getMemId());
			
			int cnt = pstmt.executeUpdate(); // update 이지만 update, delete, insert 다 된다.
			return cnt;
		}catch(SQLException e ){
			throw new DaoException("updateMember : " + e.getMessage());
		}finally{
			if(rs!=null){try{rs.close();}catch(Exception e){}}
			if(pstmt!=null){try{pstmt.close();}catch(Exception e){}}
			if(conn!=null){try{conn.close();}catch(Exception e){}}
		}
	
	}

	@Override
	public int deleteMember(MemberVO member) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try{
			conn=DriverManager.getConnection("jdbc:apache:commons:dbcp:study");
			StringBuffer sb=new StringBuffer();
			sb.append(" UPDATE member SET		");
			sb.append("		 bo_del_yn='Y'	");
			sb.append("		WHERE bo_id=?		");
			
			pstmt=conn.prepareStatement(sb.toString());
			pstmt.setString(1, member.getMemId());
			
			int cnt = pstmt.executeUpdate(); //update이지만 update,delete,insert 다 됨
			return cnt;
		}catch(SQLException e){
			throw new DaoException("deleteMember : " + e.getMessage());
		}finally{
			if(rs!=null){try{rs.close();}catch(Exception e){}}
			if(pstmt!=null){try{pstmt.close();}catch(Exception e){}}
			if(conn!=null){try{conn.close();}catch(Exception e){}}
		}
	}
	

	@Override
	public int insertMember(MemberVO member) {
		Connection conn= null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try{
			// 연결
			conn=DriverManager.getConnection("jdbc:apache:commons:dbcp:study");
			// 쿼리문 만들기 StringBuffer
			StringBuffer sb = new StringBuffer();
			// 쿼리
			sb.append(" INSERT INTO member (     							");
			sb.append(" mem_id    											");
			sb.append("    , mem_pass   , mem_name   , mem_bir    		");
			sb.append("    , mem_zip   , mem_add1   , mem_add2    		");
			sb.append("    , mem_hp   , mem_mail   , mem_job    			");
			sb.append("    , mem_hobby   , mem_mileage   , mem_del_yn  	");     											
			sb.append("    )VALUES(               							");
		    sb.append("		?        ,?   				,?					");
		    sb.append("		,?        ,?   				,?					");
		    sb.append("		,?        ,?   				,?					");
		    sb.append("		,?        ,?   				,0					");
		    sb.append("	,'N'	)           									");

			pstmt=conn.prepareStatement(sb.toString());
			// ? 세팅 , 쿼티실행
			
			int i =1 ;
			pstmt.setString(i++,member.getMemId());
			pstmt.setString(i++,member.getMemPass());
			pstmt.setString(i++,member.getMemName());
			pstmt.setString(i++,member.getMemBir());
			pstmt.setString(i++,member.getMemZip());
			pstmt.setString(i++,member.getMemAdd1());
			pstmt.setString(i++,member.getMemAdd2());
			pstmt.setString(i++,member.getMemHp());
			pstmt.setString(i++,member.getMemMail());
			pstmt.setString(i++,member.getMemJob());
			pstmt.setString(i++,member.getMemHobby());
			int cnt = pstmt.executeUpdate();

return cnt;
		}catch(SQLException e){
			throw new DaoException("insertMember : " + e.getMessage());
			}finally{
				//종료
				if(rs!=null){try{rs.close();}catch(Exception e){}}
				if(pstmt!=null){try{pstmt.close();}catch(Exception e){}}
				if(conn!=null){try{conn.close();}catch(Exception e){}}
			}
		}
	}
