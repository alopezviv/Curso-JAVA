package com.cohets.domain;
import java.util.*;
public class Coet implements Runnable{
	private String name;
	private List<Propulsor> propulsors = new ArrayList<Propulsor>();
	private double velocitat;
	private double velocitatInicial;

	private double velocitatObjectiu;
	public Coet(String name, double velocitat, double velocitatObjectiu){
		this.name = name;
		this.velocitat = velocitat;
		this.velocitatInicial = velocitat;
		this.velocitatObjectiu = velocitatObjectiu;
	}
	
	public List<Propulsor> getPropulsors() {
		return propulsors;
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
			//Activem els propulsors			
			p.activate();
		}
	}
	public void parar() {
		for(Propulsor p: propulsors) {
			//Cambiem els dos booleans del run() del propulsor el que hauria de fer que acabes el metode y moris el fil
			p.setActive(false);
			p.setAcelerating(!p.isAcelerating);
			p.getT().interrupt();
			
		}
	}
	public void frenar() {
		for(Propulsor p: propulsors) {
			//marquem cada propulsor en modo acceleracio

			p.setAcelerating(false);
		}
	}
	

	public double getVelocitat() {
		return velocitat;
	}

	public void setVelocitat(double velocitat) {
		this.velocitat = velocitat;
	}

	public double getVelocitatObjectiu() {
		return velocitatObjectiu;
	}

	public void setVelocitatObjectiu(double velocitatObjectiu) {
		this.velocitatObjectiu = velocitatObjectiu;
	}

	public String getName() {
		return name;
	}
	
	//Metode que mira si el coet pot arribar a la velocitat deitjada.
	public boolean velocitatPosible(double velocitatObjectiu) {
		boolean result = false;
		int potenciaMaximaTotal = 0;
		for(Propulsor p: propulsors) {
			potenciaMaximaTotal += p.getPotenciaMax();
		}
		double velocitatMaximaPosible = this.velocitat + (100 * Math.sqrt(potenciaMaximaTotal));
		if(velocitatMaximaPosible >= velocitatObjectiu) {
			result = true;
		}
		
		return result;
	}
	@Override
	public void run() {
		if(!velocitatPosible(this.velocitatObjectiu)) {
			System.out.println("El coete " + this.getName() + " no puede alcanzar esta velocidad");
			return;
		}
		int potenciaTotal = 0;
		if(velocitat < velocitatObjectiu){
			accelerar();
			iniciar();

			while(velocitat < velocitatObjectiu) {
				potenciaTotal=0;
				for(Propulsor p: propulsors) {
					potenciaTotal += p.getPotenciaActual();
				}
				velocitat = velocitatInicial + (100 * Math.sqrt(potenciaTotal));
			}
		}else if(velocitat > velocitatObjectiu) {
			frenar();
			iniciar();

			while(velocitat > velocitatObjectiu) {
				potenciaTotal=0;
				for(Propulsor p: propulsors) {
					potenciaTotal += p.getPotenciaActual();
				}
				velocitat = velocitatInicial + (100 * Math.sqrt(potenciaTotal));
			}
		}
		
		System.out.println("El cohete ha llegado a la velocidad");
		parar();
	}
}
