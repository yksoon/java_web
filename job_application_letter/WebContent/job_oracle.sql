select * from tab;

create table person_table (
name varchar2(20) not null, 
engname varchar2(20) not null, 
writeday varchar2(20) not null,
birthday varchar2(20) not null,
address varchar2(50) not null,
email varchar2(40) not null,
email2 varchar2(20) not null,
phone varchar2(15) not null,
picurl varchar2(50)
);

drop table person_table;

INSERT INTO PERSON_TABLE (name, engname, writeday, birthday, address, email, email2, phone) 
VALUES('ddd', 'sss', '2010-10-10', '2010-01-04', 'ddaxzca', 'fdfsdf', 'naver.com', '010-333-3333');

select * from person_table;

desc person_table;