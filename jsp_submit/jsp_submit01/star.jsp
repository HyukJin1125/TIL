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
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < i + 1; j++) {
				out.print("*");
			}
			out.print("<br>");
		}
	%>
	<%
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < i + 1; j++) {
				out.print("&nbsp&nbsp");
			}
			for (int j = 5 - i; j > 0; j--) {
				out.print("*");
			}
			out.print("<br>");
		}
	%>
	<%
		for (int i = 0; i < 5; i++) {
			for (int j = 5 - i; j > 0; j--) {
				out.print("&nbsp&nbsp");
			}
			for (int j = 0; j < i * 2 + 1; j++) {
				out.print("*");

			}

			out.print("<br>");
		}
	%>

	<%
	for(int i=0; i < 10; i++){
		for(int j=0; j <10; j++){
			if(i==j){
				out.print("*");
			}else{
			//	out.print("&nbsp&nbsp");
			}
		}
			
		}
	
	%>
	*
	<br> **
	<br> ***
	<br> ****
	<br> *****
	<br>

	<hr>
	<hr>
	<hr>

	&nbsp;&nbsp;*****
	<br> &nbsp;&nbsp;&nbsp;&nbsp;****
	<br> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;***
	<br> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;**
	<br> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;*
	<br>

	<hr>
	<hr>
	<hr>

	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;*
	<br> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;***
	<br> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;*****
	<br> &nbsp;&nbsp;&nbsp;&nbsp;*******
	<br> &nbsp;&nbsp;*********
	<br>







</body>
</html>