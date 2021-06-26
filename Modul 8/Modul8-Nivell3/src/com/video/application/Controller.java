package com.video.application;

import java.util.List;

import com.video.domain.*;
import com.video.repository.Repository;

public class Controller {
	private Repository baseDades = new Repository();
	
	//metodes per crear objectes


	public void createUsuari(String name, String lastName, String password) throws Exception {
		Utilitats.comprobarCamps(name);
		Utilitats.comprobarCamps(lastName);
		Utilitats.comprobarCamps(password);
		Usuari u = new Usuari(name,lastName,password);
		baseDades.addUsuari(u);
	}
	
	
	public Usuari getUsuari(int index) {
		return baseDades.getUsuariList().get(index);
	}
	
	
	public int getIndexUsuari(String name, String password) {
		//return -1 si el usuari no existeix sino torna el index del array
		int index = -1;
		List<Usuari> llista = baseDades.getUsuariList();
		for(int i = 0; i < llista.size();i++) {
			Usuari u = llista.get(i);
			
			if(u.getName().equals(name) && u.getPassword().equals(password)) {
				index = i;
			}
		} 
		
		return index;
	}
	
}
