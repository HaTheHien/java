package Controller;

import java.sql.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import Model.Other.*;
import Model.Product.ProductInfo;
import Model.User.Staff;
import Model.Bill.*;
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
            if (rs.wasNull())
            {
                result =  "";
            }
            else
            {
                rs.next();
                result = rs.getString("Id");
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
    public static boolean updatePointMemberShip(Connection conn,String id,int point) 
    {
        PreparedStatement stmt=null;
        boolean result = false;
        try{
            stmt = conn.prepareCall("{CALL createMembership(?,?)}");
            stmt.setString(1, id);
            stmt.setInt(2, point);
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
    public static Bill getBillInfo(Connection conn,String billID)
    {   
        PreparedStatement stmt=null;
        ResultSet rs = null;
        Bill temp = null;
        try{
            stmt = conn.prepareCall("{CALL GetBillInfo(?)}");
            stmt.setString(1, billID);
            rs = stmt.executeQuery();
            ArrayList<BillUnit> list= new ArrayList<BillUnit>();
            while (rs.next())
            {
                if (temp == null)
                {
                    java.sql.Timestamp datetime =  rs.getTimestamp("BuyDate");
                    java.util.Date dbSqlTimeConverted = new java.util.Date(datetime.getTime());
                    temp = new Bill(list, rs.getDate("BuyDate"), dbSqlTimeConverted.toString(),rs.getString("MembershipID"), rs.getString("BillID"));
                }
                BillUnit bUnit = new BillUnit(new ProductInfo(rs.getString("Brand"),rs.getString("ProductName"), rs.getString("ID"),rs.getInt("Price")),rs.getInt("Amount"));
                list.add(bUnit);
                temp.setAllProductBill(list);
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
		String sql = "Select count(*) from productstock where (productstock.LastestEXP - NOW()) /60/60/24  <= 3 and (productstock.LastestEXP - NOW()) /60/60/24  > 0";
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
}