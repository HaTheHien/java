package Model;

import java.sql.*;
import java.util.Properties;
public abstract class Model {
    public static Connection conn = null;
    public Model() {
        setupModel();
    }
    public static void setupModel(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/quanlycuahang"; 
            Properties info = new Properties(); 
            info.put("user", "root"); 
            info.put("password", "hathehien");
            conn=DriverManager.getConnection(url,info);
        }
        catch (SQLException se) { // Handle errors for JDBC
            se.printStackTrace();
        }
        catch (Exception e)
        {
            System.out.println(e.toString());
        }
    }
}
