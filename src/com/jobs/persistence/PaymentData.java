package com.jobs.persistence;

/**
 * Classe que representa una estructura
 * de dades per a emmagatzemar la informació
 * necessària per al càlcul dels pagaments.
 * 
 * Aquesta informació es guardarà en el repositori.
 * 
 * @author orboan
 *
 */

public class PaymentData {
	
	//Valors per defecte
	private double rate = 1.0; //100% de rate per defecte
	private double min = 0.0; //mínim a cobrar és 0
	private double max = -1.0; //no hi ha màxim
	private double irpf = 0.2; //IRPF del 20%
	private double govAid = 0.0; //Ajuda del govern, inicialment 0.0
	
	public PaymentData() {
		
	}
	
	public PaymentData(double rate, double min, double max, double irpf) {
		super();
		this.rate = rate;
		this.min = min;
		this.max = max;
		this.irpf = irpf;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public double getMin() {
		return min;
	}

	public void setMin(double min) {
		this.min = min;
	}

	public double getMax() {
		return max;
	}

	public void setMax(double max) {
		this.max = max;
	}

	public double getIrpf() {
		return irpf;
	}

	public void setIrpf(double irpf) {
		this.irpf = irpf;
	}

	public double getGovAid() {
		return govAid;
	}

	public void setGovAid(double govAid) {
		this.govAid = govAid;
	}
	
	
}
