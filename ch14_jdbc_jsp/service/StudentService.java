package ch14_jdbc_jsp.service;

import java.sql.*;
import java.util.ArrayList;

import ch14_jdbc_jsp.dao.StudentDAO;
import ch14_jdbc_jsp.jdbc.ConnectionPool;
import ch14_jdbc_jsp.model.StudentVO;

public class StudentService {

	private static StudentService instance = new StudentService();
	
	private StudentDAO dao = StudentDAO.getInstance();
	private ConnectionPool pool = ConnectionPool.getInstance();

	private StudentService() {
		// SINGLETON PATTERN
	}

	public static StudentService getInstance() {
		return instance;
	}

	public ArrayList<StudentVO> getStuList() {
		Connection conn = pool.getConnection();
		try {
			return dao.getStuList(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			pool.releaseConnection(conn);
		}
		return new ArrayList<StudentVO>();
	}

	public int addStu(StudentVO stu) {
		Connection conn = pool.getConnection();
		try {
			return dao.addStu(conn, stu);
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		} finally {
			pool.releaseConnection(conn);
		}
	}

	public StudentVO getStuById(String id) {
		Connection conn = pool.getConnection();
		try {
			return dao.getStuById(conn, id);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			pool.releaseConnection(conn);
		}
	}

}
