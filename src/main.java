import java.sql.*;
import GUI.*;
public class main {
    static Connection conn=null;
    public static void main(String[] args) {
        try {
            String url = "jdbc:mysql://localhost:3306/student"; 
            Properties info = new Properties(); 
            info.put("user", "root"); 
            info.put("password", "hien2000la");
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
