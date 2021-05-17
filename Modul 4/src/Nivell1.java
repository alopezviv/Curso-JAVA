import java.util.*;

public class Nivell1 {

	public static void main(String[] args) {
		//Fase 1
		
		int billet500 = 0;
		int billet200 = 0;
		int billet100 = 0;
		int billet50 = 0;
		int billet20 = 0;
		int billet10 = 0;
		int billet5 = 0;
		int moneda2 = 0;
		int moneda1 = 0;
		int compteMenjar = 0;
		int[] preu = new int[10];
		String[] plats = new String[10];
		//fase 2
		HashMap<String, Integer> preuPlat = new HashMap<String, Integer>();
		preuPlat.put("Hamburguesa completa",9);
		preuPlat.put("Llom amb formatge", 6);
		preuPlat.put("Entrecot",20);
		preuPlat.put("Paella",15);
		preuPlat.put("Fideua", 13);
		preuPlat.put("Bacon amb formatge", 5);
		preuPlat.put("Gambes a la planxa", 18);
		preuPlat.put("Calamars", 11);
		preuPlat.put("Patates Braves", 4);
		preuPlat.put("Pop a la gallega",19);
		int index=0;
		//omplim Arrays
		for(Map.Entry<String, Integer> entry: preuPlat.entrySet()) {
			preu[index] = entry.getValue();
			plats[index] = entry.getKey();
			index++;
		}
		int option = 2;
		List<String> pedido = new ArrayList<String>();
		Scanner sc = new Scanner(System.in);
		for(int i = 0; i < plats.length; i++ ) {
			System.out.println(plats[i] + " " + preu[i] + "€");
		}
		System.out.println("Que vols demanar");
		boolean isInArray;
		String plat;
		while(option != 0) {
			isInArray = false;
			System.out.println("Escriu el plat que vols");
			plat = sc.nextLine();
			//Mirem si el plat introduit esta en la carta, si no hi es salta una excepcio i surt un missatge (Nivell 2)
			try {
				for(int i = 0; i<plats.length;i++) {
					if(plats[i].equals(plat)){
						isInArray = true;
					}
				}			
				if(isInArray) {
					pedido.add(plat);
					}else {
						throw new NotInCartaException();
					}
			}catch(NotInCartaException e) {
				System.out.println("El plato no se encuentra en la carta");
			}
			//El bucle es va repetint sempre que la reposta de si o no no sigui correcte.
			//Cada cop que és incorrecte es llança una exception i es torna a preguntar (nivell 2)
			 do{
				try{
					System.out.println("Vols seguir demanant? 0 No 1 Si");
					option = sc.nextInt();
					sc.nextLine();
					if(option < 0 || option > 1) {
						throw new NotAnOptionException();
					}
				}catch(NotAnOptionException e) {
					System.out.println("Opció no vàlida");
				}
			}while(option < 0 || option > 1 );
			
		}
		//Com els index del array de plat i preu son iguals utilitzem aixo per sumar el preu en una variable
		for(int i = 0; i < pedido.size() ; i++) {
			for(int j = 0; j < plats.length ; j++) {
				if(pedido.get(i).equals(plats[j])) {
					compteMenjar += preu[j];
				}
			}
		}
		System.out.println("El preu del compte es de " + compteMenjar + "€");
		//Calucul dels billets i monedes que es necessiten
		while(compteMenjar != 0) {
			if(compteMenjar >= 500) {
				billet500++;
				compteMenjar -= 500;
			}else if(compteMenjar >= 200) {
				billet200++;
				compteMenjar -= 200;
			}else if(compteMenjar >= 100) {
				billet100++;
				compteMenjar -= 100;
			}else if(compteMenjar >= 50) {
				billet50++;
				compteMenjar -= 50;
			}else if(compteMenjar >= 20) {
				billet20++;
				compteMenjar -= 20;
			}else if(compteMenjar >= 10) {
				billet10++;
				compteMenjar -= 10;
			}else if(compteMenjar >= 5) {
				billet5++;
				compteMenjar -= 5;
			}else if(compteMenjar >= 2) {
				moneda2++;
				compteMenjar -= 2;
			}else {
				moneda1++;
				compteMenjar -= 1;
			}
		}
		System.out.println("Necessites: " + billet500 + " bilets de 500 " + billet200 + " billets de 200 " 
				+ billet100 + " billets de 100 " + billet50 + " billets de 50 " + billet20 + " billets de 20 "
				+ billet10 + " billets de 10 " + billet5 + " billets de 5 " + moneda2 + " monedes de 2 i "
				+ moneda1 + " monedes de 1");
	}

}




