package com.jobs.domain;

public class Boss extends Employee{
	
	public Boss(String name, String address, String phone, 
			double salaryPerMonth,IPaymentRate paymentRate,
			IPaymentIrpf paymentIrpf) throws Exception {
		super(name, address, phone, salaryPerMonth, paymentRate, paymentIrpf);	

		//Ho movem al controlador, on té més sentit 
		//posar-hi regles de negoci
//		this.checkSalary(8000,-1);
	}
	
	@Override
	public String toString() {
		String type = "Boss";
		return  type + " " + super.toString();
	}
}
