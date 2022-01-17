--=============================================
--  관리자 계정
--=============================================
-- web계정 생성
alter session set "_oracle_script"=true; --c##으로 계정명 지정 우회

create user web
identified by web
default tablespace users;

alter user web quota unlimited on users;

grant connect, resource to web;


--=============================================
--  web 계정
--=============================================
create table tb_member (
    user_id varchar2(20),
    pwd varchar2(20) not null,
    user_name varchar2(50) not null,
    ssn char(14) not null, -- -포함 14자리
    email varchar2(200) not null,
    tel char(11) not null, -- -없이 11자리
    job varchar2(100),
    hobby varchar2(200),
    reg_date date default sysdate,
    constraint pk_tb_member_user_id primary key(user_id)
);

--drop table tb_member;

insert into 
    tb_member 
values (
    'honggd', '1234','홍길동', '123456-1234567', 'honggd@gmail.com', '01012341234', '개발자','독서,영화', default 
);

insert into 
    tb_member(user_id, pwd, user_name, ssn, email, tel, job, hobby)
values (
    'sinsa', '1234','신사임당', '800808-2345678', 'sinsa@gmail.com', '01023455432', '주부','게임' 
);

commit;

select * from tb_member;













