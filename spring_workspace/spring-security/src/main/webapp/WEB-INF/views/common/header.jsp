<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%-- spring-webmvc의존 : security의 csrf토큰 생성 --%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${param.title}</title>

<script src="http://code.jquery.com/jquery-latest.min.js"></script>

<!-- bootstrap js: jquery load 이후에 작성할것.-->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>

<!-- bootstrap css -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">

<!-- 사용자작성 css -->
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/style.css" />
<c:if test="${not empty msg}">
<script>
	alert("${msg}");
</script>
</c:if>
<style>
[name=logoutFrm] div{
	padding: 0;
}
</style>
</head>
<body>
<div id="container">
	<header>
		<div id="header-container">
			<h2>${param.title}</h2>
		</div>
		<!-- https://getbootstrap.com/docs/4.0/components/navbar/ -->
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
			<a class="navbar-brand" href="#">
				<img src="${pageContext.request.contextPath }/resources/images/logo-spring.png" alt="스프링로고" width="50px" />
			</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
		  	</button>
			<div class="collapse navbar-collapse" id="navbarNav">
				<ul class="navbar-nav mr-auto">
			    	<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}">Home</a></li>
			    	<sec:authorize access="isAnonymous()">
                    	<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/anonymous/anonymous.do">Anonymous</a></li>			    	
			    	</sec:authorize>
			    	<sec:authorize access="isAuthenticated()">
                    	<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/board/board.do">게시판</a></li>
			    	</sec:authorize>
			    	<sec:authorize access="hasRole('ADMIN')">
	                    <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/admin/admin.do">관리자</a></li>
			    	</sec:authorize>
			    </ul>
			    <%-- 로그인하지 않았을때 --%>
				<sec:authorize access="isAnonymous()">
			    	<button 
				    	class="btn btn-outline-success my-2 my-sm-0" 
				    	type="button"
				    	onclick="location.href='${pageContext.request.contextPath}/member/memberLogin.do';">로그인</button>
	                &nbsp;
	                <button 
	                	class="btn btn-outline-success my-2 my-sm-0" 
	                	type="button"
	                	onclick="location.href='${pageContext.request.contextPath}/member/memberEnroll.do';">회원가입</button>
				</sec:authorize>
			    <%-- 로그인했을때 --%>
				<sec:authorize access="isAuthenticated()">
			    	<span>
			    		<a href="${pageContext.request.contextPath}/member/memberDetail.do">
			    			<sec:authentication property="principal.username"/>
			    			<sec:authentication property="authorities"/>
			    		</a>님 안녕하세요.
			    	</span>
			    	&nbsp;&nbsp;
			    	<%-- 로그아웃도 csrf 폼 검사를 하기 때문에 무조건 post로 보내야 한다. --%>
			    	<form:form
			    		name="logoutFrm"
			    		method="POST"
			    		action="${pageContext.request.contextPath}/member/memberLogout.do">
				    	<button 
					    	class="btn btn-outline-success my-2 my-sm-0" 
					    	type="submit">로그아웃</button>
			    	</form:form>
				</sec:authorize>
			 </div>
		</nav>
	</header>
	<section id="content">