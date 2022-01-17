<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<section id=enroll-container>
	<h2>회원 가입 정보 입력</h2>
	<form name="memberEnrollFrm" action="" method="POST"> <!-- action속성에 값을 적지 않은 이유는 어차피 같은 페이지이기 때문이다. -->
		<table>
			<tr>
				<th>아이디<sup>*</sup></th>
				<td>
					<input type="text" placeholder="4글자이상" name="memberId" id="_memberId" value="sinsa" required>
					<input type="button" value="아이디중복검사" onclick="checkIdDuplicate();"/>
					<input type="hidden" id="idValid" value="0" />
					<%-- #idValid의 값이 0이면 중복검사하지 않음. 1이면 중복검사 통과! --%>
				</td>
			</tr>
			<tr>
				<th>패스워드<sup>*</sup></th>
				<td>
					<input type="password" name="password" id="_password" value="1234" required><br>
				</td>
			</tr>
			<tr>
				<th>패스워드확인<sup>*</sup></th>
				<td>	
					<input type="password" id="passwordCheck" value="1234" required><br>
				</td>
			</tr>  
			<tr>
				<th>이름<sup>*</sup></th>
				<td>	
				<input type="text"  name="memberName" id="memberName" value="신사임당" required><br>
				</td>
			</tr>
			<tr>
				<th>생년월일</th>
				<td>	
				<input type="date" name="birthday" id="birthday" value="2000-09-09"><br />
				</td>
			</tr> 
			<tr>
				<th>이메일</th>
				<td>	
					<input type="email" placeholder="abc@xyz.com" name="email" id="email" value="sinsa@naver.com"><br>
				</td>
			</tr>
			<tr>
				<th>휴대폰<sup>*</sup></th>
				<td>	
					<input type="tel" placeholder="(-없이)01012345678" name="phone" id="phone" maxlength="11" value="01012341234" required><br>
				</td>
			</tr>
			<tr>
				<th>주소</th>
				<td>	
					<input type="text" placeholder="" name="address" id="address" value="서울시 강남구 테헤란로"><br>
				</td>
			</tr>
			<tr>
				<th>성별 </th>
				<td>
					<input type="radio" name="gender" id="gender0" value="M" checked>
					<label for="gender0">남</label>
					<input type="radio" name="gender" id="gender1" value="F">
					<label for="gender1">여</label>
				</td>
			</tr>
			<tr>
				<th>취미 </th>
				<td>
					<input type="checkbox" name="hobby" id="hobby0" value="운동" checked><label for="hobby0">운동</label>
					<input type="checkbox" name="hobby" id="hobby1" value="등산" checked><label for="hobby1">등산</label>
					<input type="checkbox" name="hobby" id="hobby2" value="독서" checked><label for="hobby2">독서</label><br />
					<input type="checkbox" name="hobby" id="hobby3" value="게임"><label for="hobby3">게임</label>
					<input type="checkbox" name="hobby" id="hobby4" value="여행"><label for="hobby4">여행</label><br />
				</td>
			</tr>
		</table>
		<input type="submit" value="가입" >
		<input type="reset" value="취소">
	</form>
</section>
<form 
	name="checkIdDuplicateFrm" 
	action="<%= request.getContextPath() %>/member/checkIdDuplicate"
	method="GET">
	<input type="hidden" name="memberId" />
</form>
<script>
const checkIdDuplicate = () => {
	const name = "checkIdDuplicatePopup"; // 팝업페이지 window객체의 name속성
	const spec = "left=500px, top=500px, width=300px, height=250px";
	const popup = open("", name, spec); // url속성은 작성하지 않는다.
	
	const $memberId = $(_memberId);
	const $frm = $(document.checkIdDuplicateFrm);
	$frm.find("[name=memberId]").val($memberId.val());
	$frm.attr("target", name) // popup에 폼을 제출
		.submit();
};

/**
 * 중복검사이후 아이디를 변경한 경우, 다시 중복검사해야 한다.
 */
$(_memberId).change(() => {
	$(idValid).val(0);
})


/**
 * name=memberEnrollFrm 유효성검사
 * - id/비번 영문자/숫자 4글자이상
 * - 이름 한글 2글자 이상
 * - 전화번호 숫자확인
 */
$(document.memberEnrollFrm).submit((e) => {
	
	//memberId
	const $memberId = $(_memberId);
	//아이디는 영문자/숫자  4글자이상만 허용 
	if(!/^\w{4,}$/.test($memberId.val())){
		alert("아이디는 최소 4자리이상이어야 합니다.");
		return false;
	}
	
	//memberId 중복검사
	const $idValid = $(idValid);
	if($idValid.val() == 0){
		alert("아이디 중복 검사해주세요.");
		return false;
	}
	
	//password
	const $password = $(_password);
	const $passwordCheck = $(passwordCheck);
	
	if(!/^[a-zA-Z0-9!@#$]{4,}$/.test($password.val())){
		alert("유효한 패스워드를 입력하세요.");
		return false;
	}
	if($password.val() != $passwordCheck.val()){
		alert("패스워드가 일치하지 않습니다.");
		return false;
	}
	
	//memberName
	const $memberName = $(memberName);
	if(!/^[가-힣]{2,}$/.test($memberName.val())){
		alert("이름은 한글 2글자 이상이어야 합니다.");
		return false;
	}
	
	//phone
	const $phone = $(phone);
	if(!/^010[0-9]{8}$/.test($phone.val())){
		alert("유효한 전화번호가 아닙니다.");
		return false;
	}
	return true;
});
</script>
<%@ include file="/WEB-INF/views/common/footer.jsp" %>