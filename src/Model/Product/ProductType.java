package Model.Product;

import java.util.ArrayList;


public class ProductType {

	private String typeName;
	private String typeID;

	//constructor

	public ProductType(String typeName, String typeID)
	{
		this.typeID=typeName;
		this.typeID=typeID;
	}

	public ProductType(ProductType b)
	{
		this.typeID=b.getTypeName();
		this.typeID=b.getTypeID();
	}
	public ProductType() {

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



}