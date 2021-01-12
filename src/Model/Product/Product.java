package Model.Product;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Controller.controller;
import Model.Model;
import Model.Other.Promotion;

public class Product {
	private ProductInfo info;
	private ProductStockInfoq stockInfo;
	private ProductType productype;
	private Promotion promotion;
	private String urlImgString;

	public Product() {

	}

	public Product(ProductInfo inf, ProductStockInfoq stock,ProductType productype,Promotion promotion)
	{
		this.info=inf;
		this.stockInfo=stock;
		this.productype = productype;
		this.promotion = promotion;
	}

	public Product(Product b)
	{
		this.info=b.getProductInfo();
		this.stockInfo=b.getProductStockInfo();
	}

	public void setProductInfo(ProductInfo info)
	{
		this.info=info;
	}
	public void setProductStockInfo(ProductStockInfoq stockInfo)
	{
		this.stockInfo=stockInfo;
	}
	public ProductInfo getProductInfo()
	{
		return this.info;
	}
	public ProductStockInfoq getProductStockInfo()
	{
		return this.stockInfo;
	}

	public ProductType getProducType() {
		return this.productype;
	}

	public void setProducType(ProductType productype) {
		this.productype = productype;
	}

	public String getUrlImgString() {
		return urlImgString;
	}

	public void setUrlImgString(String urlImgString) {
		this.urlImgString = urlImgString;
	}

	public Promotion getPromotion() {
		return promotion;
	}

	public void setPromotion(Promotion promotion) {
		this.promotion = promotion;
	}
	//query
	public boolean updateProduct(){
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "CALL `quanlycuahang`.`updateProduct`(?, ?, ?, ?, ?, ?, ?, ?,?)";
		try {
			stmt = Model.conn.prepareStatement(sql);
			stmt.setString(1, this.info.getCodeBar());
			stmt.setString(2, this.info.getProductName());
			stmt.setString(3, this.info.getBrand());
			stmt.setLong(4, this.info.getPrice());
			stmt.setInt(5, this.stockInfo.getNumStock());
			stmt.setDate(6, this.stockInfo.getLastestEXP());
			stmt.setLong(7, this.promotion.getPromoDiscount());
			stmt.setString(8, this.urlImgString);
			stmt.setString(9, this.productype.getTypeID());
			int res = stmt.executeUpdate();
			if(this.promotion.getPromoDiscount() > 0){
				sql = "CALL `quanlycuahang`.`InsertPromo`(?,?)";
					
				stmt = Model.conn.prepareStatement(sql);
				stmt.setLong(1, this.promotion.getPromoDiscount());
				stmt.setString(2,  this.info.getCodeBar());
				res = stmt.executeUpdate();
			}

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
	public boolean updateStock()
	{
		PreparedStatement stmt = null;
		String sql = "CALL `quanlycuahang`.`updateStock`(?, ?, ?);";
		try {
			stmt = Model.conn.prepareStatement(sql);
			stmt.setString(1, this.info.getCodeBar());
			stmt.setInt(2, this.stockInfo.getNumStock());
			stmt.setDate(3, this.stockInfo.getLastestEXP());
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
	public static boolean removeProduct(String idProduct)
	{
		PreparedStatement stmt = null;
		String sql = "CALL quanlycuahang.`removeProduct`(?);";
		String sql2 = "Delete from product where Id = ?";
		try {
			stmt = Model.conn.prepareStatement(sql);
			stmt.setString(1, idProduct);
			stmt.execute();
			stmt.close();
			stmt = Model.conn.prepareStatement(sql2);
			stmt.setString(1, idProduct);
			stmt.execute();
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