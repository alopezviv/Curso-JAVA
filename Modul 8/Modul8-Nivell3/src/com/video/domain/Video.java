package com.video.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.video.application.Utilitats;

public class Video implements Runnable {
	private String URL;
	private List<Tag> tagList = new ArrayList<Tag>();
	private String videoName;
	private LocalDateTime fechaSubida;
	private String status;
	int duracion;
	int tiempoVideo;
	enum VideoStatus{Reproduciendo,Pausado,Parado};
	VideoStatus videoStatus;
	Thread t;
	public Video(String name,String URL, int duracion) {
		setVideoName(name);
		setURL(URL); 
		this.duracion = duracion;
		fechaSubida = LocalDateTime.now();
		status = "Uploading";
		videoStatus = VideoStatus.Parado;
		tiempoVideo = 0;
		
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
	public void run()  {
		
		try {
			if(!status.equals("Public")) {
				throw new Exception("El video no esta subido");
			}
			if(tiempoVideo == duracion) {
				tiempoVideo = 0;
			}
			videoStatus = VideoStatus.Reproduciendo;
			while(tiempoVideo < duracion) {
				tiempoVideo++;
				Thread.sleep(1000);
			}
			videoStatus = VideoStatus.Parado;
			
		}catch(Exception e) {
			Thread.currentThread().interrupt();
		}
	}
	//lanza el metodo run del propio hilo del vidio
	public void startVideo() {
		t = new Thread(this);
		t.start();
	}
	//interrumpe el hilo
	public void pauseVideo() {
		t.interrupt();
	} 
	//interrumpe el hilo y setea el tiempo de reproduccion a 0.
	public void stopVideo() {
		t.interrupt();
		tiempoVideo = 0;
	}

	public int getDuracion() {
		return duracion;
	}

	public int getTiempoVideo() {
		return tiempoVideo;
	}
}
