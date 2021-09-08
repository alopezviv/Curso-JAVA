package com.empleados.app.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity(name = "shops")
public class Shop {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	String name;
	int capacity;
	int picturesNumber;
	public Shop() {};
	public Shop(String name, int capacity) {
		super();
		this.name = name;
		this.capacity = capacity;
		picturesNumber = 0;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public int getPicturesNumber() {
		return picturesNumber;
	}
	public void setPicturesNumber(int picturesNumber) {
		this.picturesNumber = picturesNumber;
	}
	
}
