package com.video.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.video.application.Utilitats;

public class Video {
	private String URL;
	private List<Tag> tagList = new ArrayList<Tag>();
	private String videoName;
	private LocalDateTime fechaSubida;
	private String status;
	public Video(String name,String URL) {
		setVideoName(name);
		setURL(URL); 
		fechaSubida = LocalDateTime.now();
		status = "Uploading";
	}
	
	public String getVideoName() {
		return videoName;
	}
	public void setVideoName(String videoName) {
		this.videoName = videoName;
	}
	public String getURL() {
		return URL;
	}
	public void setURL(String uRL) {
		URL = uRL;
	}
	
	public void addTag(String s) throws Exception {
		Utilitats.comprobarCamps(s);
		tagList.add(new Tag(s));
	}
	public List<Tag> getTagList() {
		return tagList;
	}
	public String getStatus() {
		//comprobem el estatus dintre del getter perque s'actualitzi si es necessari quan es consulta.
		//si es menys de 10 segons sera uptdating si es menys de 20 segons sera verifying
		if(LocalDateTime.now().isAfter(fechaSubida.plusSeconds(20))) {
			status = "Public";
		}else if(LocalDateTime.now().isAfter(fechaSubida.plusSeconds(10))) {
			status = "Verifying";
		}
		
		return status;
	}

}
