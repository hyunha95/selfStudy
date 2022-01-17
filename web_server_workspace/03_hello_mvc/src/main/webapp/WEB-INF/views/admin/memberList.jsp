<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<Member> list = (List<Member>) request.getAttribute("list");
	String searchType = request.getParameter("searchType");
	String searchKeyword = request.getParameter("searchKeyword");
%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<!-- 관리자용 admin.css link -->
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/admin.css" />
<style>
div#search-container {margin:0 0 10px 0; padding:3px; background-color: rgba(0, 188, 212, 0.3);}
div#search-memberId {display: <%= searchType == null || "memberId".equals(searchType) ? "inline-block" : "none" %>;}
div#search-memberName{display: <%= "memberName".equals(searchType) ? "inline-block" : "none" %>;}
div#search-gender{display: <%= "gender".equals(searchType) ? "inline-block" : "none" %>;}
</style>
<section id="memberList-container">
	<h2>회원관리</h2>
	
    <div id="search-container">
        <label for="searchType">검색타입 :</label> 
        <select id="searchType">
            <option value="memberId" <%= "memberId".equals(searchType) ? "selected" : "" %>>아이디</option>		
            <option value="memberName" <%= "memberName".equals(searchType) ? "selected" : "" %>>회원명</option>
            <option value="gender" <%= "gender".equals(searchType) ? "selected" : "" %>>성별</option>
        </select>
        <div id="search-memberId" class="search-type">
            <form action="<%=request.getContextPath()%>/admin/memberFinder">
                <input type="hidden" name="searchType" value="memberId"/>
                <input type="text" name="searchKeyword" value="<%= "memberId".equals(searchType) ? searchKeyword : "" %>" size="25" placeholder="검색할 아이디를 입력하세요."/>
                <button type="submit">검색</button>			
            </form>	
        </div>
        <div id="search-memberName" class="search-type">
            <form action="<%=request.getContextPath()%>/admin/memberFinder">
                <input type="hidden" name="searchType" value="memberName"/>
                <input type="text" name="searchKeyword" <%= "memberName".equals(searchType) ? searchKeyword : "" %> size="25" placeholder="검색할 이름을 입력하세요."/>
                <button type="submit">검색</button>			
            </form>	
        </div>
        <div id="search-gender" class="search-type">
            <form action="<%=request.getContextPath()%>/admin/memberFinder">
                <input type="hidden" name="searchType" value="gender"/>
                <input type="radio" name="searchKeyword" value="M" <%= "gender".equals(searchType) && "M".equals(searchKeyword) ? "checked" : "" %>> 남
                <input type="radio" name="searchKeyword" value="F" <%= "gender".equals(searchType) && "F".equals(searchKeyword) ? "checked" : "" %>> 여
                <button type="submit">검색</button>
            </form>
        </div>
    </div>
	
	<table id="tbl-member">
		<thead>
			<tr>
				<th>아이디</th>
				<th>이름</th>
				<th>회원권한</th>
				<th>성별</th>
				<th>생년월일</th>
				<th>이메일</th>
				<th>전화번호</th>
				<th>주소</th>
				<th>취미</th>
				<th>가입일</th>
			</tr>
		</thead>
		<tbody>
<%
	for(Member member : list) {
%>
		<tr>
			<td><%= member.getMemberId() %></td>
			<td><%= member.getMemberName() %></td>
			<td>
				<form
				name="memberRoleUpdateFrm" 
				action="<%= request.getContextPath() %>/admin/memberRoleUpdate"
				method="POST">
				<input type="hidden" name="memberId" value="<%= member.getMemberId() %>" />
					<select name="memberRole" class="member-role">
						<option value="<%= MemberService.USER_ROLE %>" <%= MemberService.USER_ROLE.equals(member.getMemberRole()) ? "selected" : "" %>>일반</option>
						<option value="<%= MemberService.ADMIN_ROLE %>" <%= MemberService.ADMIN_ROLE.equals(member.getMemberRole()) ? "selected" : "" %>>관리자</option>
					</select>				
				</form>
			</td>
			<td><%= member.getGender() %></td>
			<td><%= member.getBirthday() != null ? member.getBirthday() : "" %></td>
			<td><%= member.getEmail() != null ? member.getEmail() : "" %></td>
			<td><%= member.getPhone() %></td>
			<td><%= member.getAddress() != null ? member.getAddress() : ""%></td>
			<td><%= member.getHobby() != null ? member.getHobby() : ""%></td>
			<td><%= member.getEnrollDate() %></td>
		</tr>
<%
	}
%>	
		
		</tbody>
	</table>
	<div id="pageBar">
		<%= request.getAttribute("pagebar") %>
	</div>
</section>
<script>
/**
 * 검색 div 노출
 */
$(searchType).change((e) => {
	$(".search-type").hide();
	const v = $(e.target).val();
	$("#search-" + v).css("display", "inline-block");
});


$(".member-role").change((e) => {
	const $select = $(e.target);
	const memberRole = $select.val();
	console.log(memberRole);
	if(confirm(`회원의 권한을 [\${memberRole}]로 변경하시겠습니까?`)){
		const $frm = $select.parent();
		$frm.submit();
	}
	else{
		// selected 초기값으로 복원
		$select.children("[selected]").prop("selected", true);
	}
		
});

</script>
<%@ include file="/WEB-INF/views/common/footer.jsp" %>
