import java.util.*;
public class Nivell1fase4 {

	public static void main(String[] args) {
		List<Character> arrNom = new ArrayList<Character>();
		List<Character> arrCognom = new ArrayList<Character>();
		arrNom.add('A');
		arrNom.add('L');
		arrNom.add('B');
		arrNom.add('E');
		arrNom.add('R');
		arrNom.add('T');
		arrNom.add('O');
		arrCognom.add('L');
		arrCognom.add('O');
		arrCognom.add('P');
		arrCognom.add('E');
		arrCognom.add('Z');
		//creo nova llista que sera la unio de les altres dues
		List<Character> nomComplet = new ArrayList<Character>();
		nomComplet.addAll(arrNom);
		nomComplet.add(' ');
		nomComplet.addAll(arrCognom);
		for(char ch: nomComplet) {
			System.out.print(ch);
		}

	}

}
