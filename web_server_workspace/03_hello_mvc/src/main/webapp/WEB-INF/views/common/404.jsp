<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>404</title>
<style>
body {text-align: center;}
h1 {font-size: 300px;}
</style>
</head>
<body>
	<div>
		<h1>텅</h1>
		<p>요청하신 페이지는 존재하지 않습니다.</p>
		<a href="<%= request.getContextPath()%>">홈으로</a>
	</div>
</body>
</html>