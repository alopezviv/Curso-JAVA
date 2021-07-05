package com.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
	public static List<Alumne> listaAlumnos = new ArrayList<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		listaAlumnos.add(new Alumne("Alberto", 27, "JAVA", 9.5));
		listaAlumnos.add(new Alumne("Joan", 18, "React", 6.5));
		listaAlumnos.add(new Alumne("Anna", 27, "PHP", 7.3));
		listaAlumnos.add(new Alumne("Eugeni", 45, "PHP", 5.2));
		listaAlumnos.add(new Alumne("Marina", 31, "React", 3.5));
		listaAlumnos.add(new Alumne("Berta", 17, "JAVA", 9.8));
		listaAlumnos.add(new Alumne("Maria", 26, "Python", 6.7));
		listaAlumnos.add(new Alumne("Victor", 29, "PHP", 8.6));
		listaAlumnos.add(new Alumne("Oscar", 27, "React", 4.8));
		listaAlumnos.add(new Alumne("Pere", 50, "Angular", 7.3));
		
		//Primer punt
		System.out.println("Primer punto");
		listaAlumnos.stream().forEach(a -> System.out.println(a.getNombre()+ " " + a.getEdad()));
		//Segon punt
		System.out.println("Segundo punto");
		List<Alumne> alumnesNomA = listaAlumnos.stream().filter(a -> a.getNombre().charAt(0) == 'A').collect(Collectors.toList());
		alumnesNomA.forEach(a -> System.out.println(a.toString()));
		//Tercer punt
		System.out.println("Tercer punto");
		listaAlumnos.stream().filter(a -> a.getNota() >= 5).forEach(a -> System.out.println(a.toString()));
		//Quart punt
		System.out.println("Cuarto punto");
		listaAlumnos.stream().filter(a -> a.getNota() >= 5 && !a.getCurso().equals("PHP")).forEach(a -> System.out.println(a.toString()));
		//Cinque punt
		System.out.println("Quinto punto");
		listaAlumnos.stream().filter(a -> a.getEdad() >= 18 && a.getCurso().equals("JAVA")).forEach(a -> System.out.println(a.toString()));

	}

}
