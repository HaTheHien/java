create database quanlycuahang;
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
	ID Integer,
	Content nvarchar(100),
    constraint PK_Promo_ID primary key(ID)
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

INSERT INTO Promo
VALUES	(1, N'Giảm 20% thứ 2 đầu tuần'),
		(2, N'Giảm 50% cuối ngày');

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
return (Select  count(*) from product);

DROP PROCEDURE SearchProductByName
DELIMITER  $$
CREATE PROCEDURE SearchProductByName(
								INPUT NVARCHAR(100))
Begin
	SELECT * FROM quanlycuahang.productinfo WHERE ProductName LIKE INPUT;
End;
Call SearchProductByName(N'Nước uống');

DELIMITER  $$
CREATE PROCEDURE SearchProductByID(
								INPUT Integer)
Begin
	SELECT * FROM quanlycuahang.productinfo WHERE ID = INPUT;
End;

DELIMITER $$
CREATE PROCEDURE GetAllProducts()
Begin
	SELECT * FROM quanlycuahang.productinfo;
End;
Call GetAllProducts();

DELIMITER $$
CREATE PROCEDURE GetAllPromos()
Begin
	SELECT * FROM quanlycuahang.promo;
End;
Call GetAllPromos();

DELIMITER $$
CREATE PROCEDURE InsertPromo(ID Integer, Content NVARCHAR(100))
Begin
	INSERT INTO promo
    VALUES (ID, Content);
End;
Call InsertPromo(3, 'Đồng giá 10k ngày 11/11');

DELIMITER $$
CREATE PROCEDURE RemovePromo(ID Integer)
Begin
	DELETE FROM promo
    WHERE promo.ID = ID;
End;
Call RemovePromo(3);

DELIMITER $$
CREATE PROCEDURE GetBillInfo(ID Integer)
Begin
	SELECT bill.BillID, bill.SellerID, bill.BuyDate, bill.MembershipID, Amount, ID, Brand, ProductName, Price, UrlImage
    FROM (bill left JOIN billunit ON bill.billid = billunit.billid) right join productinfo on billunit.ProductID=productinfo.Id
    WHERE bill.BillID = ID;
End;
Call GetBillInfo(2);


