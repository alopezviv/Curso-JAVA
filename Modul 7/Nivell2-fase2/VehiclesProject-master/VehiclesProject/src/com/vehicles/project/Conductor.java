package com.vehicles.project;

import java.util.Date;

public class Conductor extends Persona{
	private Carnet carnetConducir;
	public Conductor(String name, String lastName, Date birthDate, Carnet carnetConducir) {
		super(name, lastName, birthDate);
		this.carnetConducir = carnetConducir;
	}
}
