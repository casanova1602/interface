package model.services;

public interface OnlinePaymentService {
	public double feePayment(double amount);
	
	public double feeInterest(double amount, int months);
}
