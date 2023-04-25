package com.jobs.domain;

public class Junior extends Employee{
	
	public Junior(String name, String address, String phone, 
			double salaryPerMonth,IPaymentRate paymentRate,
			IPaymentIrpf paymentIrpf) throws Exception {
		super(name, address, phone, salaryPerMonth, paymentRate, paymentIrpf);	

		//Ho movem al controlador, on té més sentit 
		//posar-hi regles de negoci
//		this.checkSalary(900,1600);
	}
	
	@Override
	public String toString() {
		String type = "Junior";
		return  type + " " + super.toString();
	}
}