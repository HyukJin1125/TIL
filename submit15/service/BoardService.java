package hyukjin.submit15.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import hyukjin.submit15.dao.BoardDao;
import hyukjin.submit15.jdbc.ConnectionPool;
import hyukjin.submit15.model.BoardVO;
import hyukjin.submit15.model.MemberVO;

public class BoardService {

	private BoardDao dao = BoardDao.getInstance();
	private ConnectionPool cp = ConnectionPool.getInstance();

	private static BoardService instance = new BoardService();
	
	public static BoardService getInstance() {
		return instance;
	}
	
	private BoardService() {
		
	}
	// 글 리스트
	public ArrayList<BoardVO> getBoardList(){
		Connection conn = cp.getConnection();
		
		try {
			return dao.getBoardList(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(conn != null) cp.releaseConnection(conn);
		}
		
		return new ArrayList<BoardVO>();
	}


	// 글 작성
	public int insertBoard(BoardVO board) {
		Connection conn = cp.getConnection();
		try {
			return dao.insertBoard(conn, board);
		} catch (SQLException e) {
			} finally {
			if(conn != null) cp.releaseConnection(conn);
		}
		return 0;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
