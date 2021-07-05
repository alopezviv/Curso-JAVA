package com.lambda.view;
import java.util.function.*;
import java.util.List;
import java.util.ArrayList;

public class Main {
	public static List<String> llistaNoms = new ArrayList<>();
	public static List<String> llistaMesos = new ArrayList<>();
	public static List<Integer> llistaInteger = new ArrayList<>();
	public static void main(String[] args) {
		llistaNoms.add("Alberto");
		llistaNoms.add("Joan");
		llistaNoms.add("Arc");
		llistaNoms.add("Pere");
		llistaNoms.add("Pol");
		llistaNoms.add("Nil");
		llistaNoms.add("Ash");
		llistaNoms.add("Marc");
		llistaNoms.add("Frederic");
		llistaNoms.add("Alba");
		//Primer metode fet amb Agregate Operations
		System.out.println("1.");
		llistaNoms.stream().filter(e -> e.charAt(0) == 'A' & e.length() == 3).forEach(e -> System.out.println(e));
		
		//--------------------------
		//segon mètode
		llistaInteger.add(32);
		llistaInteger.add(13);
		llistaInteger.add(2);
		llistaInteger.add(5);
		llistaInteger.add(37);
		llistaInteger.add(8);
		llistaInteger.add(16);
		llistaInteger.add(15);
		llistaInteger.add(90);
		llistaInteger.add(1);
		System.out.println("2.");

		filtreNumerosParellsToString(llistaInteger, 
				i -> i%2 == 0,
				i -> System.out.println("e"+i), 
				i -> System.out.println("o"+i));
	
		//tercer metode
		System.out.println("3.");

		List<String> llistaNomsAmbO = filtreLlistaString(llistaNoms, s -> s.contains("o"));
		llistaNomsAmbO.forEach(s -> System.out.println(s));
		//quart mètode
		System.out.println("4.");

		List<String> llistaNomsMesCincLletres = filtreLlistaString(llistaNoms, s -> s.length() > 5);
		llistaNomsMesCincLletres.forEach(s -> System.out.println(s));
		//Cinque metode
		System.out.println("5.");
		llistaMesos.add("Gener");
		llistaMesos.add("Febrer");
		llistaMesos.add("Març");
		llistaMesos.add("Abril");
		llistaMesos.add("Maig");
		llistaMesos.add("Juny");
		llistaMesos.add("Juliol");
		llistaMesos.add("Agost");
		llistaMesos.add("Setembre");
		llistaMesos.add("Octubre");
		llistaMesos.add("Novembre");
		llistaMesos.add("Desembre");
		llistaMesos.forEach(s -> System.out.println(s));
		//6è mètode
		System.out.println("6.");

		llistaMesos.forEach(System.out::println);
		
	}
	
	public static void filtreNumerosParellsToString(List<Integer> llista, Predicate<Integer> tester, Consumer<Integer> blockParell, Consumer<Integer> blockInparell) {
		for(Integer i: llista) {
			if(tester.test(i)) {
				blockParell.accept(i);
			}else {
				blockInparell.accept(i);
			}
		}
	}
	public static List<String> filtreLlistaString(List<String> llista, Predicate<String> tester){
		List<String> result = new ArrayList<>();
		for(String s: llista) {
			if(tester.test(s)) {
				result.add(s);
			}
				
			
		}
		return result;
	}
}
