package com.jobs.application;

import java.util.List;

import com.jobs.domain.AbsStaffMember;
import com.jobs.domain.Employee;
import com.jobs.domain.Volunteer;
import com.jobs.persistence.EmployeeRepository;

public class JobsController {

	private EmployeeRepository repository = new EmployeeRepository();
	
	public JobsController(){
		
	}
	
	public void createBossEmployee(String name, String address, String phone, double salaryPerMonth) throws Exception{		
		Employee boss = new Employee(name, address, phone,  salaryPerMonth, PaymentFactory.createPaymentRateBoss());
		repository.addMember(boss);
	}
	
	public void createEmployee(String name, String address, String phone, double salaryPerMonth) throws Exception{		
		Employee boss = new Employee(name, address, phone,  salaryPerMonth, PaymentFactory.createPaymentRateEmployee());
		repository.addMember(boss);
	}

	public void createManagerEmployee(String name, String address, String phone, double salaryPerMonth) throws Exception{
		Employee manager = new Employee(name, address, phone,  salaryPerMonth, PaymentFactory.createPaymentRateManager());
		repository.addMember(manager);
		
	}


	public void payAllEmployeers() {
		List<AbsStaffMember> members =repository.getAllMembers();
		for(AbsStaffMember member: members) {
			member.pay();
		}
	}

	public String getAllEmployees() {
		String result = "";
		for(AbsStaffMember member: repository.getAllMembers()) {
			result += member.toString() + "\n";
		}
		return result;
	}

	public void createVolunteer(String name, String address, String phone) throws Exception {
		Volunteer volunteer = new Volunteer(name,address,phone);
		repository.addMember(volunteer);
	}
	
	
	
}
