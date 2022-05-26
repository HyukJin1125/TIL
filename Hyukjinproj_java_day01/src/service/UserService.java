package service;

import java.sql.Connection;
import java.sql.SQLException;

import dao.UserDao;
import jdbc.ConnectionPool;
import model.UserVO;

public class UserService {

		private UserDao dao = UserDao.getInstance();
		private ConnectionPool cp = ConnectionPool.getInstance();
		
		private static UserService instance = new UserService();
		
		public static UserService getInstance() {
			return instance;
		}
	
		// 회원가입 (INSERT)
		public int registMem(UserVO mem) {
			Connection conn = cp.getConnection();
			
			try {
				return dao.registMem(conn, mem);
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				if(conn != null) cp.releaseConnection(conn);
			}
			
			return 0;
		}
		// 중복체크용
		public boolean dupleCheck(String id) {
			Connection conn = cp.getConnection();
			
			try {
				return dao.dupleCheck(conn, id);
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				if(conn != null) cp.releaseConnection(conn);
			}
			
			return false;
		}
	
		// 로그인용
		public UserVO loginMem(String id) {
			Connection conn = cp.getConnection();
			
			try {
				return dao.loginMem(conn, id);
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				if(conn != null) cp.releaseConnection(conn);
			}
			
			return null;
		}
	
	
	
	
}
