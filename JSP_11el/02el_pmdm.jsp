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
EL도 언어이다. EL사용중에는 EL이라는 언어의 문법을 따른다.<br>
사칙연산은 기본적으로 산술연산만 지원을 해준다.
<br>
<pre>
${"10"+1 }		문자열 10을 long타입으로 변환 후 10L+1L = 11L 이 된다.
${"10.1"+2 }    문자열 10.1을 Double로 변환 후 연산한다.



</pre>




</body>
</html>