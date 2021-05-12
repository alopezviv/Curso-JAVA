import java.util.Scanner;
public class Nivell2 {
	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		int[][] notesAlumnes = new int[5][3];
		//Demanem dades
		for(int i = 0; i<notesAlumnes.length;i++) {
			System.out.println("Introdueix notes alumne " + (i+1));
			for(int j = 0; j < notesAlumnes[0].length; j++) {
				System.out.println("nota " + (j+1));
				notesAlumnes[i][j] = sc.nextInt();
			}
		}
		//Calculem si esta aprovat o no
		double mitjana;
		for(int i = 0; i < notesAlumnes.length; i++) {
			System.out.println("Alumne " + (i+1));
			mitjana = (notesAlumnes[i][0] + notesAlumnes[i][1] + notesAlumnes[i][2])/3;
			if( mitjana >=5) {
				System.out.println("Aprovat");
			}else {
				System.out.println("Suspés");
			}
		}
		
	}

}
