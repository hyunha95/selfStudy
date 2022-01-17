--문제
-- 남여사원의 수를 조회
select
    sum(case when substr(emp_no,8,1) in ('1', '3') then 1 else 0 end ) 남,
    sum(case when substr(emp_no,8,1) in ('2', '4') then 1 else 0 end) 여,
    sum(decode(substr(emp_no,8,1),'1',1,'3',1)) 남,
    sum(decode(substr(emp_no,8,1), '2',1,'4',1)) 여
from    
    employee;
    

-- 함수실습문제
-- 1. 직원명과 이메일 , 이메일 길이를 출력하시오
select
    emp_name 이름,
    email 이메일,
    length(email) 이메일길이
from
    employee;
    
-- 2. 직원의 이름과 이메일 주소중 아이디 부분만 출력하시오
select
    emp_name,
    substr(email,1, instr(email, '@') - 1)
from
    employee;
    
-- 3. 60년대에 태어난 직원명과 년생, 보너스 값을 출력하시오 
select
    emp_name as "직원명",
    substr(emp_no,1,2) + 1900 as "년생",
    nvl(bonus, 0) as "보너스"
from
    employee
where
    substr(emp_no,1,2) between 60 and 69;

-- 4. '010' 핸드폰 번호를 쓰지 않는 사람의 수를 출력하시오 (뒤에 단위는 명을 붙이시오)
select
    count(*) || '명' as "인원"
from
    employee
where
    phone not like '010%';
    
    
 select * from employee;   
    
-- 5. 직원명과 입사년월을 출력하시오
select
    emp_name as "직원명",
    to_char(hire_date, 'yyyy"년"mm"월"') as "입사년월"
from 
    employee;
    
-- 6. 직원명과 주민번호를 조회하시오
select
    emp_name 직원명,
    rpad(substr(emp_no,1, 8),14,'*') 주민번호
from
    employee;

-- 7. 직원명, 직급코드, 연봉(원) 조회
select
    emp_name 직원명,
    job_code 직급코드,
    to_char((salary + salary * nvl(bonus,0)) * 12, 'FML999,999,999,999') || '원' "연봉(원)"
from    
    employee;

-- 8. 부서코드가 D5, D9인 직원들 중에서 2004년도에 입사한 직원중에 조회함.
select
    emp_id,
    emp_name,
    dept_code,
    hire_date
from
    employee
where
    dept_code in ('D5', 'D9')
    and
    extract(year from hire_date) = 2004;

-- 9. 직원명, 입사일, 오늘까지의 근무일수 조회 
select
    emp_name 직원명,
    hire_date 입사일,
    case quit_yn
        when 'Y' then trunc(quit_date - hire_date)
        when 'N' then trunc(sysdate - hire_date)
        end 근무일수
from
    employee;

select * from employee;

-- 10. 직원명, 부서코드, 생년월일, 나이(만) 조회
select
--  이거 안됨to_date(decode(substr(emp_no,8,1), '1','19000000','2','19000000','2000000') + substr(emp_no,1,6), 'yymmdd')
    emp_name 직원명,
    dept_code 부서코드,
    case 
        when substr(emp_no,8,1) in ('1','2') then '19' || to_char(to_date(substr(emp_no,1,6), 'yymmdd'), 'yy"년"mm"월"dd"일"')
        else '20' || to_char(to_date(substr(emp_no,1,6), 'yymmdd'), 'yy"년"mm"월"dd"일"')
        end 생년월일, -- 주민번호 앞6자리를 date타입으로 바꿔주고 to_char에 넣어 양식에 맞춘다.
    extract(year from sysdate) - (decode(substr(emp_no,8,1),'1','1900','2','1900','2000') + substr(emp_no,1,2)) "나이(만)"
from    
    employee;
    
-- 11. 직원들의 입사일로 부터 년도만 가지고, 각 년도별 입사인원수를 구하시오.    
select
    sum(decode(extract(year from hire_date), '1998','1','0')) "1998년",
    sum(decode(extract(year from hire_date), '1999','1','0')) "1999년",
    sum(decode(extract(year from hire_date), '2000','1','0')) "2000년",
    sum(decode(extract(year from hire_date), '2001','1','0')) "2001년",
    sum(decode(extract(year from hire_date), '2002','1','0')) "2002년",
    sum(decode(extract(year from hire_date), '2003','1','0')) "2003년",
    sum(decode(extract(year from hire_date), '2004','1','0')) "2004년",
    sum(decode(quit_yn, 'Y', '0', '1')) 전체직원수
from
    employee;
    
-- 12.  부서코드가 D5이면 총무부, D6이면 기획부, D9이면 영업부로 처리하시오.(case 사용)
select
    emp_name 사원명,
    dept_code 부서코드,
    case dept_code
        when 'D5' then '총무부'
        when 'D6' then '기획부'
        when 'D9' then '영업부'
        end 부서명
from
    employee
where
    dept_code in ('D5', 'D6', 'D9')
order by
    dept_code;

