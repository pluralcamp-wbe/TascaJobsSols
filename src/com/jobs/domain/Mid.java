package com.jobs.domain;

public class Mid extends Employee{
	
	public Mid(String name, String address, String phone, 
			double salaryPerMonth,IPaymentRate paymentRate,
			IPaymentIrpf paymentIrpf) throws Exception {
		super(name, address, phone, salaryPerMonth, paymentRate, paymentIrpf);	
		
		//Ho movem al controlador, on té més sentit 
		//posar-hi regles de negoci
//		this.checkSalary(1800,2500);
	}
	
	@Override
	public String toString() {
		String type = "Mid";
		return  type + " " + super.toString();
	}
}
