package com.empleados.app.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


import com.empleados.app.beans.Empleado;

@Repository
public class BaseDatos {
	@Autowired
	JdbcTemplate jdbcTemplate;

	
	RowMapper<Empleado> rowMapper = (rs, rowNum) ->{
		Empleado e = new Empleado(rs.getString("name"), rs.getString("work"));
		e.setId(rs.getInt("id"));
		return e;
	};
	
	public List<Empleado> getEmpleados() {
		List<Empleado> empleados = new ArrayList<Empleado>();
		String sql = "Select * from empleados";
		empleados.addAll(jdbcTemplate.query(sql, rowMapper));
		
		
		return empleados;
	}
	public void insertar(Empleado empleado) {
		String sql = "Insert into empleados(name,work,salary) values(?,?,?)";
		jdbcTemplate.update(sql, empleado.getName(),empleado.getWork(), empleado.getSalary());
		
	}
	public Optional<Empleado> getEmpleado(int id){
		String sql = "Select * from empleados where id = ?";
		Empleado e = null;
		e = jdbcTemplate.queryForObject(sql,rowMapper, new Object[] {id});
		return Optional.ofNullable(e);
	}
	public void update (Empleado e, int id) {
		String sql = "update empleados set name = ?,  work = ?,  salary = ? where id = ?";
		jdbcTemplate.update(sql, e.getName(),e.getWork(), e.getSalary(),id);
	}
	public void delete(int id) {
		String sql = "delete from empleados where id = ?";
		jdbcTemplate.update(sql, id);
	}
}
