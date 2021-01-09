package Model.User;

public interface ManagementControl {

	void addProduct();

	void removeProduct();

	void addProductType();

	void removeProductType();

	void removeBill();

	/**
	 * 
	 * @param codeBar
	 */
	void changeLastestEXP(String codeBar);

	void saveLog();

	void changePassword_Manager();

	void addPromotion();

	/**
	 * 
	 * @param barCode
	 */
	void adjustProduct(String barCode);

	void outputStatistic();

}