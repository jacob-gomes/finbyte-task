package com.assignment.payment;

import java.math.BigDecimal;

import com.assignment.payment.exception.PaymentNullException;

public class Payment {

	private BigDecimal amount;
	
	public Payment(BigDecimal amount) {
		setAmountSafely(amount);
	}

	/**
	 * @return the amount
	 */
	public BigDecimal getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(BigDecimal amount) {
		setAmountSafely(amount);
	}
	
	private void setAmountSafely(BigDecimal amount) {
		if(null == amount) {
			throw new PaymentNullException("Amount Cannot Be NULL.");
		}
		
		this.amount = amount.setScale(2, BigDecimal.ROUND_HALF_UP);
	}
}