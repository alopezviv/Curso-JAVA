package com.vehicles.application;
import com.vehicles.project.*;
import com.vehicles.persistance.*;
import java.util.List;
import java.time.LocalDate;
import java.util.ArrayList;
public class Controller {
	public static Repository baseDades = new Repository();
	public void createCar(String plate, String brand, String color) throws Exception{
		//Validacio de matricula
		compruebaMatricula(plate);
		//creem coche i l'afegim al repository
		Car car = new Car(plate,brand,color);
		baseDades.addVehicle(car);
	}
	public void createBike(String plate, String brand, String color) throws Exception{
		//Validacio de matricula
		compruebaMatricula(plate);
		//Creem moto i la afegim al repository
		Bike bike = new Bike(plate, brand, color);
		baseDades.addVehicle(bike);
	}
	public void createTruck(String plate, String brand, String color) throws Exception{
		//Validacio de matricula
		compruebaMatricula(plate);
		//Creem camio i l'afegim al repository
		Truck camion = new Truck(plate, brand, color);
		baseDades.addVehicle(camion);
	}
	public void createWheel(String brand, double diametro) throws Exception{
		//Validaci� de les dades
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
	public void addWheelsBike(int i) {
		Bike bike = (Bike)baseDades.getVehicles().get(i);
		bike.addWheels(baseDades.getWheels().get(0), baseDades.getWheels().get(1));
		baseDades.eliminateWheels();
	}
	public void addWheelsTruck(int i) throws Exception{
		//Agafem el coche concret amb el index fent casting
		
		Truck truck =(Truck)baseDades.getVehicles().get(i);
		
		List<Wheel> wheels1 = new ArrayList<Wheel>();
		List<Wheel> wheels2 = new ArrayList<Wheel>();
		//Afegim les 4 rodes que haurem creat i afegiy a la llista
		//Dos a devant i dos a derrere
		wheels1.add(baseDades.getWheels().get(0));
		wheels1.add(baseDades.getWheels().get(1));
		wheels2.add(baseDades.getWheels().get(2));
		wheels2.add(baseDades.getWheels().get(3));

		truck.addWheels(wheels1, wheels2);
		//Eliminem les rodes de la llista per si hem de crear un altre vehicle afegir les noves
		baseDades.eliminateWheels();
	}
	public void createTitular(String name, String lastName, LocalDate birthDate, boolean hasGarage, boolean hasInsurance) {
		//Agafem el carnet del que hem introduit a la llista
		Carnet carnetConducir = baseDades.getCarnets().get(0);
		Titular titular = new Titular(name, lastName, birthDate, carnetConducir, hasGarage, hasInsurance);
		//Borrem la llista de carnets de manera qe el index 0 sempre sigui el ultim introduit
		//Fem aixo ja que la llista de carnets la fem servir nomes de base de dades temporal, despers el guardem dintre de cada persona
		baseDades.addPersona(titular);
		baseDades.eliminateCarnets();
	}
	public void createConductor(String name, String lastName, LocalDate birthDate) {
		Carnet carnetConducir = baseDades.getCarnets().get(0);
		Conductor conductor = new Conductor(name, lastName, birthDate, carnetConducir);
		baseDades.addPersona(conductor);
		baseDades.eliminateCarnets();
	}
	public void createCarnet(int id, char tipo, String nom, LocalDate date) {
		Carnet carnet = new Carnet(id,tipo,nom,date);
		baseDades.addCarnet(carnet);
	}
	public  char getLicencia(int i){
		//le pasamos el index donde se encuentra la persona i devolvemos su tipo de licencia
		Conductor c = (Conductor)baseDades.getPersonas().get(i);
		char licencia = c.getCarnet().getTipoCarnet();
		return licencia;
	}
	public int getIndexPersona(String name, String lastName)  {
		// Le pasamos el nombre y apellido del titular y busca si esta dado de alta
		// retorna el index si lo encuentra y en caso negatico retorna -1
		int f = -1;
		List<Persona> personas = baseDades.getPersonas();
		for(int i = 0; i < personas.size(); i++) {
			if(personas.get(i).getName().equals(name) && personas.get(i).getLastName().equals(lastName)) {
				f = i;
			}
		}
		return f;
	}
	public int getIndexVehiculo(String plate) {
		//Devuelve el index del vehiculo en el array si no esta devuelve -1
		int f = -1;
		List<Vehicle> vehicles = baseDades.getVehicles();
		for(int i = 0; i < vehicles.size(); i++) {
			if(vehicles.get(i).getPlate().equals(plate) ) {
				f = i;
			}
		}
		return f;
	
	}
	public void addTitularVehiculo(int i) {
		//Añade titular al vehiculo que se acaba de crear.
		List<Vehicle> vehicles = baseDades.getVehicles();
		Vehicle vehiculo = vehicles.get(vehicles.size()-1);
		vehiculo.setTitular((Titular)baseDades.getPersonas().get(i));
	}
	public int getTipoVehiculo(int index) {
		int result = 0;
		Vehicle vehicle = baseDades.getVehicles().get(index);
		if (vehicle instanceof Bike) {
			result = 1;
		}else if(vehicle instanceof Car) {
			result = 2;
		}else if(vehicle instanceof Truck) {
			result = 3;
		}
		return result;
	}
	public void addConductorVehiculo(int indexVehiculo, int indexConductor) {
		//passamos el index del conductor i del vehiculo i añadimos el conductor a la lista del vehiculo
		Vehicle vehicle = baseDades.getVehicles().get(indexVehiculo);
		Conductor conductor = (Conductor)baseDades.getPersonas().get(indexConductor);
		vehicle.addConductor(conductor);
	}
	public static void compruebaMatricula(String plate) throws Exception{
		//Valida si la matricula es correcta, en cas de no sero tira una Exception
		
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
