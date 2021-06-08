package com.vehicles.project;
import java.time.LocalDate;

public class Carnet {
	private int id;
	private char tipoLicencia;
	private String nombreCompleto;
	private LocalDate fechaCaducidad;
	public Carnet(int id, char tipoLicencia, String nombreCompleto, LocalDate fechaCaducidad) {
		this.id = id;
		this.tipoLicencia = tipoLicencia;
		this.nombreCompleto = nombreCompleto;
		this.fechaCaducidad = fechaCaducidad;
	}
	public char getTipoCarnet() {
		return tipoLicencia;
	}
}
