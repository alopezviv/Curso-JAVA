package com.empleados.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.empleados.app.beans.Empleado;
import com.empleados.app.repository.BaseDades;

@Controller
public class Controlador {
	BaseDades bd = new BaseDades();
	
	
	
	@GetMapping("/")
	public String index(Model model) {
		List<Empleado> empleados = bd.getEmpleados();
		model.addAttribute("empleados", empleados);
		model.addAttribute("boton", "Insertar Libro");
		model.addAttribute("action", "/insertar");
		return "index";
	}
	
	@PostMapping("/insertar")
	public String insertar(Model model, Empleado empleado) {
		bd.addEmpleado(empleado);
		List<Empleado> empleados = bd.getEmpleados();
		model.addAttribute("empleados", empleados);
		model.addAttribute("boton", "Insertar Empleado");
		model.addAttribute("action", "/insertar");
		return "index";
	}
	@GetMapping("/borrado/{id}")
	public String borrar(Model model, @PathVariable int id) {
		bd.borrar(id);
		List<Empleado> empleados = bd.getEmpleados();
		model.addAttribute("empleados", empleados);
		model.addAttribute("boton", "Insertar Empleado");
		model.addAttribute("action", "/insertar");
		return "index";
	}
	@GetMapping("/modificar/{id}")
	public String modificar(Model model, @PathVariable int id) {
		Integer intId = Integer.valueOf(id);
		Empleado e = bd.getEmpleado(id);
		List<Empleado> empleados = bd.getEmpleados();
		model.addAttribute("empleados", empleados);
		model.addAttribute("intId", intId);
		model.addAttribute("empleado", e);
		model.addAttribute("boton", "Modificar Empleado");
		model.addAttribute("action", "/modificar");
		return "index";
	}
	@PostMapping("/modificar")
	public String modificar2(Model model, Empleado empleado, int intId) {
		//int id = intId.intValue();
		bd.modifica(empleado, intId);
		List<Empleado> empleados = bd.getEmpleados();
		model.addAttribute("empleados", empleados);
		model.addAttribute("boton", "Insertar Empleado");
		model.addAttribute("action", "/insertar");
		return "index";
	}
	@PostMapping("/filtro")
	public String modificar2(Model model, String work) {
		List<Empleado> empleados = new ArrayList<Empleado>();
		if(work.equals("TODOS")) {
			empleados = bd.getEmpleados();
		}else {
			empleados = bd.filtra(work);
		}
		model.addAttribute("empleados", empleados);
		model.addAttribute("boton", "Insertar Empleado");
		model.addAttribute("action", "/insertar");
		return "index";
	}
}
