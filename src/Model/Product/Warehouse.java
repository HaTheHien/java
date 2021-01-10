package Model.Product;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Model.Model;
import Model.Other.Promotion;

public class Warehouse {

	private ArrayList<ProductType> productTypeList;

	public static ArrayList<Product> getAllProduct() {
		ArrayList<Product> allProducts = new ArrayList<Product>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "CALL `quanlycuahang`.`GetAllProductsDetails`();";
		int numproduct = 0;
		try {
			stmt = Model.conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Product p = new Product(new ProductInfo(), new ProductStockInfoq(),new ProductType(), new Promotion());
				p.getProductInfo().setCodeBar(rs.getString("id"));
				p.getProductInfo().setBrand(rs.getString("brand"));
				p.getProductInfo().setProductName(rs.getString("productName"));
				p.getProductInfo().setPrice(rs.getInt("price"));
				p.setUrlImgString(rs.getString("urlImage"));

				p.getProducType().setTypeName(rs.getString("typeName"));
				p.getProducType().setTypeID(rs.getString("typeID"));
			

				p.getProductStockInfo().setLastestEXP(rs.getDate("lastestEXP"));
				p.getProductStockInfo().setNumStock(rs.getInt("numStock"));

				p.getPromotion().setPromoID(rs.getInt("idPromo"));
				p.getPromotion().setPromoDiscount(rs.getInt("discount"));

				allProducts.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
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
		return allProducts;
	}

	public static ArrayList<Product> getAllProductByName(String searchText) {
		ArrayList<Product> allProducts = new ArrayList<Product>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "CALL `quanlycuahang`.`SearchProductByName`(?);";
		try {
			stmt = Model.conn.prepareStatement(sql);
			stmt.setString(1, searchText);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Product p = new Product(new ProductInfo(), new ProductStockInfoq(),new ProductType(), new Promotion());
				p.getProductInfo().setCodeBar(rs.getString("id"));
				p.getProductInfo().setBrand(rs.getString("brand"));
				p.getProductInfo().setProductName(rs.getString("productName"));
				p.getProductInfo().setPrice(rs.getInt("price"));
				p.setUrlImgString(rs.getString("urlImage"));

				if (rs.getString("typeName") != null)
					p.getProducType().setTypeName(rs.getString("typeName"));
				p.getProducType().setTypeID(rs.getString("typeID"));
			

				p.getProductStockInfo().setLastestEXP(rs.getDate("lastestEXP"));
				p.getProductStockInfo().setNumStock(rs.getInt("numStock"));

				p.getPromotion().setPromoID(rs.getInt("idPromo"));
				p.getPromotion().setPromoDiscount(rs.getInt("discount"));

				allProducts.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
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
		return allProducts;
	}

	public static int getNumProduct() {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select `quanlycuahang`.`numItemProduct`() ";
		int numproduct = 0;
		try {
			stmt = Model.conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()) {
				numproduct = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
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
		return numproduct;
	}

	public static int getnumProductExpired() {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select `quanlycuahang`.`numProductExpired`()";
		int numproduct = 0;
		try {
			stmt = Model.conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()) {
				numproduct = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
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
		return numproduct;
	}
}