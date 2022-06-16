
<%@page import="com.study.member.vo.MemberVO"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<%@ include file="/WEB-INF/inc/header.jsp"%>
</head>
<body>
	<%@include file="/WEB-INF/inc/top.jsp"%>



		<div class="alert alert-warning">해당 멤버를 찾을 수 없습니다</div>
		<a href="memberList.jsp" class="btn btn-default btn-sm"> <span class="glyphicon glyphicon-list" aria-hidden="true"></span> &nbsp;목록
		</a>



		<div class="container">
			<h3>상세보기</h3>
			<table class="table table-striped table-bordered">
				<tbody>
					<tr>
						<th>아이디</th>
						<td>아이디</td>
					</tr>
					<tr>
						<th>비밀번호</th>
						<td>비밀번호</td>
					</tr>
					<tr>
						<th>회원명</th>
						<td>회원명</td>
					</tr>
					<tr>
						<th>우편번호</th>
						<td>우편번호</td>
					</tr>
					<tr>
						<th>주소</th>
						<td>주소1  주소2</td>
					</tr>
					<tr>
						<th>생일</th>
						<td><input type="date" name="memBir" class="form-control input-sm" value='' readonly="readonly"></td> <!-- 'YYYY-MM-DD'형태만 value값으로 들어갈수있어요 -->
					</tr>
					<tr>
						<th>핸드폰</th>
						<td>핸드폰</td>
					</tr>
					<tr>
						<th>직업</th>
						<td>직업</td>
					</tr>
					<tr>
						<th>취미</th>
						<td>취미</td>
					</tr>
					<tr>
						<th>마일리지</th>
						<td>마일리지</td>
					</tr>
					<tr>
						<th>탈퇴여부</th>
						<td>탈퇴여부</td>
					</tr>
					<tr>
						<td colspan="2"><a href="memberList.jsp" class="btn btn-default btn-sm"> <span class="glyphicon glyphicon-list" aria-hidden="true"></span> &nbsp;목록
						</a> <a href='memberEdit.jsp?memId=' class="btn btn-info btn-sm"> <span class="glyphicon glyphicon-king" aria-hidden="true"></span> &nbsp;수정
						</a></td>
					</tr>
				</tbody>
			</table>
		</div>


</body>
</html>