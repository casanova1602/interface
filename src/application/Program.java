package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Contract;
import model.entities.Installment;
import model.services.ContractService;
import model.services.PaypalService;

public class Program {
	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner (System.in);	
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Locale.setDefault(Locale.US);
		
		System.out.println("Enter contract data");
		System.out.print("Number: ");
		int number = sc.nextInt();
		System.out.print("Date (dd/mm/yyyy): ");
		Date date = sdf.parse(sc.next());
		System.out.println("Contract Value: ");
		double totalValue = sc.nextDouble();
		System.out.print("Enter number of installments: ");
		int installments = sc.nextInt();
		System.out.println("Installments: ");
		
		Contract contract = new Contract(number, date, totalValue);
		
		ContractService cs = new ContractService(new PaypalService());
		cs.paymentProcess(contract, installments);
		
		for(Installment i : contract.getListInstallment()) {
			System.out.println(i);
		}
		
		
	}
}
