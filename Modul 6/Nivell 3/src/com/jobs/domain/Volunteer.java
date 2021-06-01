package com.jobs.domain;

public class Volunteer extends AbsStaffMember {
	protected String description;
	
	public Volunteer(String name, String address, String phone, double totalPaid ) throws Exception {
		super(name, address, phone);
		description = "No cobra!";
		this.totalPaid = totalPaid;
	}

	
	@Override
	public void pay() {
		try {
			if(totalPaid > 300) {
				throw new Exception();
			}
		}catch(Exception e) {
			System.out.println("Los Voluntarios no pueden cobrar tantas ayudas");
			totalPaid =0;
		}
		if(totalPaid > 0) {
			description = "El Voluntario recibe una ayuda";
		}
	}
	public void payBonus() { 
		
		//El metodo no hace nada ya que asumo que los voluntarios no pueden cobrar el bonus.
	}

	public String toString() {
		
		return super.toString() + " description=" + description + " totalPaid=" + totalPaid;
	}
}
