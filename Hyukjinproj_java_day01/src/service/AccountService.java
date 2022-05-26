package service;

import java.sql.Connection;
import java.sql.SQLException;


import dao.AccountDao;

import jdbc.ConnectionPool;
import model.AccountVO;

public class AccountService {

	private AccountDao dao = AccountDao.getInstance();
	private ConnectionPool cp = ConnectionPool.getInstance();
	
	private static AccountService instance = new AccountService();
	
	public static AccountService getInstance() {
		return instance;
	}
	
	private AccountService() {
		
	}
	
	// 내역쓰기
		public int writeAccount(AccountVO account) {
			Connection conn = cp.getConnection();
			
			try {
				return dao.writeAccount(conn, account);
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				if(conn != null) cp.releaseConnection(conn);
			}
			
			return 0;
		}
	
		// 내역 조회(SELECT)
		public AccountVO getAccount(int no) {
			Connection conn = cp.getConnection();
			
			try {
				return dao.getAccount(conn, no);
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				if(conn != null) cp.releaseConnection(conn);
			}
			
			return null;
		}
		
		// 내역 수정(UPDATE)
		public int updateAcc(AccountVO acc) {
			Connection conn = cp.getConnection();
			
			try {
				return dao.updateAcc(conn, acc);
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				if(conn != null) cp.releaseConnection(conn);
			}
			
			return 0;
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
