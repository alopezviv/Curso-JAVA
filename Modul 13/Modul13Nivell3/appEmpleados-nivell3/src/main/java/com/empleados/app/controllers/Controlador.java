package com.empleados.app.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empleados.app.beans.Empleado;
import com.empleados.app.repository.BaseDatos;
import com.empleados.app.service.BaseDatosService;

@RestController
@RequestMapping("")
@CrossOrigin
public class Controlador {
	@Autowired
	BaseDatosService bd;
	@GetMapping("/getEmpleados")
	public List<Empleado> getEmpleados(){
		return bd.getEmpleados();
		
	}
	@GetMapping("/getEmpleado/{id}")
	public Empleado getEmpleado(@PathVariable int id) {
		return bd.getEmpleado(id);
	}
	@PostMapping("/insertar")
	public void insertar(Empleado e) {
		e.setSalary();
		bd.insertar(e);
	}
	@PutMapping("/update")
	public void update(Empleado e) {
		e.setSalary();
		bd.update(e);
	}
	@GetMapping("/delete/{id}")
	public void delete(@PathVariable int id) {
		bd.delete(id);
	}
}
