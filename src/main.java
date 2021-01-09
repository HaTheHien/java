import java.sql.*;
import java.util.Properties;

import javax.swing.SwingUtilities;

import GUI.Login.*;
import GUI.Login.Login_screen;
public class main {
    static Connection conn=null;
    public static void main(String[] args) {
        try {
            String url = "jdbc:mysql://localhost:3306/quanlycuahang"; 
            Properties info = new Properties(); 
            info.put("user", "root"); 
            info.put("password", "password");
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn=DriverManager.getConnection(url,info);
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    new Login_screen(conn);
                }
            });
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
