package ch14_jdbc_jsp.dao;

import java.sql.*;
import java.util.ArrayList;

import ch14_jdbc_jsp.model.StudentVO;

public class StudentDAO {

	private static StudentDAO instance = new StudentDAO();

	public static StudentDAO getInstance() {
		return instance;
	}

	private StudentDAO() {
		// SINGLETON PATTERN
	}

	// 학생 목록 조회
	public ArrayList<StudentVO> getStuList(Connection conn) throws SQLException {
		PreparedStatement ps = null;
		ResultSet rs = null;

		StringBuffer query = new StringBuffer();
		query.append("SELECT						");
		query.append("	stu_id 			AS stuId,	");
		query.append("	stu_name 		AS stuName,	");
		query.append("	stu_password 	AS stuPw,	");
		query.append("	stu_score 		AS stuScore	");
		query.append("FROM							");
		query.append("	students					");

		ps = conn.prepareStatement(query.toString());
		rs = ps.executeQuery();

		ArrayList<StudentVO> result = new ArrayList<>();
		while (rs.next()) {
			String stuId = rs.getString("stuId");
			String stuName = rs.getString("stuName");
			String stuPw = rs.getString("stuPw");
			int stuScore = rs.getInt("stuScore");
			result.add(new StudentVO(stuId, stuName, stuPw, stuScore));
		}

		if (ps != null)
			ps.close();
		if (rs != null)
			rs.close();

		return result;
	}

	// 회원 가입
	public int addStu(Connection conn, StudentVO student) throws SQLException {
		PreparedStatement ps = null;

		StringBuffer query = new StringBuffer();
		query.append("INSERT INTO					");
		query.append("	students					");
		query.append("VALUES (						");
		query.append("	?,							");
		query.append("	?,							");
		query.append("	?,							");
		query.append("	?							");
		query.append(")								");

		int idx = 1;
		ps = conn.prepareStatement(query.toString());
		ps.setString(idx++, student.getStuId());
		ps.setString(idx++, student.getStuName());
		ps.setString(idx++, student.getStuPw());
		ps.setInt(idx++, student.getStuScore());

		int result = ps.executeUpdate();

		if (ps != null)
			ps.close();

		return result;
	}

	// 로그인
	public StudentVO getStuById(Connection conn, String id) throws SQLException {
		PreparedStatement ps = null;
		ResultSet rs = null;

		StringBuffer query = new StringBuffer();
		query.append("SELECT						");
		query.append("	stu_id 			AS stuId,	");
		query.append("	stu_name 		AS stuName,	");
		query.append("	stu_password 	AS stuPw,	");
		query.append("	stu_score 		AS stuScore	");
		query.append("FROM							");
		query.append("	students					");
		query.append("WHERE 1=1						");
		query.append("	AND stu_id = ?				");

		ps = conn.prepareStatement(query.toString());
		int idx = 1;
		ps = conn.prepareStatement(query.toString());
		ps.setString(idx++, id);
		rs = ps.executeQuery();

		StudentVO result = new StudentVO();
		while (rs.next()) {
			result.setStuId(rs.getString("stuId"));
			result.setStuName(rs.getString("stuName"));
			result.setStuPw(rs.getString("stuPw"));
			result.setStuScore(Integer.parseInt(rs.getString("stuScore")));
		}

		if (ps != null)
			ps.close();
		if (rs != null)
			rs.close();

		return result;
	}
}
