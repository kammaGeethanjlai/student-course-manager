create database studentdb;
use studentdb;
create table students(
id int auto_increment primary key,
name varchar(100),
course varchar(100),
email varchar(100)
);