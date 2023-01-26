package com.demo.springboot.app.demoreactor.model;

import java.util.Objects;

public class Persona {

	private Integer idPersona;
	private String nombres;
	private Integer edad;

	public Persona() {

	}

	public Persona(Integer idPersona, String nombres, Integer edad) {
		super();
		this.idPersona = idPersona;
		this.nombres = nombres;
		this.edad = edad;
	}

	public Integer getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(Integer idPersona) {
		this.idPersona = idPersona;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	@Override
	public String toString() {
		return "Persona [idPersona=" + idPersona + ", nombres=" + nombres + ", edad=" + edad + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(idPersona);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return Objects.equals(idPersona, other.idPersona);
	}
	
	
	
	

}
