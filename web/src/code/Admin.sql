create database if not exist NjiiriSchool;
use NjiiriSchool;

drop table if exists Adminrecord;
create table Adminrecord (id int not null auto-increment,FirstName varchar(12),LastName,password,primary key(id));