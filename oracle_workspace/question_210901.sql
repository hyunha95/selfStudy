-- @실습문제 : 월별로 제품별 충 판매량을 출력하세요.
select
    to_char(sale_date, 'yyyy-mm') as 판매월, 
    p_name as 제품명,
    sum(p_count) as 판매량
from(
select * from tbl_sales
union all
select * from tbl_sales_202108
union all
select * from tbl_sales_202107
)
group by
    to_char(sale_date, 'yyyy-mm'), p_name
order by
    판매월 asc;
    
    
-- 1. 2020년 12월 25일이 무슨 요일인지 조회하시오.
select
    to_char(to_date('20201225','yyyymmdd'),'day')
from
    dual;

-- 2. 주민번호가 70년대 생이면서 성별이 여자이고, 성이 전씨인 직원들의 
--사원명, 주민번호, 부서명, 직급명을 조회하시오.
select
    emp_name,
    emp_no,
    dept_title,
    job_name
from
    employee e 
        join department d
            on e.dept_code = d.dept_id
        join job j
            on e.job_code = j.job_code
where
    substr(emp_no,1,1) = 7
    and
    substr(emp_no,8,1) in ('2','4')
    and
    emp_name like '전%';

-- 3. 가장 나이가 적은 직원의 사번, 사원명, 나이, 부서명, 직급명을 조회하시오.
select
    e.*
from(
select
    emp_id,
    emp_name,
    extract(year from sysdate) - (decode(substr(emp_no,8,1), '1',1900,'2',1900,2000) + substr(emp_no,1,2)) + 1 as 나이,
    d.dept_title,
    job_name
from
    employee e 
        join department d
            on e.dept_code = d.dept_id
        join job
        using(job_code)
order by
    나이
) e
where
    rownum = 1;
        
-- 4. 이름에 '형'자가 들어가는 직원들의 사번, 사원명, 부서명을 조회하시오.
select
    e.emp_id,
    e.emp_name,
    d.dept_title
from
    employee e join department d
        on e.dept_code = d.dept_id
where
    emp_name like '%형%';

-- 5. 해외영업팀에 근무하는 사원명, 직급명, 부서코드, 부서명을 조회하시오.
select
    e.emp_name,
    job_name,
    e.dept_code,
    d.dept_title
from
    employee e 
        join department d
            on e.dept_code = d.dept_id
        join job
        using(job_code)
where
    d.dept_title like '해외영업%';

-- 6. 보너스포인트를 받는 직원들의 사원명, 보너스포인트, 부서명, 근무지역명을 조회하시오.
select
    e.emp_name,
    e.bonus,
    d.dept_title,
    n.national_name
from
    employee e, department d, location l, nation n
    
where
    e.dept_code = d.dept_id
    and
    d.location_id = l.local_code
    and
    l.national_code = n.national_code
    and
    bonus is not null;
    
-- 7. 부서코드가 D2인 직원들의 사원명, 직급명, 부서명, 근무지역명을 조회하시오.
select
    e.emp_name,
    j.job_name,
    d.dept_title,
    n.national_name
from
    employee e, job j, department d, location l, nation n
where
    e.job_code = j.job_code
    and
    e.dept_code = d.dept_id
    and
    d.location_id = l.local_code
    and
    l.national_code = n.national_code
    and
    e.dept_code = 'D2';
    
-- 8. 급여등급테이블의 등급별 최대급여(MAX_SAL)보다 많이 받는 직원들의 사원명, 직급명, 급여, 연봉을 조회하시오.
-- (사원테이블과 급여등급테이블을 SAL_LEVEL컬럼기준으로 동등 조인할 것)
select
    e.emp_name,
    j.job_name,
    e.salary,
    (salary + (salary * nvl(bonus,0))) * 12 as연봉
from
    employee e, job j, sal_grade s
where
    e.job_code = j.job_code
    and
    e.sal_level = s.sal_level
    and
    e.salary > s.max_sal;

-- 9. 한국(KO)과 일본(JP)에 근무하는 직원들의  사원명, 부서명, 지역명, 국가명을 조회하시오.
select
    e.emp_name,
    d.dept_title,
    l.local_name,
    n.national_name
from
    employee e, department d, location l, nation n
where
    e.dept_code = d.dept_id
    and
    d.location_id = l.local_code
    and
    l.national_code = n.national_code
    and
    l.national_code in ('KO', 'JP');

-- 10. 같은 부서에 근무하는 직원들의 사원명, 부서코드, 동료이름을 조회하시오. self join 사용
select
    e1.emp_name,
    e1.dept_code,
    e2.emp_name
from
    employee e1, employee e2
where
    e1.dept_code = e2.dept_code
    and
    e1.emp_name != e2.emp_name
order by 
     2, 1;

-- 11. 보너스포인트가 없는 직원들 중에서 직급이 차장과 사원인 직원들의 사원명, 직급명, 급여를 조회하시오.
select
    e.emp_name,
    j.job_name,
    to_char(salary, 'FML999,999,999,999') as 급여
from
    employee e, job j
where
    e.job_code = j.job_code
    and
    e.bonus is null
    and
    j.job_name in ('차장','사원');

-- 12. 재직중인 직원과 퇴사한 직원의 수를 조회하시오.
select
     sum(decode(quit_yn, 'N',1)) as 재직중,
    sum(decode(quit_yn, 'Y',1)) as 퇴사
from
    employee;

select
    decode(quit_yn, 'N', '재직', '퇴사') 재직여부,
    count(*)
from
    employee
group by
    quit_yn;


select * from employee;
select * from department;
select * from location;
select * from nation;

select * from job;
select * from sal_grade;