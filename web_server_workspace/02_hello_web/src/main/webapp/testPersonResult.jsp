<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
		import="java.util.*, java.io.*"
%>
<%--
	<%@ %> 지시어 directive jsp설정태그
		- page / include / taglib

	jsp : java server page
		- html을 쉽게 작성하는 servlet(웹서비스를 위한 java class)
		- HttpServlet을 상속하는 java class로 변환
		
		- 선언없이 사용가능한 내장객체 
			- request HttpServletRequest
			- response HttpServletResponse
			- session HttpSession
			- out reponse.getWriter():PrintWriter
			
		- 자바문법을 그대로 scriptlet구문<% %>, 출력식구문<%= %>을 사용가능
		- jsp는 수정, 파일추가하는 경우에도 서버를 재시작할 필요가 없다. 언제나 동적으로 로딩된다.
 --%>
 <%
 	// 자바영역
 	// 한줄주석
 	/*
 		여러줄 주석
 	*/
 	System.out.println("123@testPersonResult.jsp");
 	String a = "안녕";
 	int b = 123;
 	
 	// 사용자 입력값 가져오기
 	String name = request.getParameter("name");
 	String color = request.getParameter("color");
 	String animal = request.getParameter("animal");
 	String[] foods = request.getParameterValues("food");
 	String food = foods != null ? Arrays.toString(foods) : "없음";
 	
 	// servlet으로부터 데이터 가져오기 : request.getAttribute
 	// 형변환하지 않으면 object타입이다.
 	String style = (String) request.getAttribute("style");
 	String todayRecommend = (String) request.getAttribute("todayRecommend");
 	
 	System.out.println("name@jsp = " + name);
 	System.out.println("color@jsp = " + color);
 	System.out.println("animal@jsp = " + animal);
 	System.out.println("food@jsp = " + food);
 	
 	System.out.println("style@jsp = " + style);
 	System.out.println("todayRecommend@jsp = " + todayRecommend);
 
 %>
<!DOCTYPE html>
<%
	System.out.println(a);
	System.out.println(b);
%>
<html>
<head>
<meta charset='UTF-8'>
<title>개인취향검사결과</title>
<style>#todayRecommend { color: <%= style %>; }</style>
</head>
<body>
<h1>개인취향검사결과 - POST + jsp</h1>
<p>이름 : <%= name %></p>
<p>선호 색상 : <%= color %></p>
<p>선호 동물 : <%= animal %></p>
<p>선호 음식 : <%= food %></p>
<hr/>
<h2>그럼 오늘 <span id='todayRecommend'><%= todayRecommend %></span>어떠세요?</h2>
</body>
</html>






