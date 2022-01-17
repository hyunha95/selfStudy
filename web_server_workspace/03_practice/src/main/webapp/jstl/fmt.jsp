<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>fmt</title>
</head>
<body>
	<h1>fmt</h1>
	<h2>숫자</h2>
	<c:set var="num1">123456789</c:set>
	<c:set var="num2">123.456789</c:set>
	<ul>
		<li><fmt:formatNumber value="${num1}" pattern="#,###"/></li>
		<li><fmt:formatNumber value="${num2}" pattern="#.##"/></li>
		<li><fmt:formatNumber value="${123.45}" pattern="#.000"/></li>
		<li><fmt:formatNumber value="0.15" pattern="#%"/></li>
		<fmt:setLocale value="ko_kr"/>
		<li><fmt:formatNumber value="${num1}" type="currency"/></li>
	</ul>
	
	<h2>날짜</h2>
	<c:set var="today" value="<%= new Date() %>"></c:set>
	<ul>
		<li><fmt:formatDate value="${today}" type="date"/></li>
		<li><fmt:formatDate value="${today}" type="time"/></li>
		<li><fmt:formatDate value="${today}" pattern="yyyy/MM/dd(E)"/></li>
		<li><fmt:formatDate value="${today}" pattern="HH:mm:ss"/></li>
	</ul>
	
	
</body>
</html>