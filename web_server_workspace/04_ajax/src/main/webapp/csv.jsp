<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="//code.jquery.com/ui/1.13.0/themes/base/jquery-ui.css">
<script src="<%= request.getContextPath() %>/js/jquery-3.6.0.js"></script>
<script src="https://code.jquery.com/ui/1.13.0/jquery-ui.js"></script>
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
	<h1>csv</h1>
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
	$(btn1).click((e) => {
		$.ajax({
			url: "<%= request.getContextPath() %>/csv/celebList.do",
			method: "GET",
			dataType: "text", // 생략해도 jquery에 의해서 자동으로 처리된다. (Content-Type 헤더값으로 판단)
			success(data){ // out.append한 내용이 여기 담긴다.
				console.log(data);
				const celebs = data.split("\n");
				console.log(celebs);
				
				const $tbody = $(".celeb-container table tbody");
				$tbody.empty(); // 초기화
				
				$.each(celebs, (i, celeb) => {
					const temp = celeb.split(",");
					console.log(i, temp);
					const tr = `<tr>
						<td>\${temp[0]}</td>
						<td>\${temp[1]}</td>
						<td>\${temp[2]}</td>
						<td>
							<img src="<%= request.getContextPath() %>/images/\${temp[3]}" alt="" />
						</td>
						<td>
							<input type="checkbox" \${temp[4] === 'true' ? 'checked' : ''}/>
						</td>
					</tr>`;
					console.log(tr);
					$tbody.append(tr);
				});
			},
			error(xhr, textStatus, err){
				console.log(xhr, textStatus, err);
			}
			
		});
	});
	</script>
	
	<hr />
	
	<h2>autocomplete</h2>
	<input type="search" name="classmate" id="classmate" />
	<script>
	
	$(classmate).autocomplete({
		source: function(request, response){
			// console.log(request); // {term: 'abc'} // request에는 사용자 입력값이 들어있다.
			// console.log(response); // f  // response에는 사용자 입력값을 처리할 콜백함수가 들어있다.
			
			$.ajax({
				url: "<%= request.getContextPath() %>/csv/autocomplete.do",
/* 				data: "a=123&b=안녕", // key, value형식의 직렬화된 문자열을 쓰거나
				data: {				 // 객체 형식으로 써도 jquery가 알아서 직렬화된 형식으로 바꿔준다.
					a: 123,
					b: "안녕"
				} */
				data: request, // data라는 속성으로 사용자 입력값을 보낼 수 있다.
				method: "GET",
				success(data){
					console.log(data);
					if(data === '') return;
					const names = data.split(",");
					console.log(names);
					const arr = $.map(names, (name, i) => {
						return{
							label: name,
							value: name
						};
					});
					console.log(arr);
					
					response(arr);
					
					
				},
				error: console.log
			});
		},
		minLength: 1,
		focus: function(event, selected){
			// console.log(event, selected);
			// focus되었을때 아무 처리하지 않음.
			return false;
		}
	});
	
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

