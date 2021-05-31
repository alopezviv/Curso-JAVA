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
		totalPaid = 0;
		
	}
	public String toString() {
		
		return super.toString() + " description=" + description + " totalPaid=" + totalPaid;
	}
}
