package com.amudhan.springcore.aop;

public class Account {
	private String accountName;

	public Account(String accountName) {
		super();
		this.accountName = accountName;
	}

	@Auditable("Account Name")
	public String getAccountName() {
		return accountName;
	}
}
