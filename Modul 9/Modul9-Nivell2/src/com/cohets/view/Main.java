package com.cohets.view;

import com.cohets.domain.*;

public class Main {

	public static void main(String[] args) {
		Coet coet1 = new Coet("32WESSDS",100,6220);
		coet1.addPropulsor(new Propulsor(0,80));
		coet1.addPropulsor(new Propulsor(1,80));
		coet1.addPropulsor(new Propulsor(2,60));
		Coet coet2 = new Coet("LDSFJA32",1000,2500);
		coet2.addPropulsor(new Propulsor(0,80));
		coet2.addPropulsor(new Propulsor(1,60));
		coet2.addPropulsor(new Propulsor(2,70));
		coet2.addPropulsor(new Propulsor(3,60));
		coet2.addPropulsor(new Propulsor(4,80));
		coet2.addPropulsor(new Propulsor(5,30));
		System.out.println(coet1.toString());
		System.out.println(coet2.toString());
		//iniciem threeads
		new Thread(coet1).start();
		new Thread(coet2).start();
	}

}
