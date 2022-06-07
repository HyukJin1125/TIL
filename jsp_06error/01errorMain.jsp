<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="01errorPage.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- NullpointerException 
	  ArrayindexOutOfBounds
	  Cast 등등
-->
<%
	//application.setAttribute("request", request);
	//HttpServletResponse resp=(HttpServletResponse)application.getAttribut;
	
	//NullPointerExcption, null.method(), null+3
	//파랑 에러 화면은 코드노출, 사이트 신뢰성이 없다.
	//에러가 전혀 안나게 만들기는 힘들다. 에러가 났을 때 파란화면 대신 다른화면을 보여주자 
	
	String a = null;
	a.charAt(0);
%>







</body>
</html>