--CHUN

--1
select
    student_name as "학생 이름",
    student_address as 주소지
from
    tb_student
order by
    1;
    
--2
select
    student_name,
    student_ssn
from
    tb_student
where
    absence_yn = 'Y'
order by
    2 desc;
    
--3
select
    student_name as 학생이름,
    student_no as 학번,
    student_address as "거주지 주소"
from
    tb_student
where
    (student_address like '%강원도%' or student_address like '%경기도%')
    and
    student_no like '9%';
    
--4
select
    professor_name,
    professor_ssn
from
    tb_professor 
where
    department_no = 005
order by
    2;

--5
select
    s.student_no,
    point
from
    tb_student s join tb_grade g
        on s.student_no = g.student_no
where
    term_no = '200402'
    and
    class_no = 'C3118100'
order by
    2 desc, 1;

--6
select
    student_no,
    student_name,
    (select department_name from tb_department where department_no = s.department_no) as department_name
from
    tb_student s
order by
    2;

--7
select
    class_name,
    (select department_name from tb_department where department_no = c.department_no) as department_name
from
    tb_class c;

--8
select
    class_name,
    professor_name
from
    tb_class c, tb_class_professor cp, tb_professor p
where
    c.class_no = cp.class_no
    and
    cp.professor_no = p.professor_no;
    
--9
select
    class_name,
    professor_name
from
    tb_class c, tb_class_professor cp, tb_professor p, tb_department d
where
    c.class_no = cp.class_no
    and
    cp.professor_no = p.professor_no
    and
    p.department_no = d.department_no
    and
    d.category = '인문사회';
    
--10
select
    s.student_no as 학번,
    s.student_name as "학생 이름",
    round(avg(point),1) as "전체 평점"
from
    tb_student s, tb_department d, tb_grade g
where
    s.department_no = d.department_no
    and
    department_name = '음악학과'
    and
    s.student_no = g.student_no
group by 
    s.student_no, s.student_name
order by
    1;
    
--11
select
    (select department_name from tb_department where department_no = s.department_no) as 학과이름,
    student_name as 학생이름,
    (select professor_name from tb_professor where professor_no = s.coach_professor_no) as 지도교수이름
from
    tb_student s
where
    student_no = 'A313047';
    
--12
select
    s.student_name,
    g.term_no
from
    tb_student s join tb_grade g
        on s.student_no = g.student_no
where
    g.term_no like '2007%'
    and
    g.class_no = (select class_no from tb_class where class_name = '인간관계론');
    
--13
select
    class_name,
    department_name
from
    tb_class c 
        left join tb_department d
            on c.department_no = d.department_no
        left join tb_class_professor cp
            on c.class_no = cp.class_no 
where
    category = '예체능'
    and
    cp.professor_no is null;
    
--14
select
    s.student_name as 학생이름,
    nvl(p.professor_name, '지도교수 미지정') as 지도교수
from
    tb_student s, tb_department d, tb_professor p
where
    s.department_no = d.department_no(+)
    and
    s.coach_professor_no = p.professor_no(+)
    and
    d.department_name = '서반아어학과'
order by
    student_no;

--15
select
    s.student_no,
    s.student_name,
    d.department_name,
    avg(point)
from
    tb_student s, tb_grade g, tb_department d
where
    s.student_no = g.student_no
    and
    s.department_no = d.department_no
    and
    s.absence_yn = 'N'
group by
    s.student_no, s.student_name, d.department_name
having
    avg(point) >= 4.0
order by
    1;

--16



    select * from tb_student;
    select * from tb_professor;
    select * from tb_class;
    select * from tb_department;
    select * from tb_grade;
    select * from tb_class_professor;
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    