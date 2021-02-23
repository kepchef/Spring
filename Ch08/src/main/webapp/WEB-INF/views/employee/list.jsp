<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>직원목록</title>
</head>
<body>
	<h3>직원목록</h3>
	
	<table border="1">
		<tr>
			<th>아이디</th>
			<th>이름</th>
			<th>휴대폰</th>
			<th>직급</th>
			<th>부서</th>
			<th>등록일</th>
			<th>관리</th>
		</tr>
		<c:forEach var="vo" items="${list}">
			<tr>
				<td>${vo.uid}</td>
				<td>${vo.name}</td>
				<td>${vo.hp}</td>
				<td>${vo.pos}</td>
				<td>${vo.dep}</td>
				<td>${vo.rdate}</td>
				<td>
					<a href="#">수정</a>
					<a href="/employee/delete?uid=${vo.uid}">삭제</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>