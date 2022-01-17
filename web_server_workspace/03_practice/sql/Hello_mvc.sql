--=================================================
-- 회원 테이블 생성
--=================================================

create table member (
    member_id varchar2(15),
    password varchar2 (300) not null, -- 암호화처리
    member_name varchar2(100) not null,
    member_role char(1) default 'U' not null, -- 회원권한 : 일반사용자(U), 관리자(A)
    gender char(1),
    birthday date,
    email varchar2(100),
    phone char(11) not null,
    address varchar2(300),
    hobby varchar2(300), -- 운동,등산,독서,게임,여행 (웹페이지의 checkbox 연동)
    enroll_date date default sysdate,
    constraints pk_member_id primary key(member_id),
    constraints ck_member_gender check(gender in ('M', 'F')),
    constraints ck_member_role check(member_role in ('U', 'A'))
);

insert into
    member
values(
    'honggd', '1234', '홍길동', 'U', 'M', to_date('19900909', 'yyyymmdd'), 
    'honggd@naver.com', '01012341234', '서울시 강남구 테헤란로',
    '운동,등산,독서', default
);

insert into member
values (
    'qwerty', '1234', '쿠어티', 'U', 'F', to_date('19900215','yyyymmdd'),
    'qwerty@naver.com', '01012341234', '서울시 송파구', '운동,등산', default
);

insert into member
values (
    'admin', '1234', '관리자', 'A', 'M', to_date('19801010','yyyymmdd'),
    'admin@naver.com', '01056785678', '서울시 관악구', '게임,독서', default
);

insert into member
values(
    'hyunha', '1234', '노현하', 'U', 'M', to_date('19950423', 'yyyymmdd'),
    'hyunha@naver.com', '01099998888', '서울시 서초구', '운동,게임', default
);

select * from member;
commit;

select
    *
from
    member
where member_id = 'hyunha';











