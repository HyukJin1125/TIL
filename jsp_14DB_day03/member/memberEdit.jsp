
<%@page import="com.study.member.vo.MemberVO"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<!DOCTYPE html>
<html lang="ko">
<head>
	<%@ include file="/WEB-INF/inc/header.jsp" %>
</head>
<body>
<%@include file="/WEB-INF/inc/top.jsp"%>



	
		<div class="alert alert-warning">해당 멤버를 찾을 수 없습니다</div>
		<a href="memberList.jsp" class="btn btn-default btn-sm"> <span class="glyphicon glyphicon-list" aria-hidden="true"></span> &nbsp;목록
		</a>



 <div class="container">	
	<h3>회원 정보 수정</h3>	
	<form action="memberModify.jsp" method="post" >
	<table class="table table-striped table-bordered">
		<tbody>
			<tr>
				<th>아이디</th>
				<td>아이디는 못바꾸지만 데이터는 넘어가야지 <input type="hidden" name="memId" value=""></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="memPass" class="form-control input-sm" 
						    pattern="\w{4,}" title="알파벳과 숫자로 4글자 이상 입력" ></td>
			</tr>
			<tr>
				<th>회원명</th>
				<td><input type="text" name="memName" class="form-control input-sm" value=""
						   required="required" pattern="[가-힣]{2,}" title="한글로 2글자 이상 입력" ></td>
			</tr>
			<tr>
				<th>우편번호</th>
				<td><input type="text" name="memZip" class="form-control input-sm" value=''></td>
			</tr>
			<tr>
				<th>주소</th>
				<td><input type="text" name="memAdd1" class="form-control input-sm" value=''>
					<input type="text" name="memAdd2" class="form-control input-sm" value=''>
				</td>
			</tr>
			<tr>
				<th>생일</th>
				<td><input type="date" name="memBir" class="form-control input-sm" value=''></td>
			</tr>
			<tr>
				<th>메일</th>
				<td><input type="email" name="memMail" class="form-control input-sm" required="required" value=''></td>
			</tr>
			<tr>
				<th>핸드폰</th>
				<td><input type="tel" name="memHp" class="form-control input-sm" value=''></td>
			</tr>
			<tr>
				<th>직업</th>
				<td>
				
					<select name="memJob" class="form-control input-sm" >
						<option value="">-- 직업 선택 --</option>
						<option value="JB01" >주부</option>
						<option value="JB02" >은행원</option>
						<option value="JB03" >공무원</option>
						<option value="JB04" >축산업</option>
						<option value="JB05" >회사원</option>
						<option value="JB06" >농업</option>
						<option value="JB07" >자영업</option>
						<option value="JB08" >학생</option>
						<option value="JB09" >교사</option>					
					</select>			
				</td>
			</tr>
			<tr>
				<th>취미</th>
				<td>
				
					<select name="memHobby" class="form-control input-sm" >
						<option value="">-- 취미 선택 --</option>
						<option value="HB01" >서예</option>
						<option value="HB02" >장기</option>
						<option value="HB03" >수영</option>
						<option value="HB04" >독서</option>
						<option value="HB05" >당구</option>
						<option value="HB06" >바둑</option>
						<option value="HB07" >볼링</option>
						<option value="HB08" >스키</option>
						<option value="HB09" >만화</option>
						<option value="HB10" >낚시</option>
						<option value="HB11" >영화감상</option>
						<option value="HB12" >등산</option>
						<option value="HB13" >개그</option>
						<option value="HB14" >카레이싱</option>					
					</select>			
				</td>
			</tr>	
			<tr>
				<th>마일리지</th>
				<td></td>
			</tr>	
			<tr>
				<th>탈퇴여부</th>
				<td></td>
			</tr>	
			<tr>
				<td colspan="2">
					<a href="memberList.jsp" class="btn btn-info btn-sm">
					<span class="glyphicon glyphicon-list" aria-hidden="true"></span>
					&nbsp;목록으로
					</a>
					<button type="submit" class="btn btn-primary">
					<span class="glyphicon glyphicon-heart" aria-hidden="true"></span>
					&nbsp;&nbsp; 저장
					</button>
					
						<button type="submit" formaction="memberDelete.jsp" class="btn btn-danger btn-sm">
					<span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
					&nbsp;&nbsp; 삭제
					</button>
					
					
				</td>
			</tr>
		</tbody>	
	</table>
	</form>
</div>


</body>
</html>