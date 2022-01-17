<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
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
	<h1>json</h1>
	<button id="btn">전체조회</button>
	<div class="celeb-container">
		<table id="tbl-celeb-list">
			<thead>
				<tr>
					<th>이름</th>
					<th>전화번호</th>
					<th>나이</th>
					<th>프로필</th>
					<th>결혼여부</th>
				</tr>
			</thead>
			<tbody></tbody>
		</table>
	</div>
	<script>
	$(btn).click((e) => {
		
		$.ajax({
			url: "<%= request.getContextPath() %>/json/celebList.do",
			dataType: "json",
			success(data){
				console.log(data);
				
				const $tbody = $("#tbl-celeb-list tbody").empty();
				
				$(data).each((i, {name, phone, age, profile, married}) => {
					const tr = `<tr>
						<td>\${name}</td>
						<td>\${phone}</td>
						<td>\${age}</td>
						<td>
							<img src="<%= request.getContextPath() %>/images/\${profile}" alt="" />
						</td>
						<td>
							<input type="checkbox" \${married ? 'checked' : ''}/>
						</td>
					</tr>`;
					$tbody.append(tr);
				});
			},
			error: console.log
		}); 
		
	});
	</script>


	<hr />
	
	<input type="number" id="index" />
	<button id="btn2">인덱스조회</button>
	<div class="celeb-container">
		<table id="tbl-celeb-one"></table>
	</div>
	<script>
	$(btn2).click((e) => {
		
		$.ajax({
			url: "<%= request.getContextPath() %>/json/celebOne.do",
			data: {
				index: $(index).val()
			},
			success(data){
				console.log(data);
				if(data == null){
					alert("조회된 Celeb이 없습니다.");
					return;
				}
				const {name, phone, age, profile, married} = data;
				const $table = $("#tbl-celeb-one");
				const $tbody = `<tbody>
					<tr>
						<td rowspan="4">
							<img src="<%= request.getContextPath() %>/images/\${profile}" alt="" />
						</td>
						<td>이름</td>
						<td>\${name}</td>
					</tr>
					<tr>
						<td>전화번호</td>
						<td>\${phone}</td>
					</tr>
					<tr>
						<td>나이</td>
						<td>\${age}</td>
					</tr>
					<tr>
						<td>결혼여부</td>
						<td>
							<input type="checkbox" \${married ? "checked" : ""}/>
						</td>
					</tr>
				</tbody>`;
				
				$table.html($tbody);
			},
			error: console.log
		});
		
	});
	</script>
	
	<hr />
	<h2>Celeb등록</h2>
	<div class="celeb-container">
		<form name="celebEnrollFrm">
			<table>
				<tr>
					<th>이름</th>
					<td><input type="text" name="name" required/></td>
				</tr>
				<tr>
					<th>전화번호</th>
					<td><input type="text" name="phone" required/></td>
				</tr>
				<tr>
					<th>나이</th>
					<td><input type="number" name="age" required/></td>
				</tr>							
				<tr>
					<th>프로필</th>
					<td><input type="file" name="profile" /></td>
				</tr>	
				<tr>
					<th>결혼여부</th>
					<td><input type="checkbox" name="married" /></td>
				</tr>		
				<tr>
					<th colspan="2">
						<input type="submit" value="등록" />
					</th>
				</tr>					
			</table>
		</form>
	</div>
	<script>
	$(document.celebEnrollFrm).submit((e) => {
		e.preventDefault(); // 제출방지
		/*
		const celeb = {
				name: $("[name=name]", e.target).val(),
				phone: $("[name=phone]", e.target).val(),
				age: $("[name=age]", e.target).val(),
		};
		if($("[name=married]", e.target).is(":checked"))
			celeb.married = "on";
		*/
		
		// 파일전송을 위해 FormData객체 변환
		const formData = new FormData(document.celebEnrollFrm);
		
		$.ajax({
			url: "<%= request.getContextPath() %>/json/celebEnroll.do",
			method: "POST",
			data: formData,
			enctype: "multipart/form-data", //파일 업로드하기 위한 것 // 생략 가능
			processData: false, // Content-Type: application/x-www-formurlencoded에 따른 처리 안함 //파일 업로드하기 위한 것. 생략 불가
			contentType: false, // Content-Type: application/x-www-formurlencoded 설정 하지 않음. //파일 업로드하기 위한 것. 생략 불가
			dataType: "json",
			success(data){
				console.log(data);
				alert(data.msg);
				
				$(btn).trigger("click"); //click핸들러 호출
			},
			error: console.log,
			complete(){
				document.celebEnrollFrm.reset(); // 폼 초기화 // reset은 jquery에 없다
			}
		});
		
	});
	</script>

	<h2>일일 박스오피스 조회</h2>
	<div>
		<input type="date" id="targetDt" />
	</div>
	<div class="boxoffice-container">
		<table>
			<thead>
				<tr>
					<th>순위</th>
					<th>영화제목</th>
					<th>누적관객수(만)</th>
				</tr>
			</thead>
			<tbody></tbody>
		</table>
	</div>
	<script>
	$(() => {
		// 페이지 로딩시 어제날짜의 박스오피스 조회
		const today = new Date();
		const yesterday = new Date(today.getFullYear(), today.getMonth(), today.getDate() - 1);
		//console.log(yesterday);
		
		// #targetDt 날짜 채우기 : yyyy-mm-dd
		const value = `\${yesterday.getFullYear()}-\${f(yesterday.getMonth() + 1)}-\${f(yesterday.getDate())}`;
		$(targetDt).val(value);
		
		getDailyBoxOffice(yesterday);
	});
	
	$(targetDt).change((e) => {
		const d = new Date($(e.target).val());
		console.log($(e.target).val());
		getDailyBoxOffice(d);
		
	});
	
	const f = n => n < 10 ? "0" + n : n;
	
	const getDailyBoxOffice = (d) => {
		const value = `\${d.getFullYear()}\${f(d.getMonth() + 1)}\${f(d.getDate())}`;
		console.log(value);
		$.ajax({
			url: "http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json",
			data: {
				key: "5814a3688b740b4d452581698c9176e4",
				targetDt: value
			},
			dataType: "json",
			success(data){
				console.log(data);
				const {boxOfficeResult: {dailyBoxOfficeList}} = data;
				const $tbody = $(".boxoffice-container tbody").empty();
				
				$(dailyBoxOfficeList).each((i, {rank, movieNm, audiAcc}) => {
					audiAcc = Math.floor((audiAcc / 10000) * 10) / 10; // 만단위 출력(소수점 첫번째자리까지)
					console.log(rank, movieNm, audiAcc);
					const tr = `<tr>
						<td>\${rank}</td>
						<td>\${movieNm}</td>
						<td>\${audiAcc}만</td>
					</tr>`;
					
					$tbody.append(tr);
				});
			},
			error: console.log
		});
	};
	</script>











	<br />
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />
</body>
</html>