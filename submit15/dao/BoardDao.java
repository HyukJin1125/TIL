package hyukjin.submit15.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ch14_jdbc_jsp.model.StudentVO;
import hyukjin.submit15.model.BoardVO;
import hyukjin.submit15.model.MemberVO;

public class BoardDao {

private static BoardDao instance = new BoardDao();
	
	public static BoardDao getInstance() {
		return instance;
	}
	private BoardDao() {
		
	}
	// 글넣기
	public int insertBoard(Connection conn, BoardVO board) throws SQLException {
		StringBuffer query = new StringBuffer();
		query.append("INSERT INTO				");
		query.append("		board		  		");
		query.append("VALUES	(				");
		query.append("		?					");
		query.append("		, ?					");
		query.append("		, ?					");
		query.append("		, ?					");
		query.append("		, ?					");
		query.append("		)					");
		
		PreparedStatement ps = conn.prepareStatement(query.toString());

		int idx = 1;
		ps.setInt(idx++, board.getNum());
		ps.setString(idx++, board.getUser());
		ps.setString(idx++, board.getDate());
		ps.setString(idx++, board.getTitle());
		ps.setString(idx++, board.getContents());
		
		int cnt = ps.executeUpdate();
		if(ps != null) ps.close();
		
		return cnt;
	}
	// 글 목록 조회(SELECT)
		public ArrayList<BoardVO> getBoardList(Connection conn) throws SQLException{
			StringBuffer query = new StringBuffer();
			query.append("SELECT					");
			query.append("		  bd_num			");
			query.append("		, bd_user			");
			query.append("		, bd_date			");
			query.append("		, bd_title	 		");
			query.append("		, bd_contents		");
			query.append("FROM						");
			query.append("board						");
			query.append("ORDER BY bd_num DESC		");
			
			PreparedStatement ps = conn.prepareStatement(query.toString());
			
			// 4. 쿼리문 실행과 동시에 결과를
			// ResultSet 객체에 담는다.
			ResultSet rs = ps.executeQuery();
			
			ArrayList<BoardVO> result = new ArrayList<>();
			
			// 5. 실행결과인 rs를 이용하여
			// 데이터 조회
			while(rs.next()) {
				BoardVO temp = new BoardVO();
				
				temp.setNum(rs.getInt("num"));
				temp.setUser(rs.getString("user"));
				temp.setDate(rs.getString("date"));
				temp.setTitle(rs.getString("title"));
				temp.setContents(rs.getString("contents"));
				
				result.add(temp);
			}
			
			if(ps != null) ps.close();
			if(rs != null) rs.close();
			
			return result;
		}
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
