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
out.print(request.getAttribute("data")); // request는 그때그때 생성된다.
out.print("<br>");
out.print(application.getAttribute("data")); // application은 서버에 하나있다.
%>


















</body>
</html>