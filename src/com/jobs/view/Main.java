package com.jobs.view;

import com.jobs.application.JobsController;
import com.jobs.application.SalariesController;
import com.jobs.persistence.EmployeeRepository;
import com.jobs.persistence.EmployeeRepository.StaffMemberType;

public class Main {

	private static EmployeeRepository repo;
	
	static {
		repo = new EmployeeRepository();
	}
		
	// private static JobsController controller=new JobsController();
	//És millor injectar el repository (DI)
	//així és més fàcil adaptar el codi al canvi de repo
	private static JobsController jobsController = 
			new JobsController(repo);
	
	private static SalariesController salariesController =
			new SalariesController(repo);

	public static void main(String[] args) throws Exception {

		//Abans de crear els empleats, assignem a cada
		//tipus d'empleat les seves dades de pagaments
		//rates
		salariesController.storeBossPaymentRate(1.5);
		salariesController.storeManagerPaymentRate(1.1);
		salariesController.storeJuniorPaymentRate(0.85);
		salariesController.storeMidPaymentRate(0.9);
		salariesController.storeSeniorPaymentRate(0.95);
		
		//max salaries
		//Boss no té màxim
		salariesController.storeManagerMaxSalary(5000.0);
		salariesController.storeJuniorMaxSalary(1600.0);
		salariesController.storeMidMaxSalary(2500.0);
		salariesController.storeSeniorMaxSalary(4000.0);
		
		//Ajuda màxima voluntaris
		salariesController.storeVolunteerMaxGovAid(300.0);
		
		//min salaries
		salariesController.storeBossMinSalary(8000.0);
		salariesController.storeManagerMinSalary(3000.0);
		salariesController.storeJuniorMinSalary(900.0);
		salariesController.storeMidMinSalary(1800.0);
		salariesController.storeSeniorMinSalary(2700.0);
		
		//irpfs
		salariesController.storeBossIrpf(0.32);
		salariesController.storeManagerIrpf(0.26);
		salariesController.storeJuniorIrpf(0.02);
		salariesController.storeMidIrpf(0.15);
		salariesController.storeSeniorIrpf(0.24);
		
		//Un cop guardats tots els valors de Payment dades
		//actualitzem les còpies a JobsController
		jobsController.updateSalariesData();
		
		//Creació d'instàncies amb valors correctes de sous nets
		jobsController.createBossEmployee("Pepe Boss", "Dirección molona", "666666666", 8100.0);
		jobsController.createManagerEmployee("Pedro Employee", "Dirección molona 2", "665226666", 4490.0);
		jobsController.createJuniorEmployee("Jordi Junior", "Adreça acollonant", "333333333", 1200.0);
		jobsController.createMidEmployee("Mateu Mid", "Adreça acollonant 2", "111111111", 2100.0);
		jobsController.createSeniorEmployee("Sergi Senior", "Adreça acollonant 3", "444444444", 3900.0);
		//2 voluntaris, un sense ajut i un amb un ajut no superior a 300
		jobsController.createVolunteer("Juan Volunteer", "Dirección molona 4", "614266666");
		jobsController.createVolunteer("Jan Voluntari", "Adreça flipant 4", "614266666", 100);
		
		//Creació d'instàncies amb valors incorrectes de sous nets o ajuts
		jobsController.createBossEmployee("Claudia Boss", "Adreça flipant", "666666666", 3500.0);
		jobsController.createManagerEmployee("Leyla Manager", "Dirección molona 2", "665226666", 6000.0);
		jobsController.createJuniorEmployee("Pepet Junior", "Adreça acollonant", "333333333", 700.0);
		jobsController.createMidEmployee("Popeye Mid", "Adreça acollonant 2", "111111111", 1500.0);
		jobsController.createSeniorEmployee("Quimet Senior", "Adreça acollonant 3", "444444444", 9000.0);
		jobsController.createVolunteer("Tatiana Voluntaria", "Adreça flipant 5", "674266386", 400);
		
		
		jobsController.payAllEmployeers();

		String allEmployees = jobsController.getAllEmployees();

		System.out.println("EMPLOYEES: \n" + allEmployees + " \n");

	}

}
