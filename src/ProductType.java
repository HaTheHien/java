import java.util.ArrayList;

public class ProductType {

	private String typeName;
	private String typeID;
	private ArrayList<Product> productList;

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