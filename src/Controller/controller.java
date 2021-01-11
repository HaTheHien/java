package Controller;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import Model.Other.*;
import Model.Product.ProductInfo;
import Model.Product.Warehouse;
import Model.User.Staff;
import Model.Bill.*;
import Model.Product.*;
public class controller
{
    public static String login(Connection conn,String user,String password)
    {
        PreparedStatement stmt=null;
        ResultSet rs = null;
        String result = "";
        try{
            String sql = "SELECT * FROM "+ "Account Where Id = ? and Pass = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, user);
            stmt.setString(2, password);
            rs = stmt.executeQuery();
            if (rs.next())
            {
                result = rs.getString("Id");
            }
            else
            {
                result =  "";
            }
        }catch (SQLException e)
        {
            e.printStackTrace();
        }finally{
            try {
                if (stmt != null)
                {
                    stmt.close();
                }
                if (rs != null)
                {
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
    public static double turnOver(Connection conn) 
    {
        CallableStatement cstmt = null;
        double turnOver_ = 0;
        try{
            cstmt = conn.prepareCall("{? = CALL turnOver()}");
            cstmt.registerOutParameter(1, Types.DOUBLE);
            cstmt.executeUpdate();
            turnOver_ =  cstmt.getDouble(1);
        }catch (SQLException e)
        {
            e.printStackTrace();
        }finally{
            try {
                if (cstmt != null)
                {
                    cstmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return turnOver_;
    }
    public static int sumOrder(Connection conn) 
    {
        CallableStatement cstmt = null;
        int sum_ = 0;
        try{
            cstmt = conn.prepareCall("{? = CALL sumOrder()}");
            cstmt.registerOutParameter(1, Types.INTEGER);
            cstmt.executeUpdate();
            sum_ =  cstmt.getInt(1);
        }catch (SQLException e)
        {
            e.printStackTrace();
        }finally{
            try {
                if (cstmt != null)
                {
                    cstmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return sum_;
    }
    public static int numberProduct(Connection conn) 
    {
        CallableStatement cstmt = null;
        int sum_ = 0;
        try{
            cstmt = conn.prepareCall("{? = CALL numProduct()}");
            cstmt.registerOutParameter(1, Types.INTEGER);
            cstmt.executeUpdate();
            sum_ =  cstmt.getInt(1);
        }catch (SQLException e)
        {
            e.printStackTrace();
        }finally{
            try {
                if (cstmt != null)
                {
                    cstmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return sum_;
    }
    public static int numProductOutStock(Connection conn) 
    {
        CallableStatement cstmt = null;
        int sum_ = 0;
        try{
            cstmt = conn.prepareCall("{? = CALL numProductOutStock()}");
            cstmt.registerOutParameter(1, Types.INTEGER);
            cstmt.executeUpdate();
            sum_ =  cstmt.getInt(1);
        }catch (SQLException e)
        {
            e.printStackTrace();
        }finally{
            try {
                if (cstmt != null)
                {
                    cstmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return sum_;
    }
    public static int numProductExpired(Connection conn) 
    {
        CallableStatement cstmt = null;
        int sum_ = 0;
        try{
            cstmt = conn.prepareCall("{? = CALL numProductExpired()}");
            cstmt.registerOutParameter(1, Types.INTEGER);
            cstmt.executeUpdate();
            sum_ =  cstmt.getInt(1);
        }catch (SQLException e)
        {
            e.printStackTrace();
        }finally{
            try {
                if (cstmt != null)
                {
                    cstmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return sum_;
    }
    public static int numTypeProduct(Connection conn) 
    {
        CallableStatement cstmt = null;
        int sum_ = 0;
        try{
            cstmt = conn.prepareCall("{? = CALL numTypeProduct()}");
            cstmt.registerOutParameter(1, Types.INTEGER);
            cstmt.executeUpdate();
            sum_ =  cstmt.getInt(1);
        }catch (SQLException e)
        {
            e.printStackTrace();
        }finally{
            try {
                if (cstmt != null)
                {
                    cstmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return sum_;
    }
    public static int numItemProduct(Connection conn) 
    {
        CallableStatement cstmt = null;
        int sum_ = 0;
        try{
            cstmt = conn.prepareCall("{? = CALL numItemProduct()}");
            cstmt.registerOutParameter(1, Types.INTEGER);
            cstmt.executeUpdate();
            sum_ =  cstmt.getInt(1);
        }catch (SQLException e)
        {
            e.printStackTrace();
        }finally{
            try {
                if (cstmt != null)
                {
                    cstmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return sum_;
    }
    public static boolean createMemberShip(Connection conn,String fullname,String addr, String phone) 
    {
        PreparedStatement stmt=null;
        boolean result = false;
        try{
            stmt = conn.prepareCall("{CALL createMembership(?,?,?)}");
            stmt.setString(1, fullname);
            stmt.setString(2, addr);
            stmt.setString(3, phone);
            stmt.executeQuery();
            result = true;
        }catch (SQLException e)
        {
            e.printStackTrace();
        }finally{
            try {
                if (stmt != null)
                {
                    stmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
    public static Membership getMemberShip(Connection conn,String id) 
    {
        PreparedStatement stmt=null;
        ResultSet rs = null;
        Membership temp = null;
        try{
            stmt = conn.prepareCall("{CALL getMembership(?)}");
            stmt.setString(1, id);
            rs = stmt.executeQuery();
            if (rs.next())
            {
                String name = rs.getString("FullName");
                String address = rs.getString("Addr");
                String phone = rs.getString("PhoneNum");
                int point = rs.getInt("Point");
                String idGet = rs.getString("MemId");
                temp = new Membership(name, address, phone, point, idGet);
            }
        }catch (SQLException e)
        {
            e.printStackTrace();
        }finally{
            try {
                if (stmt != null)
                {
                    stmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return temp;
    }
    public static ArrayList<Membership> getAllMemberShip(Connection conn) 
    {
        PreparedStatement stmt=null;
        ResultSet rs = null;
        ArrayList<Membership> list = new ArrayList<Membership>();
        try{
            stmt = conn.prepareCall("{CALL getAllMembership()}");
            rs = stmt.executeQuery();
            while (rs.next())
            {
                String name = rs.getString("FullName");
                String address = rs.getString("Addr");
                String phone = rs.getString("PhoneNum");
                int point = rs.getInt("Point");
                String id = rs.getString("MemId");
                Membership temp = new Membership(name, address, phone, point, id);
                list.add(temp);
            }
        }catch (SQLException e)
        {
            e.printStackTrace();
        }finally{
            try {
                if (stmt != null)
                {
                    stmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }
    public static ArrayList<Promotion> getAllPromo(Connection conn) 
    {
        PreparedStatement stmt=null;
        ResultSet rs = null;
        ArrayList<Promotion> list = new ArrayList<Promotion>();
        try{
            stmt = conn.prepareCall("{CALL GetAllPromos()}");
            rs = stmt.executeQuery();
            while (rs.next())
            {
                int id = rs.getInt("ID");
                int discount = rs.getInt("discount");
                String productID = rs.getString("productID");
                String productName = rs.getString("ProductName");
                Promotion temp = new Promotion(id,productID,discount,productName);
                list.add(temp);
            }
        }catch (SQLException e)
        {
            e.printStackTrace();
        }finally{
            try {
                if (stmt != null)
                {
                    stmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }
    public static Staff getAccount(Connection conn,String staffID)
    {
        PreparedStatement stmt=null;
        ResultSet rs = null;
        Staff temp = new Staff();
        try{
            stmt = conn.prepareCall("{CALL takeAccount(?)}");
            stmt.setString(1, staffID);
            rs = stmt.executeQuery();
            Staff a = new Staff();
            temp = a.getStaff(rs);
        }catch (SQLException e)
        {
            e.printStackTrace();
        }finally{
            try {
                if (stmt != null)
                {
                    stmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return temp;
    }
    public static ArrayList<Staff> getAllAccount(Connection conn)
    {
        PreparedStatement stmt=null;
        ResultSet rs = null;
        ArrayList<Staff> list = new ArrayList<Staff>();
        try{
            stmt = conn.prepareCall("{CALL getAllAccount()}");
            rs = stmt.executeQuery();
            Staff a = new Staff();
            while(true)
            {
                Staff temp = a.getStaff(rs);
                if (temp == null)
                    break;
                list.add(temp);
            }
        }catch (SQLException e)
        {
            e.printStackTrace();
        }finally{
            try {
                if (stmt != null)
                {
                    stmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }
    public static boolean removeAccount(Connection conn,String accountID) 
    {
        PreparedStatement stmt=null;
        boolean result = false;
        try{
            stmt = conn.prepareCall("{CALL removeAccount(?)}");
            stmt.setString(1, accountID);
            stmt.executeQuery();
            result = true;
        }catch (SQLException e)
        {
            e.printStackTrace();
        }finally{
            try {
                if (stmt != null)
                {
                    stmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
    public static boolean removePromo(Connection conn,int Id) 
    {
        PreparedStatement stmt=null;
        boolean result = false;
        try{
            stmt = conn.prepareCall("DELETE FROM promo where ID = ?;");
            stmt.setInt(1, Id);
            stmt.executeUpdate();
            result = true;
        }catch (SQLException e)
        {
            e.printStackTrace();
        }finally{
            try {
                if (stmt != null)
                {
                    stmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
    public static boolean createPromo(Connection conn,String ProductID,int discount) 
    {
        PreparedStatement stmt=null;
        boolean result = false;
        try{
            ArrayList<Promotion> list = getAllPromo(conn);
            Collections.sort(list,new Comparator<Promotion>() {
                @Override
                public int compare(Promotion o1, Promotion o2) {
                    if (o1.getPromoID() > o2.getPromoID())
                        return 1;
                    else
                        return -1;
                }
            });
            int id = 1;
            for (int i=0;i<list.size();i++)
            {
                if (list.get(i).getPromoID() != id)
                    break;
                id++;
            }
            stmt = conn.prepareCall("INSERT INTO promo(ID,discount,productID) VALUES(?,?,?);");
            stmt.setInt(1, id);
            stmt.setInt(2, discount);
            stmt.setString(3, ProductID);
            stmt.executeUpdate();
            result = true;
        }catch (SQLException e)
        {
            e.printStackTrace();
        }finally{
            try {
                if (stmt != null)
                {
                    stmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
    // public static ArrayList<Bill> filterBillByDate(Connection conn, Date string,Date string2) 
    // {
    //     PreparedStatement stmt=null;
    //     ResultSet rs = null;
    //     ArrayList <Bill> listBill = new ArrayList<Bill>();
    //     try{
    //         stmt = conn.prepareCall("select *  from bill join billunit on bill.BillID = billunit.billID "
    //         +"where datediff(BuyDate,?) >= 0 and datediff(?,BuyDate) >= 0");
            
    //         stmt.setDate(1, string);
    //         stmt.setDate(2, string2);
    //         rs = stmt.executeQuery();
    //         if(!rs.next()){
    //             return listBill;
    //         }
    //         else{
    //             while(true){
    //                 Bill b = new Bill();
    //                 b.setSellerID(rs.getString("SellerID"));
    //                 b.setBuyDate(rs.getDate("BuyDate"));
    //                 b.setBillID(rs.getString("BillID"));
    //                 do{
    //                     if(rs.getString("BillID").compareTo(b.getBillID()) == 0))
    //                         brea

    //                     b.setMembershipID(rs.getString("MembershipID"));
    //                     BillUnit bUnit = new BillUnit(rs.getString("ProductID"),rs.getInt("Amount"));
    //                     b.addBillUnit(bUnit);
    //                 }while();
    //             }
    //         }
    //     }catch (SQLException e)
    //     {
    //         e.printStackTrace();
    //     }finally{
    //         try {
    //             if (stmt != null)
    //             {
    //                 stmt.close();
    //             }
    //         } catch (SQLException e) {
    //             e.printStackTrace();
    //         }
    //     }
    //     return listBill;
    // }
    public static boolean updateAccount(Connection conn,String username,String fullName,String dob,String address,String pass,String type) 
    {
        PreparedStatement stmt=null;
        boolean result = false;
        try{
            stmt = conn.prepareCall("{CALL updateAccount(?,?,?,?,?,?)}");
            stmt.setString(1, username);
            stmt.setString(2, fullName);
            stmt.setString(3, dob);
            stmt.setString(4, address);
            stmt.setString(5, pass);
            stmt.setString(6, type);
            stmt.executeQuery();
            result = true;
        }catch (SQLException e)
        {
            e.printStackTrace();
        }finally{
            try {
                if (stmt != null)
                {
                    stmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public static boolean createAccount(Connection conn,String username,String fullName,String dob,String address,String pass,String type) 
    {
        PreparedStatement stmt=null;
        boolean result = false;
        try{
            stmt = conn.prepareCall("{CALL createAccount(?,?,?,?,?,?)}");
            stmt.setString(1, username);
            stmt.setString(2, fullName);
            stmt.setString(3, dob);
            stmt.setString(4, address);
            stmt.setString(5, pass);
            stmt.setString(6, type);
            stmt.executeQuery();
            result = true;
        }catch (SQLException e)
        {
            e.printStackTrace();
        }finally{
            try {
                if (stmt != null)
                {
                    stmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
    // public static Bill getBillInfo(Connection conn,String billID)
    // {   
    //     PreparedStatement stmt=null;
    //     ResultSet rs = null;
    //     Bill temp = null;
    //     try{
    //         stmt = conn.prepareCall("{CALL GetBillInfo(?)}");
    //         stmt.setString(1, billID);
    //         rs = stmt.executeQuery();
    //         ArrayList<BillUnit> list= new ArrayList<BillUnit>();
    //         while (rs.next())
    //         {
    //             if (temp == null)
    //             {
    //                 java.sql.Timestamp datetime =  rs.getTimestamp("BuyDate");
    //                 java.util.Date dbSqlTimeConverted = new java.util.Date(datetime.getTime());
    //                 temp = new Bill(list, rs.getDate("BuyDate"),rs.getString("MembershipID"), rs.getString("BillID"),rs.getString("SellerID"));
    //             }
    //             BillUnit bUnit = new BillUnit(new ProductInfo(rs.getString("Brand"),rs.getString("ProductName"), rs.getString("ID"),rs.getInt("Price")),rs.getInt("Amount"));
    //             list.add(bUnit);
    //             temp.setAllProductBill(list);
    //         }
    //     }catch (SQLException e)
    //     {
    //         e.printStackTrace();
    //     }finally{
    //         try {
    //             if (stmt != null)
    //             {
    //                 stmt.close();
    //             }
    //         } catch (SQLException e) {
    //             e.printStackTrace();
    //         }
    //     }
    //     return temp;
    // }
    public static ArrayList<Bill> getAllBill(Connection conn) 
    {
        PreparedStatement stmt=null;
        PreparedStatement stmt1=null;
        ResultSet rs = null;
        ResultSet rs1 = null;
        ArrayList <Integer> listBillId = new ArrayList<Integer>();
        ArrayList <Bill> listBill = new ArrayList<Bill>();
        try{
            stmt = conn.prepareCall("Select * from bill");
            rs = stmt.executeQuery();
            while (rs.next())
            {
                listBillId.add(rs.getInt("BillID"));
            }
            for (int i=0;i<listBillId.size();i++)
            {
                stmt.close();
                stmt = conn.prepareStatement("call GetBillInfo(?)");
                stmt.setInt(1,listBillId.get(i));
                rs = stmt.executeQuery();
                int flag = -1;
                while(rs.next())
                {
                    if (flag == -1)
                    {
                        flag = listBill.size();
                        ArrayList<BillUnit> listBillUnit = new ArrayList<BillUnit>();
                        stmt1 = conn.prepareStatement("Select * from productStock where Id = ?");
                        stmt1.setString(1,String.valueOf(listBillId.get(i)));
                        rs1 = stmt1.executeQuery();
                        ProductStockInfoq stock = null;
                        if (rs1.next())
                        {
                            stock = new ProductStockInfoq(rs1.getDate("LastestEXP"), rs1.getInt("Numstock"));
                        }
                        stmt1.close();
                        stmt1 = conn.prepareStatement("Select * from typeproduct join product on product.TypeID = typeproduct.TypeID where Id = ?");
                        stmt1.setString(1,String.valueOf(listBillId.get(i)));
                        rs1 = stmt1.executeQuery();
                        ProductType type = null;
                        if (rs1.next())
                            type = new ProductType(rs1.getString("TypeID"),rs1.getString("Name"));
                        stmt1.close();
                        stmt1 = conn.prepareStatement("Select * from promo where productID = ?");
                        stmt1.setString(1,String.valueOf(listBillId.get(i)));
                        rs1 = stmt1.executeQuery();
                        Promotion promo = null;
                        if (rs1.next())
                            promo = new Promotion(rs1.getInt("ID"),rs1.getString("productID"),rs1.getInt("discount"),rs.getString("ProductName"));
                        stmt1.close();
                        listBillUnit.add(new BillUnit(new Product(new ProductInfo(rs.getString("Brand"),rs.getString("Productname"),rs.getString("ID"),rs.getInt("Price"),rs.getString("UrlImage")),stock,type,promo),rs.getInt("amount")));
                        listBill.add(new Bill(listBillUnit,rs.getDate("BuyDate"),rs.getString("MembershipID"),rs.getString("BillID"),rs.getString("SellerID")));
                    }
                    else
                    {
                        ArrayList<BillUnit> listBillUnit = listBill.get(flag).getAllProductBill();
                        stmt1 = conn.prepareStatement("Select * from productStock where TypeId = ?");
                        stmt1.setString(1,String.valueOf(listBillId.get(i)));
                        rs1 = stmt1.executeQuery();
                        ProductStockInfoq stock = null;
                        if (rs1.next())
                        {
                            stock = new ProductStockInfoq(rs1.getDate("LastestEXP"), rs1.getInt("Numstock"));
                        }
                        stmt1.close();
                        stmt1 = conn.prepareStatement("Select * from typeproduct join product on product.TypeID = typeproduct.TypeID where Id = ?");
                        stmt1.setString(1,String.valueOf(listBillId.get(i)));
                        rs1 = stmt1.executeQuery();
                        ProductType type = null;
                        if (rs1.next())
                            type = new ProductType(rs1.getString("TypeID"),rs1.getString("Name"));
                        stmt1.close();
                        stmt1 = conn.prepareStatement("Select * from promo where productID = ?");
                        stmt1.setString(1,String.valueOf(listBillId.get(i)));
                        rs1 = stmt1.executeQuery();
                        Promotion promo = null;
                        if (rs1.next())
                            promo = new Promotion(rs1.getInt("ID"),rs1.getString("productID"),rs1.getInt("discount"),rs.getString("ProductName"));
                        stmt1.close();
                        listBillUnit.add(new BillUnit(new Product(new ProductInfo(rs.getString("Brand"),rs.getString("Productname"),rs.getString("ID"),rs.getInt("Price"),rs.getString("UrlImage")),stock,type,promo),rs.getInt("amount")));
                        listBill.get(flag).setAllProductBill(listBillUnit);
                    }
                }
            }
        }catch (SQLException e)
        {
            e.printStackTrace();
        }finally{
            try {
                if (stmt != null)
                {
                    stmt.close();
                }
                if (stmt1 != null)
                {
                    stmt1.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return listBill;
    }
  
    public static int getNumTypeProduct(Connection conn){
        PreparedStatement stmt=null;
        ResultSet rs = null;
        int result = 0;
        try{
            stmt = conn.prepareCall("Select Count(*) from typeProduct");
            rs = stmt.executeQuery();
            if (rs.next())
            {
                result = rs.getInt(1);
            }
        }catch (SQLException e)
        {
            e.printStackTrace();
        }finally{
            try {
                if (stmt != null)
                {
                    stmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
    public static int getNumSoldProduct(Connection conn){
        PreparedStatement stmt=null;
        ResultSet rs = null;
        int result = 0;
        try{
            stmt = conn.prepareCall("Select sum(Amount) from billunit");
            rs = stmt.executeQuery();
            if (rs.next())
            {
                result = rs.getInt(1);
            }
        }catch (SQLException e)
        {
            e.printStackTrace();
        }finally{
            try {
                if (stmt != null)
                {
                    stmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
    public static long getRevenue(Connection conn){
        PreparedStatement stmt=null;
        ResultSet rs = null;
        long result = 0;
        try{
            stmt = conn.prepareCall("select sum(billunit.Amount*productinfo.Price) from billunit left join productinfo on billunit.ProductID = productinfo.Id");
            rs = stmt.executeQuery();
            if (rs.next())
            {
                result = rs.getLong(1);
            }
        }catch (SQLException e)
        {
            e.printStackTrace();
        }finally{
            try {
                if (stmt != null)
                {
                    stmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
    public static int getnumBill(Connection conn) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "Select count(*) from bill";
		int numproduct = 0;
		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()) {
				numproduct = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return numproduct;
    }
    public static int getStockProductNum(Connection conn) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "Select sum(Amount) from billunit";
		int numproduct = 0;
		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()) {
				numproduct = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return numproduct;
    }
    public static int getAboutExpireProductNum(Connection conn) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "Select count(*) from productstock where productstock.Numstock > 0 and productstock.Numstock < 5";
		int numproduct = 0;
		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()) {
				numproduct = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return numproduct;
    }
    public static int getAboutOutStockProductNum(Connection conn) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "Select count(*) from productstock where datediff(productstock.LastestEXP,NOW()) <= 10 and datediff(productstock.LastestEXP,NOW()) > 0";
		int numproduct = 0;
		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()) {
				numproduct = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return numproduct;
    }
    // public static boolean createBill(Connection conn,Bill bill) 
    // {
    //     PreparedStatement stmt=null;
    //     ResultSet rs = null;
    //     String id = null;
    //     boolean result = false;
    //     try{
    //         stmt = conn.prepareCall("{CALL createBill(?,?)}");
    //         stmt.setString(1, bill.getSellerID());
    //         stmt.setString(2, bill.getMembershipID());
    //         rs = stmt.executeQuery();
    //         if (rs.next())
    //             id = rs.getString(1);
    //         ArrayList<BillUnit> billProduct = bill.getAllProductBill();
    //         for (int i = 0;i<billProduct.size();i++)
    //         {
    //             stmt = conn.prepareCall("{CALL createBillUnit(?,?,?,?)}");
    //             stmt.setString(1, id);
    //             stmt.setString(2, billProduct.get(i).getProductInfo().getCodeBar());
    //             stmt.setInt(3, billProduct.get(i).getAmount());
    //             stmt.setString(4, bill.getMembershipID());
    //             stmt.executeQuery();
    //         }
    //         result = true;
    //     }catch (SQLException e)
    //     {
    //         e.printStackTrace();
    //     }finally{
    //         try {
    //             if (stmt != null)
    //             {
    //                 stmt.close();
    //             }
    //             if (rs != null)
    //             {
    //                 rs.close();
    //             }
    //         } catch (SQLException e) {
    //             e.printStackTrace();
    //         }
    //     }
    //     return result;
    // }

}