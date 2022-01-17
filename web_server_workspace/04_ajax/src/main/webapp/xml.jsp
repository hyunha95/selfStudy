<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>xml</title>
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
	<h1>xml</h1>
	<button id="btn1">실행</button>
	<div class="celeb-container">
		<table>
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
	$(btn1).on('click', (e) => {
		
		$.ajax({
			url: "<%= request.getContextPath() %>/xml/celebList.do",
			dataType: "xml", // jquery : xml형식의 문자열을 parsing한 후, document객체로 success함수에 전달
			success(data){
				console.log(data);
				// console.log(typeof data); // object
				
				// 루트태그 찾기
				const $root = $(data).find(":root");
				// console.log($root);
				
				const $celebs = $root.children();
				// console.log($celebs);

				const $tbody = $(".celeb-container table tbody");
				$tbody.empty();
				
				$celebs.each((i, celeb) => {
					const name = $(celeb).children("name").text();
					const phone = $(celeb).children("phone").text();
					const age = $(celeb).children("age").text();
					const profile = $(celeb).children("profile").text();
					const married = $(celeb).children("married").text();
					console.log(name, phone, age, profile, married);
					
					const tr = `<tr>
						<td>\${name}</td>
						<td>\${phone}</td>
						<td>\${age}</td>
						<td>
							<img src="\${profile}" alt="" />
						</td>
						<td>
							<input type="checkbox" \${married === 'true' ? 'checked' : ''} />
						</td>
					</tr>`;
					$tbody.append(tr);
				});
			},
			error: console.log
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
		const yesterday = new Date(today.getFullYear(), today.getMonth(), today.getDate() - 1); // 오늘이 특정 달의 1일이라도 전달의 마지막 날을 반환한다.
		console.log(yesterday);
		
		// #targetDt 날짜 채우기 : yyyy-mm-dd
		const value = `\${yesterday.getFullYear()}-\${f(yesterday.getMonth() + 1)}-\${f(yesterday.getDate())}`;
		$(targetDt).val(value);
		
		getDailyBoxOffice(yesterday);
	});
	
	$(targetDt).change((e) => {
		const d = new Date($(e.target).val());
		getDailyBoxOffice(d);
	});
	
	const f = n => n < 10 ? "0" + n : n;
	
	const getDailyBoxOffice = (d) => {
		const value = `\${d.getFullYear()}\${f(d.getMonth() + 1)}\${f(d.getDate())}`;
		$.ajax({
			url: "https://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.xml",
			data: {
				key: "5814a3688b740b4d452581698c9176e4", // 실제 발급받은 발급키
				targetDt: value
			},
			success(data){
				console.log(data);
				const $dailyBoxOfficeList = $(data).find("dailyBoxOfficeList");
				const $movies = $dailyBoxOfficeList.children();
				
				const $tbody = $(".boxoffice-container tbody").empty();
				
				$movies.each((i, movie) => {
					const $movie = $(movie);
					console.log($movie.prop("tagName")); // 태그명 조회
					const rank = $(movie).children("rank").text();
					const movieNm = $(movie).children("movieNm").text();
					let audiAcc = $(movie).children("audiAcc").text();
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
	
</body>
</html>