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
		controller.createCar(plate, brand, color);
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
		controller.createWheel(marcaDelantera, diametroDelantero);
		controller.createWheel(marcaDelantera, diametroDelantero);
		controller.createWheel(marcaTrasera, diametroTrasero);
		controller.createWheel(marcaTrasera, diametroTrasero);
		try {
		controller.addWheelsCar(0);
		}catch(Exception e) {
			System.out.println("Ruedas incorrectas");
		}
		

	}

}
