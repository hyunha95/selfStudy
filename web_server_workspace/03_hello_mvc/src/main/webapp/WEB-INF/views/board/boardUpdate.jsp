<%@page import="com.kh.mvc.board.model.vo.Attachment"%>
<%@page import="java.util.List"%>
<%@page import="com.kh.mvc.board.model.vo.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>    
<%
	Board board = (Board) request.getAttribute("board");
%>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/board.css" />

<script>
/**
* boardUpdateFrm 유효성 검사
*/
function boardValidate(){
	const $title = $("[name=title]");
	const $content = $("[name=content]");
	//제목을 작성하지 않은 경우 폼제출할 수 없음.
	if(/^.+$/.test($title.val())){
		alert("제못을 입력하세요.");
		return false;
	}					   
	//내용을 작성하지 않은 경우 폼제출할 수 없음.
	// \n는 .에 포함되지 않는다.
	if(/^(.|\n)+$/.test($title.val())){
		alert("내용을 입력하세요.");
		return false;
	}	
	return true;
}

$(document.boardUpdateFrm).submit(boardValidate); // 함수 자체를 전달해야함 ()붙이면 리턴값을 전달한다.
</script>
<section id="board-container">
<h2>게시판 수정</h2>
<form
	name="boardUpdateFrm"
	action="<%=request.getContextPath() %>/board/boardUpdate" 
	method="post"
	enctype="multipart/form-data"> <!-- 이게 있어야 브라우저가 쓰기 작업을 해준다. -->
	<input type="hidden" name="no" value="<%= board.getNo() %>" />
	<table id="tbl-board-view">
	<tr>
		<th>제 목</th>
		<td><input type="text" name="title" value="<%= board.getTitle() %>" required></td>
	</tr>
	<tr>
		<th>작성자</th>
		<td>
			<input type="text" name="writer" value="<%= board.getWriter() %>" readonly/>
		</td>
	</tr>
<%
	List<Attachment> attachments = board.getAttachments();
	if(attachments != null && !attachments.isEmpty()){
%>
	<tr>
		<th>기존 첨부파일</th>
		<td>
<%
		for(Attachment attach : attachments){		
%>
		<div style="padding:0; margin:3px;">
			<img src="<%= request.getContextPath() %>/images/file.png" width="16px" />
			<%= attach.getOriginalFilename() %>
			<label for="delFile<%= attach.getNo() %>">제거</label>
			<input 
				type="checkbox" 
				name="delFile" 
				id="delFile<%= attach.getNo() %>" 
				value="<%= attach.getNo() %>" />		
		</div>
<%
		}
%>
		</td>
	</tr>
<%
	}
%>	
	<tr>
		<th>첨부파일</th>
		<td>			
			<input type="file" name="upFile1">
			<br>
			<input type="file" name="upFile2">
		</td>
	</tr>
	<tr>
		<th>내 용</th>
		<td><textarea rows="5" cols="40" name="content"><%= board.getContent() %></textarea></td>
	</tr>
	<tr>
		<th colspan="2">
			<input type="submit" value="수정하기">
		</th>
	</tr>
</table>
</form>
</section>
<%@ include file="/WEB-INF/views/common/footer.jsp" %>
