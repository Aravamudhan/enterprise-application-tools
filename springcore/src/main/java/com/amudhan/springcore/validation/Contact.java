package com.amudhan.springcore.validation;

public class Contact {
	private String mailId;
	private String phoneNumber;
	public String getMailId() {
		return mailId;
	}
	public void setMailId(String mailId) {
		this.mailId = mailId;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	@Override
	public String toString() {
		return "Contact [mailId=" + mailId + ", phoneNumber=" + phoneNumber
				+ "]";
	}
	
}
