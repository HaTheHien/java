package Bill;
public class Bill {

	private ArrayList<BillUnit> allProduct;
	private Date buyDate;
	private String time;
	private String membershipID;
	private String billID;

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