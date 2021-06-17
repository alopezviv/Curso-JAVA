package com.vehicles.project;

import java.time.LocalDate;


public class Titular extends Conductor {
	private boolean hasGarage;
	private boolean hasInsurance;
	public Titular(String name, String lastName, LocalDate birthDate, Carnet carnetConducir,boolean hasGarage, boolean hasInsurance) {
		super(name, lastName, birthDate, carnetConducir);
		this.hasGarage = hasGarage;
		this.hasInsurance = hasInsurance;
	}
	
	
}
