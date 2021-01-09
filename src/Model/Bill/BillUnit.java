package Model.Bill;

import Model.Product.ProductInfo;

public class BillUnit {

	private ProductInfo productInfo;
	private Integer amount;

	//constructor
	public BillUnit(ProductInfo info, Integer amount)
	{
		this.productInfo=info;
		this.amount=amount;
	}
	public BillUnit(BillUnit b)
	{
		this.productInfo=b.getProductInfo();
		this.amount=b.getAmount();
	}


	public void setProductInfo(ProductInfo info)
	{
		this.productInfo=info;

	}
	public void setAmount(Integer amount)
	{
		this.amount=amount;
	}


	public ProductInfo getProductInfo()
	{
		return this.productInfo;
	}
	public Integer getAmount()
	{
		return this.amount;
	}

}