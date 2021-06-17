package com.video.application;

import com.video.domain.*;
import com.video.repository.Repository;

public class Controller {
	private Repository baseDades = new Repository();
	
	//metodes per crear objectes
	public void createTag(String tag) throws Exception {
		Utilitats.comprobarCamps(tag);
		
		Tag t = new Tag(tag);
		baseDades.addTag(t);
	}
	
	public void createVideo(String videoName, String URL) throws Exception {
		Utilitats.comprobarCamps(videoName);
		Utilitats.comprobarCamps(URL);
		Video v = new Video(videoName, URL);
		baseDades.addVideo(v);
	}
	public void createUsuari(String name, String lastName, String password) throws Exception {
		Utilitats.comprobarCamps(name);
		Utilitats.comprobarCamps(lastName);
		Utilitats.comprobarCamps(password);
		Usuari u = new Usuari(name,lastName,password);
	}
	
	
}
