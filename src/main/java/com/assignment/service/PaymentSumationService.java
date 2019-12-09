package com.assignment.service;

import java.math.BigDecimal;
import java.util.List;

import com.assignment.payment.CustomerBalance;
import com.assignment.payment.Payment;

public interface PaymentSumationService {

	BigDecimal sum(List<Payment> payments);
	
	Boolean initiatePayment(List<Payment> payments, CustomerBalance customerBalance);
}
