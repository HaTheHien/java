package Model.Other;

import Model.Model;
import java.sql.*;

public class Membership {

	private String name;
	private String address;
	private String phoneNum;
	private Integer point;
	private String idMem;

	// constructor
	public Membership(String name, String address, String phone, Integer point, String idMem) {
		this.name = name;
		this.address = address;
		this.phoneNum = phone;
		this.point = point;
		this.idMem = idMem;
	}

	public Membership(Membership b) {
		this.name = b.getName();
		this.address = b.getAddress();
		this.phoneNum = b.getPhoneNum();
		this.point = b.getPoint();
		this.idMem = b.getIdMem();
	}

	public Membership() {

	}

	public Integer getPoint() {
		return this.point;
	}

	public void setPoint(Integer point) {
		this.point = point;
	}

	public String getName() {
		return this.name;
	}

	/**
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return this.address;
	}

	/**
	 * 
	 * @param address
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNum() {
		return this.phoneNum;
	}

	/**
	 * 
	 * @param phoneNum
	 */
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getIdMem() {
		return this.idMem;
	}

	/**
	 * 
	 * @param idMem
	 */
	public void setIdMem(String idMem) {
		this.idMem = idMem;
	}

	public boolean updateMembership(String oldID){
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "UPDATE `quanlycuahang`.`membership`  SET `FullName` =  ?,`Addr` = ?,`PhoneNum` =?,`Point` = ?,`MemId` = ? WHERE `MemId` = ?;";
		try {
			stmt = Model.conn.prepareStatement(sql);
			stmt.setString(1, this.name);
			stmt.setString(2, this.address);
			stmt.setString(3, this.phoneNum);
			stmt.setInt(4, this.point);
			stmt.setString(5, this.idMem);
			stmt.setString(6, oldID);
			stmt.execute();


		} catch (SQLException e) {
			e.printStackTrace();
			return false;
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
		return true;
	}

}