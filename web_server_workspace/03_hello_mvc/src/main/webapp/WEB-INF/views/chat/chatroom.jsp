<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>  
<script>
const host = location.host; 
const ws = new WebSocket(`ws://\${host}<%= request.getContextPath() %>/chat/websocket`);
ws.onopen = (e) => {
	console.log("open", e);
};
ws.onmessage = (e) => {
	console.log("message", e);
	const {data} = e;
	const {type, msg, sender, time} = JSON.parse(data);
	console.log(type, msg, sender, time);
	
	let html = "";
	switch(type){
	case "welcome":
	case "bye": html = `<li class="center"><span class="badge">\${sender}</span>\${msg}</li>`; break;
	case "msg": html = `<li><span class="badge">\${sender}</span>\${msg}</li>`; break;
	case "dm" : alert(`\${sender} 님으로부터의 DM
----------------------------------------
\${msg}
----------------------------------------`); break;
	}
	$("#msg-container ul").append(html);
	
	// 스크롤처리
	const $msgContainer = $("#msg-container");
	const scrollHeight = $msgContainer.prop("scrollHeight");
	$msgContainer.scrollTop(scrollHeight);
};
ws.onerror = (e) => {
	console.log("error", e);
};
ws.onclose = (e) => {
	console.log("close", e);
};

$(() => {
	/**
	 * websocket message 전송
	 */
	$(send).click((e) => {
		const o = {
			type: "msg",
			sender: "<%= loginMember.getMemberId() %>",
			msg: $(msg).val(),
			time: Date.now()
		};
		
		// 메세지 전송
		ws.send(JSON.stringify(o));
		
		// #msg 초기화
		$(msg).val('').focus();
		
	});
	
	$(msg).keyup((e) => {
		if(e.key === 'Enter')
			$(send).trigger("click");
	});
	
	$("#dm-client").mouseover((e) => {
		$.ajax({
			url: "<%= request.getContextPath() %>/chat/memberList",
			success(data){
				console.log(data);
				$(e.target).empty();
				$(data).each((i, memberId) => {
					$(e.target).append(`<option value="\${memberId}">\${memberId}</option>`);
				});
			},
			error: console.log
		});
	});
	
	$("#dm-send").click((e) => {
		const o = {
			type: "dm",
			sender: "<%= loginMember.getMemberId() %>",
			receiver: $("dm-client").val(),
			msg: $("#dm-msg").val(),
			time: Date.now()
		};
		
		$.ajax({
			url: "<%= request.getContextPath() %>/chat/sendDm",
			data: {
				msg: JSON.stringify(o)
			},
			success(data){
				console.log(data);
			},
			error: console.log
		});
	});
});
</script>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/chat.css" />
	<section id="chat-container">	
		<h2>채팅</h2>
		<button type="button" id="btn-userList">현재사용자확인</button>
		<div id="msg-container">
			<ul></ul>
		</div>
		
		<div id="msg-editor" class="editor">
			<textarea name="" id="msg" cols="30" rows="2"></textarea>
			<button type="button" id="send">Send</button>
		</div>
		
		<hr style="margin:20px 0" />

		<!-- dm관련 섹션 -->		
		<div id="dm-container" >
			<label for="dm-client">DM</label>
			<select class="custom-select" id="dm-client">
				<option value="" disabled selected>접속자 목록</option>
			</select>
		</div>
		<div id="dm-editor" class="editor">
			<textarea id="dm-msg" cols="30" rows="2"></textarea>
			<button type="button" id="dm-send">Send</button>
		</div>
	</section>
	
<%@ include file="/WEB-INF/views/common/footer.jsp" %>  
