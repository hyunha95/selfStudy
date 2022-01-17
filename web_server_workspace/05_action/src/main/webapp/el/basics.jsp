<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
	EL Expression Language
	${key}
	
	1. 스코프별 내장객체의 속성을 map에 보관 (생략가능)
		- 생략시에는 다음 순으로 속성을 조회
		pageScope
		requestScope
		sessionScope
		applicationScope
		
	2. 사용자입력값
		param
		paramValues
		
	3. 요청 header
		header
		headerValues
		cookie
		
	4. 초기화파라미터 : application 초기값을 key-value로 저장
		initParam
	
	5. 유일한 포인터객체
		pageContext
		
 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL Basics</title>
</head>
<body>
	<h1>EL Basics</h1>
	<h2>request</h2>
	<ul>
		<li>${coffee}</li>
		<li>${num}</li>
		<li>${person}
			<ul>
				<li>${person.name}</li>
				<li>${person.gender}</li>
				<li>${person.age}</li>
				<li>${person.married}</li>
			</ul>
		</li>
		<li>${items}
			<ol>
				<li>${items[0]}</li>
				<li>${items[1]}</li>
				<li>${items[2]}</li>
				<li>${items[3]}</li>
				<li>${items[4]}</li> <!-- 존재하지 않는 인덱스를 참조해도 오류가 발생하지 않는다. -->
			</ol>
		</li>
		<li>${map}
			<ul>
				<li>${map.name}</li> <!-- Dot Notation -->
				<li>${map.today}</li>
				<li>${map.Dr.Zang }</li> <!-- EL은 NullPointerException을 발생시키지 않는다. 출력값이 null인 경우 ""문자열을 출력 -->
				<li>${map["Dr.Zang"]} <!-- Bracket Notation 사용가능. '', "" 모두 문자열 처리 -->
					<ul>
						<li>${map["Dr.Zang"]['name']}</li>
						<li>${map["Dr.Zang"]["gender"]}</li>
						<li>${map["Dr.Zang"]['age']}</li>
						<li>${map["Dr.Zang"]["married"]}</li>
					</ul>
				</li> 
				
			</ul>
		</li>
	</ul>
	
	
	<h2>session</h2>
	<ul>
		<li>${book}</li>
	</ul>
	
	<h2>application</h2>
	<ul>
		<li>${applicationScope.movie}</li>
	</ul>
	
	<h2>사용자입력값</h2>	
	<ul>
		<li>pid : ${param.pid}</li>
		<li>option : ${paramValues.option[0]}</li>
		<li>option : ${paramValues.option[1]}</li>
	</ul>
	
	<h2>header</h2>
	<ul>
		<li>Host : ${header.Host}</li>
		<li>Referer : ${header.Referer}</li>
		<li>User-agent : ${header['User-Agent']}</li>
		<li>cookie.JSESSIONID : ${cookie.JSESSIONID.value}</li>
	</ul>
	
	<h2>initParam</h2>
	<ul>
		<li>tel : ${initParam.tel}</li>
		<li>email : ${initParam.email}</li>
	</ul>

<%
	// pageContext, request, response, session, application, out, ...
	String method = request.getMethod();
	System.out.println(method); // GET POST
	
	String contextPath = request.getContextPath();
	System.out.println(contextPath); // /action
%>

	<h2>pageContext</h2>
	<ul>
		<li>${pageContext.request.method}</li>
		<li>${pageContext.request.contextPath}</li>
	</ul>
	
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />
</body>
</html>

















