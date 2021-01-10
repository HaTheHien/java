package Model.Product;

import Model.Other.Promotion;

public class Product {
	private ProductInfo info;
	private ProductStockInfoq stockInfo;
	private ProductType productype;
	private Promotion promotion;
	private String urlImgString;

	public Product() {
		// TODO - implement Product.Product
		throw new UnsupportedOperationException();
	}

	public Product(ProductInfo inf, ProductStockInfoq stock,ProductType productype,Promotion promotion)
	{
		this.info=inf;
		this.stockInfo=stock;
		this.productype = productype;
		this.promotion = promotion;
	}

	public Product(Product b)
	{
		this.info=b.getProductInfo();
		this.stockInfo=b.getProductStockInfo();
	}

	public void setProductInfo(ProductInfo info)
	{
		this.info=info;
	}
	public void setProductStockInfo(ProductStockInfoq stockInfo)
	{
		this.stockInfo=stockInfo;
	}
	public ProductInfo getProductInfo()
	{
		return this.info;
	}
	public ProductStockInfoq getProductStockInfo()
	{
		return this.stockInfo;
	}

	public ProductType getProducType() {
		return this.productype;
	}

	public void setProducType(ProductType productype) {
		this.productype = productype;
	}

	public String getUrlImgString() {
		return urlImgString;
	}

	public void setUrlImgString(String urlImgString) {
		this.urlImgString = urlImgString;
	}

	public Promotion getPromotion() {
		return promotion;
	}

	public void setPromotion(Promotion promotion) {
		this.promotion = promotion;
	}


}