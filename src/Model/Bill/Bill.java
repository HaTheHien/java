package Model.Bill;

import java.sql.Date;
import java.util.ArrayList;

import Model.Bill.BillUnit;

public class Bill {

	private ArrayList<BillUnit> allProductBill;
	private Date buyDate;
	private String time;
	private String membershipID;
	private String billID;


	//constructor
	public Bill(ArrayList<BillUnit> allBill, Date buyDate,String time, String memID,String billID)
	{
		this.allProductBill=allBill;
		this.buyDate=buyDate;
		this.time=time;
		this.membershipID=memID;
		this.billID=billID;
	}
	public Bill(Bill b)
	{
		this.allProductBill=b.getAllProductBill();
		this.buyDate=b.getBuyDate();
		this.time=b.getTime();
		this.membershipID=b.getMembershipID();
		this.billID=b.getBillID();
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

	public String getTime() {
		return this.time;
	}

	/**
	 * 
	 * @param time
	 */
	public void setTime(String time) {
		this.time = time;
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