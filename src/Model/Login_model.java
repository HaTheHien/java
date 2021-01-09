package Model;

import Model.User.Staff;
import java.sql.*;

public class Login_model extends Model {
    public Login_model(){
        super();
    }
    public Staff getStaff(String id, String password){
        //Get Staff from username + password
        PreparedStatement stmt=null;
        ResultSet rs  = null;
        String sql = "SELECT * FROM Account Where id = ? and Pass =?";
        try{
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, id);
            stmt.setString(2, password);
            rs = stmt.executeQuery();
           
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        finally{

        }
        return Staff.getStaff(rs);
    }
}