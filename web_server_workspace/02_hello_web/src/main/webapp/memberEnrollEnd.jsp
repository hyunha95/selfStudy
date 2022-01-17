<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String userId = request.getParameter("userId");
	String pwd = request.getParameter("pwd");
	String userName = request.getParameter("userName");
	String ssn1 = request.getParameter("ssn1");
	String ssn2 = request.getParameter("ssn2");
	String email = request.getParameter("email");
	String tel1 = request.getParameter("tel1");
	String tel2 = request.getParameter("tel2");
	String tel3 = request.getParameter("tel3");
	String job = request.getParameter("job");
	String[] hobbies = request.getParameterValues("hobby");
	
	String tel = tel1 + tel2 + tel3;
	String ssn = ssn1 + "-" + ssn2;
	String hobby = hobbies != null ? String.join(",", hobbies) : "";
	
	String msg = (String) request.getAttribute("msg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script>
/**
 * 스트링 템플릿이 jsp문 법에 존재하기 때문에 이스케이핑 처리해줘야함
 * \${}
 */
	const member = `회원 등록 정보
------------------------------------
아이디 : <%= userId %>
비밀번호 : <%= pwd %>
이름 : <%= userName %>
주민번호 : <%= ssn %>
이메일 : <%= email %>
전화번호 : <%= tel %>
직업 : <%= job %>
취미 : <%= hobby %>
-------------------------------------
처리결과 : <%= msg %>
`;
alert(member);
location.href = "<%= request.getContextPath() %>";
</script>
</body>
</html>