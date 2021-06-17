package com.video.repository;
import java.util.*;

import com.video.domain.*;
public class Repository {
	private List<Tag> tagList = new ArrayList<Tag>();
	private List<Usuari> usuariList = new ArrayList<Usuari>();
	private List<Video> videoList = new ArrayList<Video>();
	public Repository() {
		
	}
	
	public void addTag(Tag t) {
		tagList.add(t);
	}
	public void addVideo(Video v) {
		videoList.add(v);
	}
	public void addUsuari(Usuari u) {
		usuariList.add(u);
	}

	public List<Tag> getTagList() {
		return tagList;
	}

	public List<Usuari> getUsuariList() {
		return usuariList;
	}

	public List<Video> getVideoList() {
		return videoList;
	}
	
	
}
