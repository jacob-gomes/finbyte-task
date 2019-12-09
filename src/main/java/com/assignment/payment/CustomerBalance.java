package com.assignment.payment;

import java.math.BigDecimal;

public class CustomerBalance {
	private BigDecimal accountBalance;

	public CustomerBalance(BigDecimal accountBalance) {
		super();
		this.accountBalance = accountBalance;
	}

	/**
	 * @return the accountBalance
	 */
	public BigDecimal getAccountBalance() {
		return accountBalance;
	}

	/**
	 * @param accountBalance the accountBalance to set
	 */
	public void setAccountBalance(BigDecimal accountBalance) {
		this.accountBalance = accountBalance;
	}
	
}
