package Hyukjinproj.src.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

import Hyukjinproj.src.model.AccountVO;



public class AccountDao {

private static AccountDao instance = new AccountDao();
	
	public static AccountDao getInstance() {
		if(instance == null) {
			instance = new AccountDao();
		}
		return instance;
	}
	
	private AccountDao() {
		
	}
	
	// 내역 쓰기 (INSERT)
		public int writeAccount(Connection conn, AccountVO account) throws SQLException {
			StringBuffer query = new StringBuffer();
			query.append("INSERT INTO				");
			query.append("		accounts		  	");
			query.append("VALUES	(				");
			query.append("		  ?					");
			query.append("		, ?					");
			query.append("		, ?					");
			query.append("		, ?					");
			query.append("		)					");
			
			PreparedStatement ps = conn.prepareStatement(query.toString());
			int idx = 1;
			ps.setString(idx++, account.getId());
			ps.setString(idx++, account.getDate());
			ps.setString(idx++, account.getContents());
			ps.setInt(idx++, account.getPrice());
			
			
			int cnt = ps.executeUpdate();
			
			if(ps != null) ps.close();
			
			return cnt;
		}
		
		// 내역 조회 (SELECT)
		public ArrayList<AccountVO> getAccount(Connection conn, String memid ) throws SQLException {
			StringBuffer query = new StringBuffer();
			query.append("SELECT					");
			query.append("		  ac_date			");
			query.append("		, ac_contents		");
			query.append("		, ac_price	 		");
			query.append("FROM						");
			query.append("		accounts			");
			query.append("WHERE 1=1					");
			query.append("  AND mem_id = ?			");
			
			PreparedStatement ps = conn.prepareStatement(query.toString());
			
			int idx = 1;
			ps.setString(idx++, memid);
			
			ResultSet rs = ps.executeQuery();
			
			ArrayList<AccountVO> result = new ArrayList<>();
			
			while(rs.next()) {
				AccountVO temp = new AccountVO();
				temp.setDate(rs.getString("ac_date"));
				temp.setContents(rs.getString("ac_contents"));
				temp.setPrice(rs.getInt("ac_price"));
				result.add(temp);
			}
			
			if(rs != null) rs.close();
			if(ps != null) ps.close();
			
			return result;
		}
		
		
	
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
