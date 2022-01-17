<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 자바코드의 위치는 jsp내에서 자유롭다.
	int sum = 0;
	for(int i = 0; i <= 10; i++){
		sum += i;
	}
	System.out.println("sum@basic.jsp = " + sum);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP Basic</title>
<script type="text/javascript"> // type="text/javascript" 쓰나 안쓰나 똑같다.
window.onload = () => {
	let v = 0;
	for(let i = 0; i <= 10; i++){
		v += i;
		console.log(i, v);		
	}
	document.querySelector("#sum").innerHTML = v;
	
	document.querySelector("#now").innerHTML = Date.now();
}
</script>
</head>
<body>
	<h1>JSP Basic</h1>
	<%-- jsp 주석 : java파일 변환시 제거된다. --%>
	<!-- html 주석 -->
	
	<h2>1 ~ 10 합구하기</h2>
	<p>서버단 결과 : <span><%= sum %></span></p>
	<p>클라이언트단 결과 : <span id="sum"></span></p>
	
	<h2>실행시각 Unix time 구하기</h2>
	<p>서버단 시각 : <%= System.currentTimeMillis() %></p>
	<p>클라이언트단 시간 : <span id="now"></span></p>
	
	
	
</body>
</html>










