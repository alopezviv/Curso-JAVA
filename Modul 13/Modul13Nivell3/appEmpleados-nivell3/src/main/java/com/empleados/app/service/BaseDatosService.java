package com.empleados.app.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empleados.app.beans.Empleado;
import com.empleados.app.repository.BaseDatos;
@Service
public class BaseDatosService implements IBaseDatos {
	@Autowired
	BaseDatos bd;
	@Override
	public List<Empleado> getEmpleados() {
		List<Empleado> empleados =(List<Empleado>)bd.findAll();
		Collections.sort(empleados, (a,b)->Integer.compare(a.getId(),b.getId()));
		return empleados;
	}

	@Override
	public Empleado getEmpleado(int id) {
		Optional<Empleado> e = bd.findById(id);
		return e.get();
	}

	@Override
	public void insertar(Empleado e) {
		bd.save(e);
		
	}

	@Override
	public void update(Empleado e) {
		bd.save(e);
		
	}

	@Override
	public void delete(int id) {
		bd.deleteById(id);
		
	}

}
