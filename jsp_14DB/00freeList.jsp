<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file = "/WEB-INF/inc/header.jsp" %>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file = "/WEB-INF/inc/top.jsp" %>
<%
	// DB 접근시 순서	
	// 1. (oracle)드라이버 로드    
	// 2. 실제 DB(데이터베이스)에 연결
	// 3. 쿼리수행
	// 4. 연결종료
	
	Class.forName("oracle.jdbc.driver.OracleDriver"); // Class.forName
	Connection conn=null;
	Statement stmt=null;
	ResultSet rs=null;
	try{
		conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","jsp","oracle");
	//2 번연결
	stmt=conn.createStatement();	// 쿼리수행 객체
	rs=stmt.executeQuery("SELECT * FROM free_board");    // 쿼리 수행, rs는 쿼리수행 결과 저장 객체(rs는 select에만 저장하는 객체이다)
	while(rs.next()){
		out.print("글번호 : "+rs.getInt("bo_no") + " , ");
		out.print("글제목 : "+rs.getString("bo_no") + " , ");
		out.print("글작성자 : "+rs.getString("bo_no") + " ,  <br>");
	}
	}catch(SQLException e){
		e.printStackTrace();
		
	}finally{
		// 연결종료
	}

%>





</body>
</html>