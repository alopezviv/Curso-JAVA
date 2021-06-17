package com.video.application;

public class Utilitats {
	//metode per comprobar camps buits de una String, si esta buit retorna Excepcio personaltzada
		public static void comprobarCamps(String s) throws Exception{
			if(s.equals("") || s == null) {
				throw new CampsBuits("Campo vacio");
			}
			
		}
}
