import java.util.Scanner;
public class Nivell3 {
	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("Cuantos numeros quieres");
		int n = sc.nextInt();
		int a = 0;
		int b = 1;
		int c;
	
		for(int i = 0; i< n; i++) {
			System.out.print(a + " ");
			c = a+b;
			a = b;
			b = c;
		
		}

	}

}
