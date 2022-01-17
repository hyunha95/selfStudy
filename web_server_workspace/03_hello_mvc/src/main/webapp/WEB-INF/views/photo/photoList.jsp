<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int totalPage = (int) request.getAttribute("totalPage");
%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<script>
const getPage = (cPage) => {
	$.ajax({
		url: "<%= request.getContextPath() %>/photo/page",
		data: {cPage},
		dataType: "json",
		success(res){
			console.log(res);
			const $container = $("#photo-container")
			
			$(res).each((i, {no, renamedFilename, writer, content, regDate}) => {
				console.log(no, renamedFilename, writer, content, regDate);
				
				const html = `<div class="polaroid">
					<img src="<%= request.getContextPath() %>/upload/photo/\${renamedFilename}" alt="" />
					<p class="info">
						<span class="writer">\${writer}</span>
						<span class="photoDate">\${regDate}</span>
					</p>
					<p class="caption">\${content}</p>
				</div>`;
					$container.append(html);
			});
			
			// 더보기 버튼
			$("#btn-more")
				.val(cPage)
				.find("#cPage")
				.text(cPage);
			
			// 마지막페이지인경우
			if(cPage == <%= totalPage %>){
				$("#btn-more")
					.attr("disabled", "disabled")
					.css("cursor", "not-allowed");
			}
		},
		error: console.log
	});
};

$(() => {
	// 첫 목록 요청!
	getPage(1);	
	
	// #btn-more 클릭 이벤트 핸들러
	$("#btn-more").click((e) => {
		const cPage = Number($("#btn-more").val()) + 1;
		getPage(cPage);
	});
	
});

</script>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/photo.css" />
<section id="photo-wrapper">
	<h2>사진게시판 </h2>
	<div id="photo-container"></div>
	<hr />
	<div id='btn-more-container'>
		<button id="btn-more" value="" >더보기(<span id="cPage"></span>/<span id="totalPage"><%= totalPage %></span>)</button>
	</div>
</section>
<%@ include file="/WEB-INF/views/common/footer.jsp" %>
