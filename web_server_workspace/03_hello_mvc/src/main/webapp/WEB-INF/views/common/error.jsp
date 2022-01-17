<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<%
	// isErrorPage="true" 작성시 던져진 예외객체에 선언없이 접근할 수 있다.
	String msg = exception.getMessage();
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
body {text-align: center;}
h1 {font-size: 250px;}
p {color: red;}
</style>
</head>
<body>
	<h1>앗</h1>
	<p><%= msg %></p>
	<p>관리자에게 문의바랍니다.</p>
	<a href="<%= request.getContextPath() %>">홈으로</a>
</body>
</html>