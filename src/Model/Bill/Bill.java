package Model.Bill;

import java.sql.Date;
import java.util.ArrayList;

import Model.Bill.BillUnit;

public class Bill {

	private ArrayList<BillUnit> allProductBill;
	private Date buyDate;
	private String membershipID;
	private String billID;
	private String sellerID;


	//constructor
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

	public void addBillUnit() {
		// TODO - implement Bill.addBillUnit
		throw new UnsupportedOperationException();
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

}