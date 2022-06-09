<%@page import="java.awt.image.RescaleOp"%>
<%@page import="com.study.common.util.CookieUtils"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="com.study.login.vo.UserVO"%>
<%@page import="com.study.common.util.UserList"%>
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
	String userId = request.getParameter("userId");
	String userPass = request.getParameter("userPass");
	String rememberMe = request.getParameter("rememberMe");
	
	String msg_EMPTY_FIELD = "아이디와 비밀번호 모두 입력해주세요.";
	String msg_WRONG_LOGIN = "아이디 또는 비밀번호가 올바르지 않습니다.";

	if (rememberMe != null) {
		response.addCookie(CookieUtils.createCookie("SAVE_ID", userId, 60 * 60 * 24 * 7));
	} else {
		response.addCookie(CookieUtils.createCookie("SAVE_ID", "", 0));
	}

	if (userId.isEmpty() || userPass.isEmpty()) { // 아이디와 비밀번호 둘 중 하나라도 없을 경우
		response.sendRedirect("login.jsp?msg=" + URLEncoder.encode(msg_EMPTY_FIELD, "UTF-8"));
	} else { // 정상 입력받은 경우
		UserList userList = new UserList();
		UserVO user = userList.getUser(userId);
		if (user != null) { // 해당 아이디가 존재
			if (user.getUserPass().equals(userPass)) { // 비밀번호 일치
		response.addCookie(new Cookie("AUTH", userId));
		response.sendRedirect("login.jsp");
			} else { // 비밀번호 틀림
		response.sendRedirect("login.jsp?msg=" + URLEncoder.encode(msg_WRONG_LOGIN, "UTF-8"));
			}
		} else { // 없는 아이디
			response.sendRedirect("login.jsp?msg=" + URLEncoder.encode(msg_WRONG_LOGIN, "UTF-8"));
		}
	}
	%>

</body>
</html>