package com.jobs.application;
import com.jobs.domain.*;
import java.util.List;


import com.jobs.persistence.EmployeeRepository;

public class JobsController {

	private EmployeeRepository repository = new EmployeeRepository();
	
	public JobsController(){
		
	}
	
	public void createBossEmployee(String name, String address, String phone, double salaryPerMonth) throws Exception{		
		Employee boss = new Employee(name, address, phone,  salaryPerMonth, PaymentFactory.createPaymentRateBoss());
		repository.addMember(boss);
	}
	
	public void createJunior(String name, String address, String phone, double salaryPerMonth) throws Exception{		
		Junior junior = new Junior(name, address, phone,  salaryPerMonth, PaymentFactory.createPaymentRateJunior());
		repository.addMember(junior);
	}
	public void createMid(String name, String address, String phone, double salaryPerMonth) throws Exception{		
		Mid mid = new Mid(name, address, phone,  salaryPerMonth, PaymentFactory.createPaymentRateMid());
		repository.addMember(mid);
	}
	public void createSenior(String name, String address, String phone, double salaryPerMonth) throws Exception{		
		Senior senior = new Senior(name, address, phone,  salaryPerMonth, PaymentFactory.createPaymentRateSenior());
		repository.addMember(senior);
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
