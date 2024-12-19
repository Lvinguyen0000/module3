drop database if exists QuanLyDiemThi;

create database QuanLyDiemThi;
use QuanLyDiemThi;

create table if not exists HocSinh(
	MaHS varchar(20) not null primary key,
    TenHs varchar(50) not null,
    NgaySinh datetime,
    Lop varchar(20),
    GT varchar(20)
);

create table if not exists GiaoVien(
	MaGV varchar(20) not null primary key,
    TenGv varchar(50) not null,
    SDT varchar(10)
);
    
create table if not exists MonHoc(
	MaMH varchar(20) not null primary key,
    TenMH varchar(20) not null,
    MaGV varchar(20),
    foreign key (MaGV) references GiaoVien(MaGV)
);

create table if not exists BangDiem(
	MaHS varchar(20),
    MaMH varchar(50),
    DiemThi int,
    NgayKT datetime,
    primary key(MaHS, MaMH),
    foreign key (MaHS) references HocSinh(MaHS),
    foreign key (MaMH) references MonHoc(MaMH)
);