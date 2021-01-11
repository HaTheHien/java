DROP DATABASE IF EXISTS quanlycuahang;
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
	discount Integer,
	productID nvarchar(30),
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

ALTER TABLE promo
ADD CONSTRAINT FK_promo_product
FOREIGN KEY (ProductID)
REFERENCES product(Id);

INSERT INTO TypeProduct(TypeID,Name)
VALUES ('1',N'Nhu yếu phẩm'),
	   ('2',N'Thức ăn nhanh'),
       ('3',N'Thiết bị điện tử');

INSERT INTO Product(TypeID,Id)
VALUES ('1','1'),
		('1','2'),
		('1','3'),
		('1','4'),
		('2','5'),
        ('2','6');
        
INSERT INTO ProductInfo(Id,Brand,Price,ProductName,UrlImage)
VALUES ('1',N'aquafina',10000,N'Nước uống',null),
		('2',N'Tường An',10000,N'Dầu ăn',null),
		('3',N'Hảo hảo',10000,N'Mì',null),
        ('4',N'Indomi',10000,N'Mì',null),
        ('5',N'thịt bò',30000,N'Cơm',null),
        ('6',N'vinamilk',30000,N'Sữa',null);
        
INSERT INTO ProductStock(Id,Numstock,LastestEXP)
VALUES ('1',100,'2015-10-10'),
		('2',200,'2016-10-5'),
        ('3',200,'2016-10-5'),
        ('4',3,'2020-12-1'),
        ('5',200,'2021-1-18'),
        ('6',200,'2021-1-15');
        
INSERT INTO Account(Id,FullName,DoB,Addr,Type,Pass)
VALUES ('1',N'Nguyễn Thị Liên','2000-12-20',N'Phường 1 Thành Phố HCM','Admin','123'),
		('2',N'Nguyễn Văn Tám','2001-03-10',N'Phường 2 Thành Phố HCM','Management','123'),
        ('3',N'Nguyễn Văn Năm','1990-08-10',N'Phường 2 Thành Phố HCM','Staff','123'),
        ('4',N'Ngô Thị Bưởi','1981-06-16',N'Phường 2 Thành Phố HCM','Staff','123'),
        ('5',N'Lê Văn Bảy','2001-08-10',N'Phường 2 Thành Phố HCM','Staff','123');
        
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
VALUES	(1, 10, 1),
		(2, 20, 2);CREATE FUNCTION turnOver()
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
return (Select count(*) from productstock where (productstock.LastestEXP - NOW()) /60/60/24  <= 0);

CREATE FUNCTION numTypeProduct()
RETURNS int DETERMINISTIC
return (Select  count(*) from typeproduct);

CREATE FUNCTION numItemProduct()
RETURNS int DETERMINISTIC
return (Select  count(*) from product);

DELIMITER  $$
CREATE PROCEDURE SearchProductByName(INPUT NVARCHAR(100))
Begin
	declare temp nvarchar(100);
    set temp= concat('%',INPUT,'%');
    
	SELECT quanlycuahang.productinfo.ID AS `ID`,
            quanlycuahang.productinfo.Brand AS `brand`, 
            quanlycuahang.productinfo.ProductName AS `productName`,
            quanlycuahang.productinfo.Price AS `price`,
            quanlycuahang.productinfo.UrlImage AS `urlImage`,
			quanlycuahang.typeproduct.TypeID AS `typeID`,
			quanlycuahang.typeproduct.Name AS `typeName`,
            quanlycuahang.productstock.Numstock AS `numStock`,
            quanlycuahang.productstock.LastestEXP AS `lastestEXP`,
            quanlycuahang.promo.ID AS `idPromo`,
            quanlycuahang.promo.discount AS `discount`
	FROM quanlycuahang.productinfo
		left join quanlycuahang.productstock on quanlycuahang.productinfo.Id = quanlycuahang.productstock.Id
		left join quanlycuahang.promo on quanlycuahang.productinfo.ID = quanlycuahang.promo.productID
        left join quanlycuahang.product on quanlycuahang.productinfo.Id = quanlycuahang.product.Id
        left join quanlycuahang.typeproduct on quanlycuahang.typeproduct.typeID = quanlycuahang.product.TypeID
	WHERE ProductName LIKE temp;
End$$

DELIMITER  $$
CREATE PROCEDURE SearchProductByID(
								INPUT NVARCHAR(100))
Begin
	SELECT quanlycuahang.productinfo.ID AS `ID`,
            quanlycuahang.productinfo.Brand AS `brand`, 
            quanlycuahang.productinfo.ProductName AS `productName`,
            quanlycuahang.productinfo.Price AS `price`,
            quanlycuahang.productinfo.UrlImage AS `urlImage`,
			quanlycuahang.typeproduct.TypeID AS `typeID`,
			quanlycuahang.typeproduct.Name AS `typeName`,
            quanlycuahang.productstock.Numstock AS `numStock`,
            quanlycuahang.productstock.LastestEXP AS `lastestEXP`,
            quanlycuahang.promo.ID AS `idPromo`,
            quanlycuahang.promo.discount AS `discount`
	FROM quanlycuahang.productinfo
		left join quanlycuahang.productstock on quanlycuahang.productinfo.Id = quanlycuahang.productstock.Id
		left join quanlycuahang.promo on quanlycuahang.productinfo.ID = quanlycuahang.promo.productID
        left join quanlycuahang.product on quanlycuahang.productinfo.Id = quanlycuahang.product.Id
        left join quanlycuahang.typeproduct on quanlycuahang.typeproduct.typeID = quanlycuahang.product.TypeID
	WHERE quanlycuahang.productinfo.ID = INPUT;
End$$

DELIMITER $$
CREATE PROCEDURE GetAllProductsDetails()
Begin
	SELECT quanlycuahang.productinfo.ID AS `ID`,
            quanlycuahang.productinfo.Brand AS `brand`, 
            quanlycuahang.productinfo.ProductName AS `productName`,
            quanlycuahang.productinfo.Price AS `price`,
            quanlycuahang.productinfo.UrlImage AS `urlImage`,
			quanlycuahang.typeproduct.TypeID AS `typeID`,
			quanlycuahang.typeproduct.Name AS `typeName`,
            quanlycuahang.productstock.Numstock AS `numStock`,
            quanlycuahang.productstock.LastestEXP AS `lastestEXP`,
            quanlycuahang.promo.ID AS `idPromo`,
            quanlycuahang.promo.discount AS `discount`
	FROM quanlycuahang.productinfo
		left join quanlycuahang.productstock on quanlycuahang.productinfo.Id = quanlycuahang.productstock.Id
		left join quanlycuahang.promo on quanlycuahang.productinfo.ID = quanlycuahang.promo.productID
        left join quanlycuahang.product on quanlycuahang.productinfo.Id = quanlycuahang.product.Id
        left join quanlycuahang.typeproduct on quanlycuahang.typeproduct.typeID = quanlycuahang.product.TypeID;
End$$

DELIMITER $$
CREATE PROCEDURE GetAllPromos()
Begin
	SELECT * FROM quanlycuahang.promo join quanlycuahang.productinfo on promo.productID = productinfo.Id;
End$$
DELIMITER;

DELIMITER $$
CREATE PROCEDURE InsertPromo(ID Integer, discount int, idProduct int)
Begin
	DECLARE ID_Promo Int;
    SET ID_Promo = ID;
    
    SELECT MAX(ID) + 1 INTO ID_Promo
    FROM promo
    WHERE EXISTS(SELECT * FROM promo where promo.id = id);
    
	Insert into promo values(ID_Promo, discount, idProduct);
End$$

DELIMITER $$
CREATE PROCEDURE RemovePromo(ID Integer)
Begin
	DELETE FROM promo
    WHERE promo.ID = ID;
End$$

DELIMITER $$
CREATE PROCEDURE UpdatePromo(idProduct nvarchar(100), discount Integer)
Begin
	update promo
    set promo.discount = discount
    where promo.productID = idProduct;
End$$

DELIMITER $$
CREATE PROCEDURE GetBillInfo(ID Integer)
Begin
	SELECT bill.BillID, bill.SellerID, bill.BuyDate, bill.MembershipID, Amount, ID, Brand, ProductName, Price, UrlImage
    FROM (bill left JOIN billunit ON bill.billid = billunit.billid) right join productinfo on billunit.ProductID=productinfo.Id
    WHERE bill.BillID = ID;
End$$
DELIMITER;
DELIMITER $$
CREATE PROCEDURE getMembership(id int)
BEGIN
  select * from membership where MemId = id;
END$$
DELIMITER;

DELIMITER $$
CREATE PROCEDURE getAllMembership()
BEGIN
  select * from membership;
END$$
DELIMITER;

DELIMITER $$
CREATE PROCEDURE updateMembership(id int,new_point int)
BEGIN
   update membership set membership.Point = new_point where MemId = id;
END$$
DELIMITER;

DELIMITER $$
CREATE PROCEDURE createMembership(fullname nvarchar(30), address nvarchar(200), phone varchar(20))
BEGIN
    set @i = (select count(*) from membership) + 1;
	insert into membership(Id,FullName,Addr,PhoneNum,Point) values(@i,fullname, address, phone, 0 );
END$$
DELIMITER;

DELIMITER $$
CREATE PROCEDURE takeAccount(id int)
BEGIN
    select * from account where Id = id;
END$$
DELIMITER;

DELIMITER $$
CREATE PROCEDURE getAllAccount()
BEGIN
  select Id,FullName,DoB,Addr,Type from account;
END$$
DELIMITER;

DELIMITER $$
CREATE PROCEDURE removeAccount(id int)
BEGIN
  DELETE FROM account where Id = id;
END$$
DELIMITER;

DELIMITER $$
CREATE PROCEDURE createAccount(username nvarchar(30),fullname nvarchar(30),dob datetime,addr nvarchar(200),pass nvarchar(200),type nvarchar(30))
BEGIN
  INSERT INTO `quanlycuahang`.`account`
	(`Id`,
	`FullName`,
	`DoB`,
	`Addr`,
	`Pass`,
	`Type`)
	VALUES(
	username,
	fullname,
	dob,
	addr,
	pass,
	type);
END$$
DELIMITER;

DELIMITER $$
CREATE PROCEDURE updateAccount(username nvarchar(30),fullname nvarchar(30),dob datetime,addr nvarchar(200),pass nvarchar(200),type nvarchar(30))
BEGIN
  Update `account` set FullName = fullname,DoB = dob,Addr = addr,Pass = pass,Type = type where Id = username;
END$$
DELIMITER;

DELIMITER $$
CREATE PROCEDURE getAllBill(id int)
BEGIN
	select * from bill left join billunit on bill.BillID = billunit.BillId left join productinfo on ProductID = productinfo.Id where bill.BillId = id;
END$$
DELIMITER;

DELIMITER $$
CREATE PROCEDURE createBill(sellerID varchar(30),membershipID varchar(30))
BEGIN
	set @id = (select count(*) from bill) + 1;
    INSERT INTO `quanlycuahang`.`bill`(`SellerID`,
									`BuyDate`,
									`MembershipID`,
									`BillID`)
									VALUES(
									sellerID,
									CurDate(),
									membershipID,
									@id);
	select @id;
END$$
DELIMITER;

DELIMITER $$
CREATE PROCEDURE decreaseStock(idProduct NVARCHAR(100), 
						decrease int)
BEGIN
	DECLARE specialty CONDITION FOR SQLSTATE '45000';
	set @i = (select numstock from productstock WHERE id = idProduct);
    	IF (@i - decrease < 0) then
		set @message = CONCAT("Not enough stock of product id: ",idProduct);
		SIGNAL SQLSTATE '45000' SET MYSQL_ERRNO=30001, MESSAGE_TEXT = @message;
	end if;
	SET SQL_SAFE_UPDATES = 0;
	UPDATE productstock
    SET numstock = @i - decrease
    WHERE id = idProduct;
END$$
DELIMITER;

DELIMITER $$
CREATE PROCEDURE createBillUnit(billID varchar(30), productID varchar(30),amount INTEGER)
BEGIN
	call decreaseStock(productID, amount);
	INSERT INTO `quanlycuahang`.`billunit`
						(`BillID`,
						`ProductID`,
						`Amount`)
						VALUES(
						billID,
						productID,
						amount);
END$$
DELIMITER;

DELIMITER $$
CREATE PROCEDURE addStock(idProduct NVARCHAR(100), count int)
BEGIN
    DECLARE EXP DATE;
    DECLARE NOW DATE;
    
    SET NOW = NOW();
    select lastestEXP into EXP from productstock where id=idProduct;
    
	SET SQL_SAFE_UPDATES = 0;
	UPDATE productstock 
    SET numstock = numstock + count 
    WHERE id = idProduct;
	
    WHILE EXP <= NOW DO
 	  SET EXP = date_add(EXP, INTERVAL 1 MONTH);
    END WHILE;
    
    UPDATE productstock 
    SET lastestEXP = EXP 
    WHERE id = idProduct;
END$$

DELIMITER $$
CREATE PROCEDURE updateStock(idProduct NVARCHAR(100), 
						count int,
                        exp date)
BEGIN
	SET SQL_SAFE_UPDATES = 0;
	UPDATE productstock
    SET numstock = count, lastestExp = exp
    WHERE id = idProduct;
END$$

DELIMITER $$
CREATE PROCEDURE updateProduct(idProduct NVARCHAR(100), 
						new_prodName NVARCHAR(100),
                        new_brand NVARCHAR(100),
                        new_price int,
                        new_stock int,
                        new_exp DATE,
                        new_discount int,
                        new_url nvarchar(100))
BEGIN
    UPDATE productinfo
    SET productName = new_prodName,
		brand = new_brand,
        price = new_price,
        urlImage = new_url
	WHERE id = idProduct;
    Call updateStock(idProduct, new_stock, new_exp);
    Call updatePromo(idProduct, new_discount);
END$$
