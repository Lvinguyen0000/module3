use quanlybanhang;

insert into customer
values (1,"Minh Quan", 10),
(2, "Ngoc Oanh", 20),
(3,"Hong Ha", 50);

insert into `order`
values (1,1,"2006-3-21",null),
(2,2,"2006-3-23",null),
(3,1,"2006-3-16",null);

insert into product
values (1,"May Giat",3),
(2,"Tu Lanh",5),
(3,"Dieu Hoa",7),
(4,"Quat",1),
(5,"Bep Dien",2);

insert into orderdetail
values (1,1,3),(1,3,7),(1,4,2),(2,1,1),(3,1,8),(2,5,4),(2,3,3);

select oID,oDate,oTotalPrice from `order`;

select c.cID, c.cName, p.pID, p.pName
from customer c
inner join `order` o on c.cID = o.cID
inner join orderdetail od on o.oID = od.oID
inner join product p on p.pID = od.pID;

select cName
from customer
where cID not in (select cID from `order`);

select o.oID, o.oDate, sum(od.odQTY*p.pPrice)
from `order` o
inner join orderdetail od on o.oID = od.oID
inner join product p on od.pID = p.pID
group by o.oID;








