package hyukjin.submit15.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;


import hyukjin.submit15.dao.MemberDao;
import hyukjin.submit15.jdbc.ConnectionPool;
import hyukjin.submit15.model.MemberVO;

public class MemberService {
	private MemberDao dao = MemberDao.getInstance();
	private ConnectionPool cp = ConnectionPool.getInstance();
	
	private static MemberService instance = new MemberService();
	
	public static MemberService getInstance() {
		return instance;
	}
	
	private MemberService() {
		
	}
	
	
	// 회원목록 조회(SELECT)
//	public ArrayList<MemberVO> getMemList(){
//		Connection conn = cp.getConnection();
//		
//		try {
//			return dao.getMemList(conn);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			if(conn != null) cp.releaseConnection(conn);
//		}
//		
//		return new ArrayList<MemberVO>();
//	}
	
	// 로그인(SELECT, WHERE)
	public MemberVO loginMem(String id) {
		Connection conn = cp.getConnection();
		
		try {
			return dao.loginMem(conn, id);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(conn != null) cp.releaseConnection(conn);
		}
		
		return new MemberVO();
	}
	
	
	// 회원가입(INSERT)
	public int insertMem(MemberVO mem) {
		Connection conn = cp.getConnection();
		
		try {
			return dao.insertMem(conn, mem);
		} catch (SQLException e) {
			System.out.println("중복된 아이디입니다.");
		} finally {
			if(conn != null) cp.releaseConnection(conn);
		}
		return 0;
	}
	
	// 회원수정(UPDATE)
//	public int updateMem(MemberVO mem) {
//		Connection conn = cp.getConnection();
//		
//		try {
//			return dao.updateMem(conn, mem);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			if(conn != null) cp.releaseConnection(conn);
//		}
//		
//		return 0;
//	}
	
}
