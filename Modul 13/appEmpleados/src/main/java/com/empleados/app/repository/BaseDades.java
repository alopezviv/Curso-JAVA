package com.empleados.app.repository;
import com.empleados.app.beans.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BaseDades {
 private List<Empleado> empleados = new ArrayList<Empleado>();
 	
 	
 public BaseDades() {
	 empleados.add(new Empleado("Alberto", "COMERCIAL"));
	 empleados.add(new Empleado("Juan", "COMERCIAL"));
	 empleados.add(new Empleado("Maria", "ADMINISTRATIVO"));
	 empleados.add(new Empleado("Pedro", "ADMINISTRATIVO"));
	 empleados.add(new Empleado("Berta", "COMERCIAL"));
	 empleados.add(new Empleado("Felipe", "ADMINISTRATIVO"));
	 empleados.add(new Empleado("Marcos", "ADMINISTRATIVO"));
	 empleados.add(new Empleado("Carla", "COMERCIAL"));
	 empleados.add(new Empleado("Cristina", "COMERCIAL"));
	 empleados.add(new Empleado("Berta", "ADMINISTRATIVO"));

 }
 
 
 
 
 
 
 
 public void addEmpleado(Empleado e) {
	 empleados.add(e);
 }
 
 public List<Empleado> getEmpleados() {
	return empleados;
 }

 public void setEmpleados(List<Empleado> empleados) {
	this.empleados = empleados;
 } 
  public void borrar(int id) {
	 Iterator<Empleado> it = empleados.iterator();
	 while(it.hasNext()) {
		 Empleado e = it.next();
		 if(e.getId() == id) {
			 it.remove();
			 break;
		 }
	 }
	 
 }
  public Empleado getEmpleado(int id) {
	  for(Empleado e :  empleados) {
		  if(e.getId() == id) {
			  return e;
		  }
	  }
	  return null;
  }
  public void modifica(Empleado e, int id) {
	  for(Empleado emp : empleados) {
		  if(emp.getId() == id) {
			  emp.setName(e.getName());
			  emp.setWork(e.getWorkEnum());
			  emp.setSalary();
			  break;
		  }
	  }
  }
  public List<Empleado> filtra(String s){
	  
	  List<Empleado> filtrado = new ArrayList<Empleado>();
	  for(Empleado e: empleados) {
		  if(e.getWork().toUpperCase().equals(s.toUpperCase())) {
			  filtrado.add(e);
		  }
	  }
	  return filtrado;
  }
 
 
}
