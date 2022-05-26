package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import model.AccountVO;



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
			query.append("		)					");
			
			PreparedStatement ps = conn.prepareStatement(query.toString());
			int idx = 1;
			ps.setString(idx++, account.getDate());
			ps.setString(idx++, account.getContents());
			ps.setInt(idx++, account.getPrice());
			
			
			int cnt = ps.executeUpdate();
			
			if(ps != null) ps.close();
			
			return cnt;
		}
		
		// 내역 조회 (SELECT)
		public AccountVO getAccount(Connection conn, int no) throws SQLException {
			StringBuffer query = new StringBuffer();
			query.append("SELECT					");
			query.append("		  ac_date			");
			query.append("		, ac_contents		");
			query.append("		, ac_price	 		");
			query.append("FROM						");
			query.append("		accounts			");
			query.append("WHERE 1=1					");
			query.append("  AND no = ?				");
			
			PreparedStatement ps = conn.prepareStatement(query.toString());
			
			int idx = 1;
			ps.setInt(idx++, no);
			
			ResultSet rs = ps.executeQuery();
			
			AccountVO result = new AccountVO();
			
			while(rs.next()) {
				result.setDate(rs.getString("date"));
				result.setContents(rs.getString("contents"));
				result.setPrice(rs.getInt("price"));
			}
			
			if(rs != null) rs.close();
			if(ps != null) ps.close();
			
			return result;
		}
		
		// 내역 수정(UPDATE)
		public int updateAcc(Connection conn, AccountVO acc) throws SQLException {
			StringBuffer query = new StringBuffer();
			query.append("UPDATE					");
			query.append("		accounts		  	");
			query.append("SET 						");
			query.append("		ac_date = ?			");
			query.append("	,	ac_contents = ?		");
			query.append("	,	ac_price = ?		");
			query.append("WHERE 1=1					");
			query.append("	AND stu_id = ?			");
			
			PreparedStatement ps = conn.prepareStatement(query.toString());

			int idx = 1;
			ps.setString(idx++, acc.getDate());
			ps.setString(idx++, acc.getContents());
			ps.setInt(idx++, acc.getPrice());
			int cnt = ps.executeUpdate();
			
			if(ps != null) ps.close();
			
			return cnt;
		}
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
