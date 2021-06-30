package com.cohets.view;

import com.cohets.domain.*;

public class Main {

	public static void main(String[] args) {
		Ventana v1 = new Ventana();
		Ventana v2 = new Ventana();
		Coet coet1 = new Coet("32WESSDS",100,10000);
		v1.setTitle("Coet 32WESSDS Control Panel");
		v1.addButtonVelocidad(coet1);
		v1.addBottonAceleracion1(coet1);
		v1.addBottonAceleracion5(coet1);
		coet1.addPropulsor(new Propulsor(0,80));
		coet1.addPropulsor(new Propulsor(1,80));
		coet1.addPropulsor(new Propulsor(2,60));
		Coet coet2 = new Coet("LDSFJA32",1000,2000);
		v2.setTitle("Coet LDSFJA32 Control Panel");
		v2.setLocation(800, 300);
		v2.addButtonVelocidad(coet2);
		v2.addBottonAceleracion1(coet2);
		v2.addBottonAceleracion5(coet2);
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
