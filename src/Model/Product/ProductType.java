package Model.Product;

import java.util.ArrayList;

public class ProductType {

	private String typeName;
	private String typeID;
	private ArrayList<Product> productList;

	//constructor

	public ProductType(String typeName, String typeID, ArrayList<Product> list)
	{
		this.typeID=typeName;
		this.typeID=typeID;
		this.productList=list;
	}

	public ProductType(ProductType b)
	{
		this.typeID=b.getTypeName();
		this.typeID=b.getTypeID();
		this.productList=b.getProductList();
	}



	public void setProductList(ArrayList<Product> list)
	{
		this.productList=list;
	}

	public ArrayList<Product> getProductList()
	{
		return this.productList;
	}

	public String getTypeName() {
		return this.typeName;
	}

	/**
	 * 
	 * @param typeName
	 */
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getTypeID() {
		return this.typeID;
	}

	/**
	 * 
	 * @param typeID
	 */
	public void setTypeID(String typeID) {
		this.typeID = typeID;
	}

	public ProductType() {
		// TODO - implement ProductType.ProductType
		throw new UnsupportedOperationException();
	}

}