package Model.Product;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Model.Model;
import Model.Other.Promotion;


public class Warehouse {

	//private ArrayList<ProductType> productTypeList;

	public static ArrayList<Product> getAllProduct() {
		ArrayList<Product> allProducts = new ArrayList<Product>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "CALL `quanlycuahang`.`GetAllProductsDetails`();";
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
				p.getPromotion().setPromoDiscount(rs.getLong("discount"));

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

	public static ArrayList<Product> getAllProductByID(String idProduct) {
		ArrayList<Product> allProducts = new ArrayList<Product>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "CALL `quanlycuahang`.`SearchProductByID`(?);";
		try {
			stmt = Model.conn.prepareStatement(sql);
			stmt.setString(1, idProduct);
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
	public static ArrayList<ProductType> getAllProductType(){
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM quanlycuahang.typeproduct;";
		ArrayList<ProductType> allType = new ArrayList<>();
		try {
			stmt = Model.conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			ProductType pt = null;
			while (rs.next()) {
				pt = new ProductType();
				pt.setTypeID(rs.getString("TypeID"));
				pt.setTypeName(rs.getString("Name"));
				allType.add(pt);
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
		return allType;
	}
	static void updateProduct(String id, String new_prodName, String new_brand,
							String new_price, String new_stock,
							String new_exp, String new_discount,
							String new_url, String new_typeProduct)
	{
		PreparedStatement stmt = null;
		String sql = "CALL updateProduct(?, ?, ?, ?, ?, ?, ?, ?, ?);";
		try {
			stmt = Model.conn.prepareStatement(sql);
			stmt.setString(1, id);
			stmt.setString(2, new_prodName);
			stmt.setString(3, new_brand);
			stmt.setInt(4, Integer.parseInt(new_price));
			stmt.setInt(5, Integer.parseInt(new_stock));
			stmt.setDate(6, Date.valueOf(new_exp));
			stmt.setInt(7, Integer.parseInt(new_discount));
			stmt.setString(8, new_url);
			stmt.setInt(9, Integer.parseInt(new_typeProduct));
			
			stmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	static void addProduct(String new_prodName, String new_brand,
						String new_price, String new_url,
						String new_typeID)
	{
		PreparedStatement stmt = null;
		String sql = "CALL `quanlycuahang`.`addProduct`(?, ?, ?, ?, ?);";
		try {
			stmt = Model.conn.prepareStatement(sql);
			stmt.setString(1, new_prodName);
			stmt.setString(2, new_brand);
			stmt.setInt(3, Integer.parseInt(new_price));
			stmt.setString(4, new_url);
			stmt.setString(5, new_typeID);

			stmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException e) {	
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	static void updateStock(String idProduct, String count, String exp)
	{
		PreparedStatement stmt = null;
		String sql = "CALL `quanlycuahang`.`updateStock`(?, ?, ?);";
		try {
			stmt = Model.conn.prepareStatement(sql);
			stmt.setString(1, idProduct);
			stmt.setInt(2, Integer.parseInt(count));
			stmt.setDate(3, Date.valueOf(exp));
			stmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException e) {	
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	static void addStock(String idProduct, String count)
	{
		PreparedStatement stmt = null;
		String sql = "CALL `quanlycuahang`.`addStock`(?, ?);";
		try {
			stmt = Model.conn.prepareStatement(sql);
			stmt.setString(1, idProduct);
			stmt.setInt(2, Integer.parseInt(count));
			stmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException e) {	
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}