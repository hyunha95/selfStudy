-- 문제 1
create table tbl_escape_watch(
    watchname varchar2(40),
    description varchar2(200)
);
--drop table tbl_escape_watch;
insert into tbl_escape_watch
values('금시계', '순금 99.99% 함유 고급시계');
insert into tbl_escape_watch
values('은시계', '고객만족도 99.99점을 획득한 고급시계');
commit;
select
    *
from
    tbl_escape_watch;
    
select
    *
from
    tbl_escape_watch
where
    description like '%99.99\%%' escape '\';
    
-- 문제 2
select
    emp_id as "사원번호",
    emp_name as "사원명",
    rpad(substr(emp_no, 1, 8),14, '*') as "주민번호",
    (salary + (salary * nvl(bonus, 0))) * 12 as "연봉"
from
    employee
where
--    substr(emp_no, 8, 1) = '1'
--    or
--     substr(emp_no, 8, 1) = '3';
    substr(emp_no, 8, 1) in ('1', '3');
    
-- 문제 3
create table tbl_files(
    fileno number(3),
    filepath varchar2(500)
);
--drop table tbl_files;
insert into tbl_files
values(1, 'c:\abc\deft\salesinfo.xls');
insert into tbl_files
values(2, 'c:\music.mp3');
insert into tbl_files
values(3, 'c:\documents\resume.hwp');
commit;
select
    *
from
    tbl_files;
    
select
    rpad(fileno, 20) as "파일번호",
    substr(filepath, instr(filepath, '\', -1) + 1) as "파일명"
from
    tbl_files;

    
    
    
    
    
    
    
    
    
    
    