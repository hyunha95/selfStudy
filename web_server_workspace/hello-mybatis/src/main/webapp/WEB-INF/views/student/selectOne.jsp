<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mybatis 실습</title>
<script
  src="https://code.jquery.com/jquery-3.6.0.js"
  integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
  crossorigin="anonymous"></script>
<style>
div#student-container{text-align:center;}
table.tbl-student{margin:10px auto;border:1px solid; border-collapse:collapse;}
table.tbl-student th,table.tbl-student td{
	border:1px solid;
	padding:5px;
	line-height: 2em; /*input태그로 인해 cell이 높이가 길어져 border 두줄현상방지 */
}
table.tbl-student th{text-align:right;}
table.tbl-student td{text-align:left;}
table.tbl-student tr:last-of-type td:first-child{text-align:center;}
</style>
</head>
<body>
	<div id="student-container">
		<h2>학생정보 검색</h2>
		<button id="btn-total-count">전체학생수</button>
		<form name="selectOneStudentFrm">
			<table class="tbl-student">
				<tr>
					<th>학생번호</th>
					<td>
						<input type="number" name="no" value="" required/>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="검색" />
					</td>
				</tr>
			</table>
		</form>
		
		<hr />
		
		<h1>학생 정보 수정</h1>
		<form name="studentUpdateFrm">
			<table class="tbl-student">
				<tr>
					<th>학생번호</th>
					<td>
						<input type="number" name="no" required readonly/>
					</td>
				</tr>
				<tr>
					<th>학생이름</th>
					<td>
						<input type="text" name="name" required/>
					</td>
				</tr>
				<tr>
					<th>학생전화번호</th>
					<td>
						<input type="tel" name="tel"  required/>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="button" value="수정" onclick="updateStudent();"/>
						<input type="button" value="삭제" onclick="deleteStudent();" />
					</td>
				</tr>
			</table>
		</form>
	</div>
<script>
/**
 * 학생정보 삭제
 */
function deleteStudent() {
	$.ajax({
		url: "${pageContext.request.contextPath}/student/studentDelete.do",
		method: "POST",
		data:{
			no : $("[name=no]", document.studentUpdateFrm).val(),
		},
		dataType : "json",
		success(res){
				console.log(res);
				alert(res.msg);
		},
		error : function(xhr, status, err){
			console.log(xhr, status, err);
		},
		complete : function(){
			$(document.studentUpdateFrm)[0].reset();
			$("[name=no]", document.selectOneStudentFrm).val('');
		}
	});
};

/**
 * 학생정보 수정
 */
function updateStudent() {
	const $frm = $(document.studentUpdateFrm);
	
	$.ajax({
		url: "${pageContext.request.contextPath}/student/studentUpdate.do",
		method: "POST",
		data:$frm.serialize(),
		dataType : "json",
		success(res){
			console.log(res);
			alert(res.msg);
		},
		error: function(xhr, status, err){
				console.log(xhr, status, err);
		},
		complete: function(){
			$frm[0].reset();
			$("[name=no]", document.selectOneStudentFrm).val('');
		}
	});
};

/**
 * 학생1명정보 조회
 */
$(document.selectOneStudentFrm).submit((e) => {
	e.preventDefault(); // 폼제출방지
	
	const no = $("[name=no]", e.target).val();
	console.log(no);
	if(!Number(no)) return;
	
	$.ajax({
//		url: "${pageContext.request.contextPath}/student/selectOneStudent.do",
		url: "${pageContext.request.contextPath}/student/selectOneStudentMap.do",
		data: {no},	// {no : no}
		success(res){
			console.log(res);
			if(res == null){
				alert(`해당 학생은 존재하지 않습니다.`);
				return;
			}

			const {no, name, tel} = res;
			const $frm = $(document.studentUpdateFrm);
			$("[name=no]", $frm).val(no);
			$("[name=name]", $frm).val(name);
			$("[name=tel]", $frm).val(tel);

		},
		error: console.log
	})
	
	
});



$("#btn-total-count").click((e) => {
	$.ajax({
		url: "${pageContext.request.contextPath}/student/totalCount.do",
		success(res){
			console.log(res);
			const {totalCount} = res;
			alert(`전체 학생수는 \${totalCount}명 입니다.`);
		},
		error: console.log
	});
});
</script>
</body>
</html>
