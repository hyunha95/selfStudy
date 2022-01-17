--210831
--chun

--1. 휴학중인 학번, 학생명, 학과명 조회
select
    s.student_no,
    s.student_name,
    d.department_name
from
    tb_student s join tb_department d
        on s.department_no = d.department_no
where
    s.absence_yn = 'Y';

--2. 수업번호, 수업명, 교수번호, 교수명 조회
select
    c.class_no,
    c.class_name,
    cp.professor_no,
    p.professor_name
from
    tb_class c 
        join tb_class_professor cp
            on c.class_no = cp.class_no
        join tb_professor p
            on cp.professor_no = p.professor_no;

--3. 송박선 학생의 모든 학기 과목별 점수를 조회(학기, 학번, 학생명, 수업명, 점수)
select
    g.term_no,
    s.student_no,
    s.student_name,
    c.class_name,
    g.point
from
    tb_student s 
        join tb_grade g
            on s.student_no = g.student_no
        join tb_class c
            on g.class_no = c.class_no
where
    s.student_name = '송박선';
--4. 학생별 전체 평점(소수점이하 첫째자리 버림) 조회 (학번, 학생명, 평점)
select trunc(avg(point)) from tb_grade;
select
    s.student_no as 학번,
    s.student_name as 학생명,
    trunc(avg(point), 1) as 전체_평점
from
    tb_grade g join tb_student s
        on g.student_no = s.student_no
group by
    s.student_no, s.student_name;

--5. 교수번호, 교수명, 담당학생명수 조회
-- 단, 5명 이상의 학생이 담당하는 교수만 출력
--내 풀이
select
    s.coach_professor_no as 교수번호,
    p.professor_name as 교수명,
    count(*) as 담당학생명수
from
    tb_professor p join tb_student s
        on p.professor_no = s.coach_professor_no
group by
    s.coach_professor_no, p.professor_name
having
    count(*) >= 5;
--강사님 풀이
select p.professor_no,
            p.professor_name,
            count(*) cnt
from tb_student S
    left join tb_professor P
        on s.coach_professor_no = p.professor_no
where s.coach_professor_no is not null
group by professor_no, p.professor_name
having count(*) >= 5
order by cnt desc;



