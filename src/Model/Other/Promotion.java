package Model.Other;
public class Promotion {
	public int promoID;
	public String productID;
	public int promoDiscount;
	public String productName;
	public Promotion(String codebar){
		this.productID = codebar;
	}
	public Promotion(){
	}
	public Promotion(int id,String product_id,int Discount, String productName_)
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
	public int getPromoID() {
		return promoID;
	}

	public void setPromoID(int promoID) {
		this.promoID = promoID;
	}

	public int getPromoDiscount() {
		return promoDiscount;
	}

	public void setPromoDiscount(int promoDiscount) {
		this.promoDiscount = promoDiscount;
	}

}