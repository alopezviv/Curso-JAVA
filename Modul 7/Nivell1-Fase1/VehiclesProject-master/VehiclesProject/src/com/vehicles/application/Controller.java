package com.vehicles.application;
import com.vehicles.project.*;
import com.vehicles.persistance.*;
import java.util.List;
import java.util.ArrayList;
public class Controller {
	public static Repository baseDades = new Repository();
	public void createCar(String plate, String brand, String color) {
		//creem coche i l'afegim al repository
		Car car = new Car(plate,brand,color);
		baseDades.addVehicle(car);
	}
	public void createWheel(String brand, double diametro) {
		Wheel wheel = new Wheel (brand,diametro);
		baseDades.addWheel(wheel);
	}
	
	public void addWheelsCar(int i) throws Exception{
		//Agafem el coche concret amb el index fent casting
		
		Car car =(Car)baseDades.getVehicles().get(i);
		
		List<Wheel> wheels1 = new ArrayList<>();
		List<Wheel> wheels2 = new ArrayList<>();
		//Afegim les 4 rodes que haurem creat i afegiy a la llista
		//Dos a devant i dos a derrere
		wheels1.add(baseDades.getWheels().get(0));
		wheels1.add(baseDades.getWheels().get(1));
		wheels2.add(baseDades.getWheels().get(2));
		wheels2.add(baseDades.getWheels().get(3));

		car.addWheels(wheels1, wheels2);
		//Eliminem les rodes de la llista per si hem de crear un altre vehicle afegir les noves
		baseDades.eliminateWheels();
	}
}
