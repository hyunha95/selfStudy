<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param value="메모" name="title"/>
</jsp:include>

<style>
div#memo-container{width:60%; margin:0 auto;text-align:center;}
</style>
<div id="memo-container">
    <form action="${pageContext.request.contextPath}/memo/insertMemo.do" class="form-inline" method="post">
        <input type="text" class="form-control col-sm-8" name="memo" placeholder="메모" required/>&nbsp;
        <input type="password" class="form-control col-sm-2" name="password" maxlength="4" placeholder="비밀번호" required/>&nbsp;
        <button class="btn btn-outline-success" type="submit" >저장</button>
    </form>

    <br />
    <!-- 메모목록 -->
	<table class="table">
	    <tr>
	      <th>번호</th>
	      <th>메모</th>
	      <th>날짜</th>
	      <th>삭제</th>
	    </tr>
	    <c:forEach items="${list}" var="memo">
	    	<tr>
	    		<td>${memo.no}</td>
	    		<td>${memo.memo}</td>
	    		<td><fmt:formatDate value="${memo.regDate}" pattern="yyyy/MM/dd HH:mm"/></td>
	    		<td>
	    			<button class="btn btn-outline-danger btn-memo-delete" data-no="${memo.no}" type="button">삭제</button>
	    		</td>
	    	</tr>
	    </c:forEach>
	</table>
</div>

<!-- Modal -->
<div class="modal fade" id="deleteMemoModal" tabindex="-1" role="dialog" aria-labelledby="deleteMemoModalTitle" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
	<div class="modal-content">
		<div class="modal-header">
		  <h5 class="modal-title" id="deleteMemoModalTitle">비밀번호를 입력하세요.</h5>
		  <button type="button" class="close" data-dismiss="modal" aria-label="Close">
			<span aria-hidden="true">&times;</span>
		  </button>
		</div>
		<form name="memoDelFrm" action="deleteMemo.do" method="post">
		   <div class="modal-body">
			 <input type="hidden" name="no" />
			 <input 
				type="password" 
				class="form-control" 
				name="password"
				placeholder="비밀번호" 
				required>
		   </div>
		   <div class="modal-footer">
			 <button type="button" class="btn btn-secondary" data-dismiss="modal">취소</button>
			 <button type="submit" class="btn btn-danger">삭제</button>
		   </div>
		</form>
	</div>
  </div>
</div>
<script>
$(".btn-memo-delete").click((e) => {
	const no = $(e.target).data("no");
	$(deleteMemoModal)
		.modal()
		.find("[name=memoDelFrm] [name=no]")
		.val(no);
});
</script>
<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>
