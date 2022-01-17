<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<fmt:setLocale value="ko_kr"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mybatis실습</title>
<style>
div#emp-container{text-align:center;}
table.tbl-emp{
	margin:0 auto;
	border:1px solid; 
	border-collapse:collapse;
}
table.tbl-emp th, table.tbl-emp td{
	border:1px solid;
	padding:5px;
}
div#search-container{
	padding:15px 0;
}
input#btn-search { width: 350px; background: lightslategray; color: white; box-shadow: 0px 3px 15px grey; }
table#tbl-search { margin:0 auto; }
table#tbl-search th,table#tbl-search td {padding:5px 15px;}
table#tbl-search td {text-align:left;}
</style>
</head>
<body>
<div id="emp-container">
	<h2>사원정보 </h2>
	<div id="search-container">
		<form name="empSearchFrm">
			<table id="tbl-search">
				<tr>
					<th colspan="2">
						<select name="searchType">
							<option value="">검색타입</option>
							<option value="emp_id" ${"emp_id".equals(param.searchType) ? "selected" : ""}>사번</option>
							<option value="emp_name" ${"emp_name".equals(param.searchType) ? "selected" : ""}>사원명</option>
							<option value="email" ${"email".equals(param.searchType) ? "selected" : ""}>이메일</option>
							<option value="phone" ${"phone".equals(param.searchType) ? "selected" : ""}>전화번호</option>
						</select>
						<input type="search" name="searchKeyword" value="${param.searchKeyword}"/>	
					</th>
				</tr>	
				<tr>
					<th>성별</th>
					<td>
						<!-- (input:radio[name=gender][value]#gender$+laber[for=gender$])*2 -->
						<input type="radio" name="gender" id="gender1" value="남" ${param.gender eq '남' ? 'checked' : ''}/>
						<label for="gender1">남</label>
						<input type="radio" name="gender" id="gender2" value="여" ${param.gender eq '여' ? 'checked' : ''}/>
						<label for="gender2">여</label>
					</td>
				</tr>
				<tr>
					<th>급여</th>
					<td>
						<input type="number" name="salary" min="0" step="500000" value="${param.salary}" />
						<!-- (input:radio[name=salaryCompare][value]#salaryCompare$+label[for=salaryCompare$])*2 -->
						<input type="radio" name="salaryCompare" id="salaryCompare1" value="ge" ${param.salaryCompare eq 'ge' ? 'checked' : ''}/>
						<label for="salaryCompare1">이상</label>
						<input type="radio" name="salaryCompare" id="salaryCompare2" value="le" ${param.salaryCompare eq 'le' ? 'checked' : ''}/>
						<label for="salaryCompare2">이하</label>
					</td>
				</tr>
				<!-- @실습문제 : 입사일 조회 -->
				<tr>
					<th>입사일</th>
					<td>
						<input type="date" name="hireDate" value="${param.hiredate}"/>	
						<input type="radio" name="hiredateCompare" id="hiredateCompare1" value='le' ${param.hireDateCompare eq 'le' ? 'checked' : ''}/>
						<label for="hiredateCompare1">이전</label>
						<input type="radio" name="hiredateCompare" id="hiredateCompare2" value='ge'${param.hireDateCompare eq 'ge' ? 'checked' : ''}/>
						<label for="hiredateCompare2">이후</label>
					</td>
				</tr>				
				<tr>
					<th colspan="2">
						<input type="submit" value="검색" />
						<input type="reset" value="초기화" onclick="location.href='empSearch2.do'"/>
					</th>
				</tr>
			</table>
		</form>
	</div>
		
	<table class="tbl-emp">
		<thead>
			<tr>
				<th></th><!-- 1부터 넘버링 처리 -->
				<th>사번</th>
				<th>사원명</th>
				<th>주민번호</th><!--뒷6자리는 ******처리-->
				<th>성별</th>
				<th>이메일</th>
				<th>전화번호</th>
				<th>부서코드</th>
				<th>직급코드</th>
				<th>급여레벨</th>
				<th>급여</th><!--원화기호, 세자리마다 콤마표시-->
				<th>보너스율</th><!--percent로 표시-->
				<th>매니져 사번</th>
				<th>입사일</th><!--날짜형식 yyyy/MM/dd-->
				<th>퇴사여부</th>
			</tr>
		</thead>
		<!-- 조회된 데이터가 있는 경우와 없는 경우를 분기처리 하세요 -->
		<tbody>
			<c:if test="${not empty list}">
					<c:forEach items="${list}" var="emp" varStatus="vs">
						<tr>
							<td>${vs.count}</td>
							<td>${emp.empId}</td>
							<td>${emp.empName}</td>
							<td>${fn:substring(emp.empNo, 0, 8)}******</td>
							<td>${emp.gender}</td>
							<td>${emp.email}</td>
							<td>${emp.phone}</td>
							<td>${emp.deptCode}</td>
							<td>${emp.jobCode}</td>
							<td>${emp.salLevel}</td>
							<td><fmt:formatNumber value="${emp.salary}" type="currency"/></td>
							<td><fmt:formatNumber value="${emp.bonus}" type="percent"/></td>
							<td>${emp.managerId}</td>
							<td><fmt:formatDate value="${emp.hireDate}" pattern="yyyy/MM/dd"/></td>
							<td>${emp.quitYn}</td>
						</tr>	
					</c:forEach>
			</c:if>
			<c:if test="${empty list}">
				<tr>
					<td colspan="15">조회된 행이 없습니다.</td>
				</tr>
			</c:if>
		</tbody>
		
	</table>
</div>

</body>
</html>
