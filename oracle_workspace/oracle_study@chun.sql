--========================================
-- 관리자계정
--========================================
-- chun계정 생성

alter session set "_oracle_script" = true;

create user chun
identified by chun
default tablespace users;

alter user chun quota unlimited on users;

grant connect, resource to chun;


--=========================================
-- chun 계정
--=========================================
select * from tb_department;
select * from tb_student; 
-- tb_student.department_no --> tb_department.department_no
-- tb_student.coach_professor_no --> tb_professor.professor_no
select * from tb_professor;
select * from tb_class;
select * from tb_class_professor;
select * from tb_grade;

-- 01_워크북_v2.0_BasicSelect
-- 문제 1
select
    department_name as "학과명",
    category as 계열
from
    tb_department;

-- 문제 2
select
    department_name || '의 정원은' || capacity || ' 명 입니다.' as "학과별 정원"
from
    tb_department;

-- 문제 3
select
    student_name
from
    tb_student
where
   department_no = 001
    and
    absence_yn= 'Y'
    and
    substr(student_ssn,8,1) in ('2','4');

-- 문제 4
select
    student_name
from 
    tb_student
where
    student_no in ('A513079', 'A513090', 'A513091', 'A513110', 'A513119')
order by
    1 desc;

-- 문제 5
select
    department_name,
    category
from
    tb_department
where
    capacity between 20 and 30;

-- 문제 6
select
    professor_name
from
    tb_professor
where 
    department_no is null;

-- 문제 7
select
    student_name
from 
    tb_student
where
    department_no is null;
    
-- 문제 8
select
    class_no
from
    tb_class
where
    preattending_class_no is not null;

-- 문제 9
select
    distinct category
from
    tb_department
order by
    1;

-- 문제 10
select
    student_no,
    student_name,
    student_ssn
from
    tb_student
where
    extract(year from entrance_date) = 2002
    and
    student_address like '%전주%'
    and
    absence_yn = 'N';

-- 실습문제
--1. 학과테이블에서 계열별 정원의 평균을 조회(정원 내림차순 정렬)
select
    category as 카테고리,
    trunc(avg(capacity)) as 정원의_평균
from
    tb_department
group by
    category
order by
    2 desc;

--2. 휴학생을 제외하고, 학과별로 학생수를 조회(학과별 인원수 내림차순)
select
    department_no,
    count(*)
from
    tb_student
where
    absence_yn = 'N'
group by
    department_no
order by
    2 desc;
    
--3. 과목별 지정된 교수가 2명이상이 과목번호와 교수인원수를 조회
select
    class_no as 과목번호,
    count(*) as 교수인원수
from
    tb_class_professor
group by
    class_no
having
    count(professor_no) >= 2;
    
-- 4. 학과별로 과목을 구분했을때, 과목구분이 "전공선택"에 한하여 과목수가 10개 
-- 이상인 행의 학과번호, 과목구분(class_type), 과목수를 조회(전공선택만 조회)
select
    department_no as 학과번호,
    class_type as 과목구분,
    count(*) as 과목수
from
    tb_class
where
    class_type = '전공선택'
group by
    department_no, class_type
having
    count(*) >= 10
order by
    1, 2;
    


--210831
--join
-- 1. 의학계열 학과학생의 학생명, 학과명 조회
-- 학생이 한명도 없는 학과(1) 존재
select
    s.student_name,
    d.department_name
from
    tb_student s join tb_department d
        using(department_no)
where
    d.category = '의학';
    
--(oracle 전용문법)
select
    s.student_name,
    d.department_name
from
    tb_student s, tb_department d
where
    s.department_no = d.department_no
    and
    d.category = '의학';
    
-- 2. 2006학번의 학생명, 담당교수명 조회
-- tb_student.coach_professor_no ---> tb_professor.professor_no
select count(*) from tb_student; --588
select count(*) from tb_student where coach_professor_no is null; -- 9
select count(*) from tb_professor; -- 144
select
    s.student_name,
    p.professor_name
from
    tb_student s join tb_professor p
     on s.coach_professor_no = p.professor_no
where
    extract(year from s.entrance_date) = 2006;
    
--(oracle 전용문법)
select
    s.student_name,
    p.professor_name
from
    tb_student s, tb_professor p
where
    s.coach_professor_no = p.professor_no
    and
    extract(year from entrance_date) = 2006;
                
-- inner join 579 --> 담당교수가 없는 학생 제외
-- left join 588 : 579 + 9 --> 담당교수가 없는 학생 포함
-- right join 580 : 579 + 1(담당학생이 없는 교수) --> 담당학생이 없는 교수 포함
                
                
-- 3. 자연과학계열의 수업명, 학과명 조회
select
    c.class_name,
    d.department_name
from
    tb_class c join tb_department d
        on c.department_no = d.department_no
where
    d.category = '자연과학';
    
--(oracle 전용문법)
select
    c.class_name,
    d.department_name
from
    tb_department d, tb_class c
where
    d.department_no = c.department_no
    and
    d.category = '자연과학';
       
-- 4. 담당학생이 한명도 없는 교수 조회
select
    p.*
from
    tb_student s right join tb_professor p
        on s.coach_professor_no = p.professor_no
where
    s.student_no is null;

--(oracle 전용문법)
select
    p.*
from
    tb_student s, tb_professor p
where
    s.coach_professor_no(+) = p.professor_no
    and
    s.coach_professor_no is null;












