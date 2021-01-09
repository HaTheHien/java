package Model.Other;

import jdk.internal.icu.impl.Trie.DataManipulate;

public class Membership {

	private String name;
	private String address;
	private String phoneNum;
	private Integer point;
	private String idMem;
	
	//constructor
	public Membership(String name, String address, String phone, Integer point, String idMem)
	{
		this.name=name;
		this.address=address;
		this.phoneNum= phone;
		this.point=point;
		this.idMem=idMem;
	}
	public Membership(Membership b)
	{
		this.name=b.getName();
		this.address=b.getAddress();
		this.phoneNum= b.getPhoneNum();
		this.point=b.getPoint();
		this.idMem=b.getIdMem();
	}


	public Integer getPoint()
	{
		return this.point;
	}
	public void setPoint(Integer point)
	{
		this.point=point;
	}

	public String getName() {
		return this.name;
	}

	/**
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return this.address;
	}

	/**
	 * 
	 * @param address
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNum() {
		return this.phoneNum;
	}

	/**
	 * 
	 * @param phoneNum
	 */
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getIdMem() {
		return this.idMem;
	}

	/**
	 * 
	 * @param idMem
	 */
	public void setIdMem(String idMem) {
		this.idMem = idMem;
	}

}