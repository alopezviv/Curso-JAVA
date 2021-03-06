package com.vehicles.application;
import com.vehicles.project.*;
import com.vehicles.persistance.*;
import java.util.List;
import java.util.ArrayList;
public class Controller {
	public static Repository baseDades = new Repository();
	public void createCar(String plate, String brand, String color) throws Exception{
		//Validacio de matricula
		if(plate.length() < 6 || plate.length() > 7) {
			throw new Exception("Es massa llarg o massa curt");
		}
		String numeros = plate.substring(0,4);
		String lletres = plate.substring(4);
		if(contarNumerosString(lletres)!=0) {
			throw new Exception("Hi ha numeros on les lletres");
		}
		if(lletres.length() < 2 || lletres.length() > 3) {
			throw new Exception("Masses lletres");
		}
		if(contarNumerosString(numeros) != numeros.length()) {
			//Aixo ho fem per comprovar que tot siguin numeros 
			throw new Exception("Hi ha lletres on els numeros");
		}
		//creem coche i l'afegim al repository
		Car car = new Car(plate,brand,color);
		baseDades.addVehicle(car);
	}
	public void createWheel(String brand, double diametro) throws Exception{
		//Validació de les dades
		
		if (diametro < 0.4 || diametro > 4) {
			throw new Exception();
		}
		

		
		//Creacio de la roda i afegim al repositori
		Wheel wheel = new Wheel (brand,diametro);
		baseDades.addWheel(wheel);
	}
	
	public void addWheelsCar(int i) throws Exception{
		//Agafem el coche concret amb el index fent casting
		
		Car car =(Car)baseDades.getVehicles().get(i);
		
		List<Wheel> wheels1 = new ArrayList<Wheel>();
		List<Wheel> wheels2 = new ArrayList<Wheel>();
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
	public static int contarNumerosString(String s) {
		//Conta quants numeros hi ha en un string
		int result = 0;
		char [] charArr = s.toCharArray();
		for(char c: charArr) {
			if(Character.isDigit(c)) {
				result++;
			}
		}
		
		return result;
	}
}
