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

<%
	//BTS
	List<String> memberList=(List<String>)request.getAttribute("memberList");
out.print("<ul>");
for(String member : memberList){
	out.print("<li>"+member);
}
%>
<img alt ="사진" src ="bts.jpg" width="50px" height="50px"> <br>
<img alt ="사진" src ="/study/07pageModule/bts.jpg" width="50px" height="50px"> <br>
<img alt ="사진" src ="<%=request.getContextPath() %>/07pageModule/bts.jpg" width="50px" height="50px"> 








</body>
</html>