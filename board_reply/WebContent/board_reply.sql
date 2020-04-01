create table board(
idx int(11) NOT NULL auto_increment, 
name varchar(10) NOT NULL, 
depth int(11) NOT NULL default 0, 
uid int(11) NOT NULL, 
PRIMARY KEY (idx)
);

select count(uid) from board;

delete from board;

alter table board add contents varchar(100);

alter table board drop column contents;

select * from board;