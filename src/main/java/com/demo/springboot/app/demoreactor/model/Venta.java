package com.demo.springboot.app.demoreactor.model;

import java.time.LocalDate;

public class Venta {

	private Integer idVenta;
	private LocalDate fecha;

	public Venta(Integer idVenta, LocalDate fecha) {
		super();
		this.idVenta = idVenta;
		this.fecha = fecha;
	}

	public Integer getIdVenta() {
		return idVenta;
	}

	public void setIdVenta(Integer idVenta) {
		this.idVenta = idVenta;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	@Override
	public String toString() {
		return "Venta [idVenta=" + idVenta + ", fecha=" + fecha + "]";
	}
	
	

}
