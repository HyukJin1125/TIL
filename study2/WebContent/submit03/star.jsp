<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<c:forEach begin="1" end="5" var="i" step="1">
	<c:forEach begin="1" end="${i}" var="j" step="1">
		*
	</c:forEach>
<br>
</c:forEach>
<hr>
<c:forEach begin="1" end="5" var="i" step="1">
	<c:forEach begin="1" end="${i}" var="j" step="1">
		&nbsp;&nbsp;
	</c:forEach>
	<c:forEach begin="0" end="${5-i}" var="j" step="1">
		*
	</c:forEach>
	<br>
</c:forEach>
<hr>
<c:forEach begin="1" end="9" var="i" step="2">
	<c:forEach begin="1" end="${(9-i)/2}" var="j" step="1">
		&nbsp;&nbsp;
	</c:forEach>
	<c:forEach begin="1" end="${i}" var="j" step="1">
		*
	</c:forEach>
	<br>
</c:forEach>
<hr>






*<br>
**<br>
***<br>
****<br>
*****<br>

<hr><hr><hr>

&nbsp;&nbsp;*****<br>
&nbsp;&nbsp;&nbsp;&nbsp;****<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;***<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;**<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;*<br>

<hr><hr><hr>

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;*<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;***<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;*****<br>
&nbsp;&nbsp;&nbsp;&nbsp;*******<br>
&nbsp;&nbsp;*********<br>







</body>
</html>