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
if, switch case default : if choose when otherwise
test 속성의 값이 "true" 일 때만 안에있는 태그들 사용한다.

<%
	int score = Integer.parseInt(request.getParameter("score"));
 	String name = request.getParameter("name");
	request.setAttribute("score", score);
%>

<%=name %> 점수 :
<c:if test="<%= score==100%>">
	만점	
</c:if>
<c:if test="${score ==100}"> 만점</c:if>
<c:if test="${score>=90 and score <100}">수</c:if>
<c:if test="<%=score>=80 && score <90%>">우</c:if>
<c:choose>
<c:when test = "${score ==100}"></c:when>
<c:when test = "${score >=90 and score <100}">수</c:when>
<c:when test = "${score >=80 and score <90}">우</c:when>
<c:otherwise>미or양or가</c:otherwise>
</c:choose>





</body>
</html>