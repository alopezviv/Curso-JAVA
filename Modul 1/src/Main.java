
public class Main {
	static final int anyRef = 1948; 
	public static void main(String[] args) {
		
		System.out.println("Nivell 1:");
		//Inicialització strings
		String nom = "Alberto";
		String cognom1 = "Lopez";
		String cognom2 = "Vivas";
		//Inicialització int
		int any = 1993;
		int mes = 8;
		int dia = 31;
		int contador = 0;
		int freqAnyTraspas = 4;
		System.out.println(cognom1 + " " + cognom2 + ", " + nom);
		System.out.println(dia + "/" + mes + "/" + any);
		
		System.out.println("Anys de traspas desde "+ anyRef + " fins a " + any);
		for(int i = anyRef; i <= any; i+= freqAnyTraspas) {
			contador++;
			System.out.print(i + " ");
		}
		System.out.println("\nEl numero d'anys de traspas desde " + anyRef + " fins a " + any + ": "+ contador);		
		String traspas = "L'any " + any + " es de traspàs";
		String notTraspas = "L'any " + any + " no es de traspàs";
				
		boolean isTraspas = false;
		if(any%4 == 0) {
			isTraspas = true;
		}
		if(isTraspas) {
			System.out.println(traspas);
		}else {
			System.out.println(notTraspas);
		}
		String nomComplet = nom + " " + cognom1 + " " + cognom2;
		String data = dia + "/" + mes + "/" + any;
		System.out.println("El meu nom es " + nomComplet + 
				"\nVaig neixer el " + data);
		if(isTraspas) {
			System.out.println(traspas);
		}else {
			System.out.println(notTraspas);
		}
		System.out.println("Nivell 2: ");
		double pi = 3.1416;
		int piInt = (int)pi;
		String piString = Double.toString(pi);
		float piFloat = (float)pi;
		System.out.println(pi + " double");
		System.out.println(piInt + " int");
		System.out.println(piString + " String");
		System.out.println(piFloat+ " Float");
		System.out.println("Nivell 3");
		int[] arrNumeros = {1,2,3,4,5,6,7,8,9,10};
		int auxiliar = arrNumeros[9];
		for(int i = 0 ; i<10; i++) {
			System.out.print(arrNumeros[i] + " ");
		}
		System.out.print("\n");
		for(int i = 9; i>0;i--) {
			arrNumeros[i] = arrNumeros[i-1];
		}
		arrNumeros[0] = auxiliar;
		for(int i : arrNumeros) {
			System.out.print(i + " ");
		}
	}
	
}
