<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Include</title>
</head>
<body>
	<h1>include</h1>
	<h2>오늘은 <%@ include file="/standard/today.jsp" %> 입니다.</h2>
	<h2>오늘은 <jsp:include page="/standard/today.jsp"/> 입니다.</h2>
</body>
</html>