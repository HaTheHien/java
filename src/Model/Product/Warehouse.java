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
		String sql = "CALL `quanlycuahang`.`GetAllProductsDetail`();";
		int numproduct = 0;
		try {
			stmt = Model.conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Product p = new Product(new ProductInfo(), new ProductStockInfoq(),new ProductType(), new Promotion());
				p.getProductInfo().setCodeBar(rs.getString(1));
				p.getProductInfo().setBrand(rs.getString(2));
				p.getProductInfo().setProductName(rs.getString(3));
				p.getProductInfo().setPrice(rs.getInt(4));
				p.setUrlImgString(rs.getString(5));

				p.getProducType().setTypeName(rs.getString(6));
				p.getProducType().setTypeID(rs.getString(7));
			

				p.getProductStockInfo().setLastestEXP(rs.getDate(8));
				p.getProductStockInfo().setNumStock(rs.getInt(9));

				p.getPromotion().setPromoID(rs.getInt(10));
				p.getPromotion().setPromoID(rs.getInt(11));

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
		String sql = "CALL `quanlycuahang`.`GetAllProductsDetailByName`(?)";
		try {
			stmt = Model.conn.prepareStatement(sql);
			stmt.setString(1, searchText);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Product p = new Product(new ProductInfo(), new ProductStockInfoq(), new ProductType(),new Promotion());
				p.getProductInfo().setCodeBar(rs.getString(1));
				p.getProductInfo().setBrand(rs.getString(2));
				p.getProductInfo().setProductName(rs.getString(3));
				p.getProductInfo().setPrice(rs.getInt(4));
				p.setUrlImgString(rs.getString(5));

				if (rs.getString(6) == null){
					p.getProducType().setTypeName(rs.getString(6));
				}
				p.getProducType().setTypeID(rs.getString(7));
			
				p.getProductStockInfo().setLastestEXP(rs.getDate(8));
				p.getProductStockInfo().setNumStock(rs.getInt(9));

				p.getPromotion().setPromoID(rs.getInt(10));
				p.getPromotion().setPromoID(rs.getInt(11));

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