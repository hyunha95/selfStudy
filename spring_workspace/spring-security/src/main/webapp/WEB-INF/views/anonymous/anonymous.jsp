<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<fmt:requestEncoding value="utf-8"/>
<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param value="Anonymous" name="title"/>
</jsp:include>
		<h1 class="text-center">Anonymous</h1>
		<p class="text-center">인증하지 않은 사용자도 접근 가능한 페이지입니다.</p>
<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>

