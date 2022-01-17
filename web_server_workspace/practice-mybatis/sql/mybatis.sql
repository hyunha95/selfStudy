--=================================================================
-- hello-mybatis
--=================================================================
-- student table
create table student(
    no number,
    name varchar2(50) not null,
    tel varchar2(11) not null,
    reg_date date default sysdate,
    constraint pk_student_no primary key(no)
);

create sequence seq_student_no;

insert into 
    student(no, name, tel)
values(
    seq_student_no.nextval,
    '홍길동',
    '01012341234'
);

select * from student;