package com.vehicles.project;

public class Bike extends Vehicle {

	public Bike(String plate, String brand, String color) {
		super(plate, brand, color);
	}
	public void addWheels(Wheel wheel1,Wheel wheel2) {
		this.wheels.add(wheel1);
		this.wheels.add(wheel2);
	}

}
