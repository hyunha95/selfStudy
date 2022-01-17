-- 서브쿼리 문제는 join문제 다시 풀어보기
-- ## @실습문제
-- 1. employee테이블에서 1990년대에 입사한 사원의 사번, 사원명, 입사년도를 인라인뷰를 사용해서 출력.
select
    *
from(
    select
        emp_id,
        emp_name,
        extract(year from hire_date) as 입사년도
    from
        employee
) 
where
    입사년도 - 1990 between 0 and 9;
    
-- 2. employee테이블에서 사원중 30대, 40대인 여자사원의 사번, 부서명, 성별, 나이를 출력하라.
with emp_age
as(
select
    emp_id,
    dept_title,
    decode(substr(emp_no,8,1),'1','남','3','남','여')gender,
    extract(year from sysdate) - (decode(substr(emp_no,8,1),'1',1900,'2',1900,2000) + substr(emp_no,1,2)) + 1 as age
from employee  e left join department d
    on e.dept_code = d.dept_id
)
select
    *
from
    emp_age
where
    age between 30 and 49;
    

    