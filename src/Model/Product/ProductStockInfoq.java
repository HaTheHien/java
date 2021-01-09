package Model.Product;

import java.sql.Date;

public class ProductStockInfoq {

	private Date lastestEXP;
	private Integer numStock;

	//constructor
	public ProductStockInfoq(Date lastest, Integer num)
	{
		this.lastestEXP=lastest;
		this.numStock=num;
	}
	public ProductStockInfoq(ProductStockInfoq b)
	{
		this.lastestEXP=b.getLastestEXP();
		this.numStock=b.getNumStock();
	}


	public  Date getLastestEXP()
	{
		return this.lastestEXP;
	}
	public  Integer getNumStock()
	{
		return this.numStock;
	}

	public void setLastestEXP(Date date)
	{
		this.lastestEXP=date;
	}
	public void setNumStock(Integer num)
	{
		this.numStock=num;
	}

}