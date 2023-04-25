package com.jobs.domain;

public class Employee extends AbsStaffMember {

	private final int numeroDePaguesAnuals = 14;

	/*
	 * Salaris bruts (els salaris nets estan a la classe abstracta AbsStaffMember
	 * perquè els voluntaris només tenen "ajuda" i a aquesta ajuda no s'hi aplica
	 * l'irpf).
	 */
	protected double salariBrutPerMes;
	protected double salariBrutPerAny;

	protected IPaymentRate paymentRate;
	protected IPaymentIrpf paymentIrpf;

	public Employee(String name, String address, String phone, double salaryPerMonth, IPaymentRate paymentRate,
			IPaymentIrpf paymentIrpf) throws Exception {
		super(name, address, phone);
		if (salaryPerMonth < 0)
			throw new Exception("Error: No podem assignar un salari negatiu.");
		if (paymentRate == null)
			throw new Exception("Error: paymentRate no pot ser null");
		if (paymentIrpf == null)
			throw new Exception("Error: paymentIrpf no pot ser null");

		this.salariBrutPerMes = salaryPerMonth;
		this.salariBrutPerAny = salaryPerMonth * this.numeroDePaguesAnuals;
		this.paymentRate = paymentRate;
		this.paymentIrpf = paymentIrpf;
	}

	@Override
	public void pay() {
		double totalPaidBrutPerMonth = paymentRate.pay(salariBrutPerMes);
		double totalPaidNetPerMonth = paymentIrpf.pay(totalPaidBrutPerMonth);
		
		//Salaris nets per mes i any
		totalPaidPerMonth = totalPaidNetPerMonth;
		totalPaidPerYear = totalPaidNetPerMonth * this.numeroDePaguesAnuals;
	}

	@Override
	public String toString() {
		String type = "Emp";
		String totalPayPerMonthStr = String.format("%.2f", this.totalPaidPerMonth);
		String totalPayPerYearStr = String.format("%.2f", this.totalPaidPerYear);
		
		return type + "[" + super.toString() + " | " + "Salari Brut: " + 
		this.salariBrutPerMes + "(mensual), " +
		this.salariBrutPerAny + "(anual) |" + 
		" Salari Net: " + totalPayPerMonthStr  + "(mensual), " + 
		totalPayPerYearStr + "(anual) ]";
	}

}
