<%@ page language="java" contentType="text/html; charset=utf-8" 
	pageEncoding="utf-8" isELIgnored="false" %>
<html>
<head>
<script 
	src="https://code.jquery.com/jquery-3.6.0.js" 
	integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" 
	crossorigin="anonymous"></script>
</head>
<body>
<h2>Hello World!</h2>
<button id="btn">gson</button>
<script>
$(btn).click((e) => {
	$.ajax({
		url: "${pageContext.request.contextPath}/gson",
		success(res){
			console.log(res);
		},
		error: console.log
	});
});
</script>
</body>
</html>
