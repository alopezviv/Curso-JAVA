package com.video.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.video.application.Utilitats;

public class Usuari {
	private String name;
	private String lastName;
	private String password;
	private LocalDate registerDate;
	private List<Video> videoList = new ArrayList<Video>();
	
	
	public Usuari(String name, String lastName, String password) {
		setName(name);
		setLastName(lastName);
		setPassword(password);
		registerDate = LocalDate.now();
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRegisterDate() {
		return registerDate.toString();
	}
	public void createVideo(String videoName, String URL, int duracion) throws Exception {
		Utilitats.comprobarCamps(videoName);
		Utilitats.comprobarCamps(URL);
		Video v = new Video(videoName, URL, duracion);
		videoList.add(v);
	}
	public String viewVideos() {
		String result = "";
		int index = 0;
		for(Video v: videoList) {
			result += index + "-" + v.getVideoName()+  " Status: " + v.getStatus()+ " " + v.getTiempoVideo() + "/" + v.getDuracion() +  "\n";
			index++;
		}
		
		return result;
	}
	public Video getVideo(int index) {
		return videoList.get(index);
	}
	
	
	
	
}
