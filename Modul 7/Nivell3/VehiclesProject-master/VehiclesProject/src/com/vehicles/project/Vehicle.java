package com.vehicles.project;

import java.util.ArrayList;
import java.util.List;

public abstract class Vehicle {
	protected Titular titular;
	protected List<Conductor> conductores;
	protected String plate;
	protected String brand;
	protected String color;
	protected List<Wheel> wheels = new ArrayList<Wheel>();

	public Vehicle(String plate, String brand, String color) {
		this.plate = plate;
		this.brand = brand;
		this.color = color;
		conductores = new ArrayList<Conductor>();
	}
	public String getPlate() {
		return plate;
	}
	public void setTitular(Titular titular){
		this.titular = titular;
	}
	public void addConductor(Conductor conductor) {
		conductores.add(conductor);
	}
}
