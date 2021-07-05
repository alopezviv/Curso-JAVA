package com.lambda;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PiValue pi = () -> 3.1415;
		System.out.println(pi.getPiValue());
	}

}
