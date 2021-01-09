package Model.Product;
public class ProductInfo {

	private String brand;
	private String productName;
	private String codeBar;
	private Integer price;

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

	public Integer getPrice() {
		return this.price;
	}

	/**
	 * 
	 * @param price
	 */
	public void setPrice(Integer price) {
		this.price = price;
	}

}