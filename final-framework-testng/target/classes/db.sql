--create table login(
--username varchar(50) not null,
--password varchar(50));


--insert into login values("admin", "admin@123"); 
--insert into login values("admin", "admin@123"); 

-- TC UNF_076
--Database: DbUNF076
--Table : product
create table product(
username varchar(50) not null,
password varchar(50),
productName varchar(50),
quantity int(10));


insert into product values("admin", "admin@123", "Blazer Girls(7-8)", 1); 