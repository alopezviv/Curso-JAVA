import java.util.Arrays;
import java.util.function.*;
public class Main {

	public static void main(String[] args) {
		String matriu[] = {"10","20","vi","34534","hola", "flexible", "horari", "607", "alberto", "programador",
				"pi", "33","investigador","plata","platea","estadi","erasmus"};
		//String matriu1[] = matriu;
		//primer punt
		System.out.println("Primer punto");
		Arrays.sort(matriu, (a,b) -> (a.length() - b.length()));
		printMatriu(matriu);
		//Segon punt
		System.out.println("Segundo punto");
		//String matriu2[] = matriu;
		Arrays.sort(matriu, (a,b) -> (b.length() - a.length()));
		printMatriu(matriu);
		//tercer punt
		System.out.println("Tercer punto");
		Arrays.sort(matriu, (a,b) -> (a.charAt(0) - b.charAt(0)));
		printMatriu(matriu);
		//Cuarto punto
		System.out.println("Cuarto punto");
		matriu = dobleFilterLoop(matriu, s -> s.contains("e"), s -> !s.contains("e"));
		printMatriu(matriu);
		//Quinto punto
		System.out.println("Quinto punto");
		Arrays.stream(matriu).map(s -> s.replace('a', '4')).forEach(System.out::println);
		//Sexto punto
		System.out.println("Sexto punto");
		Arrays.stream(matriu).filter(s -> s.chars().allMatch(Character::isDigit)).forEach(System.out::println);
		
		//Declarant les interficies
		IOperation suma = (a, b) -> a + b;
		IOperation resta = (a, b) -> a - b;
		IOperation multiplicacion = (a, b) -> a * b;
		IOperation division = (a, b) -> a / b;
		//Exemple de us
		System.out.println("Exemples interficies");
		System.out.println(suma.operacio(4, 5));
		System.out.println(division.operacio(9, 7));
	}
	public static void printMatriu(String[] m) {
		for(String s: m) {
			System.out.println(s);
		}
	}
	public static String[] dobleFilterLoop(String[] matriu, Predicate<String> block, Predicate<String> block2) {
		String[] result = new String[matriu.length];
		int index = 0;
		for(String s: matriu) {
			if(block.test(s)) {
				result[index] = s;
				index++;
			}
		}
		for(String s: matriu) {
			if(block2.test(s)) {
				result[index] = s;
				index++;
			}
		}
		return result;
	}
}
