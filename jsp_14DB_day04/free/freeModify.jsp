
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.SQLException"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@include file="/WEB-INF/inc/header.jsp"%>
<title>Insert title here</title>
</head>
<body>
	<%@include file="/WEB-INF/inc/top.jsp"%>
<jsp:useBean id="freeBoard" class= "com.study.freeboard.vo.FreeBoardVO"></jsp:useBean>
<jsp:setProperty property="*" name="freeBoard"/>
<%
Connection conn= null;
PreparedStatement pstmt=null;
ResultSet rs=null;
try{
	conn=DriverManager.getConnection("jdbc:apache:commons:dbcp:study");
	
	StringBuffer sb = new StringBuffer();
	sb.append(" UPDATE                   	");
	sb.append("        free_board    		");
	sb.append(" SET		                  ");
	sb.append("	 bo_title = ?				");
	sb.append("	,bo_category = ?			");
	sb.append("	,BO_CONTENT = ?		    ");
	sb.append("	,bo_mod_date = sysdate	");
	sb.append("		WHERE bo_no=?			");
	
	

	pstmt=conn.prepareStatement(sb.toString());
	int i=1;
	pstmt.setString(i++,freeBoard.getBoTitle());
	pstmt.setString(i++,freeBoard.getBoCategory());
	pstmt.setString(i++,freeBoard.getBoContent());
	pstmt.setInt(i++,freeBoard.getBoNo());
	
	int cnt = pstmt.executeUpdate(); // update 이지만 update, delete, insert 다 된다.

}catch(SQLException e ){
	e.printStackTrace();
}finally{
	if(rs!=null){try{rs.close();}catch(Exception e){}}
	if(pstmt!=null){try{pstmt.close();}catch(Exception e){}}
	if(conn!=null){try{conn.close();}catch(Exception e){}}
}

%>

	<div class="alert alert-warning">해당 글이 존재하지 않습니다.</div>



	<div class="alert alert-warning">수정 실패</div>

	<div class="alert alert-warning">비밀번호가 틀립니다.</div>




	<div class="alert alert-success">정상적으로 수정했습니다.</div>


	<a href="freeView.jsp?boNo=${freeBoard.boNo }" class="btn btn-default btn-sm"> <span
		class="glyphicon glyphicon-list" aria-hidden="true"></span> &nbsp;해당 뷰
	</a>

	<a href="freeList.jsp" class="btn btn-default btn-sm"> <span
		class="glyphicon glyphicon-list" aria-hidden="true"></span> &nbsp;목록
	</a>


</body>
</html>