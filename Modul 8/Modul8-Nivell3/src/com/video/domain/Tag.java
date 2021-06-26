package com.video.domain;

public class Tag {
	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	private String tagName;
	
	public Tag(String tagName) {
		this.tagName = tagName;
	}
}
