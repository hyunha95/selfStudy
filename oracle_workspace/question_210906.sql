--문제1 기술지원부에 속한 사람들의 사람의 이름,부서코드,급여를 출력하시오
select
    emp_name,
    dept_code,
    salary,
    dept_title
from
    employee e, department d
where
    e.dept_code = d.dept_id
    and
    dept_title = '기술지원부';
    
--문제2 기술지원부에 속한 사람들 중 가장 연봉이 높은 사람의 이름,부서코드,급여를 출력하시오
select
    s.*
from(
select
    emp_name,
    dept_code,
    salary
from
    employee e join department d
        on e.dept_code = d.dept_id
where
    dept_title = '기술지원부'
order by
    salary desc
) s
where
    rownum = 1;
    
-- 문제3 매니저가 있는 사원중에 월급이 전체사원 평균보다 많은 사원의 사번,이름,매니저 이름, 월급을 구하시오.
-- 1. JOIN을 이용하시오
select
    e.emp_id,
    e.emp_name,
    e1.emp_name as "매니저 이름",
    e.salary
from
    employee e join employee e1
        on e.manager_id = e1.emp_id
where
    e.manager_id is not null
    and
    e.salary > (select avg(salary) from employee);
    
-- 2. JOIN하지 않고, 스칼라상관쿼리(SELECT)를 이용하기
select
    emp_id,
    emp_name,
    (select emp_name from employee where emp_id = e.manager_id) as "매니저 이름",
    salary
from
    employee e
where
    manager_id is not null
    and 
    salary > (select avg(salary) from employee);

-- 문제4 같은 직급의 평균급여보다 같거나 많은 급여를 받는 직원의 이름, 직급코드, 급여, 급여등급 조회
select
    emp_name,
    job_code,
    salary,
    sal_level
from
    employee e
where
    salary >= (select avg(salary) from employee where job_code = e.job_code)
order by
    2;

-- 문제5 부서별 평균 급여가 3000000 이상인 부서명, 평균 급여 조회. 
-- 단, 평균 급여는 소수점 버림, 부서명이 없는 경우 '인턴'처리
select
    s.*
from(
select
    nvl(dept_code, '인턴'),
    trunc(avg(salary)) as 평균급여
from
    employee
group by
    nvl(dept_code, '인턴')
) s
where
    평균급여 >= 3000000;

-- 문제6 직급의 연봉 평균보다 적게 받는 여자사원의 사원명,직급명,부서명,연봉을 이름 오름차순으로 조회하시오
-- 연봉 계산 => (급여 + (급여*보너스))*12   
select
    emp_name,
    (select dept_title from department where dept_id = e.dept_code),
    (salary + (salary * nvl(bonus, 0))) * 12 as 연봉
from
    employee e
where
    salary < (select avg(salary) from employee where job_code =e.job_code)
order by
    emp_name;

--문제7
--다음 도서목록테이블을 생성하고, 공저인 도서만 출력하세요.
--공저 : 두명이상의 작가가 함께 쓴 도서
create table tbl_books (
book_title  varchar2(50)
,author     varchar2(50)
,loyalty     number(5)
);
insert into tbl_books values ('반지나라 해리포터', '박나라', 200);
insert into tbl_books values ('대화가 필요해', '선동일', 500);
insert into tbl_books values ('나무', '임시환', 300);
insert into tbl_books values ('별의 하루', '송종기', 200);
insert into tbl_books values ('별의 하루', '윤은해', 400);
insert into tbl_books values ('개미', '장쯔위', 100);
insert into tbl_books values ('아지랑이 피우기', '이오리', 200);
insert into tbl_books values ('아지랑이 피우기', '전지연', 100);
insert into tbl_books values ('삼국지', '노옹철', 200);
insert into tbl_books values ('별의 하루', '대북혼', 300);

select
    book_title,
    listagg(author,',') within group(order by author)
from
    tbl_books
group by
    book_title
having
    count(author) > 1




    
    
    
    
    
    
    
    
    
    
