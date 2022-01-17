<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>스마트 가전센터</title>
<script src="<%= request.getContextPath() %>/js/jquery-3.6.0.js"></script>
<style>
div.container{
	float: left;
	width: 29%;
	height:300px;
    margin: 10px;
    padding: 10px;
	background:lightgrey;
	text-align:center;
}
table {
	border:1px solid;
	margin:auto;
}
td,th {
	border:1px solid;
}
span#time{
	text-decoration:underline;
	margin: 15px;
    display: block;
}
</style>
</head>
<body>
<h1>스마트 가전 센터 주문페이지</h1>
<p>
	1. ajax를 이용해서 제품주문을 처리하고, 실시간 판매현황(최근5건)에 출력하세요. <br />
	2. 10초마다 판매랭킹리스트(상위5개제품과 누적판매량)를 갱신하는 ajax함수를 작성하세요. <br />
	(bonus) 현재시각을 표시하세요.
</p>
<div id="order-container" class="container">
	<h2>주문</h2>
	<table>
		<tr>
			<th>제품명</th>
			<td>
				<select name="pname" id="pname" required>
					<option value="iPhoneX">iPhoneX</option>
					<option value="iPhone7">iPhone7</option>
					<option value="iPhone7Plus">iPhone7Plus</option>
					<option value="GalaxyNote8">GalaxyNote8</option>
					<option value="Galaxy8">Galaxy8</option>
					<option value="샤오미맥스2">샤오미맥스2</option>
					<option value="LGV30">LGV30</option>
				</select>
			</td>
		</tr>
		<tr>
			<th>주문량</th>
			<td><input type="number" id="amount" name="amount" min="1" value="1" required></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="button" id="btn-order" value="주문" />
			</td>
		</tr>
	</table>
</div>
<div class="container">
	<h2>주문리스트</h2>
	<div id="order-list">
		<table>
			<thead>
				<tr>
					<th>제품명</th>
					<th>수량</th>
					<th>주문일자</th>
				</tr>
			</thead>
			<tbody></tbody>
		</table>
	</div>
</div>
<div class="container">
	<h2>인기순위</h2>
	<span id="time" onload="displayClock()"></span>
	<div id="rank-list">
		<table>
			<thead>
				<tr>
					<th>순위</th>
					<th>제품명</th>
					<th>누적판매량</th>
				</tr>
			</thead>
			<tbody></tbody>
		</table>
	</div>
</div>
<script>

// 주문
$("#btn-order").click((e) =>{
	$.ajax({
		url: "<%= request.getContextPath() %>/smart/smartList",
		dataType: "json",
		data: {
			'pname': $("#pname").val(), 
			'amount': $("#amount").val()},
		success(data){
			console.log(data);
			
			const $tbody = $("#order-list").find("tbody");
			$tbody.empty();
			
			$(data).each((i, {pname, amount, pdate}) => {
				// console.log(pname, amount, pdate);
				const tr = `<tr>
					<td>\${pname}</td>
					<td>\${amount}</td>
					<td>\${pdate}</td>
				</tr>`;
				$tbody.append(tr); 
			});
		},
		error: console.log
		
	});
	$("#amount").val(1);
});

// 페이지 로딩시 실시간 판매현황 바로 한번 찍힌다.
$(() => {
	$.ajax({
		url: "<%= request.getContextPath() %>/smart/orderList",
		dataType: "json",
		success(data){
			console.log(data);
			const $tbody = $("#order-list").find("tbody");
			$tbody.empty();
			
			$(data).each((i, {pname, amount, pdate}) => {
				// console.log(pname, amount, pdate);
				const tr = `<tr>
					<td>\${pname}</td>
					<td>\${amount}</td>
					<td>\${pdate}</td>
				</tr>`;
				$tbody.append(tr); 
			});
		},
		error: console.log
	});
});



// 인기순위 갱신
$(() => {
	(function foo() {
		$.ajax({
			url: "<%= request.getContextPath() %>/smart/rankList",
			dataType: "json",
			success(data){
				console.log(data);
				const $tbody = $("#rank-list").find("tbody");
				$tbody.empty();
				
				$(data).each((i, {rank, pname, accAmount}) => {
					// console.log(pname, amount, pdate);
					const tr = `<tr>
						<td>\${rank}</td>
						<td>\${pname}</td>
						<td>\${accAmount}</td>
					</tr>`;
					$tbody.append(tr); 
				});
			},
			error: console.log
		});
		setTimeout(foo, 10000);
	})();
	
	
});


function displayClock() {
    const f = function(n){
        return n < 10 ? `0\${n}` : n;
    };
    const now = new Date();
    const year = now.getFullYear();
    const month = f(now.getMonth() + 1);
    const date = f(now.getDate());
    const hour = f(now.getHours());
    const minute = f(now.getMinutes());
    const second = f(now.getSeconds());
    let a = 0;
    if(hour > 12)
    	a = "오후";
    else
    	a = "오전";

    return `\${year}년 \${month}월 \${date}일 \${a} \${hour}:\${minute}:\${second}`;
}

(function repeatClock() {
    time.innerHTML = displayClock();
    setTimeout(repeatClock, 1000); // callback함수를 1000밀리초후에 실행
})();




</script>
</body>
</html>
















