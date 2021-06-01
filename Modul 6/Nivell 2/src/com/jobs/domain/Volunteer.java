package com.jobs.domain;

public class Volunteer extends AbsStaffMember {
	protected String description;
	
	public Volunteer(String name, String address, String phone ) throws Exception {
		super(name, address, phone);
		description = "No cobra!";
		//TODO
	}

	
	@Override
	public void pay() {
		try {
			if(totalPaid > 0) {
				throw new Exception();
			}
		}catch(Exception e) {
			System.out.println("Los Voluntarios no pueden cobrar");
		}
	}
	public String toString() {
		
		return super.toString() + " description=" + description + " totalPaid=" + totalPaid;
	}
}
