package Model.Bill;

import java.sql.Date;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Model.Model;

import Model.Product.Product;

public class Bill {

	private ArrayList<BillUnit> allProductBill;
	private Date buyDate;
	private String membershipID;
	private String billID;
	private String sellerID;


	//constructor
	public Bill()
	{
		allProductBill = new ArrayList<BillUnit>();
		buyDate = null;
		membershipID = null;
		billID = null;
		sellerID = null;
	}
	public Bill(ArrayList<BillUnit> allBill, Date buyDate, String memID,String billID,String seller)
	{
		this.allProductBill=allBill;
		this.buyDate=buyDate;
		this.membershipID=memID;
		this.billID=billID;
		this.sellerID = seller;
	}
	public Bill(Bill b)
	{
		this.allProductBill=b.getAllProductBill();
		this.buyDate=b.getBuyDate();
		this.membershipID=b.getMembershipID();
		this.billID=b.getBillID();
		this.sellerID = b.getSellerID();
	}

	public void addBillUnit(Product info, Integer amount) {
		// TODO - implement Bill.addBillUnit
		allProductBill.add(new BillUnit(info, amount));
	}

	//Get-Set
	public String getSellerID()
	{
		return this.sellerID;
	}
	public ArrayList<BillUnit> getAllProductBill()
	{
		return this.allProductBill;
	}
	public void setAllProductBill(ArrayList<BillUnit> allBill)
	{
		allProductBill=allBill;
	}


	public Date getBuyDate() {
		return this.buyDate;
	}

	/**
	 * 
	 * @param buyDate
	 */
	public void setBuyDate(Date buyDate) {
		this.buyDate = buyDate;
	}

	public String getMembershipID() {
		return this.membershipID;
	}

	/**
	 * 
	 * @param membershipID
	 */
	public void setMembershipID(String membershipID) {
		this.membershipID = membershipID;
	}

	public String getBillID() {
		return this.billID;
	}

	/**
	 * 
	 * @param billID
	 */
	public void setBillID(String billID) {
		this.billID = billID;
	}
	public void addBillUnit(BillUnit u){
		this.allProductBill.add(u);
	}


	//UI
	public Long getTotalPriceWithoutDiscount()
	{
		Long result = 0L;
		for (BillUnit u : allProductBill)
			result += u.getTotal();
		return result;
	}
	
	public Long getDiscount()
	{
		Long result = 0L;
		for (BillUnit u: allProductBill)
			result += u.getDiscount();
		
		return result;
	}

	public Long getTotalPriceWithDiscount()
	{
		return getTotalPriceWithoutDiscount() - getDiscount();
	}

	//Database
	public boolean exportBill()
	{
		PreparedStatement stmt = null;
		String sql = "Call `quanlycuahang`.`addBill`(?,?,?,?);";
		try {
			//Add bill
			stmt = Model.conn.prepareStatement(sql);
			stmt.setString(1, billID);
			stmt.setDate(2, buyDate);
			stmt.setString(3, membershipID);
			stmt.setString(4, sellerID);
			stmt.executeQuery();
			for (BillUnit unit : allProductBill)
			{
				unit.exportBillUnit(billID);
			}
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
	public void setSellerID(String string) {
	}
}