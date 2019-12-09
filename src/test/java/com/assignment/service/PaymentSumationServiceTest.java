package com.assignment.service;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.assignment.payment.Payment;
import com.assignment.payment.exception.PaymentNullException;
import com.assignment.service.impl.PaymentSumationServiceImpl;

public class PaymentSumationServiceTest {

	private PaymentSumationService paymentSumationService;
	
	@Before
	public void init() {
		paymentSumationService = new PaymentSumationServiceImpl();
	}
	
	@Test
	public void checkSumForSimple() {
		List<Payment> payments = new ArrayList<Payment>();
		payments.add(new Payment(BigDecimal.valueOf(1)));
		payments.add(new Payment(BigDecimal.valueOf(2)));		
		payments.add(new Payment(BigDecimal.valueOf(3)));
		
		BigDecimal sum = paymentSumationService.sum(payments);
		
		assertTrue(sum.equals(BigDecimal.valueOf(6).setScale(2)));
	}
	
	@Test(expected=PaymentNullException.class)
	public void checkSumForNullValue() {
		List<Payment> payments = new ArrayList<Payment>();
		payments.add(new Payment(null));
		
		paymentSumationService.sum(payments);
		
	}
	
	
	@Test
	public void checkSumForNegativeValue() {
		List<Payment> payments = new ArrayList<Payment>();
		payments.add(new Payment(BigDecimal.valueOf(1)));
		payments.add(new Payment(BigDecimal.valueOf(-2)));	
		
		BigDecimal sum = paymentSumationService.sum(payments);
		
		assertTrue(sum.equals(BigDecimal.valueOf(1).setScale(2)));
	}
}
