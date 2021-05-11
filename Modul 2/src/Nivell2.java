import java.util.Scanner;
public class Nivell2 {
	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		//App escala
		//Demanem al usuari dades de longitud
		System.out.println("Dime longitud de la escalera");
		int longitudEscala = sc.nextInt();
		String resultatEscala = "";
		for(int i = 1; i<= longitudEscala; i++) {
			resultatEscala += Integer.toString(i);
			System.out.println(resultatEscala);
		}
		//App pirmide invertida
		System.out.println("Dime longitud de la piramide invertida");
		int longitudPiramide = sc.nextInt();
		System.out.println(longitudPiramide);
		String espai = " ";
		String simbol = "*";
		String resultatPiramide = "";
		int index = 0;
		int index2 = longitudPiramide;
		//loop que determina numero de files
		for(int i = 0; i < longitudPiramide/2+1 ; i++) {
			//loop que afegeix els espais al principi
			for(int j = 0; j < index; j++ ) {
				resultatPiramide += espai;	
			}
			index++;
			//Loop que afegeix els simbols
			for(int s = index2; s>0; s-- ) {
				resultatPiramide += simbol;
			}
			index2 -= 2;
			System.out.println(resultatPiramide);
			resultatPiramide = "";
		}
	}

}
