create table bbs(
	id number(3),
	writer varchar2(30),
	title varchar2(30),
	content varchar2(1000)
);

create sequence bbs_seq start with 1;

insert into bbs values(bbs_seq.nextVal, 'Gildong', '반갑습니다', '반갑습니다반갑습니다반갑습니다반갑습니다');
insert into bbs values(bbs_seq.nextVal, 'Gilnam', '안녕하세요', '안녕하세요안녕하세요안녕하세요안녕하세요');
insert into bbs values(bbs_seq.nextVal, 'Gilbook', '어서오세요', '어서오세요어서오세요어서오세요어서오세요');

select * from bbs;
select * from spmember;
select * from board;
select * from board order by num desc
select count(*) from reply 
select * from reply 
delete *from spmember;
drop table spmember purge;