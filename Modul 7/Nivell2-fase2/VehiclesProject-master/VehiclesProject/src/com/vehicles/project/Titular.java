package com.vehicles.project;

import java.util.Date;

public class Titular extends Conductor {
	private boolean hasGarage;
	private boolean hasInsurance;
	public Titular(String name, String lastName, Date birthDate, Carnet carnetConducir,boolean hasGarage, boolean hasInsurance) {
		super(name, lastName, birthDate, carnetConducir);
		this.hasGarage = hasGarage;
		this.hasInsurance = hasInsurance;
	}
}
