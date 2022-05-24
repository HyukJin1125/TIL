package ch14_jdbc_jsp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ch14_jdbc_jsp.model.WordGameVO;

public class WordGameDAO {
	private static WordGameDAO instance = new WordGameDAO();

	public static WordGameDAO getInstance() {
		return instance;
	}

	private WordGameDAO() {
		// SINGLETON PATTERN
	}

	// 단어 목록 조회
	public ArrayList<WordGameVO> getWordList(Connection conn) throws SQLException {
		PreparedStatement ps = null;
		ResultSet rs = null;

		StringBuffer query = new StringBuffer();
		query.append("SELECT						");
		query.append("	WORD 			AS WORD		");
		query.append("FROM							");
		query.append("	WORD_GAME					");

		ps = conn.prepareStatement(query.toString());
		rs = ps.executeQuery();

		ArrayList<WordGameVO> result = new ArrayList<>();
		while (rs.next()) {
			WordGameVO word = new WordGameVO(rs.getString("WORD"));
			result.add(word);
		}

		if (ps != null)
			ps.close();
		if (rs != null)
			rs.close();

		return result;
	}
}
