<%@page import="java.util.ArrayList"%>
<%@page import="com.study.common.vo.ProdVO"%>
<%@page import="com.study.common.util.ProductList"%>
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
04el_collection
list=[], map={"": object},set={}
EL에서 직접 컬렉션 만드는일 없다. java에서 만든거 request.setAttribute해서 EL로 사용한다.
<%
	List<ProdVO>proList=ProductList.getProductList();
	List<ProdVO>prodList2=new ArrayList<>();
	request.setAttribute("proList", proList);
	request.setAttribute("prodList2", prodList2);

%>
<pre>
list : ${ [1,3,5,7,8]}
map : ${{"a":1,"b":2,"c":3} }
set : ${{1,3,5,7,9} }

empty는 보통 컬렉션이랑 같이 사용하는데, 컬렉션이 null이면 true, 값이 없어도 true 이다.
${empty prodList}      ${empty prodList2}
${not empty prodList}  ${not empty prodList2}  
</pre>


</body>
</html>