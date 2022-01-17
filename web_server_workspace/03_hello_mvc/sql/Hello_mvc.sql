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

select * from member where member_id = 'practice3';
commit;

select
    *
from
    member
where member_id = 'sonn';

delete from member where member_id = 'sonn';

update 
    member 
set 
    password = ?,
    member_name = ?,
    gender = ?,
    birthday = ?,
    email = ?,
    phone = ?,
    address = ?,
    hobby = ?
where
    member_id = ?;
    
update 
    member 
set 
    password = '12345'
where
    member_id = 'hyunha';
commit;

delete from member where member_id = 'honggd';
    
update member
set password = '1ARVn2Auq2/WAqx2gNrL+q3RNjAzXpUfCXrzkA6d4Xa22yhRLy4AC50E+6UTPoscbo31nbOoq51gvkuXzJ6B2w==';
    
    
--페이징쿼리
select
    *
from
(
    select
        row_number () over (order by enroll_date desc) rnum,
        m.*
    from
        member m
)
where
    rnum between 1 and 10;

-- select * from(select row_number () over (order by enroll_date desc) rnum, m.* from member m) where rnum between ? and ?


-------------------------------------------------
-- 게시판
-------------------------------------------------
create table board(
    no number,
    title varchar2(100) not null,
    writer varchar2(20),
    content varchar2(4000) not null,
    read_count number default 0,
    reg_date date default sysdate,
    constraint pk_board_no primary key(no),
    constraint fk_board_writer foreign key(writer) references member(member_id) on delete set null
);

create sequence seq_board_no;

create table attachment(
    no number,
    board_no number not null,
    original_filename varchar2(255) not null,
    renamed_filename varchar2(255) not null,
    reg_date date default sysdate,
    constraint pk_attachment_no primary key(no),
    constraint fk_attachment_board_no foreign key(board_no) references board(no) on delete cascade
);

create sequence seq_attachment_no;

    comment on table board is '게시글';
	comment on column board.no is '게시글번호';
	comment on column board.title is '게시글제목';
	comment on column board.writer is '게시글작성자 아이디';
	comment on column board.content is '게시글내용';
	comment on column board.read_count is '조회수';
	comment on column board.reg_date is '게시글작성일시';

    comment on table attachment is '첨부파일';
	comment on column attachment.no is '첨부파일번호(PK)';
	comment on column attachment.board_no is '게시판글번호(FK)';
	comment on column attachment.original_filename is '업로드한 첨부파일명';
	comment on column attachment.renamed_filename is '서버에 저장된 첨부파일명';
	comment on column attachment.reg_date is '첨부파일업로드일시';
commit;



insert into web.board (no,title,writer,content,reg_date,read_count) values (seq_board_no.nextval,'안녕하세요, 게시판입니다 - 1','honggd','반갑습니다',to_date('18/02/10','RR/MM/DD'),0);
insert into web.board (no,title,writer,content,reg_date,read_count) values (seq_board_no.nextval,'안녕하세요, 게시판입니다 - 2','qwerty','안녕하세요',to_date('18/02/12','RR/MM/DD'),0);
insert into web.board (no,title,writer,content,reg_date,read_count) values (seq_board_no.nextval,'안녕하세요, 게시판입니다 - 3','admin','반갑습니다',to_date('18/02/13','RR/MM/DD'),0);
insert into web.board (no,title,writer,content,reg_date,read_count) values (seq_board_no.nextval,'안녕하세요, 게시판입니다 - 4','honggd','안녕하세요',to_date('18/02/14','RR/MM/DD'),0);
insert into web.board (no,title,writer,content,reg_date,read_count) values (seq_board_no.nextval,'안녕하세요, 게시판입니다 - 5','qwerty','반갑습니다',to_date('18/02/15','RR/MM/DD'),0);
insert into web.board (no,title,writer,content,reg_date,read_count) values (seq_board_no.nextval,'안녕하세요, 게시판입니다 - 6','admin','안녕하세요',to_date('18/02/16','RR/MM/DD'),0);
insert into web.board (no,title,writer,content,reg_date,read_count) values (seq_board_no.nextval,'안녕하세요, 게시판입니다 - 7','honggd','반갑습니다',to_date('18/02/17','RR/MM/DD'),0);
insert into web.board (no,title,writer,content,reg_date,read_count) values (seq_board_no.nextval,'안녕하세요, 게시판입니다 - 8','qwerty','안녕하세요',to_date('18/02/18','RR/MM/DD'),0);
insert into web.board (no,title,writer,content,reg_date,read_count) values (seq_board_no.nextval,'안녕하세요, 게시판입니다 - 9','admin','반갑습니다',to_date('18/02/19','RR/MM/DD'),0);
insert into web.board (no,title,writer,content,reg_date,read_count) values (seq_board_no.nextval,'안녕하세요, 게시판입니다 - 10','honggd','안녕하세',to_date('18/02/20','RR/MM/DD'),0);
insert into web.board (no,title,writer,content,reg_date,read_count) values (seq_board_no.nextval,'안녕하세요, 게시판입니다 - 11','qwerty','반갑습니다',to_date('18/03/11','RR/MM/DD'),0);
insert into web.board (no,title,writer,content,reg_date,read_count) values (seq_board_no.nextval,'안녕하세요, 게시판입니다 - 12','admin','안녕하세',to_date('18/03/12','RR/MM/DD'),0);
insert into web.board (no,title,writer,content,reg_date,read_count) values (seq_board_no.nextval,'안녕하세요, 게시판입니다 - 13','honggd','반갑습니다',to_date('18/03/13','RR/MM/DD'),0);
insert into web.board (no,title,writer,content,reg_date,read_count) values (seq_board_no.nextval,'안녕하세요, 게시판입니다 - 14','qwerty','안녕하세',to_date('18/03/14','RR/MM/DD'),0);
insert into web.board (no,title,writer,content,reg_date,read_count) values (seq_board_no.nextval,'안녕하세요, 게시판입니다 - 15','admin','반갑습니다',to_date('18/03/15','RR/MM/DD'),0);


insert into web.board (no,title,writer,content,reg_date,read_count) values (seq_board_no.nextval,'안녕하세요, 게시판입니다 - 16','honggd','안녕하세',to_date('18/03/16','RR/MM/DD'),0);
insert into web.board (no,title,writer,content,reg_date,read_count) values (seq_board_no.nextval,'안녕하세요, 게시판입니다 - 17','qwerty','반갑습니다',to_date('18/03/17','RR/MM/DD'),0);
insert into web.board (no,title,writer,content,reg_date,read_count) values (seq_board_no.nextval,'안녕하세요, 게시판입니다 - 18','admin','안녕하세',to_date('18/03/18','RR/MM/DD'),0);
insert into web.board (no,title,writer,content,reg_date,read_count) values (seq_board_no.nextval,'안녕하세요, 게시판입니다 - 19','honggd','반갑습니다',to_date('18/03/19','RR/MM/DD'),0);
insert into web.board (no,title,writer,content,reg_date,read_count) values (seq_board_no.nextval,'안녕하세요, 게시판입니다 - 20','qwerty','안녕하세',to_date('18/03/20','RR/MM/DD'),0);
insert into web.board (no,title,writer,content,reg_date,read_count) values (seq_board_no.nextval,'안녕하세요, 게시판입니다 - 21','admin','반갑습니다',to_date('18/04/01','RR/MM/DD'),0);
insert into web.board (no,title,writer,content,reg_date,read_count) values (seq_board_no.nextval,'안녕하세요, 게시판입니다 - 22','honggd','안녕하세',to_date('18/04/02','RR/MM/DD'),0);
insert into web.board (no,title,writer,content,reg_date,read_count) values (seq_board_no.nextval,'안녕하세요, 게시판입니다 - 23','qwerty','반갑습니다',to_date('18/04/03','RR/MM/DD'),0);
insert into web.board (no,title,writer,content,reg_date,read_count) values (seq_board_no.nextval,'안녕하세요, 게시판입니다 - 24','admin','안녕하세',to_date('18/04/04','RR/MM/DD'),0);
insert into web.board (no,title,writer,content,reg_date,read_count) values (seq_board_no.nextval,'안녕하세요, 게시판입니다 - 25','honggd','반갑습니다',to_date('18/04/05','RR/MM/DD'),0);
insert into web.board (no,title,writer,content,reg_date,read_count) values (seq_board_no.nextval,'안녕하세요, 게시판입니다 - 26','qwerty','안녕하세',to_date('18/04/06','RR/MM/DD'),0);
insert into web.board (no,title,writer,content,reg_date,read_count) values (seq_board_no.nextval,'안녕하세요, 게시판입니다 - 27','admin','반갑습니다',to_date('18/04/07','RR/MM/DD'),0);
insert into web.board (no,title,writer,content,reg_date,read_count) values (seq_board_no.nextval,'안녕하세요, 게시판입니다 - 28','honggd','안녕하세',to_date('18/04/08','RR/MM/DD'),0);
insert into web.board (no,title,writer,content,reg_date,read_count) values (seq_board_no.nextval,'안녕하세요, 게시판입니다 - 29','qwerty','반갑습니다',to_date('18/04/09','RR/MM/DD'),0);
insert into web.board (no,title,writer,content,reg_date,read_count) values (seq_board_no.nextval,'안녕하세요, 게시판입니다 - 30','admin','안녕하세',to_date('18/04/10','RR/MM/DD'),0);

insert into web.board (no,title,writer,content,reg_date,read_count) values (seq_board_no.nextval,'안녕하세요, 게시판입니다 - 31','honggd','반갑습니다',to_date('18/04/16','RR/MM/DD'),0);
insert into web.board (no,title,writer,content,reg_date,read_count) values (seq_board_no.nextval,'안녕하세요, 게시판입니다 - 32','qwerty','안녕하세',to_date('18/04/17','RR/MM/DD'),0);
insert into web.board (no,title,writer,content,reg_date,read_count) values (seq_board_no.nextval,'안녕하세요, 게시판입니다 - 33','admin','반갑습니다',to_date('18/04/18','RR/MM/DD'),0);
insert into web.board (no,title,writer,content,reg_date,read_count) values (seq_board_no.nextval,'안녕하세요, 게시판입니다 - 34','honggd','안녕하세',to_date('18/04/19','RR/MM/DD'),0);
insert into web.board (no,title,writer,content,reg_date,read_count) values (seq_board_no.nextval,'안녕하세요, 게시판입니다 - 35','qwerty','반갑습니다',to_date('18/04/20','RR/MM/DD'),0);
insert into web.board (no,title,writer,content,reg_date,read_count) values (seq_board_no.nextval,'안녕하세요, 게시판입니다 - 36','admin','안녕하세',to_date('18/05/01','RR/MM/DD'),0);
insert into web.board (no,title,writer,content,reg_date,read_count) values (seq_board_no.nextval,'안녕하세요, 게시판입니다 - 37','honggd','반갑습니다',to_date('18/05/02','RR/MM/DD'),0);
insert into web.board (no,title,writer,content,reg_date,read_count) values (seq_board_no.nextval,'안녕하세요, 게시판입니다 - 38','qwerty','안녕하세',to_date('18/05/03','RR/MM/DD'),0);
insert into web.board (no,title,writer,content,reg_date,read_count) values (seq_board_no.nextval,'안녕하세요, 게시판입니다 - 39','admin','반갑습니다',to_date('18/05/04','RR/MM/DD'),0);
insert into web.board (no,title,writer,content,reg_date,read_count) values (seq_board_no.nextval,'안녕하세요, 게시판입니다 - 40','honggd','안녕하세',to_date('18/05/05','RR/MM/DD'),0);
insert into web.board (no,title,writer,content,reg_date,read_count) values (seq_board_no.nextval,'안녕하세요, 게시판입니다 - 41','qwerty','반갑습니다',to_date('18/05/06','RR/MM/DD'),0);
insert into web.board (no,title,writer,content,reg_date,read_count) values (seq_board_no.nextval,'안녕하세요, 게시판입니다 - 42','admin','안녕하세',to_date('18/05/07','RR/MM/DD'),0);
insert into web.board (no,title,writer,content,reg_date,read_count) values (seq_board_no.nextval,'안녕하세요, 게시판입니다 - 43','honggd','반갑습니다',to_date('18/05/08','RR/MM/DD'),0);
insert into web.board (no,title,writer,content,reg_date,read_count) values (seq_board_no.nextval,'안녕하세요, 게시판입니다 - 44','qwerty','안녕하세',to_date('18/05/09','RR/MM/DD'),0);
insert into web.board (no,title,writer,content,reg_date,read_count) values (seq_board_no.nextval,'안녕하세요, 게시판입니다 - 45','admin','반갑습니다',to_date('18/05/10','RR/MM/DD'),0);

insert into web.board (no,title,writer,content,reg_date,read_count) values (seq_board_no.nextval,'안녕하세요, 게시판입니다 - 46','honggd','안녕하세',to_date('18/05/16','RR/MM/DD'),0);
insert into web.board (no,title,writer,content,reg_date,read_count) values (seq_board_no.nextval,'안녕하세요, 게시판입니다 - 47','qwerty','반갑습니다',to_date('18/05/17','RR/MM/DD'),0);
insert into web.board (no,title,writer,content,reg_date,read_count) values (seq_board_no.nextval,'안녕하세요, 게시판입니다 - 48','admin','안녕하세',to_date('18/05/18','RR/MM/DD'),0);
insert into web.board (no,title,writer,content,reg_date,read_count) values (seq_board_no.nextval,'안녕하세요, 게시판입니다 - 49','honggd','반갑습니다',to_date('18/05/19','RR/MM/DD'),0);
insert into web.board (no,title,writer,content,reg_date,read_count) values (seq_board_no.nextval,'안녕하세요, 게시판입니다 - 50','qwerty','안녕하세',to_date('18/05/20','RR/MM/DD'),0);
insert into web.board (no,title,writer,content,reg_date,read_count) values (seq_board_no.nextval,'안녕하세요, 게시판입니다 - 51','admin','반갑습니다',to_date('18/05/01','RR/MM/DD'),0);
insert into web.board (no,title,writer,content,reg_date,read_count) values (seq_board_no.nextval,'안녕하세요, 게시판입니다 - 52','honggd','안녕하세',to_date('18/06/02','RR/MM/DD'),0);
insert into web.board (no,title,writer,content,reg_date,read_count) values (seq_board_no.nextval,'안녕하세요, 게시판입니다 - 53','qwerty','반갑습니다',to_date('18/06/03','RR/MM/DD'),0);
insert into web.board (no,title,writer,content,reg_date,read_count) values (seq_board_no.nextval,'안녕하세요, 게시판입니다 - 54','admin','안녕하세',to_date('18/06/04','RR/MM/DD'),0);
insert into web.board (no,title,writer,content,reg_date,read_count) values (seq_board_no.nextval,'안녕하세요, 게시판입니다 - 55','honggd','반갑습니다',to_date('18/06/05','RR/MM/DD'),0);
insert into web.board (no,title,writer,content,reg_date,read_count) values (seq_board_no.nextval,'안녕하세요, 게시판입니다 - 56','qwerty','안녕하세',to_date('18/06/06','RR/MM/DD'),0);
insert into web.board (no,title,writer,content,reg_date,read_count) values (seq_board_no.nextval,'안녕하세요, 게시판입니다 - 57','admin','반갑습니다',to_date('18/06/07','RR/MM/DD'),0);
insert into web.board (no,title,writer,content,reg_date,read_count) values (seq_board_no.nextval,'안녕하세요, 게시판입니다 - 58','honggd','안녕하세',to_date('18/06/08','RR/MM/DD'),0);
insert into web.board (no,title,writer,content,reg_date,read_count) values (seq_board_no.nextval,'안녕하세요, 게시판입니다 - 59','qwerty','반갑습니다',to_date('18/06/09','RR/MM/DD'),0);
insert into web.board (no,title,writer,content,reg_date,read_count) values (seq_board_no.nextval,'안녕하세요, 게시판입니다 - 60','admin','안녕하세',to_date('18/06/10','RR/MM/DD'),0);

insert into web.attachment(no, board_no, original_filename, renamed_filename)
values(seq_attachment_no.nextval, 60, 'test.txt', '20211007_12345.txt');

commit;

select  * from board order by no desc;
select * from attachment order by no desc;

select
    *
from(
select  
    row_number() over(order by no desc) rnum,
    b.*,
    (select count(*) from attachment where board_no = b.no) attach_count,
    (select count(*) from board_comment where board_no =  b.no) comment_count
from 
    board b
)
where
    rnum between 1 and 10; 
    
-- select * from(select row_number() over(order by no desc) rnum, b.* from  board b) where rnum between ? and ? 

-- 게시글 + 첨부파일
select
    *
from
    board b left join attachment a
    on b.no = a.board_no
order by
    b.no desc;

-- insert쿼리
insert into 
    board(no, title, writer, content) 
values(
    seq_board_no.nextval, 
    ?,
    ?,
    ?
);

-- 게시글 + 첨부파일
-- select b.*, a.*, a.no attach_no from board b left join attachment a on b.no = a.board_nowhere b.no = ?
    
-- 첨부파일 삭제
select * from attachment where board_no = 284;
    

---------------------------------------------
-- 게시판 댓글
---------------------------------------------    
create table board_comment(
    no number,
    comment_level number default 1, -- 댓글 1, 대댓글 2
    writer varchar2(15),
    content varchar2(2000),
    board_no number,
    comment_ref number,                      -- 대댓글인 경우, 참조하는 댓글번호, 댓글인 경우 null
    reg_date date default sysdate,
    constraint pk_board_comment_no primary key(no),
    constraint fk_board_comment_writer foreign key(writer) references member(member_id) on delete set null,
    constraint fk_board_comment_board_no foreign key(board_no) references board(no) on delete cascade,
    constraint fk_board_comment_comment_ref foreign key(comment_ref) references board_comment(no) on delete cascade
);

create sequence seq_board_comment_no;

-- 댓글 데이터 생성
select * from board order by no desc; -- 287
select * from board_comment where board_no = 287;

insert into 
    board_comment
values(
    seq_board_comment_no.nextval,
    default,
    'honggd',
    '멋진 글입니다.',
    287,
    null,
    default
);

insert into 
    board_comment
values(
    seq_board_comment_no.nextval,
    default,
    'sinsa',
    '날씨도 좋고  글도 좋고!',
    287,
    null,
    default
);

insert into 
    board_comment
values(
    seq_board_comment_no.nextval,
    default,
    'admin',
    '이달의 포스팅으로 섡어되었습니다. ',
    287,
    null,
    default
);

-- 대댓글 추가
insert into 
    board_comment
values(
    seq_board_comment_no.nextval,
    2, -- 대댓글
    'qwerty',
    '감사합니다. ',
    287,
    4, -- 부모댓글
    default
);

insert into 
    board_comment
values(
    seq_board_comment_no.nextval,
    2, -- 대댓글
    'qwerty',
    '신사어머님, 감사합니다. 신사어머님 글도 잘 보고 있어요~ ',
    287,
    4, -- 부모댓글
    default
);

insert into 
    board_comment
values(
    seq_board_comment_no.nextval,
    2, -- 대댓글
    'sinsa',
    '어머머머~ 부끄럽네요...... ',
    287,
    4, -- 부모댓글
    default
);

-- 계층형쿼리
-- 행과 행사이의 부모/자식관계를 고려해 조회
-- start with : 최상위 부모행의 조건을 작성
-- connect by a = b : 부모/자식행의 연결조건 작성. prior키워드 부모컬럼 앞에 위치
-- lebel 가상컬럼 제공. 최상위부모부터 1씩 증가 처리
select
    *
from
    board_comment
where
    board_no =  287
start with
    comment_level = 1
connect by
    prior no = comment_ref
order siblings by
    no;

--select * from board_comment where board_no = ? start with comment_level = 1 connect by prior no = comment_ref order siblings by  no
      


-----------------------------------------------------
-- 사진게시판
-----------------------------------------------------
create table photo(
    no number,
    writer varchar2(20),
    content varchar2(2000),
    original_filename varchar2(256) not null,
    renamed_filename varchar2(256) not null,
    reg_date date default sysdate,
    read_count number default 0,
    constraint pk_photo_no primary key(no),
    constraint fk_photo_writer foreign key(writer) references member(member_id) on delete cascade
);

create sequence seq_photo_sequence_no;

Insert into WEB.PHOTO (NO,WRITER,CONTENT,ORIGINAL_FILENAME,RENAMED_FILENAME,REG_DATE,READ_COUNT) values (SEQ_PHOTO_SEQUENCE_NO.NEXTVAL,'abcd','하와이 가는 하늘길~','adult-adventure-aircraft-443430.jpg','20180422_174158873_108.jpg',to_date('22-04-18','DD-MM-RR'),0);
Insert into WEB.PHOTO (NO,WRITER,CONTENT,ORIGINAL_FILENAME,RENAMED_FILENAME,REG_DATE,READ_COUNT) values (SEQ_PHOTO_SEQUENCE_NO.NEXTVAL,'abcd','프랑스산 와인 시음회 :)','adult-alcohol-blur-290316.jpg','20180422_174412447_349.jpg',to_date('22-04-18','DD-MM-RR'),0);
Insert into WEB.PHOTO (NO,WRITER,CONTENT,ORIGINAL_FILENAME,RENAMED_FILENAME,REG_DATE,READ_COUNT) values (SEQ_PHOTO_SEQUENCE_NO.NEXTVAL,'abcd','여행은 즐거워','adventure-albay-clouds-672358.jpg','20180422_174453770_556.jpg',to_date('22-04-18','DD-MM-RR'),0);
Insert into WEB.PHOTO (NO,WRITER,CONTENT,ORIGINAL_FILENAME,RENAMED_FILENAME,REG_DATE,READ_COUNT) values (SEQ_PHOTO_SEQUENCE_NO.NEXTVAL,'abcd','여행은 즐거워','airplane-apartment-architecture-364245.jpg','20180422_174505657_4.jpg',to_date('22-04-18','DD-MM-RR'),0);
Insert into WEB.PHOTO (NO,WRITER,CONTENT,ORIGINAL_FILENAME,RENAMED_FILENAME,REG_DATE,READ_COUNT) values (SEQ_PHOTO_SEQUENCE_NO.NEXTVAL,'abcd','여행은 즐거워','america-architecture-billboards-461903.jpg','20180422_174516697_101.jpg',to_date('22-04-18','DD-MM-RR'),0);
Insert into WEB.PHOTO (NO,WRITER,CONTENT,ORIGINAL_FILENAME,RENAMED_FILENAME,REG_DATE,READ_COUNT) values (SEQ_PHOTO_SEQUENCE_NO.NEXTVAL,'abcd','여행은 즐거워','ancient-architecture-building-415980.jpg','20180422_174527327_327.jpg',to_date('22-04-18','DD-MM-RR'),0);
Insert into WEB.PHOTO (NO,WRITER,CONTENT,ORIGINAL_FILENAME,RENAMED_FILENAME,REG_DATE,READ_COUNT) values (SEQ_PHOTO_SEQUENCE_NO.NEXTVAL,'abcd','여행은 즐거워','arch-architecture-art-332208.jpg','20180422_174539548_250.jpg',to_date('22-04-18','DD-MM-RR'),0);
Insert into WEB.PHOTO (NO,WRITER,CONTENT,ORIGINAL_FILENAME,RENAMED_FILENAME,REG_DATE,READ_COUNT) values (SEQ_PHOTO_SEQUENCE_NO.NEXTVAL,'abcd','자나깨나 차조심, 트램조심','architecture-avenue-blur-258447.jpg','20180422_174601509_281.jpg',to_date('22-04-18','DD-MM-RR'),0);
Insert into WEB.PHOTO (NO,WRITER,CONTENT,ORIGINAL_FILENAME,RENAMED_FILENAME,REG_DATE,READ_COUNT) values (SEQ_PHOTO_SEQUENCE_NO.NEXTVAL,'abcd','여행은 즐거워','architecture-background-buildings-698604.jpg','20180422_174616171_833.jpg',to_date('22-04-18','DD-MM-RR'),0);
Insert into WEB.PHOTO (NO,WRITER,CONTENT,ORIGINAL_FILENAME,RENAMED_FILENAME,REG_DATE,READ_COUNT) values (SEQ_PHOTO_SEQUENCE_NO.NEXTVAL,'abcd','여행은 즐거워','architecture-barcelona-blue-sky-819764.jpg','20180422_174652399_241.jpg',to_date('22-04-18','DD-MM-RR'),0);
Insert into WEB.PHOTO (NO,WRITER,CONTENT,ORIGINAL_FILENAME,RENAMED_FILENAME,REG_DATE,READ_COUNT) values (SEQ_PHOTO_SEQUENCE_NO.NEXTVAL,'abcd','여행은 즐거워','architecture-basilica-buildings-326709.jpg','20180422_174743637_226.jpg',to_date('22-04-18','DD-MM-RR'),0);
Insert into WEB.PHOTO (NO,WRITER,CONTENT,ORIGINAL_FILENAME,RENAMED_FILENAME,REG_DATE,READ_COUNT) values (SEQ_PHOTO_SEQUENCE_NO.NEXTVAL,'abcd','여행은 즐거워','architecture-building-door-206767.jpg','20180422_174800692_837.jpg',to_date('22-04-18','DD-MM-RR'),0);
Insert into WEB.PHOTO (NO,WRITER,CONTENT,ORIGINAL_FILENAME,RENAMED_FILENAME,REG_DATE,READ_COUNT) values (SEQ_PHOTO_SEQUENCE_NO.NEXTVAL,'abcd','여행은 즐거워','atmosphere-beautiful-cloudburst-531318.jpg','20180422_174814411_4.jpg',to_date('22-04-18','DD-MM-RR'),0);
Insert into WEB.PHOTO (NO,WRITER,CONTENT,ORIGINAL_FILENAME,RENAMED_FILENAME,REG_DATE,READ_COUNT) values (SEQ_PHOTO_SEQUENCE_NO.NEXTVAL,'abcd','이과수이과수','back-beach-beautiful-670060.jpg','20180422_174839106_197.jpg',to_date('22-04-18','DD-MM-RR'),0);
Insert into WEB.PHOTO (NO,WRITER,CONTENT,ORIGINAL_FILENAME,RENAMED_FILENAME,REG_DATE,READ_COUNT) values (SEQ_PHOTO_SEQUENCE_NO.NEXTVAL,'abcd','여행은 즐거워','bicycle-tour-bicycles-bicyclists-17729.jpg','20180422_174856071_779.jpg',to_date('22-04-18','DD-MM-RR'),0);
Insert into WEB.PHOTO (NO,WRITER,CONTENT,ORIGINAL_FILENAME,RENAMED_FILENAME,REG_DATE,READ_COUNT) values (SEQ_PHOTO_SEQUENCE_NO.NEXTVAL,'abcd','여행은 즐거워','billboard-business-city-733778.jpg','20180422_174910053_722.jpg',to_date('22-04-18','DD-MM-RR'),0);
Insert into WEB.PHOTO (NO,WRITER,CONTENT,ORIGINAL_FILENAME,RENAMED_FILENAME,REG_DATE,READ_COUNT) values (SEQ_PHOTO_SEQUENCE_NO.NEXTVAL,'abcd','여행은 즐거워','black-clouds-dark-420885.jpg','20180422_174924429_849.jpg',to_date('22-04-18','DD-MM-RR'),0);
Insert into WEB.PHOTO (NO,WRITER,CONTENT,ORIGINAL_FILENAME,RENAMED_FILENAME,REG_DATE,READ_COUNT) values (SEQ_PHOTO_SEQUENCE_NO.NEXTVAL,'abcd','여행은 즐거워','boulders-clouds-daylight-464440.jpg','20180422_174941759_108.jpg',to_date('22-04-18','DD-MM-RR'),0);
Insert into WEB.PHOTO (NO,WRITER,CONTENT,ORIGINAL_FILENAME,RENAMED_FILENAME,REG_DATE,READ_COUNT) values (SEQ_PHOTO_SEQUENCE_NO.NEXTVAL,'abcd','여행은 즐거워','capital-cathedral-city-6502.jpg','20180422_174957191_842.jpg',to_date('22-04-18','DD-MM-RR'),0);
Insert into WEB.PHOTO (NO,WRITER,CONTENT,ORIGINAL_FILENAME,RENAMED_FILENAME,REG_DATE,READ_COUNT) values (SEQ_PHOTO_SEQUENCE_NO.NEXTVAL,'abcd','퐈이아아아아아','evening-fair-fire-65297.jpg','20180422_175019576_86.jpg',to_date('22-04-18','DD-MM-RR'),0);
Insert into WEB.PHOTO (NO,WRITER,CONTENT,ORIGINAL_FILENAME,RENAMED_FILENAME,REG_DATE,READ_COUNT) values (SEQ_PHOTO_SEQUENCE_NO.NEXTVAL,'wxyz','소나무야','375px-Pinus_densiflora_Kumgangsan.jpg','20180422_125936088_36.jpg',to_date('22-04-19','DD-MM-RR'),0);

select * from photo;
commit;

-- 페이징쿼리
select
    *
from
(
select
    row_number () over (order by no desc) rnum,
    p.*
from 
    photo p
)
where rnum between 1 and 5;

select * from (select row_number () over (order by no desc) rnum, p.* from photo p) where rnum between 1 and 5;
select * from (select row_number () over (order by no desc) rnum, p.* from photo p) where rnum between 6 and 10;














