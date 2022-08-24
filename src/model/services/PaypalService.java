package model.services;

public class PaypalService {

	private final static double FEE_PAYMENT = 0.02;
	private final static double MONTHLY_INTEREST = 0.01;
	
	public double feePayment(double amount) {
		return amount * 0.02;
	}
	
	public double feeInterest(double amount, int months) {
		return amount * months * 0.01; 
	}
}
