<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
			<h2 align="center" style="margin-top:200px;">안녕하세요, MVC입니다.</h2>	
	<ul>
		<li><a href="${pageContext.request.contextPath}/stadard/useBean.do">useBean</a></li>
		<li><a href="${pageContext.request.contextPath}/standard/include.jsp">include</a></li>
	</ul>
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
	
<%@ include file="/WEB-INF/views/common/footer.jsp" %>

