drop database if exists QuanLyBanHang;

create database QuanLyBanHang;
use QuanLyBanHang;

create table if not exists customer(
	cID varchar(10) not null primary key,
    cName varchar(100) not null,
    cAge int
);

create table if not exists `order`(
	oID varchar(10) not null primary key,
    cID varchar(10),
    oData date,
    oTotalPrice double,
    foreign key (cID) references customer(cID)
);

create table if not exists product(
	pID varchar(10) not null primary key,
    pName varchar(100) not null,
    pPrice double default(0)
);

create table if not exists orderdetail(
	oID varchar(10),
    pID varchar(10),
    odQTY int default(0),
    primary key(oID, pID),
    foreign key (oID) references `order`(oID),
    foreign key (pID) references product(pID)
)