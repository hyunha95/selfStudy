show user;

-- 조회
select * from kh.coffee;

-- 데이터추가/수정/삭제
insert into kh.coffee
values('플랫화이트', 5000); -- SQL 오류: ORA-01031: insufficient privileges

update kh.coffee
set price = 4500
where name = '플랫화이트'; -- SQL 오류: ORA-01031: insufficient privileges

delete from kh.coffee
where name = '플랫화이트'; -- SQL 오류: ORA-01031: insufficient privileges

commit;

select * from kh.emp_simple_view;

select * from kh.employee;










