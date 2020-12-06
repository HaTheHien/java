use master
create database QuanLyCuaHang
go
use QuanLyCuaHang

-- tạo bảng
create table Product
(
	Id nvarchar(30),
	constraint PK_Id1 primary key(Id),
)
create table ProductInfo
(
	Id nvarchar(30), -- id la ma vach
	Brand nvarchar(30),
	ProductName nvarchar(100),
	Price float,
	constraint PK_Id2 primary key(Id),
)
create table ProductStock
(
	Id nvarchar(30), -- id la ma vach
	LastestEXP datetime,
	Numstock int,
	constraint PK_Id3 primary key(Id),
)
create table Account
(
	Id nvarchar(30),
	FullName nvarchar(30),
	DoB datetime,
	Addr nvarchar(200),
	constraint PK_IdAccount primary key(Id),
)
create table Bill
(
	SellerID nvarchar(30),
	BuyDate datetime,
	MembershipID nvarchar(30),
	BillID nvarchar(30),
	constraint PK_billID primary key(BillID),
)
create table BillUnit
(
	BillID nvarchar(30),
	ProductID nvarchar(30),
	Amount int,
	constraint PK_bill_product_id primary key(BillID,ProductID),
)
create table Promo
(
	ProductID nvarchar(30),
)
create table Membership
(
	FullName nvarchar(30),
	Addr nvarchar(200),
	PhoneNum nvarchar(30),
	Point int,
	MemId nvarchar(30),
	constraint PK_idMem primary key(MemId),
)

-- khóa phụ
ALTER TABLE ProductStock
ADD CONSTRAINT FK_ProStock_Pro
FOREIGN KEY(Id)
REFERENCES Product(Id)

ALTER TABLE ProductInfo
ADD CONSTRAINT FK_ProInfo_Pro
FOREIGN KEY(Id)
REFERENCES Product(Id)

ALTER TABLE BillUnit
ADD CONSTRAINT FK_BillUnit_Bill
FOREIGN KEY(BillID)
REFERENCES Bill(BillID)

ALTER TABLE BillUnit
ADD CONSTRAINT FK_BillUnit_Product
FOREIGN KEY (ProductID)
REFERENCES Product(Id)

ALTER TABLE Bill
ADD CONSTRAINT FK_Bill_Account
FOREIGN KEY (SellerID)
REFERENCES Account(Id)

ALTER TABLE Bill
ADD CONSTRAINT FK_Bill_Mem
FOREIGN KEY (MembershipID)
REFERENCES Membership(MemId)