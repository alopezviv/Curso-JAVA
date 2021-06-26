package com.video.view;

import java.util.Scanner;

import com.video.application.Controller;

public class AppMain {
	public static Controller controller = new Controller();
	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		
		int option = 0;
		while(option != 3) {
			System.out.println("1-Crear Usuario \n2-Login Usuario \n3-Salir" );
			option = sc.nextInt();
			sc.nextLine();
			switch(option) {
				case 1:
					createUsuari();
					break;
				case 2:
					loginUsuari();
					break;
				case 3:
					break;
				default:
					System.out.println("Opcion no permitida");
			}
		}
	}
	

public static void createUsuari() {
	String name;
	String lastName;
	String password;
	System.out.println("Dime nombre");
	name = sc.nextLine();
	System.out.println("Dime apellido");
	lastName = sc.nextLine();
	System.out.println("Dime contraseña");
	password = sc.nextLine();
	try {
		controller.createUsuari(name, lastName, password);
	}catch(Exception e) {
		e.printStackTrace();
	}
}
public static void loginUsuari()  {
	//primero comprueba si el usuario existe, si existe desplega un menu con opciones.
	String name;
	String password;
	System.out.println("Dime nombre");
	name = sc.nextLine();
	System.out.println("Dime contraseña");
	password = sc.nextLine();
	int index = controller.getIndexUsuari(name, password);
	if(index == -1) {
		System.out.println("El usuario no existe");
	}else {
		int option = 0;
		while(option != 4) {
			System.out.println("1-Ver Videos Usuario \n"
					+ "2-Crear Video \n"
					+ "3-Acceder Video \n"
					+ "4 Salir ");
			option = sc.nextInt();
			sc.nextLine();
			switch(option) {
			case 1:
				System.out.println(controller.getUsuari(index).viewVideos());
				break;
			case 2:
				createVideo(index);
				break;
			case 3:
				videoFunctions(index);
				
				break;
			case 4:
				break;	
			default:
				System.out.println("Opcion no permitida");
		}
		}
	}	
}
public static void createVideo(int index) {
	String name;
	String URL;
	int duracion;
	System.out.println("Dime nombre");
	name = sc.nextLine();
	System.out.println("Dime url");
	URL = sc.nextLine();
	System.out.println("Dime duracion en segundos");
	duracion = sc.nextInt();
	sc.nextLine();
	try {
		controller.getUsuari(index).createVideo(name, URL, duracion);
	}catch(Exception e) {
		e.printStackTrace();
	}
	
}
public static void videoFunctions(int index) {
	System.out.println("Escoge numero de video");
	System.out.println(controller.getUsuari(index).viewVideos());
	int numVideo = sc.nextInt();
	System.out.println("1 - Reproducir \n 2-Pausar \n 3 Stop");
	int option = sc.nextInt();
	switch(option) {
		case 1:
			try {
			controller.getUsuari(index).getVideo(numVideo).startVideo();
			}catch(Exception e) {
				e.printStackTrace();
			}
			break;
		case 2:
			try {
			controller.getUsuari(index).getVideo(numVideo).pauseVideo();
			}catch(Exception e) {
				e.printStackTrace();
			}
			break;
		case 3:
			try {
			controller.getUsuari(index).getVideo(numVideo).stopVideo();
			}catch(Exception e) {
				e.printStackTrace();
			}
			break;
		default:
			System.out.println("Opcion no valida");
	}
}


}