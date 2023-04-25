package com.jobs.application;

import java.util.Map;

import com.jobs.domain.AbsStaffMember;
import com.jobs.domain.Boss;
import com.jobs.domain.Employee;
import com.jobs.domain.IPaymentIrpf;
import com.jobs.domain.IPaymentRate;
import com.jobs.domain.Junior;
import com.jobs.domain.Manager;
import com.jobs.domain.Mid;
import com.jobs.domain.Senior;
import com.jobs.domain.Volunteer;
import com.jobs.persistence.EmployeeRepository;
import com.jobs.persistence.EmployeeRepository.StaffMemberType;

public class JobsController {

	private final EmployeeRepository repository;

	private Map<StaffMemberType, Double> rates;

	private Map<StaffMemberType, Double> minSalary;

	private Map<StaffMemberType, Double> maxSalary;

	private Map<StaffMemberType, Double> irpfs;
	
	private Map<StaffMemberType, Double> govAids;

	// Sempre és millor injectar el repositori
	public JobsController(EmployeeRepository repository) {
		this.repository = repository;

		// guardem còpies als atributs
		// aqui només es guarden els valors per defecte
		setSalariesData();
	}

	// Mètode per ser cridat quan s'hagin
	// actualitzat els valors de les dades de Payment
	public void updateSalariesData() {

		// Cal actualitzar ja que al constructor
		// hi ha còpies, no referències als originals
		setSalariesData();
	}

	private void setSalariesData() {
		//Els getters de repository retornen còpies
		this.rates = this.repository.getRates();
		this.minSalary = this.repository.getMinSalaries();
		this.maxSalary = this.repository.getMaxSalaries();
		this.irpfs = this.repository.getIrpfs();
		this.govAids = this.repository.getGovAids();
	}

	/*
	 * Els següents mètodes creen empleats que cobren.
	 *
	 * He substituit l'ús del PaymentFactory per lambdes ja que IPaymentRate és una
	 * interfície funcional
	 * 
	 */

	// ****** Mètodes de creació d'empleats que cobren ******

	/*
	 * Primer Xequeja el Salari
	 * Si el salari no és correcte, el mètode checkSalary
	 * llença una excepció, i 
	 * si el salari és correcte, es crea la instància d'Employee
	 * i s'afageix al repositori
	 */
	public void createBossEmployee(String name, String address, String phone, double grossSalaryPerMonth) {
		try {
			checkSalary(StaffMemberType.BOSS, grossSalaryPerMonth, name);
			Employee boss = new Boss(name, address, phone, grossSalaryPerMonth,
					salari -> salari * rates.get(StaffMemberType.BOSS),
					salari -> salari * (1 - irpfs.get(StaffMemberType.BOSS)));
			repository.addMember(boss);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void createEmployee(String name, String address, String phone, double salaryPerMonth) {
		try {
			checkSalary(StaffMemberType.EMPLOYEE, salaryPerMonth, name);
			Employee employee = new Employee(name, address, phone, salaryPerMonth,
					salari -> salari * rates.get(StaffMemberType.EMPLOYEE),
					salari -> salari * (1 - irpfs.get(StaffMemberType.EMPLOYEE)));
			repository.addMember(employee);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void createManagerEmployee(String name, String address, String phone, double salaryPerMonth) {
		try {
			checkSalary(StaffMemberType.MANAGER, salaryPerMonth, name);
			Employee manager = new Manager(name, address, phone, salaryPerMonth,
					salari -> salari * rates.get(StaffMemberType.MANAGER),
					salari -> salari * (1 - irpfs.get(StaffMemberType.MANAGER)));
			repository.addMember(manager);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void createJuniorEmployee(String name, String address, String phone, double salaryPerMonth) {
		try {
			checkSalary(StaffMemberType.JUNIOR, salaryPerMonth, name);
			Employee employee = new Junior(name, address, phone, salaryPerMonth,
					salari -> salari * rates.get(StaffMemberType.JUNIOR),
					salari -> salari * (1 - irpfs.get(StaffMemberType.JUNIOR)));
			repository.addMember(employee);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void createMidEmployee(String name, String address, String phone, double salaryPerMonth) {
		try {
			checkSalary(StaffMemberType.MID, salaryPerMonth, name);
			Employee employee = new Mid(name, address, phone, salaryPerMonth,
					salari -> salari * rates.get(StaffMemberType.MID),
					salari -> salari * (1 - irpfs.get(StaffMemberType.MID)));
			repository.addMember(employee);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void createSeniorEmployee(String name, String address, String phone, double salaryPerMonth) {
		try {
			checkSalary(StaffMemberType.SENIOR, salaryPerMonth, name);
			Employee employee = new Senior(name, address, phone, salaryPerMonth,
					salari -> salari * rates.get(StaffMemberType.SENIOR),
					salari -> salari * (1 - irpfs.get(StaffMemberType.SENIOR)));
			repository.addMember(employee);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	// ****** Final de mètodes de creació d'empleats que cobren ******

	// ****** Mètodes de creació de voluntaris ******
	// amb sobrecàrrega amb i sense descripció explícita

	// Voluntari amb descripció per defecte i sense ajut
	public void createVolunteer(String name, String address, String phone) {
		String defaultDescription = "No cobra!";
		try {
			Volunteer volunteer = new Volunteer(name, address, phone, defaultDescription);
			repository.addMember(volunteer);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	// Voluntari amb descripció explícita i sense ajut
	public void createVolunteer(String name, String address, String phone, String description) {
		try {
			Volunteer volunteer = new Volunteer(name, address, phone, description);
			repository.addMember(volunteer);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	//Voluntari amb ajut
	public void createVolunteer(String name, String address, String phone, double ajut) {
		String defaultDescription = "Rep un ajut!";
		try {
			checkGovAid(StaffMemberType.VOLUNTEER, ajut, name);
			Volunteer volunteer = new Volunteer(name, address, phone, defaultDescription, ajut);
			repository.addMember(volunteer);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	// ****** Final de mètodes de creació de voluntaris ******

	
	
	public void payAllEmployeers() {
		// TODO Auto-generated method stub
		for (AbsStaffMember member : repository.getAllMembers()) {
			// if(member instanceof Employee)
			member.pay();
		}

	}

	public String getAllEmployees() {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		for (AbsStaffMember member : repository.getAllMembers()) {
			sb.append(member.toString() + "\n");
		}
		return sb.toString();
	}

	
	
	// Helper method for salary validation
	private double checkSalary(StaffMemberType type, double monthlyGrossSalary, String name) throws Exception {
		IPaymentRate irate = salary -> salary * rates.get(type);
		IPaymentIrpf iirpf = salary -> salary * (1 - irpfs.get(type));
		double totalPaid = iirpf.pay(irate.pay(monthlyGrossSalary));

		String totalPaidStr = String.format("SalariNetTotalMensual = %.2f", totalPaid);

		String exceptionMessage;

		if (totalPaid < minSalary.get(type)) {
			exceptionMessage = buildExceptionMessage("poc", "més", type, totalPaidStr, name);
			throw new Exception(exceptionMessage + minSalary.get(type) + " per mes.");
		}
		if (maxSalary.get(type) != -1 && totalPaid > maxSalary.get(type)) {
			exceptionMessage = buildExceptionMessage("", "menys", type, totalPaidStr, name);
			throw new Exception(exceptionMessage + maxSalary.get(type) + " per mes.");
		}
		return totalPaid;
	}

	private String buildExceptionMessage(String poc, String mesmenys, StaffMemberType type, String totalPaidStr,
			String name) {
		return "Error de Salari: Aquest empleat " + type.toString() + " (" + name + ") cobra massa " + poc + "! ("
				+ totalPaidStr + "). Ha de cobrar " + mesmenys + " de ";
	}
	
	private void checkGovAid(StaffMemberType type, double ajut, String name) throws Exception {
		String msg = "Error ajut: Un voluntari no pot rebre un ajut superior a " + govAids.get(type);
		if(ajut > govAids.get(type)) throw new Exception(msg);
	}

}
