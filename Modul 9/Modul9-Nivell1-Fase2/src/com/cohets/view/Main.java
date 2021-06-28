package com.cohets.view;

import com.cohets.domain.Coet;

public class Main {

	public static void main(String[] args) {
		Coet coet1 = new Coet("32WESSDS");
		coet1.addPropulsor(10);
		coet1.addPropulsor(30);
		coet1.addPropulsor(80);
		Coet coet2 = new Coet("LDSFJA32");
		coet2.addPropulsor(30);
		coet2.addPropulsor(40);
		coet2.addPropulsor(50);
		coet2.addPropulsor(50);
		coet2.addPropulsor(30);
		coet2.addPropulsor(10);
		System.out.println(coet1.toString());
		System.out.println(coet2.toString());
	}

}
