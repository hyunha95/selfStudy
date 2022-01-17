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

create or replace trigger trig_member_del
    after
    delete on member
    for each row
begin
    insert into member_del
    values(
    :old.id, :old.name, :old.gender, :old.birthday, :old.email, :old.address, :old.reg_date, sysdate
    );
end;
/

desc member_del;
delete from member where name = '노현하';
select * from member_del;
commit;







---------------------------------------------------------------------------
--210917
/*##@실습문제
회원삭제정책이 바뀌었다. 
Member테이블에 탈퇴일 DEL_DATE컬럼(기본값 없음), 탈퇴여부 DEL_FLAG컬럼(Y/N값만 허용하고, 기본값이 N)을 추가하고, 회원삭제시에는 N값을 Y값으로 변경하기로 한다. 
또 회원조회시에는 삭제된 회원은 제외하고 보여질수 있는 있도록 쿼리를 수정하세요. 
(단, 컬럼추가는  sqldevleoper에서 작업할것)
그밖에 이 정책이 수행되는데 버그를 일으킬 요소를 찾아 수정하세요.*/

--탈퇴회원관리2 - 하나의 테이블에서 관리
-- 서브쿼리에의한 테이블 생성은 not null을 제외한 제약조건, 컬럼기본값이 모두 제거됨.
create table tb_member
as
select
    m.*
from
    member m;
    
select * from tb_member;

-- 테이블 수정
alter table tb_member
add del_date date
add del_flag char(1) default 'N'
add constraints ck_tb_member_del_flag check(del_flag in ('Y', 'N'))
add constraints pk_tb_member_id primary key(id)
add constraints uq_tb_member_email unique(email)
add constraints ck_tb_member_gender check(gender in ('M', 'F'));

alter table tb_member
modify reg_date default sysdate;


-- 제약조건 조회
select
    ucc.column_name,
    uc.*
from
    user_constraints uc join user_cons_columns ucc
        on uc.constraint_name = ucc.constraint_name
where
    uc.table_name = 'TB_MEMBER';

-- 기본값 확인
select
    *
from
    user_tab_columns
where
    table_name = 'TB_MEMBER';












