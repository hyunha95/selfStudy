<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="<%= request.getContextPath() %>/js/jquery-3.6.0.js"></script>
<style>
table {
	border: 1px solid #000;
	border-collapse: collapse;
	margin-top: 10px;
}
th, td {
	border: 1px solid #000;
	padding: 5px;
}
table img {
	width: 100px; 
}
</style>
</head>
<body>
	<h1>html</h1>
	<button id="btn1">실행</button>
	<div class="celeb-container"></div>
<script>
$(btn1).click((e) => {
	let a= 3;
	
	$.ajax({
		url: "<%= request.getContextPath() %>/html/celebList.do",
		method: "GET",		// 전송방식
		datatype: "html",   // 리턴받을 데이터타입
		async: false,		// 비동기통신을 동기적으로 처리
		beforeSend(){
			console.log("beforeSend");
		},
		success(data){
			console.log("success", data);
			$(".celeb-container").html(data);
		},
		error(xhr, testStatus, err){
			console.log("error", xhr, testStatus, err);
		},
		complete(){
			console.log("complete"); // 성공/실패와 상관없이 실행되는 메소드
			a *= 100;
		}
	});
	
	alert(a);
});
</script>
</body>
</html>