<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mybatis실습 - selectList</title>
<style>
div#student-container{text-align:center;}
table.tbl-student{margin:0 auto;border:1px solid; border-collapse:collapse;}
table.tbl-student th,table.tbl-student td{
	border:1px solid;
	padding:5px;
}
</style>
</head>
<body>
<div id="student-container">
	<h2>selectList</h2>
	<p>SqlSession의 selectList메소드를 호출해서 List&lt;Student>를 리턴받음.</p>
	<table class="tbl-student">
		<thead>
			<tr>
				<th>학번</th>
				<th>이름</th>
				<th>전화번호</th>
				<th>등록일</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="student">
				<tr>
					<td>${student.no}</td>
					<td>${student.name}</td>
					<td>${student.tel}</td>
					<td><fmt:formatDate value="${student.regDate}" pattern="yyyy-MM-dd"/></td>
				</tr>
			</c:forEach>			
		</tbody>
	</table>
	
	<hr />
	
	<h2>selectList</h2>
	<p>SqlSession의 selectList메소드를 호출해서 List&lt;Map&lt;String, Object>>를 리턴받음.</p>
	<table class="tbl-student">
		<thead>
			<tr>
				<th>학번</th>
				<th>이름</th>
				<th>전화번호</th>
				<th>등록일</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${mapList}" var="student">
				<tr>
					<td>${student.no}</td>
					<td>${student.name}</td>
					<td>${student.tel}</td>
					<td><fmt:formatDate value="${student.regDate}" pattern="yyyy-MM-dd"/></td>
				</tr>
			</c:forEach>			
		</tbody>
	</table>
</div>
</body>
</html>
