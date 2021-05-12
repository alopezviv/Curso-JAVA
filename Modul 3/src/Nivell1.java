import java.util.Scanner;
import java.util.Arrays;
public class Nivell1 {
	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		//FASE 1
		System.out.println("Fase 1");
		//Declarem variables
		String ciudad1;
		String ciudad2;
		String ciudad3;
		String ciudad4;
		String ciudad5;
		String ciudad6;
		//Assignem variables amb input del usuari
		System.out.println("Dime un nombre de ciudad");
		ciudad1 = sc.nextLine();
		System.out.println("Dime un nombre de ciudad");
		ciudad2 = sc.nextLine();
		System.out.println("Dime un nombre de ciudad");
		ciudad3 = sc.nextLine();
		System.out.println("Dime un nombre de ciudad");
		ciudad4 = sc.nextLine();
		System.out.println("Dime un nombre de ciudad");
		ciudad5 = sc.nextLine();
		System.out.println("Dime un nombre de ciudad");
		ciudad6 = sc.nextLine();
		System.out.println(ciudad1 + ", " + ciudad2 + ", " + ciudad3 + ", " + ciudad4 + ", " + ciudad5 + ", " + ciudad6);
		//Fase 2
		System.out.println("Fase 2");
		String[] ciudades = {ciudad1,ciudad2,ciudad3,
				ciudad4,ciudad5,ciudad6}; 
		Arrays.sort(ciudades);
		System.out.println("Ciutats per ordre alfabètic");
		System.out.println(Arrays.toString(ciudades));
		//Fase 3 
		System.out.println("Fase 3");
		String[] ciudadesModificadas = new String[6];
		for(int i = 0; i < ciudades.length; i++) {
			String ciudad = ciudades[i];
			for(int j = 0; j < ciudad.length() ; j++ ) {
				if(ciudad.charAt(j) == 'a') {
					if(j == ciudad.length() - 1) {
						ciudad = ciudad.substring(0, j) + "4";
					}else{
						
						ciudad = ciudad.substring(0, j) + "4" + ciudad.substring(j+1) ;
						
					}
					
				}
				
			}
			ciudadesModificadas[i] = ciudad;
		}
		System.out.println("Ciutats modificades per ordre alfabètic");
		System.out.println(Arrays.toString(ciudadesModificadas));
		//Fase 4
		System.out.println("Fase 4");
		//Declarem arrays
		char[] charCiudad1 = new char[ciudad1.length()];
		char[] charCiudad2 = new char[ciudad2.length()];
		char[] charCiudad3 = new char[ciudad3.length()];
		char[] charCiudad4 = new char[ciudad4.length()];
		char[] charCiudad5 = new char[ciudad5.length()];
		char[] charCiudad6 = new char[ciudad6.length()];
		//Omplim els arrays de valors
		for(int i = 0 ; i < ciudad1.length(); i++) {
			charCiudad1[i] = ciudad1.charAt(i);
		}
		for(int i = 0 ; i < ciudad2.length(); i++) {
			charCiudad2[i] = ciudad2.charAt(i);
		}
		for(int i = 0 ; i < ciudad3.length(); i++) {
			charCiudad3[i] = ciudad3.charAt(i);
		}
		for(int i = 0 ; i < ciudad4.length(); i++) {
			charCiudad4[i] = ciudad4.charAt(i);
		}
		for(int i = 0 ; i < ciudad5.length(); i++) {
			charCiudad5[i] = ciudad5.charAt(i);
		}
		for(int i = 0 ; i < ciudad6.length(); i++) {
			charCiudad6[i] = ciudad6.charAt(i);
		}
		//Imprimim les ciutats al reves
		for(int i = ciudad1.length()-1 ; i>=0; i--) {
			System.out.print(charCiudad1[i]);
		}
		System.out.println();
		for(int i = ciudad2.length()-1 ; i>=0; i--) {
			System.out.print(charCiudad2[i]);
		}
		System.out.println();
		for(int i = ciudad3.length()-1 ; i>=0; i--) {
			System.out.print(charCiudad3[i]);
		}
		System.out.println();
		for(int i = ciudad4.length()-1 ; i>=0; i--) {
			System.out.print(charCiudad4[i]);
		}
		System.out.println();
		for(int i = ciudad5.length()-1 ; i>=0; i--) {
			System.out.print(charCiudad5[i]);
		}
		System.out.println();
		for(int i = ciudad6.length()-1 ; i>=0; i--) {
			System.out.print(charCiudad6[i]);
		}
		System.out.println();
	}

}
