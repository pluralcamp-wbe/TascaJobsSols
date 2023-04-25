package com.jobs.domain;

public class Volunteer extends AbsStaffMember {

	protected String description;
	private final double ajut;

	public Volunteer(String name, String address, String phone, 
			String description) throws Exception {
		super(name, address, phone);
		this.description = description;
		this.ajut = 0.0;
	}
	
	//Sobrecàrrega del constructor amb l'ajut
	public Volunteer(String name, String address, String phone, 
			String description, double ajut) throws Exception {
		super(name, address, phone);
		this.description = description;
		
		this.ajut = ajut;
		this.totalPaidPerMonth = ajut;
		
		//Ho movem al controlador, on té més sentit 
		//posar-hi regles de negoci
//		checkSalary();
	}

	@Override
	public void pay() {
		
		/* 
		 * Voluntari cobra l'ajut
		 */
		totalPaidPerMonth = this.ajut;
	}
	

	@Override
	public String toString() {
		String type = "Voluntari";

		return type + "[" + super.toString() + " | " + "descripcio: " + 
		this.description + " | " + "Ajut: "
				+ this.totalPaidPerMonth + "]";
	}
}
