<%@page import="java.util.Arrays"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.kh.action.person.model.vo.Person"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String str1 = "hello";
	String str2 = new String("hello");
	
	int big = 100;
	int small = 30;
	
	Person person1 = new Person("홍길동", 'M', 35, false);
	Person person2 = new Person("홍길동", 'M', 35, false);
	
	List<Integer> list1 = null;
	List<Integer> list2 = new ArrayList<>();
	List<Integer> list3 = Arrays.asList(1,2,3,4,5);
	
	
	pageContext.setAttribute("str1", str1);
	pageContext.setAttribute("str2", str2);
	pageContext.setAttribute("big", big);
	pageContext.setAttribute("small", small);
	pageContext.setAttribute("person1", person1);
	pageContext.setAttribute("person2", person2);
	pageContext.setAttribute("list1", list1);
	pageContext.setAttribute("list2", list2);
	pageContext.setAttribute("list3", list3);
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL Operator</title>
</head>
<body>
	<h1>EL Operator</h1>
	
	<h2>산술연산</h2>
	<ul>
		<li>${big + small}</li>
		<li>${big - small }</li>
		<li>${big * small }</li>
		<li>${big / small } ${big div small}</li>
		<li>${big % small } ${big mod small}</li>
	</ul>
	
	<ul>
		<li>${big > small}  ${big gt small}</li>
		<li>${big >= small} ${big ge small}</li>
		<li>${big < small}  ${big lt small}</li>
		<li>${big <= small} ${big le small}</li>
		<li>${big == small} ${big eq small}</li>
		<li>${big != small} ${big ne small}</li>
		<li>${big > small ? "안녕" : "잘가"}</li>
		<li>${big < small ? "안녕" : "잘가"}</li>
		<li>${str1}${str2}</li><!-- EL은 문자열 +연산을 지원하지 않는다. -->
		<li>${str1.concat(str2)}</li>
	</ul>
	
	<h2>객체간 연산</h2>
	<ul>
		<li><%= str1.equals(str2) %> <%= str1 == str2 %></li>
		<li>${str1.equals(str2)} ${str1 eq str2} ${str1 == str2}</li><!-- EL은 ==를 사용해도 주소값이 아닌 equals를 내부적으로 호출한다. -->
	</ul>	
	<ul>
		<li><%= person1.equals(person2) %> <%= person1 == person2 %></li>
		<li>${person1.equals(person2)} ${person1 == person2}</li>
	</ul>
	
	<h2>empty</h2>
	<ul>
		<li>${empty list1} ${!empty list1}</li>
		<li>${empty list2} ${not empty list2}</li>
		<li>${empty list3} ${not empty list3 }</li>
	</ul>
	
	<ul>
		<li>${true and true} ${true && true}</li>
		<li>${true or true} ${true || true}</li>		
	</ul>
	
</body>
</html>