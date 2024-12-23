drop database if exists demo;

create database demo;

use demo;

create table products (
    id int primary key auto_increment,
    product_code varchar(50) not null,
    product_name varchar(100) not null,
    product_price decimal(10,2) not null,
    product_amount int not null,
    product_description text,
    product_status int not null
);

insert into products(product_code, product_name, product_price, product_amount, product_description, product_status) values
('SP01', 'Sản phẩm 1', 10000, 10, 'Mô tả sản phẩm 1', 1),
('SP02', 'Sản phẩm 2', 20000, 20, 'Mô tả sản phẩm 2', 1),
('SP03', 'Sản phẩm 3', 30000, 30, 'Mô tả sản phẩm 3', 1),
('SP04', 'Sản phẩm 4', 40000, 40, 'Mô tả sản phẩm 4', 1),
('SP05', 'Sản phẩm 5', 50000, 50, 'Mô tả sản phẩm 5', 1),
('SP06', 'Sản phẩm 6', 60000, 60, 'Mô tả sản phẩm 6', 1),
('SP07', 'Sản phẩm 7', 70000, 70, 'Mô tả sản phẩm 7', 1),
('SP08', 'Sản phẩm 8', 80000, 80, 'Mô tả sản phẩm 8', 1),
('SP09', 'Sản phẩm 9', 90000, 90, 'Mô tả sản phẩm 9', 1),
('SP10', 'Sản phẩm 10', 100000, 100, 'Mô tả sản phẩm 10', 1);

alter table products add UNIQUE index product_code_index(product_code);

alter table products add index composite_index(product_name, product_price);

explain select * from products;

create view v_product as
select product_code, product_name, product_price, product_status
from products;

alter view v_product as
select product_code, product_name, product_price, product_status
from products
where product_status = 1;

drop view v_product;


DELIMITER //
create procedure sp_get_product()
BEGIN
    select * from products;
END //
DELIMITER ;

delimiter //
CREATE PROCEDURE sp_add_product (in p_product_code varchar(50), in p_product_name varchar(100), in p_product_price decimal(10,2), in p_product_amount int, in p_product_description text, in p_product_status int)
BEGIN
    insert into products(product_code, product_name, product_price, product_amount, product_description, product_status)
    VALUES (p_product_code, p_product_name, p_product_price, p_product_amount, p_product_description, p_product_status);
END //
delimiter ;

delimiter //
create PROCEDURE sp_update_by_id(in p_id int, in p_product_code varchar(50), in p_product_name varchar(100), in p_product_price decimal(10,2), in p_product_amount int, in p_product_description text, in p_product_status int)
BEGIN
    update products 
    set productcode = p_product_code, productname = p_product_name, productprice = p_product_price, productamount = p_product_amount, productdescription = p_product_description, productstatus = p_product_status
    where id = p_id;
END //
delimiter ;

delimiter //
create PROCEDURE sp_delete_by_id(in p_id int)
BEGIN
    delete from products where id = p_id;
END //
delimiter ;


    


