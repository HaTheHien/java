package Model.Other;
public class Promotion {

	private String namePromo;
	private String idPromo;

	//constructor

	public Promotion(String name,String id)
	{
		this.namePromo=name;
		this.idPromo=id;
	}
	public Promotion( Promotion b)
	{
		this.namePromo=b.getNamePromo();
		this.idPromo=b.getIdPromo();
	}

	public boolean checkPromotion() {
		// TODO - implement Promotion.checkPromotion
		throw new UnsupportedOperationException();
	}

	


	public String getNamePromo()
	{
		return this.namePromo;
	}
	public String getIdPromo()
	{
		return this.idPromo;
	}

	public void setNamePromo(String name)
	{
		this.namePromo=name;

	}
	public void setIdPromo(String id)
	{
		this.idPromo=id;
	}
}