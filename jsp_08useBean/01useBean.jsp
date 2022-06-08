<%@page import="com.study.login.vo.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file = "/WEB-INF/inc/header.jsp" %>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file = "/WEB-INF/inc/top.jsp" %>

자바빈 : 자바규칙을 만족하는 자바 클래스
규칙
1. 패키지가 있어야 한다.
2. 기본 생성자가 있어야 한다.
3. 멤버변수는 private
4. get/set은 public
5. 직렬화(선택사항)
<hr>
<%
	UserVO user = new UserVO();
	UserVO user2 = new UserVO("a004","혁진","123","member");
	System.out.println(user2);
%>
<%=user %> <br>
<%=user2 %>

</body>
</html>