package com.vehicles.view;
import java.util.Scanner;
import com.vehicles.application.Controller;
import java.util.List;
import java.util.ArrayList;
public class Main {
	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		Controller controller = new Controller();
		System.out.println("Dime la matricula");
		String plate = sc.nextLine();
		System.out.println("Dime la marca");
		String brand = sc.nextLine();
		System.out.println("Dime el color");
		String color = sc.nextLine();
		System.out.println("Dime si es Coche o moto" + "\n"
				+ "1 - Moto" + "\n"
				+ "2-Coche");
		int option = sc.nextInt();
		sc.nextLine();
		if(option == 2) {
			try {
			controller.createCar(plate, brand, color);
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
			System.out.println("Marca ruedas delantera");
			String marcaDelantera = sc.nextLine();
			System.out.println("Diametro ruedas delanteras");
			double diametroDelantero = sc.nextDouble();
			sc.nextLine();
			System.out.println("Marca ruedas traseras");
			String marcaTrasera = sc.nextLine();	
			System.out.println("Diametro ruedas traseras");
			double diametroTrasero = sc.nextDouble();
			sc.nextLine();
			try {
			controller.createWheel(marcaDelantera, diametroDelantero);
			controller.createWheel(marcaDelantera, diametroDelantero);
			controller.createWheel(marcaTrasera, diametroTrasero);
			controller.createWheel(marcaTrasera, diametroTrasero);
			}catch(Exception e) {
				System.out.println("Tamaño de la rueda incorrecto");
			}
			try {
			controller.addWheelsCar(0);
			}catch(Exception e) {
				System.out.println("Ruedas incorrectas");
			}
		}else if(option == 1) {
			try {
				controller.createBike(plate, brand, color);
				}catch(Exception e){
					System.out.println(e.getMessage());
				}
				System.out.println("Marca ruedas delantera");
				String marcaDelantera = sc.nextLine();
				System.out.println("Diametro ruedas delanteras");
				double diametroDelantero = sc.nextDouble();
				sc.nextLine();
				System.out.println("Marca ruedas traseras");
				String marcaTrasera = sc.nextLine();	
				System.out.println("Diametro ruedas traseras");
				double diametroTrasero = sc.nextDouble();
				sc.nextLine();
				try {
				controller.createWheel(marcaDelantera, diametroDelantero);
				
				controller.createWheel(marcaTrasera, diametroTrasero);
				}catch(Exception e) {
					System.out.println("Tamaño de la rueda incorrecto");
				}
				try {
				controller.addWheelsBike(0);
				}catch(Exception e) {
					System.out.println("Ruedas incorrectas");
				}
		}else {
			System.out.println("Opcion incorrecta");
		}

	}

}
