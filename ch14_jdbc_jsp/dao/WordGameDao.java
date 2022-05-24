package ch14_jdbc_jsp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ch14_jdbc_jsp.model.StudentVO;

public class WordGameDao {
	
	private static WordGameDao instance = new WordGameDao();
	
	public static WordGameDao getInstance() {
		return instance;
	}
	
	private WordGameDao() {
		
	public ArrayList<WordGameDao> getWordList(Connection conn) throws SQLException{
		StringBuffer query = new StringBuffer();
		query.append("SELECT							");
		query.append("		  stu_id	AS id			");
		query.append("		, stu_name	AS name			");
		query.append("		, stu_password	AS password	");
		query.append("		, stu_score	 AS score		");
		query.append("FROM								");
		query.append("		students					");
		
		PreparedStatement ps = conn.prepareStatement(query.toString());
		
		// 4. 쿼리문 실행과 동시에 결과를 ResultSet 객체에 담는다.
		ResultSet rs = ps.executeQuery();
		
		ArrayList<WordGameDao> result = new ArrayList<>();
		
		// 5. 실행결과인 rs를 이용하여 데이터 조회
		while(rs.next()) {
			WordGameDao temp = new WordGameDao();
			
			temp.setStuId(rs.getString("id"));
			temp.setStuName(rs.getString("name"));
			temp.setStuPassword(rs.getString("password"));
			temp.setStuScore(rs.getInt("score"));
			
			result.add(temp);
		}
		
		if(ps != null) ps.close();
		if(rs != null) rs.close();
		
		return result;
	}
	}
	
}
