package com.vehicles.view;

import java.util.Scanner;
import com.vehicles.application.Controller;
import java.util.List;
import java.time.LocalDate;
import java.util.ArrayList;

public class Main {
	public static Scanner sc = new Scanner(System.in);
	public static Controller controller = new Controller();
	public static int numPersonas = 0;
	public static int numVehicles = 0;
	public static void main(String[] args) {
		int optionMenu = 0;
		while(optionMenu != 5) {
			System.out.println("1 - Crear Vehiculo \n "
					+ "2 - Crear Titular \n"
					+ "3 - Crear conductor \n"
					+ "4 - Añadir conductor a Vehiculo \n"
					+ "5 - Salir");
			optionMenu = sc.nextInt();
			sc.nextLine();
			switch(optionMenu) {
				case 1:
					createVehicle();
					break;
				case 2:
					try {
					createTitular();
					}catch(Exception e) {
						System.out.println(e.getMessage());
					}
					break;
				case 3:
					try {
						createConductor();
					}catch(Exception e) {
						System.out.println(e.getMessage());
					}
					break;
				case 4:
					addConductorVehicle();
					break;
				case 5:
					break;
				default:
					System.out.println("Opción no vàlida");
			}
		}
			/*System.out.println("Es el titular el mismo que el conductor? 0 - No lo es ");
			int isTitularTheConductor = sc.nextInt();
			sc.nextLine();
			if(isTitularTheConductor == 0) {
				try {
					createConductor();
				}catch(Exception e) {
					System.out.println(e.getMessage());
				}
				tipoLicencia = controller.getLicencia(1);
				try {
				compruebaLicencia(optionVehicle, tipoLicencia);
				}catch(Exception e) {
					System.out.println(e.getMessage());
				}
			}/*/
			
		
		
		
	}
	public static void createCarnet() {
		//pide datos al usuario i llama al controller para crear un carnet
			System.out.println("ID carnet");
			int id = sc.nextInt();
			sc.nextLine();
			System.out.println("Tipo Carnet");
			char tipoCarnet = sc.next().charAt(0);
			sc.nextLine();
			System.out.println("Nombre completo");
			String nomCompleto = sc.nextLine();
			System.out.println("Introduce fecha de cadcidad:");
			System.out.println("A�o");
			int year = sc.nextInt();
			System.out.println("Mes");
			int month = sc.nextInt();
			System.out.println("Dia");
			int day = sc.nextInt();
			sc.nextLine();
			controller.createCarnet(id, tipoCarnet, nomCompleto, LocalDate.of(year,month,day) );
			
	}
	public static void createConductor() throws Exception{
		System.out.println("Nombre conductor");
		String name = sc.nextLine();
		System.out.println("Apellido");
		String lastName = sc.nextLine();
		System.out.println("A�o nacimiento");
		int year = sc.nextInt();
		System.out.println("Mes nacimiento");
		int month = sc.nextInt();
		System.out.println("Dia de nacimiento");
		int day = sc.nextInt();
		sc.nextLine();
		createCarnet();
		controller.createConductor(name, lastName,LocalDate.of(year,month,day));	
	}
	public static void createTitular() throws Exception{
		System.out.println("Nombre titular");
		String name = sc.nextLine();
		System.out.println("Apellido");
		String lastName = sc.nextLine();
		System.out.println("A�o nacimiento");
		int year = sc.nextInt();
		System.out.println("Mes nacimiento");
		int month = sc.nextInt();
		System.out.println("Dia de nacimiento");
		int day = sc.nextInt();
		sc.nextLine();
		createCarnet();
		boolean hasGarage;
		boolean hasInsurance;
		System.out.println("Tiene garage? 0-no, 1 -si");
		int garageOption = sc.nextInt();
		if(garageOption == 0) {
			hasGarage = false;
		}else if (garageOption == 1) {
			hasGarage = true;
		}else {
			throw new Exception("Opcion garage incorecta");
		}
		System.out.println("Tiene seguro? 0-no, 1 -si");
		int insuranceOption = sc.nextInt();
		if(insuranceOption == 0) {
			hasInsurance = false;
		}else if (insuranceOption == 1) {
			hasInsurance = true;
		}else {
			throw new Exception("Opcion Seguro incorecta");
		}
		
		controller.createTitular(name, lastName,LocalDate.of(year,month,day), hasGarage, hasInsurance);	
		}
	public static void compruebaLicencia(int optionVehicle, char tipoLicencia ) throws Exception {
		//Le pasamos la opcion de vehiculo a crear i el tipo de carnet. SI no es compatible lanza Excepcion
		if(tipoLicencia != 'a' && optionVehicle == 1 ) {
			throw new Exception("No tiene carnet de moto");
		}else if(tipoLicencia != 'b' && optionVehicle == 2) {
			throw new Exception("No tiene Carnet de coche");
		}else if(tipoLicencia != 'c' && optionVehicle == 3) {
			throw new Exception("No tiene carnet de Camion");
		}
	
	};
	public static void addConductorVehicle() {
		try {
			System.out.println("Dime nombre del conductor");
			String name = sc.nextLine();
			System.out.println("Dime apellido conductor");
			String lastName = sc.nextLine();
			int indexConductor = controller.getIndexPersona(name, lastName);
			if (indexConductor == -1) {
				throw new Exception("La persona no existe");
			}
			System.out.println("Dime la matricula del coche");
			String plate = sc.nextLine();
			int indexCoche = controller.getIndexVehiculo(plate);
			if (indexCoche == -1) {
				throw new Exception("El vehiculo no existe");
			}
			//Sacamos el tipo de carnet i el tipo numero de vehiculo para comprobar la licencia
			char tipoLicencia = controller.getLicencia(indexConductor);
			int tipoVehiculo = controller.getTipoVehiculo(indexCoche);
			compruebaLicencia(tipoVehiculo, tipoLicencia);
			controller.addConductorVehiculo(indexCoche, indexConductor);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public static void createVehicle() {
		System.out.println("Dime nombre del titular");
		String name = sc.nextLine();
		System.out.println("Dime apellido titular");
		String lastName = sc.nextLine();
		try {
			int index = controller.getIndexPersona(name, lastName);
			if (index == -1) {
				throw new Exception("El titular no existe");
			}
			System.out.println("Dime si es Coche, moto o camion:" + "\n"
					+ "1 - Moto" + "\n"
					+ "2 - Coche" +"\n"
					+ "3 - Camion");
			int optionVehicle = sc.nextInt();
			sc.nextLine();
			char tipoLicencia = controller.getLicencia(index);
			try {
				compruebaLicencia(optionVehicle, tipoLicencia);
				System.out.println("Dime la matricula");
				String plate = sc.nextLine();
				System.out.println("Dime la marca");
				String brand = sc.nextLine();
				System.out.println("Dime el color");
				String color = sc.nextLine();
				
				String marcaDelantera;
				double diametroDelantero;
				String marcaTrasera;
				double diametroTrasero;
				switch(optionVehicle) {
					case 1:
						try {
							controller.createBike(plate, brand, color);
							numVehicles++;
							}catch(Exception e){
								System.out.println(e.getMessage());
							}
							System.out.println("Marca ruedas delantera");
							 marcaDelantera = sc.nextLine();
							System.out.println("Diametro ruedas delanteras");
							 diametroDelantero = sc.nextDouble();
							sc.nextLine();
							System.out.println("Marca ruedas traseras");
							marcaTrasera = sc.nextLine();	
							System.out.println("Diametro ruedas traseras");
							diametroTrasero = sc.nextDouble();
							sc.nextLine();
							try {
							controller.createWheel(marcaDelantera, diametroDelantero);
							
							controller.createWheel(marcaTrasera, diametroTrasero);
							}catch(Exception e) {
								System.out.println("Tama�o de la rueda incorrecto");
							}
							try {
							controller.addWheelsBike(0);
							}catch(Exception e) {
								System.out.println("Ruedas incorrectas");
							}
							break;
					case 2:
						try {
							controller.createCar(plate, brand, color);
							numVehicles++;
							}catch(Exception e){
								System.out.println(e.getMessage());
							}
							System.out.println("Marca ruedas delantera");
							marcaDelantera = sc.nextLine();
							System.out.println("Diametro ruedas delanteras");
							diametroDelantero = sc.nextDouble();
							sc.nextLine();
							System.out.println("Marca ruedas traseras");
							marcaTrasera = sc.nextLine();	
							System.out.println("Diametro ruedas traseras");
							diametroTrasero = sc.nextDouble();
							sc.nextLine();
							try {
							controller.createWheel(marcaDelantera, diametroDelantero);
							controller.createWheel(marcaDelantera, diametroDelantero);
							controller.createWheel(marcaTrasera, diametroTrasero);
							controller.createWheel(marcaTrasera, diametroTrasero);
							}catch(Exception e) {
								System.out.println("Tama�o de la rueda incorrecto");
							}
							try {
							controller.addWheelsCar(0);
							}catch(Exception e) {
								System.out.println("Ruedas incorrectas");
							}
							break;
					case 3:
						try {
							controller.createTruck(plate, brand, color);
							numVehicles++;
							}catch(Exception e){
								System.out.println(e.getMessage());
							}
							System.out.println("Marca ruedas delantera");
							marcaDelantera = sc.nextLine();
							System.out.println("Diametro ruedas delanteras");
							diametroDelantero = sc.nextDouble();
							sc.nextLine();
							System.out.println("Marca ruedas traseras");
							marcaTrasera = sc.nextLine();	
							System.out.println("Diametro ruedas traseras");
							diametroTrasero = sc.nextDouble();
							sc.nextLine();
							try {
							controller.createWheel(marcaDelantera, diametroDelantero);
							controller.createWheel(marcaDelantera, diametroDelantero);
							controller.createWheel(marcaTrasera, diametroTrasero);
							controller.createWheel(marcaTrasera, diametroTrasero);
							}catch(Exception e) {
								System.out.println("Tama�o de la rueda incorrecto");
							}
							try {
							controller.addWheelsTruck(0);
							}catch(Exception e) {
								System.out.println("Ruedas incorrectas");
							}
							break;
					default:
						System.out.println("Opcion no valida");
				}
				controller.addTitularVehiculo(index);
				}catch(Exception e) {
					System.out.println(e.getMessage());
				}
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
		}	
}
