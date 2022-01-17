<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String str = "Hello world";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<script src="/web/js/jquery-3.6.0.js"></script>
<script>
const name = "홍길동";
</script>
<style>
div, section,header,aside,footer {padding:10px;}
div#container	{ background-color:#F0F0F0; width:960px; margin:0 auto;}
header				{background-color:#908886; height:100px; }
nav					{float:right; transform: translateY(-10px); }
nav ul {display: flex;}
nav ul li			{list-style:none; }
nav ul li a			{text-decoration:none;color:black; padding:0 10px;}
nav ul li:not(:last-of-type)::after  {content: "|"}	
nav ul li a:hover	{color:white;}
section#content		{background-color:#F5F5F5; float:left; width:640px; min-height:500px; }
aside				{background-color:#DCDAD9; float:right; width:280px; min-height:500px; }
footer { background-color:#555555; clear:both;  text-align:center; padding-bottom: 30px; } 
footer h3 { text-align: left; }
</style>
<title>HTML5 레이아웃</title>
</head>
	<body>
		<div id="container">
			<header>
				<h2>Header</h2>
				<nav>
					<ul class="navi">
						<li><a href="/web/main.jsp">Home</a></li>
						<li><a href="/web/html5.jsp">HTML5</a></li>
						<li><a href="/web/css3.jsp">CSS3</a></li>
						<li><a href="/web/js.jsp">Javascript</a></li>
						<li><a href="/web/jquery.jsp">JQuery</a></li>
						<li><a href="/web/mobile.jsp">Mobile</a></li>
						<li><a href="/web/profile.jsp">Profile</a></li>
					</ul>
				</nav>
			</header>