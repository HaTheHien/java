package Model.Product;
public class ProductInfo {

	private String brand;
	private String productName;
	private String codeBar;
	private long price;
	private String URLImage;

	public ProductInfo(String brand_,String name_,String codeBar_,long price_)
	{
		brand = brand_;
		productName = name_;
		codeBar = codeBar_;
		price = price_;
	}
	public ProductInfo(String brand_,String name_,String codeBar_,long price_,String URLimage)
	{
		brand = brand_;
		productName = name_;
		codeBar = codeBar_;
		price = price_;
		URLImage= URLimage;
	}
	public ProductInfo(String codeBar){
		this.brand = "";
		this.productName = "";
		this.codeBar = codeBar;
		this.URLImage = "";
	}
	public ProductInfo(){

	}
	public String getBrand() {
		return this.brand;
	}

	/**
	 * 
	 * @param brand
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getProductName() {
		return this.productName;
	}

	/**
	 * 
	 * @param productName
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getCodeBar() {
		return this.codeBar;
	}

	/**
	 * 
	 * @param codeBar
	 */
	public void setCodeBar(String codeBar) {
		this.codeBar = codeBar;
	}

	public void getAttribute() {
		// TODO - implement ProductInfo.getAttribute
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param attribute
	 */
	public void setAttribute(int attribute) {
		// TODO - implement ProductInfo.setAttribute
		throw new UnsupportedOperationException();
	}

	public long getPrice() {
		return this.price;
	}

	/**
	 * 
	 * @param price
	 */
	public void setPrice(long price) {
		this.price = price;
	}

}