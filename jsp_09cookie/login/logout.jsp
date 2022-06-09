<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="/WEB-INF/inc/header.jsp"%>
<%
request.setCharacterEncoding("utf-8");
%>
<title>Insert title here</title>
</head>
<body>
	<%@ include file="/WEB-INF/inc/top.jsp"%>
	<%
	String msg_LOGOUT = "로그아웃 되었습니다.";
	Cookie cookie = new Cookie("AUTH", "");
	cookie.setMaxAge(0);
	response.addCookie(cookie);
	response.sendRedirect("login.jsp?msg=" + URLEncoder.encode(msg_LOGOUT, "UTF-8"));
	%>
</body>
</html>