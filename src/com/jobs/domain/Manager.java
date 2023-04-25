package com.jobs.domain;

public class Manager extends Employee{
	
	public Manager(String name, String address, String phone, 
			double salaryPerMonth,IPaymentRate paymentRate,
			IPaymentIrpf paymentIrpf) throws Exception {
		super(name, address, phone, salaryPerMonth, paymentRate, paymentIrpf);	
		
		//Ho movem al controlador, on té més sentit 
		//posar-hi regles de negoci
//		this.checkSalary(3000,5000);
	}
	
	@Override
	public String toString() {
		String type = "Manager";
		return  type + " " + super.toString();
	}
}
