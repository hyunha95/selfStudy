<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>core - forEach</title>
<style>
table {
	border: 1px solid #000;
	border-collapse: collapse;
}
td, th {
	border: 1px solid #000;
	padding: 5px;
}
</style>
</head>
<body>
	<h1>core - forEach</h1>
	<h2>list</h2>
	<ul>
		<!-- 반복접근할 것을 items에 그걸 저장할 변수명을 var에 저장 -->
		<c:forEach items="${names}" var="name" varStatus="vs">
			<li>${vs.index}${vs.count} ${vs.first} ${vs.last} ${name}</li>
		</c:forEach>
	</ul>
	
	<c:forEach items="${names}" var="name" varStatus="vs">
		${name}${!vs.last ? ", " : ""}
	</c:forEach>
	
	<div>
		<h3>회원목록</h3>
		<table>
			<tr>
				<th>No</th>
				<th>이름</th>
				<th>성별</th>
				<th>나이</th>
				<th>결혼여부</th>
			</tr>
			<c:forEach items="${persons}" var="person" varStatus="vs">
				<tr>
					<th>${vs.count}</th>
					<th>${person.name}</th>
					<th>
						<select name="" id="">
							<option value="M" ${person.gender eq 'M'.charAt(0) ? 'selected' : ''}>남</option>
							<option value="F" ${person.gender eq 'F'.charAt(0) ? 'selected' : '' }>여</option>
						</select>
					</th>
					<th>${person.age}</th>
					<th>
						<input type="checkbox" name="" id="" ${person.married ? "checked" : ""} />
					</th>
				</tr>
			</c:forEach>
		</table>
	</div>
	
	<h2>set</h2>
	<ul>
		<c:forEach items="${numbers}" var="number" varStatus="vs">
			<li>${number}</li>
		</c:forEach>	
	</ul>
	
	<h2>map</h2>
	<c:forEach items="${map}" var="entry">
		<p>${entry.key} : ${entry.value}</p>
	</c:forEach>
	
	
	
	
	
	
	
	
	
</body>
</html>