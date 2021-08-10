package com.mylabs.product.entity;

public class User {
	private String userName;
	private String firstName;
	private String lastName;
	private int phoneNumber;
	private String emailAddress;
	private String interestedStocks;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getInterestedStocks() {
		return interestedStocks;
	}

	public void setInterestedStocks(String interestedStocks) {
		this.interestedStocks = interestedStocks;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

}
