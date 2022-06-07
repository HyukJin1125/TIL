<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
 <%@ page autoFlush="true" buffer="8kb"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 
out이랑 관계가 있습니다. out.print("<html>")
out은 response랑 관련이 있다.
(브라우저에게 전달할)데이터를 임시저장 / 데이터 = html 태그 인 문자열을 말한다. -->
<%-- <html>태그부터 </html>까지 8000byte가 보통 안된다 
	만약 넘어도 autoFlush()해주니깐 괜찮다.
--%>
<%
	long startTime = System.nanoTime();
	for(int i = 0; i<10000; i++){
		out.print("술이 좋아");
		// out.flush();    // 버퍼에 있는거를 브라우저에 전달한다.
		// out.clear();    	 // 버퍼에 있는거를 비운다.
	}
	long endTime = System.nanoTime();
	out.print(endTime-startTime);
%>












</body>
</html>