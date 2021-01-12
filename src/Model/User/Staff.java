package Model.User;

import java.sql.*;
public class Staff {
    private String id;
    private String fullname;
    private Date dob;
    private String address;
    private String type;
    private String permission;

    public static Staff getStaff(ResultSet rs) {
        Staff s = null;
        try{
            if (rs.next()){
                s = new Staff();
                s.id = rs.getString("id");
                s.fullname = rs.getString("Fullname");
                s.dob = rs.getDate("DoB");
                s.address = rs.getString("Addr");
                s.type = rs.getString("Type");
                s.permission = rs.getString("Type");
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return s;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public Date getDob() {
        return dob;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }


    

}
