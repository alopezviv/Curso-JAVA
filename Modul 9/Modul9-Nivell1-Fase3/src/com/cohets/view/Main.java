package com.cohets.view;

import com.cohets.domain.*;

public class Main {

	public static void main(String[] args) {
		Coet coet1 = new Coet("32WESSDS");
		coet1.addPropulsor(new Propulsor(0,50,80));
		coet1.addPropulsor(new Propulsor(1,30,80));
		coet1.addPropulsor(new Propulsor(2,40,60));
		Coet coet2 = new Coet("LDSFJA32");
		coet2.addPropulsor(new Propulsor(0,50,80));
		coet2.addPropulsor(new Propulsor(1,60,60));
		coet2.addPropulsor(new Propulsor(2,30,70));
		coet2.addPropulsor(new Propulsor(3,30,60));
		coet2.addPropulsor(new Propulsor(4,50,80));
		coet2.addPropulsor(new Propulsor(5,20,30));
		System.out.println(coet1.toString());
		System.out.println(coet2.toString());
		//iniciem threeads
		coet1.iniciar();
		coet2.iniciar();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//accelerem
		coet1.accelerar();
		coet2.accelerar();
		//esperem 30 segons i desaccelerem
		try{
			Thread.sleep(30000);
		}catch(Exception e) {
			e.printStackTrace();
		}
		coet1.frenar();
		coet2.frenar();
	}

}
