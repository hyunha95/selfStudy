--=============================================
--210824
--=============================================
--문제 1

select * from employee;
-- 1. JOB테이블에서 JOB_NAME의 정보만 출력되도록 하시오
SELECT
    job_name
FROM
    job;

-- 2. DEPARTMENT테이블의 내용 전체를 출력하는 SELECT문을 작성하시오
select 
    *
from
    department;

-- 3. EMPLOYEE 테이블에서 이름(EMP_NAME),이메일(EMAIL),전화번호(PHONE),고용일(HIRE_DATE)만 출력하시오
select
    emp_name,
    email,
    phone,
    hire_date
from 
    employee;

-- 4. EMPLOYEE 테이블에서 고용일(HIRE_DATE) 이름(EMP_NAME),월급(SALARY)를 출력하시오
select
    hire_date,
    emp_name,
    salary
from 
    employee;

/*5. EMPLOYEE 테이블에서 월급(SALARY)이 2,500,000원이상인 사람의 
EMP_NAME 과 SAL_LEVEL을 출력하시오 
(힌트 : >(크다) , <(작다) 를 이용)*/
select
    emp_name,
    sal_level
from 
    employee
where
    salary >= 2500000;
    
/*6. EMPLOYEE 테이블에서 월급(SALARY)이 350만원 이상이면서 JOB_CODE가 'J3' 인 사람의 
이름(EMP_NAME)과 전화번호(PHONE)를 출력하시오
(힌트 : AND(그리고) , OR (또는))*/
select
    emp_name,
    phone
from 
    employee
where
    (salary >= 3500000) and (job_code = 'J3');

-- 7. employee테이블에서 현재 근무중인 사원을 이름 오름차순으로 정렬해서 출력.
select
    emp_name
from 
    employee
where
    quit_yn = 'N'
order by
    emp_name asc;



--문제 2
/*today회사의 회원테이블을 만든다. 다음조건을 만족하는 컬럼 데이터타입을 작성하자.
* id : 6자리에서 15자리(변동가능성 없음)
* password : 8자리이상 15자리
* name : 한글입력 
* phone : - 없이 11자리
* ssn 주민등록번호 : -없이 13자리
* mileage 회원마일리지 : 
* reg_date 가입일 : */

--선생님풀이
CREATE TABLE tbl_member_today (
		id varchar2(15)
		,password char(15)
		,name varchar2(30)
		,phone char(11)
		,ssn char(13)
		,mileage number
		,reg_date date
);
--내풀이
/*create table today(
    id char(15),
    password char(15),
    name char(12),
    phone char(11),
    ssn char(13),
    mileage number,
    reg_date date
);*/

insert into tbl_member_today
values('hyunha95', '11112222', '노현하', '01022223333', '1234567891123', '100', sysdate);

select * from tbl_member_today;
















