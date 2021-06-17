package com.video.domain;

import java.util.ArrayList;
import java.util.List;

public class Video {
	private String URL;
	private List<Tag> tagList = new ArrayList<Tag>();
	private String videoName;
	
	public Video(String name,String URL) {
		setVideoName(name);
		setURL(URL); 
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
	public void addTag(Tag tag) {
		tagList.add(tag);
	}
	
}
