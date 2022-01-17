<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Jsp Action Tag & EL</title>
</head>
<body>
	<h1>Jsp Action Tag & EL</h1>
	<h2>Action Tag</h2>
	<ul>
		<li><a href="${pageContext.request.contextPath}/standard/useBean.do">useBean</a></li>
		<li><a href="${pageContext.request.contextPath}/standard/include.jsp">include</a></li>
	</ul>
	
	<h2>EL</h2>
	<ul>
		<li><a href="${pageContext.request.contextPath}/el/basics.do?pid=prod123&option=lg&option=red">basics</a></li>
		<li><a href="${pageContext.request.contextPath}/el/operator.jsp">EL연산</a></li>
	</ul>
	
	<h2>JSTL</h2>
	<ul>
		<li><a href="${pageContext.request.contextPath}/jstl/core.jsp?x=32&y=27">core</a></li>
		<li><a href="${pageContext.request.contextPath}/jstl/coreForEach.do">core:forEach</a></li>
		<li><a href="${pageContext.request.contextPath}/jstl/fmt.jsp">format</a></li>
		<li><a href="${pageContext.request.contextPath}/jstl/functions.jsp">functions</a></li>
	</ul>
	
	
	
</body>
</html>