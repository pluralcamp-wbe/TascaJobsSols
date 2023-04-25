package com.jobs.persistence;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jobs.domain.AbsStaffMember;
import com.jobs.persistence.EmployeeRepository.StaffMemberType;

public class EmployeeRepository {

	// Per a guardar els empleats i voluntaris (Staff Members)
	private static List<AbsStaffMember> members = new ArrayList<>();

	// Per a guardar totes les payment dades de cada tipus d'empleat
	private static Map<StaffMemberType, PaymentData> paymentData = new HashMap<>();

	// Omplim el map paymentData amb valors per defecte per a cada empleat
	static {
		for (StaffMemberType type : StaffMemberType.values()) {
			paymentData.put(type, new PaymentData());
		}
	}

	public EmployeeRepository() {

	}

	// Members
	public List<AbsStaffMember> getAllMembers() {
		// retorna una còpia
		// així evitem modificacions no desitjades a l'original
		return new ArrayList<>(members);
	}

	// Afegim staff members a la "base de dades" (list)
	public void addMember(AbsStaffMember member) throws Exception {
		if (member == null)
			throw new Exception();
		members.add(member);
	}

	// Helpers
	
	//Payment rates
	public void assignRate(StaffMemberType type, double rate) {
		PaymentData pd = paymentData.get(type);
		pd.setRate(rate);
	}

	public Map<StaffMemberType, Double> getRates() {
		Map<StaffMemberType, Double> rates = new HashMap<>();
		for (var entry : paymentData.entrySet()) {
			rates.put(entry.getKey(), entry.getValue().getRate());
		}
		return rates;
	}

	//Salaris mínims
	public void assignMinSalary(StaffMemberType type, double minSalary) {
		paymentData.get(type).setMin(minSalary);
	}

	public Map<StaffMemberType, Double> getMinSalaries() {
		Map<StaffMemberType, Double> minSalaries = new HashMap<>();
		for (var entry : paymentData.entrySet()) {
			minSalaries.put(entry.getKey(), entry.getValue().getMin());
		}
		return minSalaries;
	}

	//Salaris màxims
	public void assignMaxSalary(StaffMemberType type, double maxSalary) {
		paymentData.get(type).setMax(maxSalary);
	}

	public Map<StaffMemberType, Double> getMaxSalaries() {
		Map<StaffMemberType, Double> maxSalaries = new HashMap<>();
		for (var entry : paymentData.entrySet()) {
			maxSalaries.put(entry.getKey(), entry.getValue().getMax());
		}
		return maxSalaries;
	}

	// IRPFs
	public void assignIrpf(StaffMemberType type, double irpf) {
		paymentData.get(type).setIrpf(irpf);
	}

	public Map<StaffMemberType, Double> getIrpfs() {
		Map<StaffMemberType, Double> irpfs = new HashMap<>();
		for (var entry : paymentData.entrySet()) {
			irpfs.put(entry.getKey(), entry.getValue().getIrpf());
		}
		return irpfs;
	}

	// Ajudes (de moment només n'hi ha per als voluntaris)
	// (Ampliable a tot tipus d'staff members)
	public void assignAid(StaffMemberType type, double aid) {
		paymentData.get(type).setGovAid(aid);
	}
	
	public Map<StaffMemberType, Double> getGovAids() {
		Map<StaffMemberType, Double> aids = new HashMap<>();
		for (var entry : paymentData.entrySet()) {
			aids.put(entry.getKey(), entry.getValue().getGovAid());
		}
		return aids;
	}	

	// tipus d'empleat segons payment rate
	public static enum StaffMemberType {
		BOSS, MANAGER, EMPLOYEE, JUNIOR, MID, SENIOR, VOLUNTEER
	}
}
