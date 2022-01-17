--chun
/*춘 기술대학교는 매년 수강신청 기간맊 되면 특정 인기 과목들에 수강 신청이 몰려 문제가 되고 있다. 
최근 3 년을 기준으로 수강인원이 가장 많았던 3 과목을 찾는 구문을 작성해보시오
=> 실행결과는 최근 5년 2005 ~ 2009이므로, 쿼리에서는 특정년도를 기술하지않고, 데이터상 최근 5년을 찾도록 해보세요*/
select
    *
from(
select
    substr(term_no,1,4), 
    class_name,
    count(*)
from
    tb_class c join tb_grade g
        using(class_no)
where
    to_char(add_months(sysdate, -36), 'yyyy') = to_char(, 'yyyy');
group by
    substr(term_no,1,4), class_name
) e
order by
    3 desc;
    
--@실습문제 : ex_emp테이블의 급여가 변경되면 ex_emp_salary_log테이블에 변경내역을 기록하는 트리거를 작성
-- 특정컬럼 update시에만 trigger작동하려면, update of salary on ex_emp 작성
create table ex_emp_salary_log(
    no number primary key,
    before_salary number,
    after_salary number,
    log_date date default sysdate
);

create sequence seq_ex_emp_log_no;

create or replace trigger trig_ex_emp_salary_log
    before
    update of salary on ex_emp
    for each row
begin
        insert into
            ex_emp_salary_log
        values(
            seq_ex_emp_log_no.nextval, 
            :old.salary, 
            :new.salary,
            default
        );
end;
/

update
    ex_emp
set
    salary = salary + 1000
where
    emp_id = '201';
    
select * from ex_emp;
select * from ex_emp_salary_log;



--04_워크북_v2.0_DDL
--1. 계열 정보를 저장할 카테고리 테이블을 만들려고 핚다. 다음과 같은 테이블을 작성하시오.
create table tb_category(
    name varchar2(10),
    use_yn char(1) default 'Y'
);
desc tb_category;

-- 2. 과목 구분을 저장할 테이블을 만들려고 한다. 다음과 같은 테이블을 작성하시오.
create table tb_class_type(
    no varchar2(5),
    name varchar2(10),
    constraints pk_tb_class_type_no primary key(no)
);
-- 제약조건 조회
select
    ucc.column_name,
    uc.*
from
    user_constraints uc join user_cons_columns ucc
        on uc.constraint_name = ucc.constraint_name
where
    uc.table_name = 'TB_CLASS_TYPE';

-- 3. tb_category 테이블의 name 컬럼에 primary key를 생성하시오.
alter table tb_category
add constraints pk_tb_category_name primary key(name);
-- 제약조건 조회
select
    ucc.column_name,
    uc.*
from
    user_constraints uc join user_cons_columns ucc
        on uc.constraint_name = ucc.constraint_name
where
    uc.table_name = 'TB_CATEGORY';
    
-- 4. tb_class_type 테이블의 name 컬럼에 null 값이 들어가지 않도록 속성을 변경허시오.
alter table tb_class_type
modify name varchar2(10) not null;

-- 5. 두 테이블에서 컬럼 명이 no인 것은 기존 타입을 유지하며서 크기는 10으로, 컬럼명이
-- name인 것은 마찬가지로 기존 타입을 유지하면서 크기 20으로 변경하시오.
alter table tb_category
modify name varchar2(20);

alter table tb_class_type
modify no varchar2(10);
alter table tb_class_type
modify name varchar2(20);

-- 6. 두 테이블의 no컬럼과 name컬럼의 이름을 각각 tb_를 제외한 테이블 이름이 앞에 붙은 형태로 변경한다.
alter table tb_category
rename column name to category_name;

alter table tb_class_type
rename column no to class_type_no;
alter table tb_class_type
rename column name to class_type_name;

-- 7. tb_category 테이블과 tb_class_type테이블의 primary key 이름을 다음과 같이 변경하시오.
alter table tb_class_type
rename constraints pk_tb_class_type_no to pk_no;













