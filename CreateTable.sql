drop database if exists hibernate_test;
create database hibernate_test;
use hibernate_test;
create table NEWS(
ID int(11) primary key auto_increment,
TITLE varchar(50) not null,
CONTENT varchar(50) not null,
TIME date
);