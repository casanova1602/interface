package model.services;

import java.util.Calendar;
import java.util.Date;

import model.entities.Contract;
import model.entities.Installment;

public class ContractService {

	private OnlinePaymentService ps;
	
	public ContractService(OnlinePaymentService ps) {
		this.ps = ps;
	}

	public void paymentProcess(Contract contract, int months) {
		
		double valorParcela = contract.getTotalValue() / months;
		
		for(int i=1; i <= months; i++) {
			Date date = addMonth(contract.getDate(), i);
			double installmentInterest = valorParcela + ps.feeInterest(valorParcela, i);
			double parcelaTotal = installmentInterest + ps.feePayment(installmentInterest);
			contract.addInstallment(new Installment(date, parcelaTotal));
		}
	}
	
	private Date addMonth(Date date, int i) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, i);
		return cal.getTime();
	}
}
