<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>functions</title>
</head>
<body>
	<h1>functions</h1>
	<c:set var="str1">Hello world, Hello jstl</c:set>
	<c:set var="str2">Hello EL</c:set>
	
	<ul>
		<li>${fn:toUpperCase(str1)}</li>
		<li>${fn:toLowerCase(str2)}</li>
		<li>${fn:length(str1)} ${fn:length(str1) > 0}</li>
		<c:if test="${fn:length(str1) > 0}">
			<li>
				str1은 빈문자열이 아닙니다.
			</li>
		</c:if>
		<li>${fn:contains(str1, 'world') ? "world 있다" : "world 없다" }</li>
		<li>${fn:indexOf(str1, 'world')} ${fn:indexOf(str1, 'lotteworld')}</li>
		<li>${fn:replace(str1, "Hello", "Goobye")} ${str1}</li>
		<li>${fn:substring(str1, 6, 11) }</li>
		
		<li>${str1}${str2} ${str1.concat(str2)}</li>
		<c:forEach items="${fn:split(str1, ',')}" var="str">
			<li>${str}</li>
		</c:forEach>
		<c:set var="xssStr"><script>alert("메롱!");</script></c:set>
		<li>${fn:escapeXml(xssStr)}</li>
		<li><c:out value="${xssStr}" escapeXml="true"></c:out></li>
	</ul>
	
	<img src="${pageContext.request.contextPath}/images/file.png" alt="" />
	<img src='<c:url value="/images/file.png"/>' alt="" />
	
	
</body>
</html>