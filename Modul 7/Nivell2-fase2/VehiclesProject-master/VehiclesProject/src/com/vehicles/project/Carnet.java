package com.vehicles.project;
import java.util.Date;
public class Carnet {
	private int id;
	private char tipoLicencia;
	private String nombreCompleto;
	private Date fechaCaducidad;
	public Carnet(int id, char tipoLicencia, String nombreCompleto, Date fechaCaducidad) {
		this.id = id;
		this.tipoLicencia = tipoLicencia;
		this.nombreCompleto = nombreCompleto;
		this.fechaCaducidad = fechaCaducidad;
	}
}
