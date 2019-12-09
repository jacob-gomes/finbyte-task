package com.assignment.service.impl;

import java.math.BigDecimal;
import java.util.List;

import com.assignment.payment.CustomerBalance;
import com.assignment.payment.Payment;
import com.assignment.service.PaymentSumationService;

public class PaymentSumationServiceImpl implements PaymentSumationService {

	@Override
	public BigDecimal sum(List<Payment> payments) {
		//double sum = 0; 
		//BigDecimal sumBigDecimal = BigDecimal.ZERO;
		Payment payment = new Payment(BigDecimal.ZERO); 
		
		payment = payments.stream().reduce(payment, PaymentSumationServiceImpl::accumalator);			
		
		return payment.getAmount();
	}
	
	private static Payment accumalator(Payment payment, Payment counter) {
		if(BigDecimal.ZERO.compareTo(counter.getAmount()) < 0) {
			payment.setAmount(payment.getAmount().add(counter.getAmount()));
		}
		return payment;
	}

	@Override
	public synchronized Boolean initiatePayment(List<Payment> payments,CustomerBalance customerBalance) {
		BigDecimal sumOfPayments = sum(payments) ;
		
		if(null != customerBalance.getAccountBalance() 
				&& customerBalance.getAccountBalance().compareTo(sumOfPayments) > 0) {
			return true;
		}
		return false;
	}
}
