package com.video.repository;
import java.util.*;

import com.video.domain.*;
public class Repository {
	
	private List<Usuari> usuariList = new ArrayList<Usuari>();
	public Repository() {
		
	}
	
		
	public void addUsuari(Usuari u) {
		usuariList.add(u);
	}

	
	public List<Usuari> getUsuariList() {
		return usuariList;
	}

	
	
	
}
