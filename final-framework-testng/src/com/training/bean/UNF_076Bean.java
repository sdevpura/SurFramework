package com.training.bean;

public class UNF_076Bean {
	private String userName;
	private String password;
	private String productName;
	private int quantity;

	public UNF_076Bean() {
	}

	
	
	public UNF_076Bean(String userName, String password, String productName, int quantity) {
		super();
		this.userName = userName;
		this.password = password;
		this.productName = productName;
		this.quantity = quantity;
	}



	public String getUserName() {
		return userName;
	}



	public void setUserName(String userName) {
		this.userName = userName;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getProductName() {
		return productName;
	}



	public void setProductName(String productName) {
		this.productName = productName;
	}



	public int getQuantity() {
		return quantity;
	}



	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}



	@Override
	public String toString() {
		return "UNF_076Bean [userName=" + userName + ", password=" + password + ", productName=" + productName
				+ ", quantity=" + quantity + "]";
	}
	
	
	
	

/*	public UNF_076Bean(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "LoginBean [userName=" + userName + ", password=" + password + "]";
	}*/

}
