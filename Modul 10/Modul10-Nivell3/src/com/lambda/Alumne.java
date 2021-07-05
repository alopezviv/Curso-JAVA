package com.lambda;

public class Alumne {
	private String nombre;
	private int edad;
	private String curso;
	private double nota;
	public Alumne(String nombre, int edad, String curso, double nota) {
		this.nombre = nombre;
		this.edad = edad;
		this.curso = curso;
		this.nota = nota;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	public double getNota() {
		return nota;
	}
	public void setNota(double nota) {
		this.nota = nota;
	}
	public String toString() {
		return nombre + " Edad: " + edad + " Curso: " + curso + " Nota: "  + nota;
	}
}
