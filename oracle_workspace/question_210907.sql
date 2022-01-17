--210907
-- 1.
create table ex_member(
    member_code number,
    member_id varchar2(20),
    member_pwd char(20) not null,
    member_name varchar2(30),
    member_addr varchar2(100) not null,
    gender char(3),
    phone char(11) not null,
    constraints pk_ex_member_member_code primary key(member_code),
    constraints uq_ex_member_member_id unique(member_id),
    constraints ck_ex_member_gender check(gender in ('남', '여'))
);
comment on column ex_member.member_code is '회원전용코드';
comment on column ex_member.member_id is '회원 아이디';
comment on column ex_member.member_pwd is '회원 비밀번호';
comment on column ex_member.member_name is '회원 이름';
comment on column ex_member.member_addr is '회원 거주지';
comment on column ex_member.gender is '성별';
comment on column ex_member.phone is '회원 연락처';

select
    *
from
    user_col_comments
where
    table_name = 'EX_MEMBER';

-- 2.
create table ex_member_nickname(
    member_code number,
    member_nickname varchar2(100) not null,
    constraints pk_ex_member_nickname_member_code primary key(member_code),
    constraints fk_ex_member_nickname_member_code foreign key(member_code) references ex_member(member_code)
);

comment on column ex_member_nickname.member_code is '회원전용코드';
comment on column ex_member_nickname.member_nickname is '회원 이름';


--chun
-- 1
select
    student_no as 학번, 
    student_name as  이름,
    to_char(entrance_date, 'yyyy-mm-dd') as 입학년도   
from
    tb_student
where
    department_no = '002'
order by
    3;

--2
select
    professor_name,
    professor_ssn
from
    tb_professor
where
    professor_name not like '___';

--3
-- 내 풀이
select
    professor_name as 교수이름,
   trunc(months_between(sysdate, to_date((decode(substr(professor_ssn,8,1),'1',1900,'2',1900,2000) 
   + substr(professor_ssn,1,2)) || substr(professor_ssn,3,4)))/12) as 나이
from
    tb_professor
where
    substr(professor_ssn,8,1) = '1'
order by
    나이;

-- 선생님 풀이
SELECT PROFESSOR_NAME AS 교수이름,
       TO_NUMBER(TO_CHAR(SYSDATE, 'YYYY')) - TO_NUMBER('19' || SUBSTR(PROFESSOR_SSN, 1, 2)) AS 나이,
       TRUNC(
        MONTHS_BETWEEN(
            SYSDATE,  
            TO_DATE('19' ||SUBSTR(PROFESSOR_SSN, 1, 6),'RRRRMMDD'))/12
       ) 만나이
FROM   TB_PROFESSOR
WHERE  SUBSTR(PROFESSOR_SSN, 8, 1) = '1'
ORDER BY 2, 1;

--4
select
    substr(professor_name,2) as 이름
from
    tb_professor;
    
--5
--년도형식문자 RR, YY
select
    student_no,
    student_name
from
    tb_student
where
    to_number(to_char(entrance_date, 'yyyy')) 
    - to_number(to_char(to_date(substr(student_ssn,1,2), 'RR'), 'YYYY')) > 19
order by 
    1;

select
    to_date(substr(student_ssn,1,2), 'RR'),
    to_char(to_date(substr(student_ssn,1,2), 'RR'), 'YYYY'),
    to_number(to_char(to_date(substr(student_ssn,1,2), 'RR'), 'YYYY'))
from
    tb_student;
--6
select
    to_char(to_date(20201225), 'day', 'nls_date_language = korean')
from
    dual;

--7
/* 
TO_DATE('99/10/11','YY/MM/DD') = 99년 10월 11일
TO_DATE('49/10/11','YY/MM/DD') = 49년 10월 11일
TO_DATE('99/10/11','RR/MM/DD') = 99년 10월 11일
TO_DATE('49/10/11','RR/MM/DD') = 49년 10월 11일
*/

--8
select
    student_no,
    student_name
from
    tb_student
where
    substr(student_no,1,1) <> 'A';

--9
select
    round(avg(point), 1) as 평점
from
    tb_grade
where
    student_no = 'A517178';
    
--10
-- 학생이 없는 학과도 조회
select
    d.department_no as 학과번호,
    count(student_no) as "학생수(명)"
from
    tb_student s right join tb_department d
        on s.department_no = d.department_no
group by
    d.department_no
order by
    1;
    
SELECT DEPARTMENT_NO AS 학과번호,
       COUNT(*) AS "학생수(명)"
FROM   TB_STUDENT
GROUP BY DEPARTMENT_NO
ORDER BY 1;
    
--11
select
    count(*)
from
    tb_student
where
    coach_professor_no is null;
    
--12

select
    substr(term_no,1,4) as 년도,
    round(avg(point),1) as "년도 별 평점"
from
    tb_grade g join tb_student s
        on g.student_no = s.student_no
where
    s.student_name = '김고운'
group by
    substr(term_no,1,4)
order by
    1;

--13
select
    d.department_no as 학과코드명,
    sum(case when absence_yn = 'Y' then 1 else 0 end) as "휴학생 수"
from
    tb_department d left join tb_student s
        on d.department_no = s.department_no
group by
    d.department_no
order by
    1;

--14
select
    student_name as 동일이름,
    count(*) as "동명인 수",
    listagg(student_name, ',') within group(order by student_name)
from
    tb_student
group by
    student_name
having
    count(*) > 1
order by
    1;

--15
select
    decode(grouping(substr(g.term_no,1,4)), 0, substr(g.term_no,1,4), 1, ' ') as 년도,
    decode(grouping(substr(g.term_no,5,2)), 0 ,substr(g.term_no,5,2), 1, ' ') as 학기,
    round(avg(point), 1) as 평점
from
    tb_student s join tb_grade g
        on s.student_no = g.student_no
where
    s.student_no = 'A112113'
group by 
    rollup(substr(g.term_no,1,4), substr(g.term_no,5,2));















