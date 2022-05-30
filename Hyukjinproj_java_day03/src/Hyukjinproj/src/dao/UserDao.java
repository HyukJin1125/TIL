package Hyukjinproj.src.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Hyukjinproj.src.model.UserVO;

public class UserDao {

private static UserDao instance = new UserDao();
	
	private UserDao() {
		
	}
	
	public static UserDao getInstance() {
		return instance;
	}
	
	// 회원가입 (INSERT)
		public int registMem(Connection conn, UserVO mem) throws SQLException {
			StringBuffer query = new StringBuffer();
			query.append("INSERT INTO				");
			query.append("		members			  	");
			query.append("VALUES	(				");
			query.append("		?					");
			query.append("		, ?					");
			query.append("		, ?					");
			query.append("		)					");
			
			PreparedStatement ps = conn.prepareStatement(query.toString());

			int idx = 1;
			ps.setString(idx++, mem.getMemId());
			ps.setString(idx++, mem.getMemPw());
			ps.setInt(idx++, mem.getAge());
			
			int cnt = ps.executeUpdate();
			if(ps != null) ps.close();
			
			return cnt;
		}
		// 중복체크
		public boolean dupleCheck(Connection conn, String id) throws SQLException {
			StringBuffer query = new StringBuffer();
			query.append("SELECT					");
			query.append("		  COUNT(*) AS cnt	");
			query.append("FROM						");
			query.append("		members				");
			query.append("WHERE 1=1					");
			query.append("	AND	mem_id = ?			");
			
			PreparedStatement ps = conn.prepareStatement(query.toString());
			
			int idx = 1;
			ps.setString(idx++, id);
			
			ResultSet rs = ps.executeQuery();
			int cnt = 0;
			
			while(rs.next()) {
				cnt = rs.getInt("cnt");
			}
			
			if(ps != null) ps.close();
			if(rs != null) rs.close();
			
			return (cnt == 1);
		}
	
		// 로그인(SELECT, WhERE)
		public UserVO loginMem(Connection conn, String id) throws SQLException {
			StringBuffer query = new StringBuffer();
			query.append("SELECT					");
			query.append("		  mem_id			");
			query.append("		, mem_pw			");
			query.append("FROM						");
			query.append("		members				");
			query.append("WHERE 1=1					");
			query.append("  AND mem_id = ?			");
			
			PreparedStatement ps = conn.prepareStatement(query.toString());
			
			int idx = 1;
			ps.setString(idx++, id);
			
			ResultSet rs = ps.executeQuery();
			UserVO result = new UserVO();
			
			while(rs.next()) {
				result.setMemId(rs.getString("mem_id"));
				result.setMemPw(rs.getString("mem_pw"));
			}

			if(rs != null) rs.close();
			if(ps != null) ps.close();
			
			return result;
		}
		// 통계(SELECT)
				public ArrayList<UserVO>totalMem(Connection conn) throws SQLException {
					StringBuffer query = new StringBuffer();
//				
//				
					query.append("select age_y * 10   as y                           ");
					query.append("     , avg(mem_sum) as y_avg                       ");
					query.append("from (                                             ");
					query.append("        select  a.mem_id                           ");
					query.append("             ,  a.mem_age                          ");
					query.append("             ,  trunc(a.mem_age/10) as age_y       ");
					query.append("             ,  sum(b.ac_price)     as mem_sum     ");
					query.append("        from members a                             ");
					query.append("           , accounts b                            ");
					query.append("        where a.mem_id = b.mem_id(+)               ");
					query.append("        group by a.mem_id                          ");
					query.append("              ,  a.mem_age                         ");
					query.append("              ,  trunc(a.mem_age/10)               ");
					query.append("      )                                            ");
					query.append("group by age_y * 10                                ");
					
					PreparedStatement ps = conn.prepareStatement(query.toString());
									
					ResultSet rs = ps.executeQuery();
					ArrayList<UserVO> result = new ArrayList<>();
					
					while(rs.next()) {
						UserVO temp = new UserVO(); 
						temp.setAge(rs.getInt("y"));
						temp.setMemPw(Integer.toString(rs.getInt("y_avg")));
						result.add(temp);						
					}

					if(rs != null) rs.close();
					if(ps != null) ps.close();
					
					return result;
				}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
