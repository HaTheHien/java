package Controller;

import java.sql.*;
public class controler
{
    String login(Connection conn,String user,String password)throws Exception
    {
        PreparedStatement stmt=null;
        String sql = "SELECT * FROM "+ "Account Where Id = ? and Pass = ?";
        stmt = conn.prepareStatement(sql);
        stmt.setString(1, user);
        stmt.setString(2, password);
        ResultSet rs = stmt.executeQuery();
        if (rs.wasNull())
        {
            return "";
        }
        if (stmt != null)
        {
            stmt.close();
        }
        return rs.getString("Id");
    }
    double turnOver(Connection conn) throws Exception
    {
        PreparedStatement stmt=null;
        CallableStatement cstmt = conn.prepareCall("{? = CALL turnOver()}");
        cstmt.registerOutParameter(1, Types.DOUBLE);
        cstmt.executeUpdate();
        double turnOver_ =  cstmt.getDouble(1);
        if (stmt != null)
        {
            stmt.close();
        }
        return turnOver_;
    }
    int sumOrder(Connection conn) throws Exception
    {
        PreparedStatement stmt=null;
        CallableStatement cstmt = conn.prepareCall("{? = CALL sumOrder()}");
        cstmt.registerOutParameter(1, Types.INTEGER);
        cstmt.executeUpdate();
        int sum_ =  cstmt.getInt(1);
        if (stmt != null)
        {
            stmt.close();
        }
        return sum_;
    }
    int numberProduct(Connection conn) throws Exception
    {
        PreparedStatement stmt=null;
        CallableStatement cstmt = conn.prepareCall("{? = CALL numProduct()}");
        cstmt.registerOutParameter(1, Types.INTEGER);
        cstmt.executeUpdate();
        int sum_ =  cstmt.getInt(1);
        if (stmt != null)
        {
            stmt.close();
        }
        return sum_;
    }
    int numProductOutStock(Connection conn) throws Exception
    {
        PreparedStatement stmt=null;
        CallableStatement cstmt = conn.prepareCall("{? = CALL numProductOutStock()}");
        cstmt.registerOutParameter(1, Types.INTEGER);
        cstmt.executeUpdate();
        int sum_ =  cstmt.getInt(1);
        if (stmt != null)
        {
            stmt.close();
        }
        return sum_;
    }
    int numProductExpired(Connection conn) throws Exception
    {
        PreparedStatement stmt=null;
        CallableStatement cstmt = conn.prepareCall("{? = CALL numProductExpired()}");
        cstmt.registerOutParameter(1, Types.INTEGER);
        cstmt.executeUpdate();
        int sum_ =  cstmt.getInt(1);
        if (stmt != null)
        {
            stmt.close();
        }
        return sum_;
    }
    int numTypeProduct(Connection conn) throws Exception
    {
        PreparedStatement stmt=null;
        CallableStatement cstmt = conn.prepareCall("{? = CALL numTypeProduct()}");
        cstmt.registerOutParameter(1, Types.INTEGER);
        cstmt.executeUpdate();
        int sum_ =  cstmt.getInt(1);
        if (stmt != null)
        {
            stmt.close();
        }
        return sum_;
    }
    int numItemProduct(Connection conn) throws Exception
    {
        PreparedStatement stmt=null;
        CallableStatement cstmt = conn.prepareCall("{? = CALL numItemProduct()}");
        cstmt.registerOutParameter(1, Types.INTEGER);
        cstmt.executeUpdate();
        int sum_ =  cstmt.getInt(1);
        if (stmt != null)
        {
            stmt.close();
        }
        return sum_;
    }
}