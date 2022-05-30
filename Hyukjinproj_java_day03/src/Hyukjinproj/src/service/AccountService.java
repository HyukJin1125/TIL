package Hyukjinproj.src.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import Hyukjinproj.src.dao.AccountDao;
import Hyukjinproj.src.model.AccountVO;
import jdbc.ConnectionPool;

public class AccountService {

	private AccountDao dao = AccountDao.getInstance();
	//private ConnectionPool cp = ConnectionPool.getInstance();
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
		public ArrayList<AccountVO> getAccount(String id) {
			Connection conn = cp.getConnection();
			
			try {
				return dao.getAccount(conn, id);
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				if(conn != null) cp.releaseConnection(conn);
			}
			
			return null;
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
