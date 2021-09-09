package com.empleados.app.beans;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "pictures")
public class Picture {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String autor;
	private Date entranceDate;
	private int shopId;
	public Picture() {
		setEntranceDate();
	};
	public Picture(String autor,  int shopId) {
		super();
		this.autor = autor;
		long now = System.currentTimeMillis();
		Date date = new Date(now);
		this.entranceDate = date;
		this.shopId = shopId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}
	public Date getEntranceDate() {
		return entranceDate;
	}
	public void setEntranceDate() {
		long now = System.currentTimeMillis();
		Date date = new Date(now);
		this.entranceDate = date;
	}
	public int getShopId() {
		return shopId;
	}
	public void setShopId(int shopId) {
		this.shopId = shopId;
	}
}	
