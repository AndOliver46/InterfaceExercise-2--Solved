package services;

import java.util.Calendar;
import java.util.Date;

import entities.Contract;
import entities.Installment;

public class ContractService {
	private OnlinePaymentService onlinePaymentService;

	public ContractService() {
	}

	public ContractService(OnlinePaymentService onlinePaymentService) {
		this.onlinePaymentService = onlinePaymentService;
	}

	public void processContract(Contract contract, Integer months) {
		double basicQuota = contract.getTotalValueDouble() / months;
		
		for (int i = 1; i <= months; i++) {
			double basicQuotaAndFee = basicQuota + onlinePaymentService.interest(basicQuota, i);
			double updatedQuota = basicQuotaAndFee + onlinePaymentService.paymentFee(basicQuotaAndFee);
			
			Date dueDate = addMonths(contract.getDate(), i);
			
			contract.getIntallments().add(new Installment(dueDate, updatedQuota));
		}
	}
	
	private Date addMonths(Date date, int N) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, N);
		return cal.getTime();
	}

}
