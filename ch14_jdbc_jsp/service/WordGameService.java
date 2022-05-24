package ch14_jdbc_jsp.service;

import java.sql.*;
import java.util.ArrayList;

import ch14_jdbc_jsp.dao.WordGameDAO;
import ch14_jdbc_jsp.jdbc.ConnectionPool;
import ch14_jdbc_jsp.model.WordGameVO;

public class WordGameService {
	
	private static WordGameService instance = new WordGameService();
	
	private WordGameDAO dao = WordGameDAO.getInstance();
	private ConnectionPool pool = ConnectionPool.getInstance();

	private WordGameService() {
		// SINGLETON PATTERN
	}

	public static WordGameService getInstance() {
		return instance;
	}

	public ArrayList<WordGameVO> getWordList() {
		Connection conn = pool.getConnection();
		try {
			return dao.getWordList(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			pool.releaseConnection(conn);
		}
		return new ArrayList<WordGameVO>();
	}
}
