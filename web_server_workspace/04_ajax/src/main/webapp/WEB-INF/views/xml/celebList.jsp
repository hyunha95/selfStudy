<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="java.util.List"%>
<%@page import="com.kh.ajax.celeb.model.vo.Celeb"%>
<%@ page language="java" contentType="text/xml; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<Celeb> celebList = (List<Celeb>) request.getAttribute("celebList");
%>
<celebs>
<%
	for(Celeb celeb : celebList){
%>
	<celeb>
		<name><%= celeb.getName() %></name>
		<phone><%= celeb.getPhone() %></phone>
		<age><%= celeb.getAge() %></age>
		<profile><%= request.getContextPath() %>/images/<%= celeb.getProfile() %></profile>
		<married><%= celeb.isMarried() %></married>
	</celeb>
<%	
	}
%>
</celebs>



