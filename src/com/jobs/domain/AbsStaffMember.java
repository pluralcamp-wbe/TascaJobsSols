package com.jobs.domain;

public abstract class AbsStaffMember {

	protected int id;
	protected String name;
	protected String address;
	protected String phone;
	
	//Salaris nets
	protected double totalPaidPerMonth=0;
	protected double totalPaidPerYear=0;
	
	private static int COUNTER_MEMBERS = 1;

	public AbsStaffMember(String name, String address, String phone) throws Exception {
		if (name.equals(""))
			throw new Exception();
		if (address.equals(""))
			throw new Exception();
		if (phone.equals(""))
			throw new Exception();

		this.name = name;
		this.address = address;
		this.phone = phone;
		id = COUNTER_MEMBERS;
		COUNTER_MEMBERS++;
	}

	public abstract void pay();
	
	//Ho movem al controlador, on té més sentit 
//	public abstract void checkSalary(double minSal, double maxSal) 
//			throws Exception;
	
	@Override
	public String toString() {
		return  "Nom: " + this.name + " | "
				+ "Adreça: " + this.address + " | "
				+ "Telèfon: " + this.phone;		
	}
}
