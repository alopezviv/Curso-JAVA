package com.video.domain;

import java.time.LocalDate;

public class Usuari {
	private String name;
	private String lastName;
	private String password;
	private LocalDate registerDate;
	
	
	public Usuari(String name, String lastName, String password) {
		setName(name);
		setLastName(lastName);
		setPassword(password);
		registerDate = LocalDate.now();
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRegisterDate() {
		return registerDate.toString();
	}
	
	
	
	
	
}
