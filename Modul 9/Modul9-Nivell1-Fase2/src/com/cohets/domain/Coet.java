package com.cohets.domain;
import java.util.*;
public class Coet {
	private String name;
	private List<Integer> propulsors = new ArrayList<Integer>();
	
	public Coet(String name){
		this.name = name;
		
	}
	
	public String toString() {
		String propulsorString = "[ ";
		for(int pr: propulsors) {
			propulsorString += pr + " ";
		}
		propulsorString += "]";
		String result = "Rocket id=" + name + "\nPotencia Màxima Propulsors: " + propulsorString ; 
		
		return result;
	}
	public void addPropulsor(int p) {
		propulsors.add(p);
	}
}
