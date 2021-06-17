package com.vehicles.persistance;
import java.util.ArrayList;
import java.util.List;
import com.vehicles.project.*;
public class Repository {
	public static List<Vehicle> vehicles = new ArrayList<>();
	public static List<Wheel> wheels = new ArrayList<>();
	public static List<Persona> personas = new ArrayList<>();
	public static List<Carnet> carnets = new ArrayList<>();
	public void addVehicle(Vehicle vehicle) {
		vehicles.add(vehicle);
	}
	public List<Vehicle> getVehicles(){
		return vehicles;
	}
	public void addWheel(Wheel wheel) {
		wheels.add(wheel);
	}
	public List<Wheel> getWheels(){
		return new ArrayList<>(wheels);
	}
	public void eliminateWheels() {
		wheels.clear();
	}
	public void addPersona(Persona persona) {
		personas.add(persona);
	}
	public List<Persona> getPersonas(){
		return personas;
	}
	public void addCarnet(Carnet carnet) {
		carnets.add(carnet);
	}
	public void eliminateCarnets() {
		carnets.clear();
	}
	public List<Carnet> getCarnets(){
		return new ArrayList<>(carnets);
	}
}
