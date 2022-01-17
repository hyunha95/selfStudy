--한줄 주석
/*
    여려줄 주석
    여려줄 주석
    여려줄 주석
*/

-- 접속정보 생성
--sql developer에서 해당계정으로 쉽게 접속하기 위해 저장하는 계정 정보 (아이디/비번 저장)

--관리자
--sys(슈퍼관리자) : 데이터베이스생성/삭제 권한 있음. 최상위 관리자. 접속시 sysdba롤 설정.
--system(일반관리자) : 데이터베이스 유지보수

show user;

--현재 등록된 사용자 조회
select * from dba_users;

--일반사용자 kh 생성
--12c부터 관리자가 아닌 계정은 c##(C##)로 시작해야 한다. 이를 우회하기 위한 설정
alter session set "_oracle_script"=true;

create user kh
identified by kh    -- 비밀번호 지정(대소문자 구분)
default tablespace users; -- tablespace는 실제 저장공간

alter user kh quota unlimited on users; -- users tablespace에 사용용량을 무한으로 지정

-- create session 접속권한 부여
grant create session to kh; -- 권한 부여
grant connect to kh; -- 롤(role) 부여, 롤은 권한 묶음. connect롤에는 create session권한이 포함되어 있음.

-- resource롤에는 일부 데이터베이스 객체(table, index, procedure) 생성권한을 포함한다.
grant connect, resource to kh;



--210908
--qwerty 사용자 생성
alter session set"_oracle_script" = true;

create user qwerty
identified by qwerty
default tablespace users;

alter user qwerty quota unlimited on users;

grant connect, resource to qwerty;



--kh계정에게 create role 권한 부여
grant create role to kh;



