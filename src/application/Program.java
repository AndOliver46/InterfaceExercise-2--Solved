package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Contract;
import entities.Installment;
import services.ContractService;
import services.PaypalService;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter contract data");
		System.out.print("Number: ");
		int number = sc.nextInt();
		System.out.print("Date (dd/MM/yyyy): ");
		sc.nextLine();
		Date date = sdf.parse(sc.nextLine());
		System.out.print("Contract value: ");
		double totalValue = sc.nextDouble();

		System.out.print("Number of installments: ");
		int months = sc.nextInt();

		Contract contract = new Contract(number, date, totalValue);
		ContractService cs = new ContractService(new PaypalService());

		cs.processContract(contract, months);
		for(Installment x : contract.getIntallments()) {
			System.out.println(x.toString());
		}
	}

}
