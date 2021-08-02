package com.empleados.app.service;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import com.empleados.app.beans.Empleado;

public interface IBaseDatos {
	public List<Empleado> getEmpleados();
	public Empleado getEmpleado(int id);
	public void insertar(Empleado e);
	public void update(Empleado e);
	public void delete(int id);
}
		
	
