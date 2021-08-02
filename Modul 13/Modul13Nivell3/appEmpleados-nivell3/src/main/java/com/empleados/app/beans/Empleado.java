package com.empleados.app.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Empleado {
	private static int classId = 1; // Id que cambiara cada cop perque sigui unica per cada objecte.
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String name;
	private enum Work{ADMINISTRATIVO, COMERCIAL};
	private float salary;
	private Work work;
	public Empleado() {}
	public Empleado(String name, String work) {
		//this.id = classId;
		//classId++;
		this.name = name;
		if(work.toUpperCase().equals("ADMINISTRATIVO")) {
			this.work = Work.ADMINISTRATIVO;
		}else {
			this.work = Work.COMERCIAL;
		}
		setSalary();
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
	public float getSalary() {
		return salary;
	}
	public void setSalary() {
		if(this.work.name().equals("ADMINISTRATIVO")) {
			this.salary = 1000;
		} else if(this.work.name().equals("COMERCIAL")) {
			this.salary = 1500;
		}
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	public String getWork() {
		return work.toString();
	}
	
	public Work getWorkEnum() {
		return this.work;
	}
	public void setWork(Work work) {
		this.work = work;
	}
	
}
