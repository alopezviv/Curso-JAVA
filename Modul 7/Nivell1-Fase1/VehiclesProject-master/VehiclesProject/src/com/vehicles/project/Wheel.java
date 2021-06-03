package com.vehicles.project;

public class Wheel {
	private String brand;
	private double diameter;

	public Wheel(String brand, double diameter) {
		this.brand = brand;
		this.diameter = diameter;
	}
	public boolean equals(Wheel wheel) {
		//Override per comparar les wheels com nosaltres volem
		boolean result = false;
		if(brand.equals(wheel.brand) && diameter == wheel.diameter) {
			result = true;
		}
		return result;
	}
}
