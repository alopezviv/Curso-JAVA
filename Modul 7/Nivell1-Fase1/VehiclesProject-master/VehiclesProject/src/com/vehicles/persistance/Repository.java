package com.vehicles.persistance;
import java.util.ArrayList;
import java.util.List;
import com.vehicles.project.*;
public class Repository {
	public static List<Vehicle> vehicles = new ArrayList<>();
	public static List<Wheel> wheels = new ArrayList<>();
	public void addVehicle(Vehicle vehicle) {
		vehicles.add(vehicle);
	}
	public List<Vehicle> getVehicles(){
		return new ArrayList<>(vehicles);
	}
	public List<Wheel> getWheels(){
		return new ArrayList<>(wheels);
	}
	public void eliminateWheels() {
		wheels.clear();
	}
}
