package com.vehicles.project;

import java.time.LocalDate;


public class Persona {
	private String name;
	private String lastName;
	private LocalDate birthDate;
	
	public Persona(String name, String lastName, LocalDate birthDate) {
		this.name = name;
		this.lastName = lastName;
		this.birthDate = birthDate;
	}
	public String getName() {
		return name;
	}
	public String getLastName() {
		return lastName;
	}
}
