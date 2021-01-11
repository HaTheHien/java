package Model.Other;
public class Promotion {
	public String promoID;
	public String productID;
	public long promoDiscount;
	public String productName;
	public Promotion(){

	}
	public Promotion(String id,String product_id,long Discount, String productName_)
	{
		promoID = id;
		productID = product_id;
		promoDiscount = Discount;
		productName = productName_;
	}
	public String getProductName(){
		return productName;
	}
	public String getProductID(){
		return productID;
	}
	public String getPromoID() {
		return promoID;
	}

	public void setPromoID(String promoID) {
		this.promoID = promoID;
	}

	public void setPromoID(int promoID) {
		this.promoID = String.valueOf(promoID);
	}

	public long getPromoDiscount() {
		return promoDiscount;
	}

	public void setPromoDiscount(long promoDiscount) {
		this.promoDiscount = promoDiscount;
	}

}