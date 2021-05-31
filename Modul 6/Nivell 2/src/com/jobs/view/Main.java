package com.jobs.view;

import com.jobs.application.JobsController;

public class Main {

	
	
	private static JobsController controller=new JobsController();
	
	public static void main(String[] args) throws Exception {
		try {
		controller.createBossEmployee("Pepe Boss", "Direccion molona", "666666666", 100.0);
		controller.createEmployee("Pedro Employee", "Direccion molona 2", "665266666", 40.0);
		controller.createEmployee("Laura Employee", "Direccion molona 3", "625266666", 45.0);
		controller.createVolunteer("Juan Volunteer", "Direccion molona 4", "614266666");
		controller.createManagerEmployee("Pedro Manager", "Direccion molona 5", "665226666", 80.0);
		}catch(Exception e){
			System.out.println("Ha habido un error");
		}
		
		controller.payAllEmployeers();
		
		String allEmployees=controller.getAllEmployees();
		
		System.out.println("EMPLOYEES: " + allEmployees + " \n");
		
	}

}
