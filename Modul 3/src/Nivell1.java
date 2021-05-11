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
		System.out.println("Fase 1");
		String[] ciudades = {ciudad1,ciudad2,ciudad3,
				ciudad4,ciudad5,ciudad6}; 
		Arrays.sort(ciudades);
		System.out.println(Arrays.toString(ciudades));
	}

}
