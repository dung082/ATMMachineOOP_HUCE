create database doanoop;
use doanoop;

create table account
(
	stk varchar(20) not null primary key,
    pass varchar(7),
    sotien bigint,
    nganhang varchar(5),
    quyen varchar(10)
);
DROP TABLE account;
insert into account (stk,pass,sotien,nganhang,quyen) values 
('1234567890','123456',60000000,'A','guess'),
('1234567891','123456',50000000,'B','guess'),
('1234567892','123456',40000000,'C','guess'),
('1234567893','123456',30000000,'D','guess'),
('1234567894','123456',20000000,'E','guess'),
('1234567895','123456',1000000,'F','guess'),
('admin123','123456',0,'A','admin');

create table totien 
(
	st500 int,
    st200 int,
    st100 int,
    st50 int, 
    st20 int ,
    st10 int
);

