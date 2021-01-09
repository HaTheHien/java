﻿create database quanlycuahang;

use quanlycuahang;

-- tạo bảng
create table Product
(
	Id nvarchar(30),
	TypeID nvarchar(30),
	constraint PK_Id1 primary key(Id)
);
create table ProductInfo
(
	Id nvarchar(30), -- id la ma vach
	Brand nvarchar(30),
	ProductName nvarchar(100),
	Price int,
	UrlImage nvarchar(100)
);
create table ProductStock
(
	Id nvarchar(30), -- id la ma vach
	LastestEXP datetime,
	Numstock int
);
create table Account
(
	Id nvarchar(30),
	FullName nvarchar(30),
	DoB datetime,
	Addr nvarchar(200),
	Pass nvarchar(200),
	Type nvarchar(30),
	constraint PK_IdAccount primary key(Id)
);
create table Bill
(
	SellerID nvarchar(30),
	BuyDate datetime,
	MembershipID nvarchar(30),
	BillID nvarchar(30),
	constraint PK_billID primary key(BillID)
);
create table BillUnit
(
	BillID nvarchar(30),
	ProductID nvarchar(30),
	Amount int,
	constraint PK_bill_product_id primary key(BillID,ProductID)
);
create table Promo
(
	PromoString nvarchar(100)
);
create table TypeProduct
(
	TypeID nvarchar(30),
	Name nvarchar(100),
	constraint PK_typeProduct primary key(typeID)
);
create table Membership
(
	FullName nvarchar(30),
	Addr nvarchar(200),
	PhoneNum nvarchar(30),
	Point int,
	MemId nvarchar(30),
	constraint PK_idMem primary key(MemId)
);

-- khóa phụ
ALTER TABLE ProductStock
ADD CONSTRAINT FK_ProStock_Pro
FOREIGN KEY(Id)
REFERENCES Product(Id);

ALTER TABLE ProductInfo
ADD CONSTRAINT FK_ProInfo_Pro
FOREIGN KEY(Id)
REFERENCES Product(Id);

ALTER TABLE BillUnit
ADD CONSTRAINT FK_BillUnit_Bill
FOREIGN KEY(BillID)
REFERENCES Bill(BillID);

ALTER TABLE BillUnit
ADD CONSTRAINT FK_BillUnit_Product
FOREIGN KEY (ProductID)
REFERENCES Product(Id);

ALTER TABLE Bill
ADD CONSTRAINT FK_Bill_Account
FOREIGN KEY (SellerID)
REFERENCES Account(Id);

ALTER TABLE Bill
ADD CONSTRAINT FK_Bill_Mem
FOREIGN KEY (MembershipID)
REFERENCES Membership(MemId);

ALTER TABLE Product
ADD CONSTRAINT FK_Product_TypeProduct
FOREIGN KEY (TypeID)
REFERENCES TypeProduct(TypeID);

INSERT INTO TypeProduct(TypeID,Name)
VALUES ('1',N'Nhu yếu phẩm');

INSERT INTO Product(TypeID,Id)
VALUES ('1','1'),
		('1','2');
        
INSERT INTO ProductInfo(Id,Brand,Price,ProductName,UrlImage)
VALUES ('1',N'aquafina',10000,N'Nước uống',null),
		('2',N'Tường An',10000,N'Dầu ăn',null);
        
INSERT INTO ProductStock(Id,Numstock,LastestEXP)
VALUES ('1',100,'2015-10-10'),
		('2',200,'2016-10-5');
        
INSERT INTO Account(Id,FullName,DoB,Addr,Type)
VALUES ('1',N'Nguyễn Thị Liên','2000-12-20',N'Phường 1 Thành Phố HCM','Admin'),
		('2',N'Nguyễn Văn Tám','2001-06-10',N'Phường 2 Thành Phố HCM','Management');
        
INSERT INTO Bill(BillID,BuyDate,MembershipID,SellerID)
VALUES ('1','2010-10-10',null,'1'),
		('2','2010-10-11',null,'2');
        
INSERT INTO BillUnit(ProductID,Amount,BillID)
VALUES ('1',2,'1'),
		('2',3,'2');
        
INSERT INTO Membership(MemId,FullName,Addr,PhoneNum,Point)
VALUES ('1',N'Nguyễn Thị Hai',N'Phường 1 Thành Phố HCM','12345',100),
		('2',N'Nguyễn Văn Bảy',N'Phường 2 Thành Phố HCM','23456',20);

CREATE FUNCTION turnOver()
RETURNS double DETERMINISTIC
return (Select sum(billunit.Amount * productInfo.Price) from billunit left join productInfo on billunit.ProductID=productinfo.Id);

CREATE FUNCTION sumOrder()
RETURNS int DETERMINISTIC
return (Select count(*) from bill);

CREATE FUNCTION numProductOutStock()
RETURNS int DETERMINISTIC
return (Select count(*) from productstock where productstock.Numstock = 0);

CREATE FUNCTION numProductExpired()
RETURNS int DETERMINISTIC
return (Select count(*) from productstock where (productstock.LastestEXP - NOW()) /60/60/24  <= 3);

CREATE FUNCTION numTypeProduct()
RETURNS int DETERMINISTIC
return (Select  count(*) from typeproduct);

CREATE FUNCTION numItemProduct()
RETURNS int DETERMINISTIC
return (Select  count(*) from product)

// khuc moi
DELIMITER $$
CREATE PROCEDURE getMembership(id int)
BEGIN
  select * from membership where MemId = id;
END

DELIMITER $$
CREATE PROCEDURE getAllMembership()
BEGIN
  select * from membership;
END

DELIMITER $$
CREATE PROCEDURE updateMembership(id int,new_point int)
BEGIN
   update membership set membership.Point = new_point where MemId = id;
END

DELIMITER $$
CREATE PROCEDURE createMembership(fullname nvarchar(30), address nvarchar(200), phone varchar(20))
BEGIN
	insert into membership(FullName,Addr,PhoneNum,Point) values(fullname, address, phone, 0 );
END

DELIMITER $$
CREATE PROCEDURE takeAccount(id int)
BEGIN
    select * from account where Id = id;
END

DELIMITER $$
CREATE PROCEDURE getAllAccount()
BEGIN
  select Id,FullName,DoB,Addr,Type from account;
END

DELIMITER $$
CREATE PROCEDURE removeAccount(id int)
BEGIN
  DELETE FROM account where Id = id;
END

DELIMITER $$
CREATE PROCEDURE createAccount(fullname nvarchar(30),dob datetime,addr nvarchar(200),pass nvarchar(200),type nvarchar(30))
BEGIN
  INSERT INTO `quanlycuahang`.`account`
	(`FullName`,
	`DoB`,
	`Addr`,
	`Pass`,
	`Type`)
	VALUES(
	fullname,
	dob,
	addr,
	pass,
	type);
END

DELIMITER $$
CREATE PROCEDURE getAllBill(id int)
BEGIN
	select * from bill left join billunit on bill.BillID = billunit.BillId left join productinfo on ProductID = productinfo.Id where bill.BillId = id;
END