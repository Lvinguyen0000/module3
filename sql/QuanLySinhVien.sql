DROP DATABASE IF exists QuanLySinhVien;

create database QuanLySinhVien;
use QuanLySinhVien;

create table if not exists Class(
	ClassID int not null primary key auto_increment,
    ClassName varchar(60) not null,
    StartDate datetime not null,
    Status bit
);

create table if not exists Student(
	StudentID int not null primary key auto_increment,
    StudentName varchar(30) not null,
    Address varchar(50),
    Phone varchar(20),
    Status bit,
    ClassID int not null
);

create table if not exists Subject(
	SubID int not null primary key auto_increment,
    SubName varchar(30) not null,
    Credit tinyint not null default(1),
    Status bit default(1),
    check(Credit >= 1)
);

create table if not exists Mark(
	MarkID int not null primary key auto_increment,
    SubID int not null unique,
    StudentID int not null unique,
    Mark float default(0),
    ExamTiems tinyint default(1),
    check (Mark >=0),
    check (Mark <=100)
);