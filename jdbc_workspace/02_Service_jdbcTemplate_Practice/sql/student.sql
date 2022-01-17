--210914
--=================================================
-- 관리자계정
--=================================================
-- student계정 생성
alter session set"_oracle_script" = true;

create user student
identified by student
default tablespace users;

alter user student quota unlimited on users;

grant connect, resource to student;


--=================================================
-- student 계정
--=================================================
-- member 테이블 생성
-- jdbc연동시 date타입의 시분초는 사용불가. 시분초가 필요한 경우 timestamp사용할 것.
create table member(
    id varchar2(20),
    name varchar2(100) not null,
    gender char(1),
    birthday date,
    email varchar2(500),
    address varchar2(1000),
    reg_date timestamp default systimestamp,
    constraints pk_member_id primary key(id),
    constraints uq_member_email unique(email),
    constraints ck_member_gender check(gender in ('M', 'F'))
);

insert into
    member
values(
    'honggd', '홍길동', 'M', '1990-09-09', 'honggd@naver.com', '서울시 강남구 테헤란로 123', default
);
insert into
    member
values(
    'gogd', '고길동', 'M', '1970-07-07', 'gogd@naver.com', '경기도 구리시 소동 1000', default
);
insert into
    member
values(
    'sinsa', '신사임당', 'F', '1945-10-19', 'sinsa@naver.com', '경상남도 함양시 안의면 1234', default
);
insert into
    member
values(
    'donghhh', '이동휘', 'M', '1977-02-12', 'donghhh@naver.com', '서울시 종로구 풍동', default
);

delete from
    member
where
    id = 'yoogs';
    
    
select 
    * 
from member
order by
    reg_date desc;
commit;


-----------------------------------------------------------------------------
--210916
--탈퇴회원 관리용 테이블
--trigger 객체 trig_member_del을 생성해서 member테이블에 delete가 실행 될 때 마다 member_del테이블에 insert할 것.
create table member_del
as
select
    m.*,
    systimestamp del_date
from
    member m
where
    1 = 0; -- false 실제데이터는 제외하고, 테이블구조만 본떠서 member_del 테이블 생성


--삭제트리거 생성
--resource 롤에 create trigger권한이 있기때문에 별도의 DCL(grant)없이 진행할 수 있음.
create or replace trigger trig_member_del
    before delete on member
    for each row
begin
    insert into member_del(id, name, gender, birthday, email, address, reg_date, del_date)
    values(:old.id, :old.name, :old.gender, :old.birthday, :old.email, :old.address, :old.reg_date, systimestamp);
end;




