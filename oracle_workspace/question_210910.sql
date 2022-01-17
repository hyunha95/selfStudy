--@실습문제 : function생성
/*주민번호를 입력받아 나이를 리턴하는 저장함수 fn_age를 생성하고,
사원테이블에서 사번, 이름, 성별, 연봉, 나이를 조회*/
create or replace function fn_age(
    p_emp_no employee.emp_no%type
)
return varchar2
is
begin
    if substr(p_emp_no,8,1) in ('1','2') then
        return (extract(year from sysdate)) - (1900 + substr(p_emp_no,1,2)) + 1;
    else
        return (extract(year from sysdate)) - (2000 + substr(p_emp_no,1,2)) + 1;
    end if;
end;
/

select
    emp_id as 사번,
    emp_name as 이름,
    decode(substr(emp_no,8,1),'1','남','3','남','여') as 성별,
    (salary + (salary * nvl(bonus, 0))) * 12 as 연봉,
    fn_age(emp_no) as 나이
from
    employee;
    

--@실습문제 : 난수테이블
--테이블 생성
create table tb_number(
    id number,
    num number,
    reg_date date default sysdate,
    constraints pk_tb_number_id primary key(id)
);
--시퀀스 생성
create sequence seq_tb_number
start with 1
increment by 1
nomaxvalue
nominvalue 
nocycle
cache 20
;
--테이블에 값 대입하고 평균 출력
declare
    average number;
begin
    for n in 1..100 loop
        insert into tb_number
        values(
            seq_tb_number.nextval,
            trunc(dbms_random.value(0,999)),
            default
        );
    end loop;
    commit;
    
    select
        avg(num)
    into
        average
    from
        tb_number;
        
        dbms_output.put_line(average);
end;
/




