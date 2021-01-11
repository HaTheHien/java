package Model.Bill;

import java.lang.Thread.State;
import com.mysql.cj.xdevapi.Statement;

import Model.Product.Product;
import Model.Product.ProductInfo;
import Model.Product.Warehouse;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import Model.Model;

public class BillUnit {

	private Product product;
	private Integer amount;

	//constructor
	public BillUnit(Product info, Integer amount)
	{
		this.product=info;
		this.amount=amount;
	}
	public BillUnit(BillUnit b)
	{
		this.product=b.getProduct();
		this.amount=b.getAmount();
	}
	public void increOne(){
		this.amount ++;
	}
	public BillUnit(String codebar,Integer amount){
		this.product = Warehouse.getAllProductByID(codebar).get(0);
		this.amount = amount;
	}



	public BillUnit() {
	}
	//UI
	public Long getTotal()
	{
		return product.getProductInfo().getPrice() * amount;
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
			stmt.setString(1, product.getProductInfo().getCodeBar());
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
			stmt.setString(2, product.getProductInfo().getCodeBar());
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

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}
}