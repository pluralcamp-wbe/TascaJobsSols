package com.jobs.application;

import com.jobs.persistence.EmployeeRepository;
import com.jobs.persistence.EmployeeRepository.StaffMemberType;

public class SalariesController {
	private EmployeeRepository repository;
	
	//Sempre és millor injectar el repositori
	public SalariesController(EmployeeRepository repository) {
		this.repository = repository;
	}
	
	
	//rates:
	public void storeBossPaymentRate(double rate) throws Exception{				
		repository.assignRate(StaffMemberType.BOSS, rate);
	}	
	
	public void storeManagerPaymentRate(double rate) throws Exception{				
		repository.assignRate(StaffMemberType.MANAGER, rate);
	}		
	
	public void storeJuniorPaymentRate(double rate) throws Exception{				
		repository.assignRate(StaffMemberType.JUNIOR, rate);
	}	
	
	public void storeMidPaymentRate(double rate) throws Exception{				
		repository.assignRate(StaffMemberType.MID, rate);
	}	
	
	public void storeSeniorPaymentRate(double rate) throws Exception{				
		repository.assignRate(StaffMemberType.SENIOR, rate);
	}	
	
	
	
	//max salaries:
	public void storeBossMaxSalary(double max) {
		repository.assignMaxSalary(StaffMemberType.BOSS, max);
	}
	
	public void storeManagerMaxSalary(double max) {
		repository.assignMaxSalary(StaffMemberType.MANAGER, max);
	}
	
	public void storeJuniorMaxSalary(double max) {
		repository.assignMaxSalary(StaffMemberType.JUNIOR, max);
	}
	
	public void storeMidMaxSalary(double max) {
		repository.assignMaxSalary(StaffMemberType.MID, max);
	}
	
	public void storeSeniorMaxSalary(double max) {
		repository.assignMaxSalary(StaffMemberType.SENIOR, max);
	}
	
	
	
	//min salaries:
	public void storeBossMinSalary(double min) {
		repository.assignMinSalary(StaffMemberType.BOSS, min);
	}
	
	public void storeManagerMinSalary(double min) {
		repository.assignMinSalary(StaffMemberType.MANAGER, min);
	}
	
	public void storeJuniorMinSalary(double min) {
		repository.assignMinSalary(StaffMemberType.JUNIOR, min);
	}
	
	public void storeMidMinSalary(double min) {
		repository.assignMinSalary(StaffMemberType.MID, min);
	}
	
	public void storeSeniorMinSalary(double min) {
		repository.assignMinSalary(StaffMemberType.SENIOR, min);
	}
	
	
	
	//irpfs:
	public void storeBossIrpf(double irpf) {
		repository.assignIrpf(StaffMemberType.BOSS, irpf);
	}
	
	public void storeManagerIrpf(double irpf) {
		repository.assignIrpf(StaffMemberType.MANAGER, irpf);
	}
	
	public void storeJuniorIrpf(double irpf) {
		repository.assignIrpf(StaffMemberType.JUNIOR, irpf);
	}
	
	public void storeMidIrpf(double irpf) {
		repository.assignIrpf(StaffMemberType.MID, irpf);
	}
	
	public void storeSeniorIrpf(double irpf) {
		repository.assignIrpf(StaffMemberType.SENIOR, irpf);
	}
	
	//Ajuda del govern:
	public void storeVolunteerMaxGovAid(double aid) {
		repository.assignAid(StaffMemberType.VOLUNTEER, aid);
	}
}
