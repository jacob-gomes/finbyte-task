package com.assignment;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.assignment.payment.Payment;
import com.assignment.service.PaymentSumationService;
import com.assignment.service.impl.PaymentSumationServiceImpl;

public class Solution {
	public static void main(String[] args) {
		PaymentSumationService paymentSumationService = new PaymentSumationServiceImpl();
		
		List<Payment> payments = new ArrayList<Payment>();
		
		
		BigDecimal testNumber = BigDecimal.ZERO;
		testNumber.add(BigDecimal.valueOf(3.0));
		
		Payment testPayment = new Payment(null);
		testPayment.setAmount(testNumber);
		
		payments.add(new Payment(BigDecimal.valueOf(1.012)));
		payments.add(new Payment(BigDecimal.valueOf(2.067)));		
		payments.add(testPayment);	
		
		
		BigDecimal sum = paymentSumationService.sum(payments);
		System.out.println(sum.doubleValue());
	}
	
}