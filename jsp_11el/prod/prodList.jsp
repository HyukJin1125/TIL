<%@page import="java.text.DecimalFormat"%>
<%@page import="com.study.common.vo.ProdVO"%>
<%@page import="java.util.List"%>
<%@page import="com.study.common.util.ProductList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="/WEB-INF/inc/header.jsp" %>
<title>제품 목록</title>
<style>
.prod-list tbody td {border: 1px dashed;}
.prod-list tbody ul {padding-left: 20px;}
.prod-list tbody ul li {list-style: none; line-height: 1.4em;}

.prod-title a ,
.prod-title a:active,
.prod-title a:focus   {text-overflow:ellipsis; text-decoration: none; }

.prod-image {text-align: center;}
.prod-image img {
	 height: 150px; 
}
</style>
</head>
<body>
<div class="container">
<h3>제품 목록</h3>
<table class="prod-list">
	<caption class="hidden"><em>컴퓨터 제품 목록</em></caption>
	<colgroup>
		<col style="width: 33%;">
		<col style="width: 33%;">
		<col />
	</colgroup>



<tbody>
				<%
				DecimalFormat won = new DecimalFormat("###,### 원");
				List<ProdVO> prodList = ProductList.getProductList();
				for (int i = 0; i < prodList.size(); i+=3) {
					%>
					<tr>
					<%
					for (int j = i; j < i+3; j++) {
						%>
						<td>
							<ul>
								<li class="prod-image">
									<a href=<%="prodView.jsp?prodId=" + prodList.get(j).getProdId()%>>
								<img alt="" src=<%=request.getContextPath() + prodList.get(j).getProdImg()%>></a>
								<li class="prod-title">
									<a href=<%="prodView.jsp?prodId=" + prodList.get(j).getProdId()%>><%=prodList.get(j).getProdName()%></a>
								<li class="prod-price"><%=won.format(prodList.get(j).getProdPrice())%>
								<li class="prod-reg-date">등록월 <%=prodList.get(j).getProdRegDate()%>
							</ul>
						</td>
						<%
					}
					%>
					</tr>
					<%
				}
				%>
			</tbody>	

</table>
</div>
</body>
</html>