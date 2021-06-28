package com.cohets.view;

import com.cohets.domain.Coet;

public class Main {

	public static void main(String[] args) {
		Coet coet1 = new Coet("32WESSDS", 3);
		Coet coet2 = new Coet("LDSFJA32", 6);
		System.out.println(coet1.toString());
		System.out.println(coet2.toString());
	}

}
