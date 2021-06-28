package com.cohets.domain;
import java.util.*;
public class Coet {
	private String name;
	private List<Propulsor> propulsors = new ArrayList<Propulsor>();
	
	public Coet(String name){
		this.name = name;
		
	}
	
	public String toString() {
		String propulsorString = "\n";
		for(Propulsor pr: propulsors) {
			propulsorString += pr.toString() + "\n";
		}
		
		String result = "Rocket id=" + name  + propulsorString ; 
		
		return result;
	}
	public void addPropulsor(Propulsor p) {
		propulsors.add(p);
	}
	public void accelerar() {
		for(Propulsor p: propulsors) {
			//marquem cada propulsor en modo acceleracio
			p.setAcelerating(true);
		}
	}
	public void iniciar() {
		for(Propulsor p: propulsors) {
			//marquen true la variable perque loopeji infinit el metode run i inicialitzem els trheads			
			p.setActive(true);
			new Thread(p).start();
		}
	}
	public void frenar() {
		for(Propulsor p: propulsors) {
			//marquem cada propulsor en modo acceleracio

			p.setAcelerating(false);
		}
	}
}
