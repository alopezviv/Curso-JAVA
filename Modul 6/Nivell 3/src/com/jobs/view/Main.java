package com.jobs.view;

import com.jobs.application.JobsController;

public class Main {

	
	
	private static JobsController controller=new JobsController();
	
	public static void main(String[] args) throws Exception {
		try {
		controller.createBossEmployee("Pepe Boss", "Direccion molona", "666666666", 4100.0);
		controller.createJunior("Pedro Junior", "Direccion molona 2", "665266666", 1200);
		controller.createMid("Laura Mid", "Direccion molona 3", "625266666", 2000);
		controller.createSenior("Manuel Senior", "Direccion molona 3", "625266666", 2950);
		controller.createVolunteer("Juan Volunteer", "Direccion molona 4", "614266666",100);
		controller.createManagerEmployee("Pedro Manager", "Direccion molona 5", "665226666", 3900);
		}catch(Exception e){
			System.out.println("Ha habido un error");
		}
		
		controller.payAllEmployeers();
		
		String allEmployees=controller.getAllEmployees();
		
		System.out.println("EMPLOYEES: " + allEmployees + " \n");
		
		controller.payAllEmployeesBonus();
		
		allEmployees=controller.getAllEmployees();
		
		System.out.println("EMPLOYEES: " + allEmployees + " \n");
		
	}

}
