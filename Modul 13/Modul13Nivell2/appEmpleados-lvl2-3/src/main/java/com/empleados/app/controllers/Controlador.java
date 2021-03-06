package com.empleados.app.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.empleados.app.beans.Empleado;
import com.empleados.app.repository.BaseDatos;
@CrossOrigin
@RestController
@RequestMapping("")
public class Controlador {
	@Autowired
	private BaseDatos bd;
	@GetMapping("/getEmpleados")
	public List<Empleado> getEmpleados(){
		return bd.getEmpleados();
		
	}
	@GetMapping("/getEmpleado/{id}")
	public Optional<Empleado> getEmpleado(@PathVariable int id) {
		return bd.getEmpleado(id);
	}
	@PostMapping("/insertar")
	public void insertar( Empleado e) {
		e.setSalary();
		bd.insertar(e);
	}
	@PutMapping("/update/{id}")
	public void update(Empleado e, @PathVariable int id) {
		e.setSalary();
		bd.update(e, id);
	}
	@GetMapping("/delete/{id}")
	public void delete(@PathVariable int id) {
		bd.delete(id);
	}
}
