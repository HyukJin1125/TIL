<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 사진이 먼저오냐 memberList가 먼저오냐 차이 -->
사진 한장씩 다운받고 쉬는시간
<img alt ="사진" src ="aoa.jpg" width="50px" height="50px"> <br>
<img alt ="사진" src ="/study/07pageModule/aoa.jpg" width="50px" height="50px"> <br>
<img alt ="사진" src ="<%=request.getContextPath() %>/07pageModule/aoa.jpg" width="50px" height="50px"> 

<%
	//AOA
	List<String> memberList=(List<String>)request.getAttribute("memberList");
out.print("<ul>");
for(String member : memberList){
	out.print("<li>"+member);
}

%>


</body>
</html>