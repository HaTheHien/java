package Model.Product;
public class Product extends ProductType {
	private ProductInfo info;
	private ProductStockInfoq stockInfo;

	public Product() {
		// TODO - implement Product.Product
		throw new UnsupportedOperationException();
	}

	public Product(ProductInfo inf, ProductStockInfoq stock)
	{
		this.info=inf;
		this.stockInfo=stock;
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

}