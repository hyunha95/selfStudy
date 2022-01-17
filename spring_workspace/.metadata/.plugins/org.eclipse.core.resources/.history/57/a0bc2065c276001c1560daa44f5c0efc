<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%-- spring-webmvc의존 : security의 csrf토큰 생성 --%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script>
$(() => {
	$(loginModal)
		.modal('show')
		.on("hide.bs.modal", (e) => {
			location.href = '${pageContext.request.contextPath}';
		});
});
</script>

</head>
<body>
	<!-- Modal 시작 -->
	<div class="modal fade" id="loginModal" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
	  <div class="modal-dialog modal-dialog-centered">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title" id="staticBackdropLabel">로그인</h5>
	        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
	      </div>
	      <form:form 
	      	id="loginFrm"
	      	action="${pageContext.request.contextPath}/member/login.do"
	      	method="post"
	      	class="m-5">
	        <!-- 아이디 -->
	        <div class="mb-3">
			    <label for="id" class="form-label">아이디</label>
			    <input type="text" name="id" class="form-control" id="id">
			    <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>
		    </div>
		    <!-- 비밀번호 -->
			<label for="password" class="form-label">비밀번호</label>
			<input type="password" name="password" id="password" class="form-control">
			<div id="passwordHelpBlock" class="form-text">
			  Your password must be 8-20 characters long, contain letters and numbers, and must not contain spaces, special characters, or emoji.
			</div>
			<!-- 아이디 저장 -->
			<div class="mb-3 form-check">
			    <input type="checkbox" class="form-check-input" id="exampleCheck1">
			    <label class="form-check-label" for="exampleCheck1">아이디 저장</label>
			</div>
			<!-- submit 버튼 -->
		    <button type="submit" class="btn btn-primary">로그인</button>
	      </form:form>
	    </div>
	  </div>
	</div>
	<!-- Modal 끝 -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>