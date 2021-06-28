package com.cohets.domain;

public class Coet {
	private String name;
	private int propulsors;
	
	public Coet(String name, int propulsors){
		this.name = name;
		this.propulsors = propulsors;
	}
	
	public String toString() {
		String result = "Rocket id=" + name + ": Te " + propulsors + " propulsors."; 
		
		return result;
	}
}
