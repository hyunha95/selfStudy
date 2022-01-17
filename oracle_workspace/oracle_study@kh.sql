--21_08_24
-- 사용자가 가진 테이블목록
select * from tab;

-- 사원관리시스템
-- table(entity | relation)
-- 데이터를 저장하는 데이터베이스 객체 . 행과 열로 구성되어 있다.

-- row(record | tuple)
-- 한행은 현실세계의 하나의 객체(사원, 부서, 지역, 국가, 직급...)를 표현하는 단위

-- column(field | attribute)
-- row의 구성요소, 자료형과 값을 가진다.

-- domain
-- 한 컬럼이 가질 수 있는 원자값의 집합. 성별컬럼의 남/여 

select * from employee;
select * from department;
select * from location;
select * from nation;

select * from job;
select * from sal_grade;

-- 테이블 명세 간단 조회 (NOT NULL은 값이 무조건 있어야함을 표시한다.)
describe employee;
desc employee;

--=========================================================
--DATA TYPE
--=========================================================

-----------------------------------------------------------
-- 1. 문자형
-----------------------------------------------------------
-- char          고정형 문자타입. 최대 2000byte
--      char(10) 일때, 'korea' 입력시 실제값은 5byte이지만, 저장된 값은 10byte.
--      char(10) 일때, '한국' 입력시 실제값은 6byte 이지만, 저장된 값은 10byte.
--      (xe버전에서는 한글 1개당 3byte처리. ee버전에서는 2byte처리됨.)

-- varchar2  가변형 문자타입. 최대 4000byte
--      varchar2(10) 일때, 'korea' 입력시 실제값은 5byte, 저장된 값 5byte.
--      varchar2(10) 일때, '한국' 입력시 실제값은 6byte, 저장된 값은 6byte.

-- long 최대크기 2gb
-- clob 최대크기 4gb

create table tb_datatype (
    a char(10),
    b varchar2(10)
);

desc tb_datatype;

--데이터추가(행단위) 추가
insert into tb_datatype
values('korea', 'korea');
insert into tb_datatype
values('한국','한국');
insert into tb_datatype
values('필승','필승코리아'); -- ORA-12899: "KH"."TB_DATATYPE"."B" 열에 대한 값이 너무 큼(실제: 15, 최대값: 10)

select
    a, 
    lengthb(a), -- 해당컬럼의 byte수 리턴
    b,
    lengthb(b)
from
    tb_datatype;
    
commit; -- 메모리상의 작업내용을  실제 db에 반영 


-----------------------------------------------
-- 2. 숫자형
-----------------------------------------------
-- number([p, s])
-- p : 표현가능한 전체자리수
-- s : 소수점이하 자리수

-- 1234.567값처리
-- number : 1234.567
-- number(7, 3) : 1234.567
-- number(7) : 1235 (반올림)
-- number(7, 1) : 1234.6
-- number(7, -2) : 1200

--drop table tb_datatype;
create table tb_datatype(
    a number,
    b number(7, 3),
    c number(7),
    d number(7, 1),
    e number (7, -2)
);

insert into tb_datatype
values(1234.567, 1234.567, 1234.567, 1234.567, 1234.567);

insert into tb_datatype
values(1234.56789, 1234.56789, 1234.56789, 1234.56789, 1234.56789);

insert into tb_datatype
values(123456789, 123456789, 123456789, 123456789, 123456789);
-- ORA-01438: value larger than specified precision allowed for this column


select * from tb_datatype;

------------------------------------------------
-- 3. 날짜형
------------------------------------------------
-- date 년월일시분초
-- timestamp 년월일시분초밀리초 지역대


-- drop table tb_datatype;
create table tb_datatype(
    a date,
    b timestamp
);

insert into tb_datatype
values(sysdate, systimestamp);

select 
    to_char(a, 'yyyy/mm/dd hh24:mi:ss'), 
    b
from tb_datatype;

-- 날짜형간 산술연산 지원 : 단위가 하루인 숫자
-- 날짜 + 숫자 : date
-- 날짜 - 숫자 : date
-- 날짜 - 날짜 : number

select
    to_char(sysdate, 'yyyy/mm/dd hh24:mi:ss'), 
    to_char(sysdate - 1, 'yyyy/mm/dd hh24:mi:ss'), 
    to_char(sysdate + 1, 'yyyy/mm/dd hh24:mi:ss'),
    sysdate - (sysdate - 1)
from 
    dual; -- 가상테이블(1행)

-- 수료일에서 남은 날짜
select
    to_date('20220217', 'yyyymmdd') - sysdate
from
    dual;
    

--==============================================
-- DQL part 1
--==============================================
-- Data Query Language
-- 테이블의 데이터를 조회하는 언어
-- DML의 하위개념
-- 조회결과 0행 이상의 Resultset(결과집합)이 반환된다.

/*

select 컬럼 [5]

from 테이블 [1]

where 조건절 (특정행을 필터링) [2]

group by 컬럼 (특정컬럼기준으로 그룹핑) [3]

having 조건걸 (그룹핑된 결과를 필터링) [4]

order by 컬럼 (특정 컬럼 기준으로 행을 정렬) [6]

*/

-- 사원테이블에서 (from)
-- 부서코드가 D5인 사원의 (where)
-- 사번, 사원명, 부서코드, 전화번호 조회 (select)
-- (사원명 오름차순) (order by)
select
    emp_id,
    emp_name,
    dept_code,
    phone
from
    employee
where
    dept_code = 'D5'
order by
    emp_name asc;
    
    
    
    
    
    
    
    
    
    

--21_08_25
----------------------------------------------------
-- SELECT
----------------------------------------------------
-- Resultset의 컬럼을 선정하는 구문
-- 별칭 alias : as "별칭" //as, "" 생략가능
-- 공백, 특수문자, 숫자로 시작하는 경우 ""(쌍따옴표)로 감싸야 한다.
select
    emp_name "사원 이름",
    salary "8월급여",
    nvl(bonus, 0) as "보너스",
    salary + (salary * nvl(bonus, 0)) as "실급여",
   (salary + (salary * nvl(bonus, 0))) * 12  as "연봉"
from   
    employee;
-- nvl(val, nullValue)
-- val가 null이 아니라면 val리턴, null이라면 nullValue를 리턴    
    

-- null 값과는 산술연산할 수없다.
select
    1,
    1 + null,
    1 - null,
    1 * null,
    1 /null
from
    dual;

-- 문자열 연결 연산자 ||
select 
    emp_name,
    123,
    emp_name || '안녕' || '하세요' as "인사"
--    emp_name + '안녕' -- ORA-01722: invalid number
from
    employee;

-- + 산술연산자
SELECT
    1 + 2,
    123 + '45' -- '45'를 45(number)로 변환후 처리
FROM
    dual;    

-- distinct
-- 중복제거연산자. select구문에 단 한번만 사용가능하다.
-- 2개 이상 컬럼에 사용 시 2개 컬럼을 하나의 값으로 취급
select distinct
    job_code,
    dept_code
from
    employee
order by
    job_code;


---------------------------------------------
-- where
---------------------------------------------
-- 조건에 맞는 (true인 경우) 행만 결과집합에 포함시키는 조건구문
/*
=       같다
!=, <>, ^=      같지 않다.
> < >= <=
between a and b           a이상 b이하
like | not like                  문자패턴비교
is null | is not null         null값비교
in | not in                         값목록 포함여부
*/

-- 부서코드가 D6이면서 200만원 이상 급여를 받는 사원조회(사원명, 부서코드, 전화번호)
select 
    emp_name,
    dept_code,
    phone
from
    employee
where
    dept_code = 'D6' 
    and
    salary >= 2000000;
    -- dept_code != 'D6';
    -- dept_code <> 'D6';
    -- dept_code ^= 'D6';

-- 직급코드가 J1이 아닌 사원들의 급여등급(sal_level)을 중복없이 순서대로 출력하세요.
select distinct 
   sal_level
from
    employee
where
    job_code != 'J1'
order by
    sal_level;

-- 재직중인 사원들 중 (직급코드가 J1 또는 J2)가 아닌 사원 조회(사번, 사원명, 직급코드)
select
    emp_no,
    emp_name,
    job_code
from
    employee
where
    quit_yn = 'N'
    and
   (job_code != 'J1' and job_code != 'J2');
--    not(job_code = 'J1' or job_code = 'J2');

-- 오늘 기준 20년 이상 근무한 사원의 이름, 직급, 급여를 조회
-- 날짜 - 날짜 = 숫자 -> sysdate - hire_date = 근무일수
select
    emp_name,
    job_code,
    salary
from 
    employee
where
    (sysdate - hire_date) >= 20 * 365;
-- (sysdate - hire_date) / 365 >= 20;

-- 부서를 지정받지 못한 사원 조회
select
    *
from
    employee
where
--   dept_code = null; -- null은 비교연산 불가
--    dept_code is null;
--     not dept_code is null;
    dept_code is not null;

-- 보너스를 받는 사원 조회
select
    emp_name,
    bonus
from
    employee
where
    bonus is not null;
    
-- 급여를 350만원 이상 600만원 이하로 받는 사원 조회(사원명, 급여)
select
    emp_name,
    salary
from
    employee
where
    salary between 3500000 and 6000000;
--    salary >= 3500000
--    and
--    salary <= 6000000;    

-- 날짜(과거) 이후 날짜(미래)이전
-- 입사일이 2000년 1월1일 이후 2010년 12월 31일이전인 사원조회
select
    emp_name,
    hire_date
from
    employee
where
    hire_date between '2000/01/01' and '2010/12/31' -- 날짜형식(문자)은 날짜형으로 자동형변환되서 처리.
order by
    hire_date;

-- 날짜형식 조회
select
    *
from
    v$nls_parameters;
-- alter session set nls_date_format = 'RR/MM/DD';

-- like 문자패턴비교
-- 'a%' a글자 이후 0개 이상의 글자가 존재하는 경우 a ab abc
-- 'a_' a글자 이후 딱 한개의 글자가 존재하는 경우 ab ac ad
select
    emp_name
from 
    employee
where
    emp_name like '%이%';
    emp_name like '_오_';
    
 -- 전화번호가 010으로 시작하는 사원 조회
 select
    emp_name,
    phone
 from
    employee
where
--    phone like '010%';
    phone like '010________';

--email에서 '_' 앞에 3글자인 사원 조회
 select
    emp_name,
    email
 from
    employee
where
    email like '___\_%' escape'\'; 

-- in 연산자
-- 부서코드가 D5 또는 D9인 사원 조회(사원명, 부서코드)
select
    emp_name,
    dept_code
from
    employee
where
--    dept_code = 'D5' 
--    or 
--    dept_code = 'D9';
--    dept_code in ('D5', 'D9'); -- 값 목록의 개수 제한 없음.
    dept_code not in ('D5', 'D9');

-- 직급코드가 J7 또는 J2이면서, 급여가 200만원 이상인 사원 조회(사원명, 급여, 직급코드)
select
    emp_name,
    salary,
    job_code
from
    employee
where
--    job_code in ('J7', 'J2')
    (job_code = 'J7' or job_code = 'J2')
    and 
    salary >= 2000000;

-- 연산자 우선순위
-- 산술연산 > 연결연산(||) > 비교연산 > null비교 | in | like > between and > not > and > or

------------------------------------------------
-- ORDER BY
------------------------------------------------
-- 결과집합의 정렬기준을 명시
-- query 맨 마지막에 실행됨.
-- 컬럼명, 별칭, 컬럼순서로 기준컬럼을 지정

-- number 오름차순 : 작은수 -> 큰수
-- character 오름차순 : 사전등재순
-- date 오름차순 : 과거 -> 미래

-- 사원테이블을 입사순서대로 조회
-- asc (기본값) 오름차순
-- desc 내림차순
select
    emp_name as "사원명",
    hire_date as "입사일"
from
    employee
order by
--    hire_date desc;
--    입사일 desc;
    2 desc; --컬럼 순서 1부터 시작

-- 사원명 부서코드 조회
-- nulls first | last
select
    emp_name,
    dept_code
from
    employee
order by
    dept_code desc nulls first, 
    emp_name;



--===============================================
-- FUNCTION
--===============================================
-- 일련의 작업절차를 모아둔 객체.
-- 호출해서 이용.
-- 반드시 하나의 값을 리턴

-- 1. 단일행 처리함수 : 행 마다 호출해서 행 마다 하나의 값을 리턴
--      a. 문자처리함수
--      b. 숫자처리함수
--      c. 날짜처리함수
--      d. 형변환함수
--      e. 기타함수
-- 2. 그룹함수 : 여러행을 그룹핑하고, 그룹당 하나의 값을 리턴

---------------------------------------------------
-- 단일행 처리함수
---------------------------------------------------
--***************************************************************
-- a. 문자처리함수
--***************************************************************
-- length(value) : number
select
    emp_name,
    length(emp_name),
    lengthb(emp_name)
from
    employee;
    
-- instr(value, search[, start_position, occur]):number 
-- value에서 search의 위치(인덱스)를 리턴. 존재하지 않으면 0을 리턴
-- db에서 index는 1부터 시작
select
    instr('kh정보교육원 국가정보원 정보문화사', '정보'),
    instr('kh정보교육원 국가정보원 정보문화사', '정보', 1, 1),
    instr('kh정보교육원 국가정보원 정보문화사', '정보', 5, 1),
    instr('kh정보교육원 국가정보원 정보문화사', '정보', 5, 2),
    instr('kh정보교육원 국가정보원 정보문화사', '정보', -1), -- 뒤에서 부터 찾는다 리턴 인덱스는 앞에서 부터 카운트한 숫자
    instr('kh정보교육원 국가정보원 정보문화사', 'ㅋㅋㅋ')
from
    dual;

-- 사원테이블에서 email 컬럼 '@'의 위치를 조회
select
    email,
    instr(email, '@'),
    substr(email, 1, instr(email, '@') - 1) id
from
    employee;

-- substr(value, position[, length]) : character
-- value에서 position부터 length만큼 잘라서 반환
select
    substr('show me the money', 6, 2),
    substr('show me the money', 6),
    substr('show me the money', 13)
from
    dual;

-- lpad | rpad(value, n_byte[, padding])
-- n_byte의 공간에 value와 남은 공간은 padding문자로 채운다.
select
    lpad(email, 20, '#'),
    rpad(email, 20, '#'),
    lpad(email, 20)
from
    employee;

-- 숫자자리수 통일
select
    lpad(12, 5, '0'),        --00012
    lpad(123, 5, '0'),      -- 00123
    lpad(1234, 5, '0'),    --01234
    lpad(12345, 5, '0'),   --12345
    lpad(123456, 5, '0') --12345
from
    dual;



--EMP테이블의 EMAIL컬럼에서 @앞이 4글자인 사원을 조회하는 구문을 작성하시
select
    email
from
    employee
where
        email like '____@%';






/*
DEPT_CODE가 D9이거나 D6이고 SALARY이 300만원 이상이고 BONUS가 있고

남자이고 이메일주소가 _ 앞에 3글자 있는

사원의 EMP_NAME, EMP_NO, DEPT_CODE, SALARY를 조회*/

select
    emp_name,
    emp_no,
    dept_code,
    salary
from   
    employee
where
    (dept_code = 'D9' or dept_code = 'D6')
    and
    salary >= 3000000
    and
    bonus is not null
    and
    email like '___\_%' escape'\'
    and
    substr(emp_no, 8, 1) in ('1', '3');
    
    
    
    
    
    
    
    
    
    
    
    
--21-08-27
--***************************************************************
-- b. 숫자처리함수
--***************************************************************
-- ceil(value)
-- ceilling(천장)
select
    ceil(123.456),
    ceil(123.456 * 10) / 10
from
    dual;

-- floor(value)
select
    floor(123.456),
    floor(123.456 * 100) /100
from
    dual;
-- trunc(value[, position])
-- 숫자/날짜형에 대한 버림처리
select
    trunc(123.456),
    trunc(123.456, 2)
from
    dual;

-- round(value[, position])
select
    round(1234.567),
    round(1234.567, 1)
from
    dual;

-- mod(a, b)
-- a를 b로 나눈 나머지
select
    mod(10, 3),
    mod(10, 5),
    mod(10, 4)
from
    dual;

--***************************************************************
-- c. 날짜처리함수
--***************************************************************
-- add_months(date, number):date
--number달 이후/이전 날짜를 반환
select
    add_months(sysdate, 1),
    add_months(sysdate, -1),
    add_months(sysdate, 12),
    add_months(sysdate + 4, 1)
from
    dual;

--months_between(date1, date2):number
--date1(미래)과 date2(과거)사이의 개월수 차이를 리턴
select
    emp_name,
    trunc(sysdate - hire_date) "근무일수",
    trunc(months_between(sysdate, hire_date)) "근무개월수",
    trunc(months_between(sysdate, hire_date) / 12) || '년' || 
    trunc(mod(months_between(sysdate, hire_date), 12)) || '개월' "재직기간(n년 m개월)"
from
    employee;



-- extract(year | month | day | hour | minute | second from date):number
select
    extract(year from sysdate) 년,
    extract(month from sysdate) 월,
    extract(day from sysdate) 일,
    extract(hour from cast(sysdate as timestamp)) 시, --시분초는 형변환이 필요하다
    extract(minute from cast(sysdate as timestamp)) 분,
    extract(second from cast(sysdate as timestamp)) 초
from
    dual;

-- 사원테이블에서 2001년 입사자만 조회(사원명, 입사년, 입사월, 입사일) 조회
select
    emp_name,
    extract(year from hire_date) 입사년,
    extract(month from hire_date) 입사월,
    extract(day from hire_date) 입사일
from
    employee
where
--    hire_date between '2001/01/01' and '2001/12/31';
--    hire_date >= '2001/01/01' and hire_date <= '2001/12/31';
    extract(year from hire_date) = 2001;

-- trunc(date):date
--시분초 정보를 제거
select
    to_char(sysdate, 'yyyy/mm/dd hh24:mi:ss'),
    to_char(trunc(sysdate), 'yyyy/mm/dd hh24:mi:ss')
from
    dual;

--***************************************************************
-- d. 형변환함수
--***************************************************************
/*
                   to_char        to_date
              -------->    -------->
    number              char            date
             <--------     <--------
              to_number       to_char
*/

-- to_char(date, format):char
select
    to_char(sysdate, 'yy/mm/dd hh24:mi:ss'),
    to_char(sysdate, 'yy/mm/dd(dy) am hh24:mi:ss')
from
    dual;

-- 사원테이블에서 입사일을 1990년 2월 19일로 조회
select
    emp_name,
    to_char(hire_date, 'FM yyyy"년 " mm"월 "dd"일" (dy)', 'nls_date_language = korean') 입사일
from
    employee;

select * from employee;

-- to_char(number, format):char
-- 9 : 자리에 해당하는 수가 없을 경우 공백(소수점이상), 0(소수점이하)
-- 0 : 자리에 해당하는 수가 없을 경우 0 출력
select
    to_char(1234567890, 'FML999,999,999,999'),
    to_char(1234567890, 'FML000,000,000,000')
from
    dual;

-- 전사원의 사원명, 급여, 연봉(급여 + (급여 * 보너스)) * 12
select
    emp_name 사원명,
    to_char(salary, 'FML9,999,999,999') 급여,
    to_char((salary + (salary * nvl(bonus, 0))) * 12, 'FML99,999,999,999') 연봉
from
    employee;
    
-- to_number(char, format):number
select
    to_number('￦8,000,000', 'FML999,999,999') + 100
from
    dual;


-- to_date(char, format):date
--char 날짜를 표현하고 있는 문자형
select
    to_date('20190103', 'yyyymmdd'),
    to_date('03/01/19', 'dd/mm/yy')
from
    dual;

select
    emp_name,
    hire_date
from
    employee
where
    hire_date >= to_date('2000/01/01', 'yyyy/mm/dd');

-- kh company는 입사 후 3달간 수습기간을 거쳐 정식사원이 된다. 사원별 정식사원이 된 날짜를 년월일 형식으로 조회
select
    emp_name,
    to_char(hire_date, 'yyyy"년 "mm"월 " dd"일"') 입사일,
    to_char(add_months(hire_date, 3), 'yyyy"년 "mm"월 "dd"일"') as "정식사원이 된 날"
from
    employee;

-- 시간연산
-- 현재시각으로부터 1일 2시간 3분 4초뒤를 조회 (yyyy-mm-dd hh24:mi:ss)
-- 날짜 + 1 (단위가 하루)
select
    to_char(sysdate + 1 + (2 /24) + (3 /24 / 60) + (4/24/60/60), 'yyyy"-"mm"-"dd" "hh24":"mi":"ss')
from
    dual;
    

-- 기간을 나타내는 interval타입으로 변환하는 함수
-- to_yminterval : year to month interval
-- to_dsinterval : day to second interval
select
    sysdate + to_yminterval('01-06'), --1년 6개월 뒤
    to_char(sysdate + to_dsinterval('01 02:03:04'), 'yyyy-mm-dd hh24:mi:ss')
from
    dual;
    

-- dday 구하기
-- 날짜(미래) - 날짜(과거):number
-- '2022-02-17'
-- numtodsinterval(날짜차이, 단위):dsinterval
select
    to_date('2022-02-17') - sysdate,
    numtodsinterval(to_date('2022-02-17', 'yyyy-mm-dd') - sysdate, 'day'),
    extract(day from numtodsinterval(to_date('2022-02-17', 'yyyy-mm-dd') - sysdate, 'day')) diff
from
    dual;


--***************************************************************
-- e. 기타함수
--***************************************************************
-- nvl(value, null일 경우 값)
-- nvl2(value, null이 아닐때 값, null일때 값)
select
    bonus,
    nvl(bonus, 0),
    nvl2(bonus, '보너스 있음', '보너스 없음') "보너스여부"
from
    employee;

-- 선택함수 decode
--decode(표현식, 값1, 결과값1, 값2, 결과값2, ...[, defalut값])
select
    emp_name,
    emp_no,
    decode(substr(emp_no, 8 ,1), '1', '남', '2', '여', '3', '남', '4', '여') gender,
    decode(substr(emp_no, 8 ,1), '1', '남', '3', '남', '여') gender
from
    employee;
    
-- 사원명, 직급타입 조회(직급코드가 J1이면 사장, J2임원, 나머지 평사원)
select
    emp_name,
    decode(job_code, 'J1', '사장', 'J2', '임원', '평사원') 직급타입
from
    employee;
    
-- 선택함수 case
/*
-- 문법1
case 표현식 
    when 값1 then 결과값1
    when 값2 then 결과값2
    ...
    [else 기본값]
    end

-- 문법2
case    
    when 조건식1 then 결과값1
    when 조건식2 then 결과값2
    ...
    [else 기본값]
    end
*/
select
    emp_name,
    case substr(emp_no, 8, 1)
        when '1' then '남'
        when '2' then '여'
        when '3' then '남'
        when '4' then '여'
        end as "gender",
    case substr(emp_no, 8, 1)
        when '2' then '여'
        when '4' then '여'
        else '남'
        end as "gender",
        case job_code
            when 'J1' then '사장'
            when 'J2' then '임원'
            else '평사원'
            end as "직급타입"
from
    employee;

--(문법2)
select
    emp_name,
    case
        when substr(emp_no, 8, 1) in ('1', '3') then '남'
        when substr(emp_no, 8, 1) in ('2', '4') then '여'
        end gender,
    case
        when substr(emp_no, 8, 1) in ('1', '3') then '남'
        else '여'
        end gender
from
    employee;


-- 생일끝자리수에 맞게 9/1~10까지 백신을 신청할 수 있다. 사원별 백신신청일 조회.
select
    case substr(emp_no, 6, 1)
        when '1' then '21/09/01'
        when '2' then '21/09/02'
        when '3' then '21/09/03'
        when '4' then '21/09/04'
        when '5' then '21/09/05'
        when '6' then '21/09/06'
        when '7' then '21/09/07'
        when '8' then '21/09/08'
        when '9' then '21/09/09'
        when '0' then '21/09/10'
        end as "백신신청일",
    case
        when substr(emp_no, 6, 1) != 0 then '21/09/0' || substr(emp_no, 6, 1)
        else '21/09/10'
        end "백신신청일"
from
    employee;

-- 사원명, 나이 조회
-- 한국나이 = 현재년도 - 출생년도 + 1
select
    emp_name,
    emp_no,
--    extract(year from sysdate) - (1900 + substr(emp_no,1,2)) + 1,
--    extract(year from sysdate) - (2000 + substr(emp_no,1,2)) + 1
    decode(substr(emp_no,8,1),'1','1900','2','1900','2000') + substr(emp_no,1,2) "출생년도",
    extract(year from sysdate) - (decode(substr(emp_no,8,1) ,'1','1900','2','1900','2000') + substr(emp_no,1,2)) + 1 "한국나이"
from
    employee;
    


------------------------------------------------------
-- 그룹함수
------------------------------------------------------
-- group by절 통해서 행을 그룹핑하고 그룹당 한번 실행, 결과를 리턴하는 함수.
-- group by절을 명시하지 않은 경우, 테이블 전체 행을 하나의 그룹으로 처리.

-- sum(col)
select
--    emp_name, -- ORA-00937: not a single-group group function 일반컬럼과 그룹함수를 동시에 사용할 수 없다.
    sum(salary)
from
    employee;

-- avg(col)
-- 전달한 컬럼값이 null인 경우 그룹함수 연산에서 제외된다.
select
    trunc(avg(salary)) "급여평균",
    avg(bonus) "보너스 받는 사원 평균",
    avg(nvl(bonus, 0)) "전체 사원평균",
    trunc(avg(salary * nvl(bonus,0)))
from
    employee;

-- count(col)
-- col값이 null이 아닌 col 행의 수
select
    count(bonus),
    count(*) - count(bonus),
    count(dept_code),
    count(*) -- 행의 수
from 
    employee;
    
select
    count(*)
from
    employee
where
    bonus is null;
    
select
--    bonus,
--    case when bonus is null then 1 else 0 end
    sum(case when bonus is null then 1 else 0 end)
from 
    employee;

-- 남자사원 중에 300만원 이상 급여를 받는 사원수
select
    count(*)
from
    employee
where
    substr(emp_no, 8, 1) in ('1', '3')
    and
    salary >= 3000000;


-- max/min(col)
-- 숫자형 : 최대값/최소값
-- 날짜형 : 가장 늦은 날짜/ 가장 이른 날짜
-- 문자형 : 사전등재가 가장 늦은 문자/사전등재가 가장 빠른 문자
select
    max(salary),
    min(salary),
    max(hire_date),
    min(hire_date),
    max(emp_name),
    min(emp_name)
from
    employee;

-- @실습문제
-- 남여사원의 수를 조회
--------------------------
-- 남                    여
--------------------------
--15                     9 
--------------------------
select
    sum(case when substr(emp_no,8,1) in ('1', '3') then 1 else 0 end) as "남",
    sum(case when substr(emp_no,8,1) in ('2', '4') then 1 else 0 end) as "여",
    sum(decode(substr(emp_no,8,1), '1', '1','3','1'))
from
    employee;




-- 210830
--==============================================
-- DQL part2
--==============================================

------------------------------------------------
-- group by
------------------------------------------------
-- 특정컬럼 기준으로 행을 그룹핑.
-- group by절을 명시하지 않으면 테이블 전체행을 하나의 그룹으로 간주.

-- 부서별 급여의 합계/평균을 조회
select
    dept_code, -- 일반컬럼과 그룹함수는 같이 쓸 수 없지만 group by절에 명시한 일반컬럼은 쓸 수 있다.
    count(*),
    sum(salary),
    trunc(avg(salary))
from
    employee
group by
    dept_code
order by
    1;
    
-- 직급별 사원수와 평균급여를 조회(직급코드순 정렬)
select
    job_code 직급,
    count(*) 사원수,
    trunc(avg(salary)) 평균급여
from
    employee
group by
    job_code
order by
    job_code;

-- 성별 평균급여 조회
select
    decode(substr(emp_no,8,1),'1','남','3','남','여'),
    count(*),
    trunc(avg(salary))
from
    employee
group by
    decode(substr(emp_no,8,1),'1','남','3','남','여');
    

-- 입사년도별 인원수 조회(입사년도 내림차순)
select
     extract(year from hire_date) "입사년도",
     count(*) "인원 수"
from
    employee
group by
    extract(year from hire_date)
order by
     1 desc;

-- 2개 이상의 컬럼을 기준으로 grouping하기

-- 부서별 직급별 급여평균 조회
select
    dept_code, 
    job_code,
    trunc(avg(salary))
from
    employee
group by
    dept_code, job_code
order by
    1, 2;

-- 부서별 성별 급여평균을 조회
select
    dept_code 부서,
    decode(substr(emp_no,8,1),'1','남','3','남','여') 성별,
    trunc(avg(salary)) 평균급여
from
    employee
group by
    dept_code, decode(substr(emp_no,8,1),'1','남','3','남','여')
order by
    1, 2;
    

------------------------------------------------
-- having
------------------------------------------------
-- group by 절에 대한 조건절(필터링)

-- 부서별 급여평균이 300만원 이상인 부서의 인원수와 평균 급여를 조회
select
    dept_code,
    avg(salary)
from
    employee
--where
--    avg(salary) >= 3000000 -- ORA-00934: group function is not allowed here -- where절에 group 함수 금지
group by
    dept_code
having -- group by에 대한 조건절. 그룹함수 사용가능
    avg(salary) >= 3000000
    and
    dept_code != 'D9';


-- 부서별 인원수가 3명 이하인 부서조회(부서원 오름차순)
select
    nvl(dept_code, '인턴') 부서,
    count(*) "인원 수"
from    
    employee
group by
    dept_code
having
    count(*) <= 3
order by
    2;

-- 관리하는 사원이 2명이상인 매니저 사원의 아이디와 관리하는 사원수를 조회
-- (manager_id가 null인 행은 제외)
select
    manager_id,
    count(*)
from
    employee
group by
    manager_id 
having
    count(manager_id) >= 2
order by 
    1;
/*select
    manager_id,
    count(*)
from
    employee
where
    manager_id is not null
group by
    manager_id
having 
    count(*) >= 2
order by
    1;*/
    
---------------------------------------------
-- rollup | cube
---------------------------------------------
-- 그룹핑 산출 결과물에 소계를 추가하는 함수
-- group by절에서만 사용
-- 1. rollup 두개 이상의 컬럼을 그룹핑할 때 단방향 소계
-- 2. cube 두개 이상의 컬럼을 그룹핑할 때 양방향 소계
-- 한개 컬럼을 기준으로 그룹핑하는 경우 두 함수의 결과는 동일하다.

-- grouping(col):col이 data인 경우, 0을 반환
-- rollup/cube에 의한 소계 컬럼인 경우, 1을 반환

select
--    dept_code,
--    grouping(dept_code),
    decode(grouping(dept_code), 0, nvl(dept_code, '인턴'), 1, '총원') dept_code,
    count(*)
from
    employee
group by
    cube(dept_code)
order by
    1;

-- 성별인원수 조회(총원도 함께 조회할 것)
select
    decode(grouping(decode(substr(emp_no,8,1), '1','남','3','남','여')), 0, decode(substr(emp_no,8,1), '1','남','3','남','여'),1,'총원') 성별,
    count(*) 인원
from
    employee
group by
    rollup(decode(substr(emp_no,8,1), '1','남','3','남','여'));
    
-- 직급별 인원수가 3명 이상인 직급과 총원을 조회
select
    decode(grouping(job_code), 0, job_code, 1, '총원') "직급",
    count(*) "인원 수"
from
    employee
group by
    rollup(job_code)
having
    count(*) >= 3  --job_code 에 null이 없다
order by
    2;
    
-- 2개 이상의 컬럼을 그룹핑하는 경우
select
    dept_code,
    job_code,
    count(*)
from
    employee
group by
    rollup(dept_code, job_code)
order by
    1, 2;

select
    decode(grouping(dept_code), 0, nvl(dept_code, 'D0'), '총원') dept_code,
    decode(grouping(job_code), 0, job_code, '총원') job_code,
    count(*)
from
    employee
group by
    cube(dept_code, job_code)
order by
    1, 2;


select
    count(*)
from
    employee
group by
    ();
















--210831
--===========================================================
-- JOIN
--===========================================================
-- 두개 이상의 테이블의 레코드를 합쳐 하나의 가상 테이블(relation)을 만들 수 있다.
-- 1. join : 행과 행을 합친다(가로)
-- 2. union(집합연산) : 컬럼과 컬럼을 합친다(세로)

-- 송종기 사원의 부서명은?
-- employee.dept_code
-- department.dept_titile
select dept_code from employee where emp_name = '송종기';
select dept_title from department where dept_id = 'D9';

select
    dept_title
from
    employee e join department d
        on e.dept_code = d.dept_id
where
    emp_name = '송종기';

-- join종류
-- 1. Equi join 조인조건절에 동등비교(=)를 사용한 경우
-- 2. Non-equi join 조인조건절에 동등비교(=)를 사용하지 않은 경우(!=, between and, in, is null, ...)

-- join문법
-- 1. ansi표준문법 : join on 키워드 사용
-- 2. oracle전용문법 : ,(join 대신 콤마), where(on대신) 사용

-- Equi join
-- 1. inner join 내부조인
-- 2. outer join 외부조인
-- 3. cross join 교차조인
-- 4. self join 자기조인
-- 5. multiple join 다중조인

--------------------------------------------------
-- Inner Join
--------------------------------------------------
-- 내부조인(교집합)
-- 좌우측테이블에서 조인조건절에 부합하는 행만 사용.
-- 기준컬럼값이 null이거나 상대테이블에 매칭되는 행이 없는 경우는 제외.

-- employee테이블 dept_code가 null인 사원제외
-- department테이블 사원이 없는 행 (D2, D3, D7) 제외

select * from employee;
select * from department;
select
    *
from    
    employee e join department d -- inner 생략 가능
        on  e.dept_code = d.dept_id; -- 조인 조건절 
        --employee테이블의 행-dept_code컬럼값이 department테이블의 행-dept_id컬럼값과 일치하면 연결

-- 22행 : employee(22행) + department(6행)

--(oracle 전용문법)
select
    *
from
    employee e, department d
where
    e.dept_code = d.dept_id
    and
    d.dept_title = '총무부';
    



---------------------------------------------------
-- Outer Join
---------------------------------------------------
-- 외부조인
-- 1. left outer join : 왼쪽테이블행 전부와 조인조건에 일치하는 오른쪽테이블행
-- 2. right outer join : 오른쪽테이블행 전부와 조인조건에 일치하는 왼쪽테이블행
--3. full outer join : 왼쪽/오른쪽테이블행 전부
select
    *
from
    employee e left join department d -- outer 생략가능
        on e.dept_code = d.dept_id; -- 24행 : 22행(inner join) + 2행(dept_code가 null인 employee의 행)

--(oracle 전용문법)
--left join : 조인조건절 우측테이블 컬럼에 (+)를 추가.
select
    *
from
    employee e, department d
where
    e.dept_code = d.dept_id(+);

select
    *
from
    employee e right join department d
        on e.dept_code = d.dept_id; --25행 : 22행(inner join) + 3행(department에서 매칭되지 못한 행 D3 D4 D7)
--(oracle 전용문법)
--right join : 조인조건절 좌측테이블 컬럼에 (+)를 추가.
select
    *
from   
    employee e, department d
where
    e.dept_code(+) = d.dept_id;

select
    *
from
    employee e full join department d
        on e.dept_code = d.dept_id; -- 27행: 22행(inner join) + 2행(하동운, 이오리) + 3행(D3 D4 D7)
--oracle 전용문법에는 full outer join 없다.


-- employee - job
-- 기준컬럼명이 동일하다. employee.job_code = job.job_code
select * from employee;
select * from job;

-- 테이블별칭: as 사용금지, 대소문자 구분하지 않음.
select
    job_name
from
    employee emp join job j
        on emp.job_code = j.job_code
where
    emp.emp_name = '노옹철';

-- using : 기준컬럼명이 동일한 경우만 조인조건절로 사용
-- 별칭을 이용해서 기준컬럼에 접근할 수 없다.
select
    job_code,
    e.emp_name
from
    employee e join job j
        using(job_code);

-- inner join, outer join의 결과가 같다.
select
    *
from
    employee e join job j
        using(job_code);


--------------------------------------------------
-- Cross Join
--------------------------------------------------
-- Cartesian's Product 카테시안의 곱(모든 경우의 수)
-- 좌측테이블 행과 우측테이블행이 조인할 수 있는 모든 경우를 리턴
select
    *
from
    employee e cross join department d;

--(oracle 전용문법)
select
    *
from
    employee e, department d;

-- 평균급여와 사원급여간 차이 조회
select trunc(avg(salary)) as avg_sal from employee;

select 
   emp_name,
   salary,
   avg_sal,
   salary - avg_sal as diff
from
    employee e cross join (select trunc(avg(salary)) as avg_sal from employee);
    
    select
	emp_name,
	salary,
	avg_sal,
	salary - avg_sal
from
	employee e cross join (select trunc(avg(salary)) as avg_sal from employee);

--------------------------------------------------
-- Self Join
--------------------------------------------------
-- 자기조인 같은 테이블 좌측/우측에 배치해서 조인.

--사원별 관리자 이름 조회
select manager_id from employee where emp_name = '송종기';
select emp_name from employee where emp_id = '200';

select
    e1.emp_name,
    e2.emp_name as manager_name
from
    employee e1 join employee e2
        on e1.manager_id = e2.emp_id
where
    e1.emp_name = '송종기';
    
--(oracle 전용문법)
select
    e1.emp_name,
    e2.emp_name as manager_name
from
    employee e1, employee e2
where
    e1.manager_id = e2.emp_id(+)
    and
    e1.emp_name = '송종기';

--------------------------------------------------
-- Multiple Join
--------------------------------------------------
-- 다중조인, 여러 개의 테이블을 조인.
-- 조인 한번당 좌우측테이블만 조인하고 이를 반복.

-- 사원명, 부서명, 지역명 조회
select * from employee; -- employee.dept_code -> department.dept_id
select * from department; -- department.location_id -> location.local_code
select * from location;
select * from job;
select * from nation;
select
    *
from
    employee e 
        left join department d
            on e.dept_code = d.dept_id
        left join location L
            on d.location_id = L.local_code;

--(oracle 전용문법)
select
    *
from
    employee e, department d, location l
where
    e.dept_code = d.dept_id(+)
    and
    d.location_id = l.local_code(+);

-- @실습문제: 직급이 대리이면서 ASIA지역에 근무하는 사원조회
-- 사번, 사원명, 직급명(job.job_name), 부서명(department.dept_title), 근무지역명(location.local_name), 국가명(nation.national_name) 조회
select
    e.emp_id,
    e.emp_name,
    j.job_name,
    d.dept_title,
    L.local_name,
    n.national_name
from
    employee e 
        left join department d
            on e.dept_code = d.dept_id
        left join location L
            on d.location_id = L.local_code
        left join nation n
            using(national_code)
         join job j
            using(job_code)
where
    j.job_name = '대리'
    and
    L.local_name like 'ASIA_';        


select
	e.emp_id,
	e.emp_name,
	j.job_name,
	d.dept_title,
	L.local_name,
	n.national_name
from
	employee e 
		left join job j
			on e.job_code = j.job_code
		left join department d
			on e.dept_code = d.dept_id
		left join location L
			on d.location_id = L.local_code
		left join nation n
			on L.national_code = n.national_code
where 
	j.job_name = '대리'
	and
	L.local_name like 'ASIA_';



--210901
-------------------------------------------------
-- Non Equi Join
-------------------------------------------------
-- 동등조건(=)이 아닌 조인조건을 사용하는 조인
-- !=, between and, in 등 연산자를 사용.

select * from employee;
select * from sal_grade; -- 급여등급테이블 

select
    *
from
    employee e join sal_grade s
        on e.salary between s.min_sal and s.max_sal;

--(oracle 전용문법)
select
    *
from
    employee e, sal_grade s
where
    e.salary between s.min_sal and s.max_sal;


--===================================================
-- SET OPERATOR
--===================================================
-- 집합연산자. 여러 결과집합의 컬럼을 연결해서(세로) 하나의 relation을 생성하는 방식.

-- 집합연산의 조건
-- 1. 컬럼수 동일
-- 2. 연결될 컬럼은 호환 가능한 자료형이어야 한다.
-- 3. 컬럼명이 다르다면, 첫번째 결과집합의 컬럼명이 최종 반영된다.
-- 4. order by절은 마지막 결과집합에 딱 학번만 사용 가능

-- 집합연산자 종류
-- 1. union 합집합 : 중복된 행은 제거, 첫번째 컬럼기준으로 오름차순 정렬지원
-- 2. union all 합집합 : 중복제거 없음/정렬 없음
-- 3. intersect 교집합 : 공통된 행만 필터링
-- 4. minus 차집합 : 기준이 될 결과집합에서 공통된 행 제거

-- 결과집합 A
select
    emp_id, emp_name, dept_code, salary
from    
    employee
where
    dept_code = 'D5';

-- 결과집합 B
select
    emp_id, emp_name, dept_code, salary
from
    employee
where
    salary > 3000000;

-- union all
select
    emp_id, emp_name, dept_code, salary
from    
    employee
where
    dept_code = 'D5'
union all
select
    emp_id, emp_name, dept_code, salary
from
    employee
where
    salary > 3000000;

-- union
-- 1. 중복행 제거 : 모든 컬럼의 값이 동일한 행
-- 2. 첫번째 컬럼기준으로 오름차순 정렬
select
    emp_id, emp_name, dept_code, salary
from    
    employee
where
    dept_code = 'D5'
union
select
    emp_id, emp_name, dept_code, salary
from
    employee
where
    salary > 3000000
order by salary desc;


-- intersect
select
    emp_id, emp_name, dept_code, salary
from    
    employee
where
    dept_code = 'D5'
intersect
select
    emp_id, emp_name, dept_code, salary
from
    employee
where
    salary > 3000000
order by salary desc;

-- minus
select
    emp_id, emp_name, dept_code, salary
from    
    employee
where
    salary > 3000000
minus
select
    emp_id, emp_name, dept_code, salary
from
    employee
where
    dept_code = 'D5';
    
    
-- 판매데이터 생성   
    create table tbl_sales(
		sale_date   date,
	 	p_name    varchar2(20),
    	p_count     number
    );
    
    --drop table tbl_sales;
	
	-- 두달전 판매데이터
    insert into tbl_sales values( add_months(sysdate, -2), '새우깡', 10);
    insert into tbl_sales values( add_months(sysdate, -2)+1, '새우깡', 15);
    insert into tbl_sales values( add_months(sysdate, -2)+2, '감자깡', 20);
    insert into tbl_sales values( add_months(sysdate, -2)+3, '새우깡', 10);

	-- 지난달 판매데이터
    insert into tbl_sales values( add_months(sysdate, -1), '고구마깡', 10);
    insert into tbl_sales values( add_months(sysdate, -1)+1, '새우깡', 15);
    insert into tbl_sales values( add_months(sysdate, -1)+2, '감자깡', 20);
    insert into tbl_sales values( add_months(sysdate, -1)+3, '감자깡', 10);

	-- 이번달 판매데이터
    insert into tbl_sales values( sysdate, '새우깡', 5);
    insert into tbl_sales values( sysdate, '감자깡', 7);

    insert into tbl_sales values( sysdate, '새우깡', 5);
    insert into tbl_sales values( sysdate, '새우깡', 15);
    insert into tbl_sales values( sysdate, '고구마깡', 10);

    insert into tbl_sales values( sysdate, '고구마깡', 20);
    insert into tbl_sales values( sysdate, '허니버터칩', 15);
    insert into tbl_sales values( sysdate, '허니버터칩', 10);
    insert into tbl_sales values( sysdate, '고구마깡', 5);

    insert into tbl_sales values( sysdate, '새우깡', 10);

    select * from tbl_sales;
    --select to_char(sale_date,'rr/mm/dd hh24:mi:ss') from tbl_sales;
    commit;
    
-- @실습문제 : 두달전 판매데이터를 조회하는 쿼리작성
select
    *
from
    tbl_sales
where
    to_char(add_months(sysdate, -2), 'yyyy-mm') = to_char(sale_date, 'yyyy-mm');
-- extract(month from add_months(sysdate, -2)) = extract(month from sale_date); 작년까지 출력됨
    
-- 지난달 판매테이터 조회
select
    *
from
    tbl_sales
where
    to_char(add_months(sysdate, -1), 'yyyy-mm') = to_char(sale_date, 'yyyy-mm');   


-- 이번달 판매데이터 tbl_sales
-- 지난달 판매데이터 tbl_sales_202108
-- tbl_sales_202107
-- tbl_sales_202106
-- tbl_sales_202105

create table tbl_sales_202108
as 
select
    *
from
    tbl_sales
where
    to_char(add_months(sysdate, -1), 'yyyy-mm') = to_char(sale_date, 'yyyy-mm');   

select * from tbl_sales_202108;

create table tbl_sales_202107
as 
select
    *
from
    tbl_sales
where
    to_char(add_months(sysdate, -2), 'yyyy-mm') = to_char(sale_date, 'yyyy-mm');   

select * from tbl_sales_202107;

-- 이전달 데이터 삭제
/*
delete from
    tbl_sales
where
    to_char(add_months(sysdate, -2), 'yyyy-mm') = to_char(sale_date, 'yyyy-mm') -- 7월 데이터삭제
    or
    to_char(add_months(sysdate, -1), 'yyyy-mm') = to_char(sale_date, 'yyyy-mm');   --8월 데이터 삭제
*/

commit; -- delete작업을 db server에 실반영.

--@실습문제 : 지난 3개월 판매데이터를 조회.
-- 2021-07, 2021-08, 2021-09
select * from tbl_sales_202107
union all
select * from tbl_sales_202108
union all
select * from tbl_sales;

-- 지난 3달 제품별 총 판매량
select
    p_name,
    sum(p_count)
from (
    select * from tbl_sales_202107
    union all
    select * from tbl_sales_202108
    union all
    select * from tbl_sales
)
group by
    p_name;

 
--===================================================   
-- TOP-N 분석
--===================================================    
-- 가장 크거나/작은 n개의 데이터 조회

-- rownum 
--      테이블의 레코드(행)에 대한 일련번호. insert될때 오라클이 내부적으로 1부터 순차적으로 부여함.(변경불가)
--      where절에 의해 결과집합이 필터링될때, inline-view를 생성할 때  rownum 새로 발급.
-- rowid : 특정레코드에 대한 논리적 주소값(행 고유번호)
select
    rownum,
    rowid,
    employee.*
from
    employee
order by
    emp_name;

--where    
select
    rownum,
    employee.*
from
    employee
where
    dept_code = 'D5';
    
-- inline-view    
select
    rownum new,
    e.*
from(
select
    rownum old,
    employee.*
from
    employee
order by
    emp_name
) e;

-- 급여를 제일 많이 받는 3명 조회(사원명, 급여)
select
    rownum,
    e.*
from(
select
    emp_name,
    salary
from
    employee
order by
    salary desc
) e
where
    rownum <= 3;
    
-- 입사일이 빠른 10명의 사원 조회
select
    rownum,
    e.*
from(
    select
        emp_name,
        hire_date
    from
        employee
    order by
        hire_date
) e
where
    rownum <= 10;
    
-- 급여를 많이 받는 순으로 6위 ~ 10위 조회
-- 새 rownum은 where절 처리가 끝나야 완전히 부여. 1부터 순차적접근은 괜찮지만, offset이 있는 경우는 조회가 불가능핟.
select
    rownum,
    e.*
from(
    select
        rownum rnum,
        e.*
    from(
        select
            emp_name,
            salary
        from
            employee
        order by
            salary desc
    ) e
) e
where
    rnum between 6 and 10;
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
--210903
--===============================================
-- SUB-QUERY
--===============================================
-- main-query 안에 또 하나의 쿼리를 작성할 수 있다.
-- main-query 실행 중 sub-query를 먼저 실행하고, 결과를 main-query에 전달.

--조건
--1. 반드시 소괄호안에
--2. order by문법 지원하지 않음.
--3. 결과집합의 행열수와 맞게 사용.

-- 노옹철 직원의 관리자이름 조회
select
    emp_name
from
    employee
where
    emp_id = (
    select
        manager_id
    from
        employee
    where
        emp_name = '노옹철'
    );
--노옹철사원의 관리자
select
    manager_id
from
    employee
where
    emp_name = '노옹철';
    
-- 전사원의 평균급여보다 많은 급여를 받는 사원 조회
select
    emp_name,
    salary,
    (select trunc(avg(salary)) from employee) avg_sal
from
    employee
where
    salary > (select avg(salary) from employee);

-- 서브쿼리 유형
-- 1. 일반서브쿼리 : 서브쿼리 단독으로 실행이 가능한 경우
-- 2. 상관서브쿼리(상호연관 서브쿼리) : 메인쿼리의 값을 참조해서 실행하는 서브쿼리 

--------------------------------------------------------------
-- 단일행 단일컬럼 서브쿼리
--------------------------------------------------------------
-- 결과집합이 1행 1열인 경우
-- 평균급여보다 적은 급여를 받는 사원을 조회
select
    emp_name,
    salary
from
    employee
where
    salary < (select avg(salary) from employee);

-- 윤은해 사원과 같은 금액 급여를 받는 사원 조회(사번, 사원명, 급여)
select
    emp_id,
    emp_name,
    salary
from
    employee
where
    salary = (select salary from employee where emp_name = '윤은해')
    and
    emp_name <> '윤은해';

-- 최대급여, 최소급여를 받는 사원 조회
select
    emp_name,
    salary
from
    employee
where
    salary = (select max(salary)from employee)
    or
    salary = (select min(salary)from employee);
    
-- D1, D2 부서원 중에서 D5부서의 평균급여보다 많은 급여를 받는 사원조회(사원명, 부서코드,급여)
select
    emp_name,
    dept_code,
    salary
from
    employee
where
    (dept_code in ('D1','D2'))
    and
    salary > (select avg(salary) from employee where dept_code = 'D5');
    
------------------------------------------------------------
-- 다중행 단일컬럼 서브쿼리
------------------------------------------------------------
-- n행 1열 서브쿼리
-- in | not in, any | some | all, exists 등의 연산자와 사용

-- 송종기, 하이유 사원과 같은 부서에 근무하는 사원조회
select
    emp_name,
    dept_code
from
    employee
where
    dept_code in (select dept_code from employee where emp_name in ('송종기', '하이유'));

-- 차태연, 박나라, 이오리와 같은 직급 사원조회(사원명, 직급코드)
select
    emp_name,
    job_code
from
    employee
where
    job_code in (select job_code from employee where emp_name in ('차태연','박나라','이오리'));

-- ASIA1지역 부서원 조회
select * from location;
select * from department;
select
    emp_name,
    dept_code
from
    employee
where
    dept_code in (
        select dept_id from department where location_id = (
            select local_code from location where local_name = 'ASIA1'));

select
    *
from
    employee e
        left join department d
            on e.dept_code = d.dept_id
        left join location l
            on d.location_id = l.local_code
where
    l.local_name = 'ASIA1';

select * from job;
select * from department;
-- 직급이 대표, 부사장이 아닌 사원의 부서명, 사원명 조회
select
    emp_name,
    dept_title
from
    employee e left join department d
        on e.dept_code = d.dept_id
where
    job_code not in (select job_code from job where job_name in ('대표', '부사장'));
    
------------------------------------------------------
-- 다중컬럼 서브쿼리
------------------------------------------------------
-- = 연산자 : 1행 n열 서브쿼리
-- in 연산자 : n행 n열 서브쿼리

--퇴사한 직원과 같은 부서, 같은 직급의 사원 조회
select
    dept_code,
    job_code
from
    employee
where
    quit_yn = 'Y';

select
    *
from
    employee
where
    (dept_code, job_code) in (select dept_code, job_code from employee where quit_yn = 'Y')
    and
    quit_yn = 'N';

-- ORA-01427: single-row subquery returns more than one row

-- 유하진 사원 금일 퇴사
update employee set quit_date = sysdate, quit_yn = 'Y' where emp_id = '221';
commit;


-- 직급별 최소급여를 받는 사원조회(사번, 이름, 직급코드, 급여 조회)
-- (직급코드, 급여)
select
    emp_id,
    emp_name,
    job_code,
    salary
from
    employee
where
    (job_code, salary) in (select job_code, min(salary) from employee group by job_code);
        
-- 부서별 최대급여를 받는 사원 조회(사원명, 부서명, 급여)
-- 인턴도 포함
-- (부서코드, 급여)
select
    emp_name,
    nvl(dept_code, '인턴') dept_code,
    nvl(dept_title, '인턴') dept_title,
    salary
from
    employee e left join department d
        on e.dept_code = d.dept_id
where
    (nvl(dept_code, 'D0'), salary) in (select nvl(dept_code, 'D0'), max(salary) from  employee group by dept_code);
    -- null은 비교연산할 수 없기 때문에 nvl을 쓴다.


select dept_code from employee group by dept_code;

-------------------------------------------------
-- 상관 서브쿼리
-------------------------------------------------
-- 상호연관 서브쿼리.
-- main-query의 값을 참조해서 sub-query를 실행, 결과를 main-query에 반환
-- 직급별 최소급여를 받는 사원조회(사번, 이름, 직급코드, 급여 조회)
select
    emp_id,
    emp_name,
    job_code,
    salary
from
    employee e
where
     salary = (select min(salary) from employee where job_code = e.job_code);

select * from employee;
select min(salary) j1 from employee where job_code ='J1';
select min(salary) j2 from employee where job_code ='J2';
select min(salary) j3 from employee where job_code ='J3';
select min(salary) j4 from employee where job_code ='J4';
select min(salary) j5 from employee where job_code ='J5';
select min(salary) j6 from employee where job_code ='J6';
select min(salary) j7 from employee where job_code ='J7';

-- exists (sub-query)
-- 서브쿼리의 결과집합이 1행 이상이면 참, 0행이면 거짓


-- 부하직원이 있는 사원 조회
-- 사번을 다른 행 manager_id컬럼에서 참조하고 있다면 부하직원이 있는 것.
select
    *
from 
    employee e
where
    exists (select * from employee where manager_id = e.emp_id);

-- 부서테이블에서 실제 부서원이 존재하는 부서를 조회
select
    *
from
    department d
where
    exists(select 1 from employee where dept_code = d.dept_id); -- 행이 있는지 없는지만 확인하기 위해서 효율적으로 1만 적는다.

select 1 from employee where dept_code = 'D1';


--------------------------------------------------
-- Scala Sub-query
--------------------------------------------------
-- 결과집합이 단일값(scala)인, 1행1열인 상관서브쿼리 (select절)

--사번명, 부서명 조회
select
    emp_name,
    (select dept_title from department where dept_id = e.dept_code) dept_title
from
    employee e;

-- 사번, 사원명, 관리자사번, 관리자명 조회
select
    emp_id,
    emp_name,
    manager_id,
    (select emp_name from employee where  emp_id = e.manager_id) as manager_name
from
    employee e;

--------------------------------------------------------
-- Inline-view
--------------------------------------------------------
-- from절에 사용한 sub-query

-- 여자사원 조회(사번, 사원명, 성별)
select
    emp_id,
    emp_name,
    decode(substr(emp_no,8,1), '1','남','3','남','여') as gender
from
    employee
where
    decode(substr(emp_no,8,1), '1','남','3','남','여') = '여';

select
    *
from(
    select
        emp_id,
        emp_name,
        decode(substr(emp_no,8,1), '1','남','3','남','여') as gender
    from
        employee
)
where
    gender = '여';

-- with절로 선언
with emp_view
as
(select
    emp_id,
    emp_name,
    decode(substr(emp_no,8,1), '1','남','3','남','여') as gender
from
    employee)
select
    *
from
    emp_view
where
    gender = '여';
    
    
    
    
    
    







--210906
--============================================================
-- 고급쿼리
--============================================================

--------------------------------------------------------------
-- 윈도우함수
--------------------------------------------------------------
-- 행과 행간의 관계를 쉽게 정의하는 표준함수
-- 순위/ 집계/ 비율/ 통계 관련 함수들이 있다.
-- select절에만 사용가능하다.

-- window_function (args) over ([partition by절][order by절][windowing절])
-- args : 윈도우함수에 전달할 인자 (0 ~ n개)
-- over절 : 행그룹핑, 정렬
--      - partition by절 : 그룹핑(group by와 유사)
--      - order by절 : 정렬
--      - windowing절 : 대상행 지정

-- 순위관련 함수
-- rank
-- dense_rank
-- row_number

-- 급여순위조회
select
    emp_name,
    salary,
    rank () over (order by salary desc) as rank,
    dense_rank () over (order by salary desc) as rank,
    row_number () over (order by salary desc) as rank
from
    employee;

-- top-n
select
    *
from(
    select
        emp_name,
        salary,
        rank () over (order by salary desc) as rank
    from
        employee
)
where
    rank between 6 and 10;

-- partition by : 행 그룹핑한 상태에서 순위를 부여
select
    emp_name,
    dept_code,
    salary,
    rank () over (partition by dept_code order by salary desc) rank,
    rank () over (order by salary desc) "rank_전사원"
from
    employee
order by 
    dept_code, rank;
    
-- @실습문제 : 입사일이 빠른 순서로 조회(사번, 사원명, 입사일, 입사순서)
select
    emp_id,
    emp_name,
    hire_date,
    rank () over (order by hire_date desc) as 입사순서
from
    employee;

-- @실습문제 : 부서별 입사일이 빠른 순서로 정렬 및 조회(부서명, 사원명, 입사일, 부서별 입사순서, 전체 입사순서)
select
    (select dept_title from department where dept_id = e.dept_code) as 부서명,
    emp_name,
    hire_date,
    rank () over (partition by dept_code order by hire_date) as 부서별_입사순서,
    row_number () over (order by hire_date) as 전체_입사순서
from
    employee e
order by
    부서명, 부서별_입사순서;

-- 집계함수
-- 그룹함수를 (sum, avg, min, max)확장한 윈도우함수
-- 일반컬럼과 그룹함수 결과를 동시에 조회 가능
select
    emp_name,
    salary,
    dept_code,
    sum(salary) over (partition by dept_code order by salary) "부서별 급여 누계",
    sum(salary) over(partition by dept_code) "부서별 급여합계",
    sum(salary) over() "전사원 급여합계"
from
    employee;
    
-- 판매데이터
select
    sale_date,
    p_name,
    p_count,
    sum(p_count) over (partition by p_name order by rownum) "제품별 누계",
    sum(p_count) over (order by rownum) "전체판매수량 누계"
from
    tbl_sales
order by
    p_name;
    
--@실습문제 : 지난 3개월간 월별로 제품별 판매량 누계와 월별 전체판매량 누계를 조회
select
    s.*,
    sum(sale_cnt) over (partition by p_name order by sale_date) "제품별 누계",
    sum(sale_cnt) over (order by sale_date, p_name) "전체누계"
from(
    select 
        to_char(sale_date, 'yyyy-mm') sale_date,
        p_name,
        sum(p_count) as sale_cnt
    from (
        select *
        from tbl_sales_202107
        union all
        select *
        from tbl_sales_202108
        union all
        select *
        from tbl_sales
    )
    group by to_char(sale_date, 'yyyy-mm'), p_name
    order by sale_date
) s
order by
    1;

-- listagg
-- grouping된 행들의 특정컬럼값을 구분자로 모아 나열하는 함수
select
    dept_code,
    listagg(emp_name, ',') within group(order by emp_id) emp_names
from
    employee
group by
    dept_code;

select
    emp_name,
    dept_code,
    listagg(emp_name, ',') within group(order by emp_id) over(partition by dept_code)
from
    employee;

--=========================================================
-- DML
--=========================================================
-- Data Manipulation Language 데이터 조작어
-- 테이블의 레코드(행)에 대해서 삽입(insert), 수정(update), 삭제(delete)하는 명령어
-- DB제어시에 가장 많이 사용되는 데이터 CRUD에 해당한다.

-----------------------------------------------------------
-- insert
-----------------------------------------------------------
-- 테이블에 행을 추가하는 명령

/*
문법1
insert into 테이블명
values(컬럼1값, 컬럼2값, ...)
- 테이블의 모든 컬럼에 대한 값을 순서에 맞추어 빠짐없이 제공해야 한다. 

문법2
insert into 테이블명 (컬럼명1, 컬럼명2, ...)
values(컬럼1값, 컬럼2값, ...)
- 입력하고자 하는 컬럼만 테이블 옆에 나열한 후, 해당컬럼 순서와 개수에 맞게 값을 제공한다.
- null을 허용하는 컬럼은 생략가능하다.(생략되면 null값이 대입)
- not null인 컬럼은 생략할 수 없다.(단, default값이 지정되면 생략가능)
*/

create table sample(
    a number,
    b varchar2(100),
    c varchar2(100) not null,
    d date default sysdate not null
);

desc sample;

-- 문법 1
insert into
    sample
values(
    1, '안녕', 'Hello', sysdate
);

insert into
    sample
values(
    2, '잘가', 'ByeBye', sysdate
);

insert into
    sample
values(
    3, null, 'Have lunch?', default
);

--문법 2
insert into
    sample(c, d, b)
values(
    'CCCCC', sysdate, 'BBBBBB'
);
insert into
    sample(a, b, c)
values(
    5, 'bbbbb', 'ccccc'
);

select
    *
from
    sample;

-- ex_employee 연습용 사원테이블
create table ex_emp
as
select
    *
from
    employee;

select * from ex_emp;

-- 제약조건 재추가
alter table ex_emp
add constraint pk_ex_emp_id primary key(emp_id) -- 기본키 제약조건추가
modify quit_yn default 'N' -- quit_yn컬럼 기본값 지정
modify hire_date default sysdate; -- hire_date 기본값 지정

desc ex_emp;
commit;
-- ex_emp에 사원정보 2명 입력(emp_id 중복되지 않도록 할 것)
insert into 
    ex_emp
values(
    '224', '노현하', '950423-1234567', 'hyunha@naver.com', '01012345678', null, 'J7', 'S5', 2800000, null, '201', sysdate, null, 'N'
);

insert into 
    ex_emp
values(
    '225', '노슈아', '110423-1234566', 'shua@naver.com', null, null, 'J7', 'S5', 1500000, null, '201', sysdate, null, 'N'
);
/*insert into 
    ex_emp
values(
    '301', '홍길동', '900909-1234567', 'honggd@naver.com', '01012341234', 'D1', 'J6', 'S3', 3000000, null, '200', default, null, default
);
insert into 
    ex_emp(emp_id, emp_name, emp_no, job_code, sal_level)
values(
    '302', '신사임당', '700909-2234567', 'J2', 'S1'
);*/
commit;
select * from ex_emp;

-- subquery를 이용한 insert
create table emp_simple(
    emp_id varchar2(10),
    emp_name varchar2(20),
    phone char(11),
    email varchar2(50),
    dept_title varchar2(50)
);

insert into 
    emp_simple (
    select
        emp_id,
        emp_name,
        phone,
        email,
        (select dept_title from department where dept_id = e.dept_code) as dept_title
    from
        employee e
);

select * from emp_simple;

--------------------------------------------------
-- update
--------------------------------------------------
-- 기존의 레코드(행)의 일부 컬럼을 수정하는 명령어

select * from sample;

update
    sample
set
    b = upper(b),
    c = upper(c)
where
    a = 5;
    
-- DML 작업은 auto-commit되지 않으므로, TCL(commit, rollback)처리를 해야한다.
-- commit 최근 작업을 db에 반영.
-- rollback 최근 작업을 취고하고 마지막 commit 시점으로 돌아간다.
commit;
rollback;
    
-- ex_emp에서 D5부서원의 급여를 5%씩 인산하는 dml 작성
select * from ex_emp where dept_code = 'D5';
update
    ex_emp
set
    salary = salary * 1.05
where
    dept_code = 'D5';

----------------------------------------------------------
-- delete
----------------------------------------------------------
-- 특정행을 삭제하는 명령어.
-- where절을 사용하지 않으면 테이블 모든 행을 제거하므로 주의할 것.
select * from sample;

delete from
    sample
where
    a is null;

commit;
rollback;

------------------------------------------------------------
-- truncate
------------------------------------------------------------
-- 테이블 전체행을 삭제
-- DML이 아닌 DDL. DDL은 자동커밋된다.(명령어 실행과 동시에 db서버에 실제로 반영된다.)
-- DML과 같은 before-image 생성작업(행단위)이 없으므로 수행속도가 빠르다. 

delete from sample; -- before-image생성작업 있음.
rollback;

truncate table sample;

select * from sample;















-- 210907
--=============================================================
-- DDL
--=============================================================
-- Data Definition Language
-- 데이터베이스 객체를 생성 create, 수정 alter, 삭제 drop 하는 명령어
-- auto-commit되므로 별도의 TCL(commit, rollback)이 필요없다.

select distinct object_type from all_objects;
/*
* EDITION
* CONSUMER GROUP
* **SEQUENCE**
* SCHEDULE
* **PROCEDURE**
* OPERATOR
* DESTINATION
* WINDOW
* SCHEDULER GROUP
* **PACKAGE**
* PROGRAM
* XML SCHEMA
* JOB CLASS
* **TABLE**
* **SYNONYM**
* **VIEW**
* **FUNCTION**
* INDEXTYPE
* **INDEX**
* TYPE
* EVALUATION CONTEXT
* USER
*/

---------------------------------------------------
-- comment
---------------------------------------------------
-- 테이블/컬럼에 대하여 주석을 달 수 있다.

-- Data Dictionary
-- user, all, dba접두사로 시작하는 이름
-- 데이터베이스 객체의 메타정보를 관리하는 시스템테이블(읽기전용)
select
    *
from
    user_tab_comments
where
    table_name = 'EMPLOYEE';

select
    *
from
    user_col_comments
where
    table_name = 'EMPLOYEE';

-- member테이블 생성

create table member(
    id varchar2(20),
    password varchar2(30),
    name varchar2(100)
);

-- 테이블 주석
comment on table member is ''; -- '' = null
-- 컬럼주석
comment on column member.id is '회원아이디';
comment on column member.password is '회원비밀번호(영소문자포함 8 ~ 16자리)';
comment on column member.name is '회원이름';

-- 주석조회
select * from user_tab_comments where table_name = 'MEMBER';
select * from user_col_comments where table_name = 'MEMBER';



--==========================================================
-- CONSTRAINTS
--==========================================================
-- 제약조건. 테이블 생성 시에 각 컬럼에 대해서 값에 대한 범위, 조건을 제시할 수 있다.
-- 데이터무결성을 지키기 위한 것.
-- 데이터무결성이란 데이터의 정확성/일관성을 유지해서 결점이 없도록 하는 것.

-- not null(C, NN) : 해당컬럼에 null을 허용하지 않는다. 필수항목
-- unique(U) : 해당컬럼값이 행별로 유일해야한다. 중복을 허용하지 않음. 닉네임, 주민번호, 이메일 등
-- primary key(P) : 기본키, 레코드(행)을 식별하는 컬럼. (unique + not null) 테이블당 한개씩 지정가능. 아이디, 상품번호...
-- foreign key(R) : 외래키. 부모테이블 department 의 컬럼값만을 참조해서 자식테이블 employee 컬럼에서 사용하도록 하는 것.
-- check(C) : 컬럼값의 범위/값목록을 제한하는 것.

---------------------------------------------------
-- not null
---------------------------------------------------
-- drop table member;
create table member(
    id varchar2(20) not null,
    password varchar2(30) not null,
    name varchar2(100) not null,
    hobby varchar2(500)
);
insert into member values(null, '1234', null, '축구, 농구, 야구'); -- ORA-01400: cannot insert NULL into ("KH"."MEMBER"."ID")
insert into member values('honggd', '1234', '홍길동', null);

select * from member;

----------------------------------------------------
-- unique
----------------------------------------------------
-- 두개 이상의 컬럼을 묶어서 하나의 제약조건으로 지정 가능.

-- 제약조건은 not null을 제외하고는 제약조건명을 반드시 작성하도록 한다.
-- 제약조건은 not null을 제외하고 컬럼레벨, 테이블레벨에 작성이 가능하다.
-- drop table member;
create table member(
    id varchar2(20) not null,
    password varchar2(30) not null,
    name varchar2(100) not null,
    email varchar2(500),  -- unique-- 컬럼레벨
    constraint uq_member_email unique(email) -- 테이블 레벨
);
insert into member values('honggd', '1234', '홍길동', 'gd@naver.com');
-- insert into member values('gogd', '1234', '홍길동', 'gd@naver.com');
insert into member values('honggd', '1234', '홍길동', null);
insert into member values('sagd', '1234', '사길동', null); -- oracle은 여러개의 null값을 허용(mssql 경우에는 하나 이상의 null을 허용하지 않는다.)

select * from member;

--제약조건 DD 조회
select
    *
from
    user_constraints
where
    table_name = 'MEMBER';

-- 제약조건 조회
select
    *
from
    user_cons_columns
where
    table_name = 'MEMBER';

select
    ucc.column_name,
    uc.*
from
    user_constraints uc join user_cons_columns ucc
        on uc.constraint_name = ucc.constraint_name
where
    uc.table_name = 'MEMBER';


--------------------------------------------------
-- primary key
--------------------------------------------------
-- 레코드를 구별하기 위한 식별자컬럼을 지정.
-- not null + unique
-- 테이블당 하나만 지정가능

-- drop table member;
create table member(
    id varchar2(20),
    password varchar2(30) not null,
    name varchar2(100) not null,
    email varchar2(500),
    constraint pk_member_id primary key(id), -- 테이블 레벨
    constraint uq_member_email unique(email) -- 테이블 레벨
);

insert into member values('honggd', '1234', '홍길동', 'honggd@naver.com');
insert into member values('', '1234', '홍길동', 'honggd@naver.com'); -- ORA-01400: cannot insert NULL into ("KH"."MEMBER"."ID")
insert into member values('honggd', '1234', '홍길동길동', 'honghonggd@naver.com'); -- ORA-00001: unique constraint (KH.PK_MEMBER_ID) violated

select * from member;

-- 복합 pk (2개 이상의 컬럼을 연결)
create table tb_order(
    product_no number,                      --상품번호
    member_id varchar2(20),             --회원아이디
    order_date date default sysdate,    -- 주문일자
    cnt number,                                          --상품수량
    constraints pk_order_pno_mid_date primary key(product_no, member_id, order_date)
);

insert into tb_order(product_no, member_id, cnt)
values(111, 'honggd', 3);
insert into tb_order(product_no, member_id, cnt)
values(112, 'honggd', 5);

insert into tb_order(product_no, member_id, cnt)
values('', 'honggd', 5); -- ORA-01400: cannot insert NULL into ("KH"."TB_ORDER"."PRODUCT_NO")

select 
    product_no,
    member_id,
    to_char(order_date, 'yy-mm-dd hh24:mi:ss') order_date,
    cnt
from tb_order;

-- 제약조건 조회
select
    ucc.column_name,
    uc.*
from
    user_constraints uc join user_cons_columns ucc
        on uc.constraint_name = ucc.constraint_name
where
    uc.table_name = 'TB_ORDER';

------------------------------------------------------
-- foreign key
------------------------------------------------------
-- 참조무결성을 유지하기 위한 제약조건
-- 부모테이블의 컬럼값(department.dept_id)만 참조해서 자식테이블의 컬럼(employee.dept_code)에 사용할 수 있도록 하는 것.
-- 자식테이블의 컬럼에 fk를 지정한다.
-- 참조하는 부모테이블의 컬럼은 pk, uq제약조건이 걸려있어야 한다.

-- 제약조건 조회
select
    ucc.column_name,
    uc.*
from
    user_constraints uc join user_cons_columns ucc
        on uc.constraint_name = ucc.constraint_name
where
    uc.table_name = 'EMPLOYEE';
    
-- shop_member테이블 생성
create table shop_member(
    id varchar2(20),
    name varchar2(50) not null,
    constraints pk_shop_member_id primary key(id)
);

insert into shop_member values('honggd' ,'홍길동');
insert into shop_member values('sinsa' ,'신사임당');
insert into shop_member values('leess' ,'이순신');

select * from shop_member;

--shop_buy테이블 생성
--drop table shop_buy;
create table shop_buy(
    no number,
    member_id varchar2(20),
    prod_code varchar2(20),
    cnt number default 1,
    constraints pk_shop_buy_no primary key(no),
    constraints fk_shop_buy_member_id foreign key(member_id) references shop_member(id) on delete cascade
);

insert into shop_buy
values(1, 'honggd', 'p1234', 3);
insert into shop_buy
values(2, 'sinsa', 'p888', 10);
insert into shop_buy
values(3, 'honggd', 'p333', 1);
insert into shop_buy
values(4, 'seses', 'p777', 1); -- ORA-02291: integrity constraint (KH.FK_SHOP_BUY_MEMBER_ID) violated - parent key not found

select * from shop_buy;
select * from shop_member;

-- 자식데이터를 삭제가능
--부모데이터 삭제 조건
-- 1. on delete restricted (기본값)
-- 2. on delete set null 자식테이블의 데이터를 null로 지정
-- 3. on delete cascade 자식행도 함께 삭제

-- 부모테이블 shop member 에서 sinsa데이터를 삭제
delete from shop_member where id = 'sinsa'; -- ORA-02292: integrity constraint (KH.FK_SHOP_BUY_MEMBER_ID) violated - child record found

-- 식별관계 : 자식테이블의 fk컬럼이 pk인 경우
-- shop.member.id(1) - shop_nickname.member_id(1)

-- 비식별 관계 : 자식테이블의 fk컬럼이 pk가 아닌 경우. 
-- shop_member.id(1) - shop_buy.member_id(N)
-- department.dept_id(1) - employee.dept_code(N)

create table shop_nickname (
    member_id varchar2(20),
    nickname varchar2(30) not null,
    constraints pk_shop_nickname_member_id primary key(member_id),
    constraints fk_shop_nickname_member_id foreign key(member_id) references shop_member(id)
);

insert into shop_nickname
values('honggd', '홍길이길이');
insert into shop_nickname
values('honggd', '홍도도적'); -- ORA-00001: unique constraint (KH.PK_SHOP_NICKNAME_MEMBER_ID) violated

select * from shop_nickname;

-----------------------------------------------
-- check
-----------------------------------------------
-- 컬럼값의 범위를 제한, 값목록을 한정.

-- drop table member;
create table member(
    -- 컬럼명 자료형(크기) [default 기본값] [not null]
    id varchar2(20),
    password varchar2(30) not null,
    name varchar2(100) not null,
    email varchar2(500),
    gender char(1),
    point number default 0,
    constraints pk_member_id primary key(id), 
    constraints uq_member_email unique(email),
    constraints ck_member_gender check(gender in ('M','F')),
    constraints ck_member_point check(point >= 0)
);

insert into member
values('honggd', '1234', '홍길동', 'honggd@naver.com', 'M', 300);
-- ORA-02290: check constraint (KH.CK_MEMBER_GENDER) violated
-- ORA-02290: check constraint (KH.CK_MEMBER_POINT) violated

select * from member;

-- 제약조건 조회
select
    ucc.column_name,
    uc.*
from
    user_constraints uc join user_cons_columns ucc
        on uc.constraint_name = ucc.constraint_name
where
    uc.table_name = 'MEMBER';


------------------------------------------------------
-- alter
------------------------------------------------------
-- 데이터베이스 객체를 수정하는 명령어

-- alter table은 컬럼/제약조건을 수정

-- add 컬럼/제약조건
-- modify 컬럼(자료형, default값, not null) -- not null을 제외한 제약조건은 수정불가하다.
-- rename 컬럼/제약조건
-- drop 컬럼/제약조건

-- product 테이블 생성
create table product (
    code varchar2(20)
);

-- add 컬럼
alter table product 
add name varchar2(50) not null;

alter table product
add brand varchar2(100);

desc product;

-- add 제약조건 (uq, pk, fk, ck)
-- not null은 add가 아닌 modify명령어를 사용해야 한다.
alter table product
add constraints pk_product_code primary key(code);

-- 제약조건 조회
select
    ucc.column_name,
    uc.*
from
    user_constraints uc join user_cons_columns ucc
        on uc.constraint_name = ucc.constraint_name
where
    uc.table_name = 'PRODUCT';

-- modify 컬럼 (자료형, 크기, 기본값, null여부)
alter table product
modify brand varchar2(200) not null;

alter table product
modify brand null;

desc product;

insert into product
values('abc1234', '안경세정제', null);

alter table product
modify name varchar2(10); -- ORA-01441: cannot decrease column length because some value is too big

select * from product;

commit;

-- 제약조건은 이름 변경외에는 수정할 수 없다.

--rename 컬럼명
alter table product
rename column code to cd;

desc product;

--rename 제약조건
alter table product
rename constraints PK_PRODUCT_CODE to PK_PRODUCT_CD;

-- drop 컬럼
alter table product
drop column brand;

-- drop 제약조건
-- not null 제약조건은 삭제가능
alter table product
drop constraints SYS_C008595;


-- 테이블명 변경
alter table product rename to tb_product;

select * from tab;

------------------------------------------------
-- drop
------------------------------------------------
-- 자식테이블이 fk로 참조하고 있는 테이블은 삭제불가

drop table shop_member; -- ORA-02449: unique/primary keys in table referenced by foreign keys

-- 삭제 (자식테이블의 fk제약조건을 제거)

















--210908
--====================================================
-- DCL
--====================================================
-- Data Control Language
-- 권한 관련 부여 grant, 회수 revoke 명령어
-- TCL Transaction Control Language 트랙잭션 제어어(commit, rollback)

-------------------------------------------------------
-- grant
-------------------------------------------------------
-- 권한/롤 부여하는 명령어
-- grant 권한|롤 to 사용자|롤 [with admin option]
-- 권한 : create session, create table. select 테이블, insert테이블...
-- 롤 : 권한 묶음. connect, resource, dba
-- with admin option: 부여받은 권한/롤을 다른 사용자에게 다시 부여할 수 있는 권한

create table coffee(
    name varchar2(100) primary key,
    price number
);

insert into coffee values('맥심', 2000);
insert into coffee values('카누', 3000);
insert into coffee values('네스카페', 2500);

select * from coffee;

commit;

--qwerty계정에게 coffee 조회권한 부여
grant select on coffee to qwerty;

--qwerty계정에게 coffee insert 권한 부여
grant insert, update, delete on coffee to qwerty;

-- coffee_role에서 coffee테이블 관련 권한 관리
-- 일반계정은 create role권한을 부여받아야한다.
alter session set"_oracle_script" = true;
create role coffee_role;

-- coffee테이블 관련 권한을 role에 부여
grant select, insert, update, delete on coffee to coffee_role;

-- coffe_role을 qwerty에게 부여
grant coffee_role to qwerty; 

--------------------------------------------------
-- revoke
--------------------------------------------------
-- 권한 회수

revoke insert, update, delete on coffee from qwerty;
revoke select on coffee from qwerty;

revoke coffee_role from qwerty;



---------------------------------------------------
-- 권한/롤 조회
---------------------------------------------------
-- 권한
select * from user_sys_privs;
-- 롤
select * from user_role_privs;


--=================================================
-- DATABASE OBJECT part1
--=================================================

---------------------------------------------------
-- Data Dictionary
---------------------------------------------------
-- 데이터베이스 객체를 효율적으로 관리하기 위한 메타정보를 제공하는 시스템테이블
-- 사용자가 객체를 제어하는 동안 실시간으로 반영.(db를 직접 수정하는 작업 없음. 조회만 가능)

-- 1. user_xxx : 계정이 소유한 객체만 조회
-- 2. all_xxx : 계정이 소유한 것과, 권한을 부여받아 사용가능한 객체를 모두 조회
-- 3. dba_xxx : 관리자만 조회가능. 데이터베이스의 모든 객체를 조회

select * from user_tables;
select * from user_constraints;

select * from user_sys_privs; -- 부여받은 권한 조회
select * from user_role_privs; -- 부여받은 롤 조회
select * from role_sys_privs; -- 부여받은 롤에 속한 권한 조회

select * from all_tables;
select * from all_constraints;

----------------------------------------------------
-- 관리자로 접속
----------------------------------------------------
select * from dba_tables where owner = 'KH';
select * from dba_tables where owner = 'CHUN';

select * from dba_users;

select * from dba_sys_privs where grantee = 'KH';
select * from dba_role_privs where grantee = 'KH';

-- Data Dictionary 조회
select * from dict;
select * from dict where comments like '%priv%' and table_name like 'USER_%';


--===============================================
-- Stored View
--===============================================
-- 실제테이블에 근거하여 생성하는 가상테이블
-- 실제데이터를 가지고 있지 않지만, 테이블처럼 사용이 가능하다.

-- inline-view와 달리 저장해두고 뷰이름으로 참조하여 영구적 사용이 가능하다.
-- resource롤에 create view는 포함되어 있지 않다.

-- 특징
-- 1. 실제 존재하는 컬럼외에 연산처리된 컬럼도 사용이 가능
-- 2. 조인뷰, 서브쿼리 사용가능
-- 3. 제한적으로 DML도 가능. 읽기 전용으로 사용하는 것을 추천
-- 4. 테이블의 일부데이터에 대한 공유가 가능.

-- 관리자계정으로 create view권한 부여
grant create view to kh;

-- 권한 조회
select * from user_sys_privs;

-- 복잡한 연산으로 처리되는 컬럼 포함 emp_view
-- drop view emp_view;
create or replace view emp_view
as
select
    e.*,
    (extract(year from sysdate)) - (substr(emp_no,1,2) + decode(substr(emp_no,8,1), '1',1900,'2',1900,2000)) + 1 age,
    decode(substr(emp_no,8,1), '1','남','3','남','여') gender
from
    employee e;
    
-- 뷰 조회
select
    *
from
    emp_view
where
    gender = '남'
    and 
    age >= 40;

-- dd에서 확인
select * from user_views;

-- 사번 사원명 전화번호 이메일 부서명 직급명 조회 가능한 emp_simple_view를 생성/조회하세요
create or replace view emp_simple_view
as
select
    emp_id,
    emp_name,
    phone,
    email,
    (select dept_title from department where dept_id = e.dept_code) as dept_code,
    (select job_name from job where job_code = e.job_code) as job_name
from
    employee e;

select * from emp_simple_view;

-- qwerty사용자에게 emp_simple_view에 대한 조회권한 부여
-- qwerty -> employee (X)
-- qwerty -> emp_simple_view(O)
grant select on emp_simple_view to qwerty;


------------------------------------------------
-- sequence
------------------------------------------------
-- 정수값을 순차적으로 발행하는 객체.
-- 고유한 번호를 발급해서 중복 없는 처리를 한다.
-- 빠짐없는 순서를 제공해야 된다면 sequence를 쓰지 않는 것이 좋다.

/*
create sequence 이름
[start with 시작값(1)]
[increment  by 증가값(1)]
[nomaxvalue | maxvalue 최대값]
[nominvalue | minvalue 최소값]
[no cycle | cycle] -- 최대/최소값에 도달했을 때 순환여부. nocycle 순환없이 종료(에러유발) | cycle은 시작값부터 다시 시작
[cache 20 | nocache] -- 20개씩 채번해서 메모리에서 번호부여
*/

create table foo(
    no number primary key,
    id varchar2(100) not null
);

create sequence seq_foo
start with 1
increment by 1
nomaxvalue
nominvalue
nocycle
cache 20;

insert into foo
values(seq_foo.nextval, 'honggd');
insert into foo
values(seq_foo.nextval, 'sinsa');

select * from foo;

-- 시퀀스객체 현재번호 확인
select seq_foo.currval from dual;

-- dd에서 확인
select * from user_sequences;
-- last_number는 다음 발급번호를 의미한다.


-- 포맷팅된 pk만들기
create table kh_order (
    no varchar2(20) primary key,
    order_date date default sysdate
);

create sequence seq_kh_order_no;

-- kh-20210908-0034
insert into kh_order (no)
values('kh-' || to_char(sysdate, 'yyyymmdd') || '-' || lpad(seq_kh_order_no.nextval, 4, '0'));

select * from kh_order;

-- 시퀀스객체의 start with값은 수정이 불가능하다. 객체 삭제후 새로 생성해야 한다.


----------------------------------------------------
-- Index
----------------------------------------------------
-- 색인
-- sql문의 처리속도 향상을 위해서 컬럼에 대해 만드는 객체
-- key/value형식이며, key에는 컬럼값, value에는 행이 저장된 주소값을 보관.

-- 인덱스 적용하면 좋은 컬럼
-- 1. 선택도가 좋은 컬럼(컬럼값의 고유도가 높은 컬럼) : 사번, 주민번호, 이메일, 전화번호(매우 좋음), 이름(좋음), 성별(매우나쁨)
-- 2. pk, uq제약조건이 걸린 컬럼(자동으로 인덱스 생성)
-- 3. 조인 기준컬럼 / where 조건에 자주 참조되는 컬럼
-- 4. 값이 지정되면 변경이 잘 일어나지 않는 컬럼

-- 인덱스 적용하면 나쁜 컬럼
-- 1. 선택도 나쁜 컬럼
-- 2. 값 변경이 자주 일어나는 컬럼
-- 3. 개수가 너무 많아도 성능저하

-- dd에서 employee테이블에 대한 조회
select * from user_indexes where table_name = 'EMPLOYEE';
select * from user_ind_columns where table_name = 'EMPLOYEE';

select
    uic.column_name,
    ui.*
from 
    user_indexes ui join user_ind_columns uic
        on ui.index_name = uic.index_name
where
    ui.table_name = 'EMPLOYEE';


select * from employee where emp_name = '송종기';
select * from employee where emp_id = '201';

select * from employee where emp_name != '송종기'; -- index X
select * from employee where emp_name is null; -- index X

-- emp_name 인덱스 생성
create index idx_employee_emp_name on employee(emp_name);


-- 실행계획은 optimizer이 결정하는데, 다음 경우는 index를 사용하지 않는다.
-- 1. 인덱스컬럼에 변형이 가해지는 경우 substr(emp_no,8,1)
-- 2. 컬럼 null비교하는 경우
-- 3. not 비교검색
-- 4. 비교값의 데이터타입이 다른 경우

commit;













--210910
--=======================================================
-- PL/SQL
--=======================================================
-- Procedural Language Extension to SQL 절차적언어확장
-- 변수선언, 조건문, 반복문 사용가능
/*
익명블럭의 구조

declare
    -- 변수 선언부(선택)
begin
    -- 실행부(필수)
exception
    -- 예외처리부(선택)
end;
/
*/

-- 콘솔출력설정(세션별)
set serveroutput on;


declare
    v_phone varchar2(100); 
begin
    -- 사원테이블 조회
    select 
        phone
    into
        v_phone
    from
        employee
    where
        emp_name = '&사원명';
        
    -- 콘솔 출력
    dbms_output.put_line('전화번호 : ' || v_phone);

exception
    when no_data_found then dbms_output.put_line('해당사원이 존재하지 않습니다.');
end;
/

-------------------------------------------------
-- PL/SQL 자료형
-------------------------------------------------
-- 1. 기본자료형
--      문자형 : varchar2, char
--      숫자형 : number, pls_integer, binary_integer   
--      날짜형 : date, timestamp
--      논리형 : boolean

-- 복합자료형(참조형)
--      record
--      cursor
--      collection

-------------------------------------------------
-- 타입 참조
-------------------------------------------------

-- 1. %type
declare
    v_emp_name employee.emp_name%type;
    v_phone employee.phone%type;
    v_email employee.email%type;
begin
    select
        emp_name, phone, email
    into 
        v_emp_name, v_phone, v_email
    from
        employee
    where
        emp_id = '&사번';
        
        dbms_output.put_line('사원명 :' || v_emp_name);
        dbms_output.put_line('전화번호 :' || v_phone);
        dbms_output.put_line('이메일 :' || v_email);
        
end;
/

-- 2. %rowtype
-- 테이블의 한행을 참조(모든 컬럼)
declare
    emp_row employee%rowtype;
begin
    select
        *
    into 
        emp_row
    from
        employee
    where
        emp_id = '&사번';
        
        dbms_output.put_line('사원명 :' || emp_row.emp_name);
        dbms_output.put_line('전화번호 :' || emp_row.phone);
        dbms_output.put_line('이메일 :' || emp_row.email);
        
end;
/

-- 3. record
-- 복합자료형. 여러 컬럼타입을 묶어서 하나의 타입으로 선언.

declare
--    emp_name employee.emp_name%type;
--    detp_title department.dept_title%type;
    -- 사용자 정의 타입 : record
    type my_emp_type is record(
        emp_name employee.emp_name%type,
        dept_title department.dept_title%type
    );
    
    emp_row my_emp_type;
    
begin
    -- 사원명, 부서명
    select
        e.emp_name, d.dept_title
    into
        emp_row
    from
        employee e left join department d
            on e.dept_code = d.dept_id
    where
        e.emp_id = '&사번';
        
    dbms_output.put_line('사원명 :' || emp_row.emp_name);
    dbms_output.put_line('부서명 :' || emp_row.dept_title);
end;
/

-- @실습문제 : 사번을 입력받고 사번, 사원명, 직급명, 부서명을 조회하는 익명블럭을 생성

declare

    type my_emp_type is record(
    emp_id employee.emp_id%type,
    emp_name employee.emp_name%type,
    job_name job.job_name%type,
    dept_title department.dept_title%type
    );
    
    emp_row my_emp_type;
    
begin
    select
        e.emp_id, e.emp_name, j.job_name, d.dept_title
    into
        emp_row
    from
        employee e
            left join department d
                on e.dept_code = d.dept_id
            left join job j
                using(job_code)
            where
                e.emp_id = '&사번';
                
    dbms_output.put_line('사번 : ' || emp_row.emp_id);
    dbms_output.put_line('사원명 : ' || emp_row.emp_name);
    dbms_output.put_line('직급명 : ' || emp_row.job_name);
    dbms_output.put_line('부서명 : ' || emp_row.dept_title);
end;
/


-------------------------------------------------
-- pl/sql dml
-------------------------------------------------
-- transaction 처리 (commit/rollback) 도 함께 진행해야 한다.

select * from member;

desc member;

declare
    id member.id%type := 'kkk'; --대입연산자 :=
    password member.password%type := '1234';
    name member.name%type := '신사임당';
    email member.name%type;
    gender member.gender%type;
    point member.point%type;
begin
    email := 'sinsa@naver.com';
    gender := 'F';
    point := 100;
    
    -- dml
    insert into
        member
    values(
    id, password, name, email, gender, point
    );
    -- tcl(commit)
    commit;
end;
/


-------------------------------------------------
-- 조건식
-------------------------------------------------
/*
if 조건식 then
    -- 실행구문
end if;

if 조건식 then
    -- 참일 때 실행구문
else
    -- 거짓일 때 실행구문
end if;

if 조건식1 then
    -- 조건식1 참일 때 구문
elsif   조건식 2 then
    -- 조건식2 참일 때 구문
end if;
*/

declare
    num number;
begin
    num := &정수;
    
    if mod(num, 2) = 0 then
        dbms_output.put_line('짝수를 입력하셨습니다.');
    else
        dbms_output.put_line('홀수를 입력하셨습니다.');
    end if;
        
end;
/

--@실습문제 : 사원이벤트 기획중인데, 짝수년도 입사자를 대상으로 한다.
-- 사번을 입력하면 입사년도를 따져서 "축하합니다. 이벤트 대상자입니다.(짝수년도)" / "내년 이벤트를 기다려주세요.(홀수년도)"

declare
    hire_year number;
begin
    -- 1. 데이터조회
    select
        extract(year from hire_date)
    into
        hire_year
    from
        employee
    where
        emp_id = '&사번';
    
    dbms_output.put_line(hire_year);
    -- 2. 검사
    if mod(hire_year, 2) = 0 then
        dbms_output.put_line('축하합니다. 이벤트 대상자입니다.');
    else
        dbms_output.put_line('내년 이벤트를 기다려주세요.');
    end if;
end;
/

-- case문
-- decode함수는 pl/sql안에서 단독사용이 불가하다. (sql문안에서는 사용가능)
/*
문법1
case 표현식
    when 값1 then
        --실행문1;
    when 값2 then
        --실행문2;
    else
        --기본실행문
end case;

문법2
case   
    when 조건식1 then
        --조건식1 참일 때 실행문
    when 조건식2 then
        --조건식2 참일 때 실행문
    else
        --기분실행문
end case;
*/

begin
    case mod(&정수,3)
        when 0 then
            dbms_output.put_line('가위');
        when 1 then
            dbms_output.put_line('바위');
        else
            dbms_output.put_line('보');
    end case;
end;
/

declare
    n number;
begin
    n := &정수;
    case
        when mod(n,3) = 0 then
            dbms_output.put_line('가위');
        when mod(n,3) = 1 then
            dbms_output.put_line('바위');
        else
            dbms_output.put_line('보');
    end case;
end;
/

-- @실습문제: 사번을 입력받고, 관리자에 대한 성과급을 지급하려한다.
-- 관리하는 사원이 5명이상은 급여의 15% 지급 : '성과급은 ??원입니다.'
-- 관리하는 사원이 5명미만은 급여의 10% 지급 : '성과급은 ??원입니다.'
-- 관리하는 사원이 없는 경우는 '대상자가 아닙니다.'
declare
    emp_name employee.emp_name%type;
    salary employee.salary%type;
    num number;
begin 
    select 
        emp_name, salary, (select count(*)  from employee where manager_id = e.emp_id)
    into 
        emp_name, salary, num
    from
        employee e
    where
        emp_id = '&사번';
    
    dbms_output.put_line(emp_name);
    dbms_output.put_line(salary);
    dbms_output.put_line(num);
    --성과급 구분
    case
        when num >= 5 then
            dbms_output.put_line('성과금 : ' || (salary * 0.15));
        when num > 0 then
            dbms_output.put_line('성과금 : ' || (salary * 0.1));
        else
            dbms_output.put_line('대상자가 아닙니다.');
    end case;
end;
/

----------------------------------------------------
-- 반복문
----------------------------------------------------
-- 기본 loop
-- while loop
-- for loop

declare
    n number := 1;
begin

/*    loop
        dbms_output.put_line(n);
        n := n + 1;
        -- 탈출조건
        exit when n > 5;
    end loop;*/
    
    while n <=5 loop
        dbms_output.put_line(n);
        n := n + 1;
    end loop;
end;
/

/*
reverse 가능 

for 증감변수 in 시작값..종료값 loop
    -- 시작값에서 종료값으로 1씩 증가.
end loop;
*/
begin
    for n in reverse 1..5 loop
        dbms_output.put_line(n);
    end loop;
end;
/

--@실습문제 : 사용자가 입력한 수의 구구단 출력
--선생님 풀이
declare
    dan number := &단;
begin

    if dan >=2 and dan <=9 then
        -- 구구단 출력
        for n in 1..9 loop
            dbms_output.put_line(dan || '*' || n || '=' || (dan * n));
        end loop;
    else
        dbms_output.put_line('잘못 입력하셨습니다.');
    
    end if;
end;
/
--내 풀이
declare
    n number :=1;
    inputNum number := '&정수';
begin
    case 
    when inputNum >=1 and inputNum <=9 then
    while n <= 9 loop
        dbms_output.put_line(inputNum || '*' || n || '=' || inputNum * n);
        n := n + 1;
    end loop;
    else
        dbms_output.put_line('잘못입력하셨습니다.');
    end case;
end;
/

select * from employee;

-- employee 사원 전체조회
declare
    errow employee%rowtype;
begin
    
    for n in 200..223 loop
        select
            *
        into
            errow
        from
            employee
        where
            emp_id = n;
            
            dbms_output.put_line(errow.emp_id || '      ' || errow.emp_name || '        ' || errow.phone);
    
    end loop;
end;
/

--====================================================
-- DATABASE OBJECT part 2
--====================================================

------------------------------------------------------
-- Stored Function
------------------------------------------------------
-- 리턴값이 반드시 존재하는 프로시져 객체.
-- 일반 sql, 익명블럭, pl/sql객체에서 호출해서 사용가능

/*

매개변수선언부, 리턴타입선언부에서는 자료형의 크기를 작성하지 않는다.
create [or replace] function 함수명(매개변수명1 자료형, ...)
return 자료형
is
    -- 지역변수선언
begin
    -- 실행구문
    return 값;
exception
    -- 예외처리
    return 기본값;
end;
/

*/

-- 양모자 씌우기함수
create or replace function myfunc(
    p_name varchar2
)
return varchar2
is
    result varchar2(32767);
begin
    result := 'd' || p_name || 'b';
    return result;
end;
/

-- 일반 sql
select
    myfunc(emp_name)
from
    employee;

-- 성별 함수 : 주민번호를 받아서 성별 리턴
create or replace function fn_gender(
    p_emp_no employee.emp_no%type
) 
return char
is
begin
    case
        when substr(p_emp_no,8,1) in ('1','3') then
            return '남';
        else
            return '여';
    end case;
end;
/

-- 1. 일반 sql
select
    emp_name,
    fn_gender(emp_no)
from
    employee
where
    fn_gender(emp_no) = '남';

-- 2. 익명블럭, 다른pl/sql객체
begin
    dbms_output.put_line(fn_gender('900909-1234567'));
end;
/

-- 3. execute명령
var gender char;
exec :gender := fn_gender('900909-1234567');
print gender;














--210913
--------------------------------------------------------
-- Stored Procedure
--------------------------------------------------------
-- 작업절차를 정리해서 객체로 저장해 둔것
-- 함수와 달리 반환값이 없다. (매개변수의 모드를 설정해서 호출부로 값 전달이 가능)
-- 큰업무를 분활해서 여러 프로시져를  구현 후 사용하는 것을 추천.
-- 일반 sql문에서는 호출불가. 다른 프로시져 또는 execute명령어를 사용해 호출

/*
create or replace procedure 프로시져명
(매개변수1 [in | out | in out] 자료형, ...)
is
        -- 지역변수선언
begin
        -- 실행구문 
 end;
 /
 
*/

select * from ex_emp;

-- 특정사원을 삭제하는 프로시져
create or replace procedure proc_del_ex_emp(
    p_emp_id in ex_emp.emp_id%type
)
is

begin
    -- dml
    delete from
        ex_emp
    where
        emp_id = p_emp_id;
    
    -- transaction처리
    commit;
end;
/

-- 익명블럭에서 호출
set serveroutput on;
begin

    proc_del_ex_emp(223);
    dbms_output.put_line(223 || '사원 삭제 성공!');
end;
/

select * from ex_emp;

--@실습문제 : 사번을 입력받고, employee테이블의 레코드를 찾아서 ex_emp에 insert하는 프로시져
-- 1. 입력받은 사번으로 employee 조회.
-- 2. 선언한 지역변수에 조회한 record 대입
-- 3. ex_emp에 insert작업
create or replace procedure proc_merge_emp(
    p_emp_id in ex_emp.emp_id %type
)
is
    errow employee%rowtype;
begin
    -- 1. employee 사원조회 -> 변수에 대입
    select
        *
    into
        errow
    from
        employee
    where
        emp_id = p_emp_id;
    -- 2. ex_emp 레코드 사입
    insert into ex_emp
    values(
    errow.emp_id, errow.emp_name, errow.emp_no, errow.email, errow.phone, errow.dept_code, 
    errow.job_code, errow.sal_level,    errow.salary, errow.bonus, errow.manager_id, errow.hire_date, 
    errow.quit_date, errow.quit_yn
    );
    -- 3. tcl처리(commit)
    commit;
end;
/

begin
    proc_merge_emp(223);
    dbms_output.put_line(223 || '추가완료');
end;
/

-- 사원정보 조회 프로시져
-- 사번을 전달하고, 사원명, 부서명, 직급명 조회(-> 프로시져호출부로 전달이 되어야 함)

-- out mode 매개변수 : 호출부에서 공간주소값을 전달, 프로시져에 값을 대입
create or replace procedure proc_emp_info(
    p_emp_id in employee.emp_id%type,
    
    p_emp_name out employee.emp_name%type,
    p_dept_title out department.dept_title%type,
    p_job_name out job.job_name%type
)
is

begin
    -- 사번을 통해 사원조회 -> out mode 매개변수 값을 대입
    select
        emp_name,
        (select dept_title from department where dept_id = e.dept_code),
        (select job_name from job where job_code = e.job_code)
    into
        p_emp_name,
        p_dept_title,
        p_job_name
    from
        employee e
    where
        emp_id = p_emp_id;
        
    -- 변수 확인
    dbms_output.put_line(p_emp_name);
    dbms_output.put_line(p_dept_title);
    dbms_output.put_line(p_job_name);
end;
/

-- 호출부
declare
    -- 프로시져 out매개변수로 전달할 지역변수 선언
    v_emp_name employee.emp_name%type;
    v_dept_title department.dept_title%type;
    v_job_name job.job_name%type;
begin
    
    proc_emp_info('&사번', v_emp_name, v_dept_title, v_job_name);
    dbms_output.put_line('v_emp_name = ' || v_emp_name);
    dbms_output.put_line('v_dept_title = ' || v_dept_title);
    dbms_output.put_line('v_job_name = ' || v_job_name);
end;
/

-----------------------------------------------------
-- cursor
-----------------------------------------------------
-- sql 요청 후 결과집합을 가리키는 포인터객체
-- 여러행의 결과를 처리할 수 있다.

-- 1. 암시적 커서  
        -- 모든 sql문이 실행됨과 동시에 결과집합에 대한 암묵적 커서가 만들어져 처리됨.
        -- 커서선언 - open - fetch - close 단계를 거쳐 처리됨.
-- 2. 명시적 커서
        -- 커서선언 - open - fetch- close 단계를 직접 처리해야함.
        -- for..in문 생성시 open-fetch-close는 자동으로 처리

-- 파라미터 없는 커서        
declare
    -- 1. 커서 선언
    cursor emp_cursor
    is
    select
        *
    from
        employee;

    erow employee%rowtype;
begin
    -- 2. open
    open emp_cursor;
    
    -- 3. fetch 한행씩 cursor로 부터 가져오기
    loop 
        fetch emp_cursor into erow;
        --종료조건
        exit when emp_cursor%notfound; -- 더 이상 가져올 행이 없는 경우
        dbms_output.put_line(erow.emp_id || '       ' || erow.emp_name || '        ' || erow.phone);
    end loop;
    -- 4. close
    close emp_cursor;
end;
/

-- 파라미터 있는 커서
declare
    -- 1. 커서 선언
    cursor emp_cursor(
        p_dept_code employee.dept_code%type
    )
    is
    select
        *
    from
        employee
    where
        dept_code = p_dept_code;

    erow employee%rowtype;
begin
    -- 2. open
    open emp_cursor('&부서코드');
    
    -- 3. fetch 한행씩 cursor로 부터 가져오기
    loop 
        fetch emp_cursor into erow;
        --종료조건
        exit when emp_cursor%notfound; -- 더 이상 가져올 행이 없는 경우
        dbms_output.put_line(erow.emp_id || '       ' || erow.emp_name || '        ' || erow.dept_code);
    end loop;
    -- 4. close
    close emp_cursor;
end;
/

--@실습문제 : 직급명으로 사원조회 프로시져
-- proc_emp_job('대리')
-- 사번, 사원명, 직급명을 조회
create or replace procedure proc_emp_job(
    p_job_name job.job_name%type
)
is
    -- 1. cursor 선언
    cursor emp_cursor(
        pc_job_name job.job_name%type
    )
    is
    select
        e.emp_id,
        e.emp_name,
        j.job_name
    from
        employee e join job j
            using (job_code)
    where
        j.job_name = pc_job_name;

    -- fetch된 데이터를 보관한 변수
    v_emp_id employee.emp_id%type;
    v_emp_name employee.emp_name%type;
    v_job_name job.job_name%type;
begin
    -- 2. open
    open emp_cursor(p_job_name);
    -- 3. fetch
    loop
        fetch emp_cursor into v_emp_id, v_emp_name, v_job_name;
        exit when emp_cursor%notfound;
        dbms_output.put_line(v_emp_id || '          ' || v_emp_name || '            ' || v_job_name);
    end loop;
    -- 4. close
    close emp_cursor;

end;
/

begin
    proc_emp_job('&직급명');
end;
/


--for..in문을 이용한 cursor
-- 1. open - fetch - close 처리
-- 2. 레코드변수는 for..in문에서 선언가능
-- 3. exit 불필요

-- 파라미터 없는 커서        
declare
    -- 1. 커서 선언
    cursor emp_cursor
    is
    select
        *
    from
        employee;

begin
    -- 2. open - fetch - close, 레코드변수 , exit처리
    for erow in emp_cursor loop 
        dbms_output.put_line(erow.emp_id || '       ' || erow.emp_name || '        ' || erow.phone);
    end loop;

end;
/

-- 파라미터 있는 커서
declare
    -- 1. 커서 선언
    cursor emp_cursor(
        p_dept_code employee.dept_code%type
    )
    is
    select
        *
    from
        employee
    where
        dept_code = p_dept_code;

begin
    -- 2. open - fetch - close, 레코드변수 , exit처리
    for erow in emp_cursor('&부서코드') loop 
        dbms_output.put_line(erow.emp_id || '       ' || erow.emp_name || '        ' || erow.dept_code);
    end loop;
    
end;
/

-- for..in문 버전
--@실습문제 : 직급명으로 사원조회 프로시져
-- proc_emp_job('대리')
-- 사번, 사원명, 직급명을 조회
create or replace procedure proc_emp_job(
    p_job_name job.job_name%type
)
is
    -- 1. cursor 선언
    cursor emp_cursor(
        pc_job_name job.job_name%type
    )
    is
    select
        e.emp_id,
        e.emp_name,
        j.job_name
    from
        employee e join job j
            using (job_code)
    where
        j.job_name = pc_job_name;

begin
    for erow in emp_cursor(p_job_name) loop
        dbms_output.put_line(erow.emp_id || '          ' || erow.emp_name || '            ' || erow.job_name);
    end loop;

end;
/

begin
    proc_emp_job('&직급명');
end;
/


-----------------------------------------------------
-- Trigger
-----------------------------------------------------
-- 방아쇠, 연쇄반응
-- 특정이벤트(DDL, DML, LOGON) 발생시 자동으로 처리될 구문을 가진 객체

-- 주의사항
-- 원DML이 변경하는 테이블을 trigger 내부에서는 접근할 수 없다.

-- 1. DDL Trigger
-- 2. DML Trigger
-- 3. Logon/Logoff Trigger

/*
create [or replace] trigger 트리거명
    before | after                                                          -- 원DML문 이전/이후 실행 (after)
    insert or update or delete on 테이블명               -- 특정테이블 insert/update/delete
    [for each row]                                                         -- 문장레벨트리거/행레벨트리거
[declare]

begin

end;
/
*/

select * from member;
desc member;
-- member테이블의 변경내역을 logging
create table member_log(
    no number primary key,
    log varchar2(1000),
    log_date date default sysdate
); 
create sequence seq_member_log_no;

/*
의사레코드 Pseudo Record
                    :old                                    :new
----------------------------------------
insert         null                                     삽입후

update      변경전                                 변경후

delete       삭제전                                  null
*/
-- trigger 생성
create or replace trigger trig_member_log
    after
    insert or update or delete on member
    for each row
begin
    if inserting then
    -- insert
    insert into
        member_log(no, log)
    values(
        seq_member_log_no.nextval, :new.id || ' 회원이 등록했습니다.'
    );    
    elsif updating then
        -- updating ('컬럼명')
    insert into
        member_log(no, log)
    values(
        seq_member_log_no.nextval, :new.id || ' 회원이 이름을' || :old.name || '에서' || :new.name || '으로 변경했습니다.'
    );  
    elsif deleting then
    insert into
        member_log(no, log)
    values(
        seq_member_log_no.nextval, :old.id || '회원이 탈퇴했습니다.'
    );       
    end if;
    -- trigger에서는 별도의 트랜잭션 처리를 하지 않는다. 
    -- 원DML문과 같은 트랜잭션으로 처리된다.
end;
/

select * from member;
select * from member_log;

insert into 
    member
--values('yoogs','1234','유관순', 'yoogs@naver.com', 'F', 100);
values('sejong', '1234', '세종대왕', 'sejong@naver.com', 'M', 1000);

update
    member
set
    name = '세종'
where
    id = 'sejong';

delete from
    member
where 
    id = 'kkk';

-- 원DML
rollback;
commit;















--210914
--상품 재고 관리
--1. 상품테이블
create table product(
    no number,
    name varchar2(100) not null,
    brand varchar2(100) not null,
    price number not null,
    stock number default 0,
    constraints pk_product_no primary key(no)
);
alter table product
add constraints ck_product_stock check(stock >= 0);
--2. 상품입출고 테이블
create table product_io (
    no number,
    pno number,
    cnt number,
    status char(1),
    io_date date default sysdate,
    constraints pk_product_io_no primary key(no),
    constraints fk_product_io_pno foreign key(pno) references product(no),
    constraints ck_product_io_status check (status in ('I', 'O'))
);

create sequence seq_product_no;
create sequence seq_product_io_no;

--상품 데이터 추가
insert into
    product
values(
    seq_product_no.nextval, '갤럭시 z-fold', '삼성', 15000000, default
);

insert into
    product
values(
    seq_product_no.nextval, '아이폰13', '애플', 1300000, default
);
insert into
    product
values(
    seq_product_no.nextval, '갤럭시워치' , '삼성', 300000, default
);
insert into
    product
values(
    seq_product_no.nextval, '애플워치', '애플', 490000, default
);

select * from product;

commit;

--입출고테이블만 관리
-- 1번상품 10개 입고 -> 상품테이블 1번 레코드 stock + 10
-- 1번상품 5개 출고 -> 상품테이블 1번 레코드 stock - 5

create or replace trigger trig_product_stock
    after
    insert on product_io
    for each row
begin

    if :new.status = 'I' then
        -- 입고
        update
            product
        set
            stock = stock + :new.cnt
        where
            no = :new.pno;
    else
        -- 출고
                -- 입고
        update
            product
        set
            stock = stock - :new.cnt
        where
            no = :new.pno;
    end if;
    
end;
/

--입출고 데이터 입력
insert into
    product_io
values(
    seq_product_io_no.nextval, 1, 10, 'I', default
);
insert into
    product_io
values(
    seq_product_io_no.nextval, 2, 50, 'I', default
);
insert into
    product_io
values(
    seq_product_io_no.nextval, 21, 100, 'I', default
);
select * from product_io;
select * from product;
commit;

insert into
    product_io
values(
    seq_product_io_no.nextval, 21, 1, 'O', default
);








