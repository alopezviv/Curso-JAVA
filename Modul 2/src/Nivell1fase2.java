import java.util.*;
public class Nivell1fase2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Character> arrChar = new ArrayList<Character>();
		arrChar.add('A');
		arrChar.add('L');
		arrChar.add('B');
		arrChar.add('E');
		arrChar.add('R');
		arrChar.add('T');
		arrChar.add('O');
		arrChar.add('L');
		arrChar.add('P');
		arrChar.add('E');
		arrChar.add('Z');
		for(int i = 0; i< arrChar.size(); i++) {
			if(arrChar.get(i) == 'A' || arrChar.get(i) == 'E' || arrChar.get(i) == 'I' || arrChar.get(i) == 'O' || arrChar.get(i) == 'U' ) {
				System.out.println(arrChar.get(i) + " es vocal");
			}else if(arrChar.get(i) == '1' || arrChar.get(i) == '2' || arrChar.get(i) == '3' || arrChar.get(i) == '4' || arrChar.get(i) == '5' || arrChar.get(i) == '6' || arrChar.get(i) == '7' || arrChar.get(i) == '8' || arrChar.get(i) == '9' || arrChar.get(i) == '0') {
				System.out.println("Els noms de persona no tenen numeros!");

			}else {
				System.out.println(arrChar.get(i) + " es consonant");

			}
		}
		
	}

}
