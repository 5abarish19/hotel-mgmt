drop database hotelmanagementsystem;
create database hotelmanagementsystem;
show databases;
use hotelmanagementsystem; 

create table login(
username varchar(25),
password varchar(25));

insert into login values('admin','12345');

select * from login;

create table employee(
name varchar(25),
age varchar(3),
gender varchar(15),
job varchar(30),
salary varchar(15),
phone varchar(15),
email varchar(40),
aadhar varchar(20));

select * from employee;

SET SQL_SAFE_UPDATES = 0;
delete from room where roomno = 500;
SET SQL_SAFE_UPDATES = 1;

desc employee;

create table room(
roomno varchar(5),
available varchar(20),
cleaning varchar(20),
price varchar(10),
type varchar(15));

select * from room;

create table driver(
name varchar(25),
age varchar(3),
gender varchar(15),
company varchar(30),
model varchar(30),
available varchar(15),
location varchar(40));

select * from driver;

select * from room;

create table customer(
id varchar(25),
number varchar(15),
name varchar(35),
gender varchar(10),
country varchar(30),
room varchar(30),
checkin varchar(30),
deposit varchar(10));

select * from customer;

select * from room order by roomno asc;

delete from room where roomno = 500;

create table department(
department varchar(30),
budget varchar(30));

insert into department values('Front Office','500000');
insert into department values('Housekeeping','40000');
insert into department values('Food and Beverage','23000');
insert into department values('Food Production','540000');
insert into department values('Security','250000');
insert into department values('Maintainence','200000');

select * from department;