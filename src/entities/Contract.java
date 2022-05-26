package entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Contract {
	private Integer number;
	private Date date;
	private Double totalValueDouble;

	List<Installment> intallments = new ArrayList<>();

	public Contract() {
	}

	public Contract(Integer number, Date date, Double totalValueDouble) {
		this.number = number;
		this.date = date;
		this.totalValueDouble = totalValueDouble;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Double getTotalValueDouble() {
		return totalValueDouble;
	}

	public void setTotalValueDouble(Double totalValueDouble) {
		this.totalValueDouble = totalValueDouble;
	}

	public List<Installment> getIntallments() {
		return intallments;
	}

}
