package com.vehicles.project;

import java.time.LocalDate;


public class Conductor extends Persona{
	private Carnet carnetConducir;
	public Conductor(String name, String lastName, LocalDate birthDate, Carnet carnetConducir) {
		super(name, lastName, birthDate);
		this.carnetConducir = carnetConducir;
	}
	public Carnet getCarnet() {
		return this.carnetConducir;
	}
}
