package Model.Bill;

import java.lang.Thread.State;
import com.mysql.cj.xdevapi.Statement;
import Model.Product.ProductInfo;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import Model.Model;

public class BillUnit {

	private ProductInfo productInfo;
	private Integer amount;

	//constructor
	public BillUnit(ProductInfo info, Integer amount)
	{
		this.productInfo=info;
		this.amount=amount;
	}
	public BillUnit(BillUnit b)
	{
		this.productInfo=b.getProductInfo();
		this.amount=b.getAmount();
	}


	public void setProductInfo(ProductInfo info)
	{
		this.productInfo=info;

	}
	public void setAmount(Integer amount)
	{
		this.amount=amount;
	}


	public ProductInfo getProductInfo()
	{
		return this.productInfo;
	}
	public Integer getAmount()
	{
		return this.amount;
	}

	//UI
	public Long getTotal()
	{
		return productInfo.getPrice() * amount;
	}
	public Long getDiscount()
	{
		Long result = 0L;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT discount(?);";
		try {
			//Add bill
			stmt = Model.conn.prepareStatement(sql);
			stmt.setString(1, productInfo.getCodeBar());
			rs = stmt.executeQuery();
			while (rs.next()) {
				result = rs.getLong(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return 0L;
		} finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result * amount;
	}

	//Database
	public boolean exportBillUnit(String billID)
	{
		PreparedStatement stmt = null;
		String sql = "Call `quanlycuahang`.`addBillUnit`(?,?,?);";
		try {
			//Add bill
			stmt = Model.conn.prepareStatement(sql);
			stmt.setString(1, billID);
			stmt.setString(2, productInfo.getCodeBar());
			stmt.setInt(3, amount);
			stmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return true;
	}
}