package com.demo.springboot.app.demoreactor.combinacion;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.demo.springboot.app.demoreactor.model.Persona;
import com.demo.springboot.app.demoreactor.model.Venta;

import reactor.core.publisher.Flux;

public class Combinacion {

	private final Logger log = LoggerFactory.getLogger(Combinacion.class);
	
	public void merge() {
		
		
		List<Persona> personas1 = new ArrayList<>();

		personas1.add(new Persona(1, "Ignacio", 2));
		personas1.add(new Persona(2, "Rafa", 30));
		personas1.add(new Persona(3, "Dani", 30));
		
		
		List<Persona> personas2 = new ArrayList<>();

		personas2.add(new Persona(4, "Anto", 30));
		personas2.add(new Persona(5, "Samuel", 3));
		personas2.add(new Persona(6, "Valeria", 13));
		
		List<Venta> ventas = new ArrayList<>();
		ventas.add(new Venta(1, LocalDate.now()));
		
		
		Flux<Persona> fx1 = Flux.fromIterable(personas1);
		Flux<Persona> fx2 = Flux.fromIterable(personas2);
		Flux<Venta> fx3 = Flux.fromIterable(ventas);
		
		Flux.merge(fx1, fx2, fx3)
		.subscribe(x -> log.info(x.toString()));
		
	}
	
	
	public void zip() {
		
		List<Persona> personas1 = new ArrayList<>();

		personas1.add(new Persona(1, "Ignacio", 2));
		personas1.add(new Persona(2, "Rafa", 30));
		personas1.add(new Persona(3, "Dani", 30));
		
		
		List<Persona> personas2 = new ArrayList<>();

		personas2.add(new Persona(4, "Anto", 30));
		personas2.add(new Persona(5, "Samuel", 3));
		personas2.add(new Persona(6, "Valeria", 13));
		
		List<Venta> ventas = new ArrayList<>();
		ventas.add(new Venta(1, LocalDate.now()));
		
		
		Flux<Persona> fx1 = Flux.fromIterable(personas1);
		Flux<Persona> fx2 = Flux.fromIterable(personas2);
		Flux<Venta> fx3 = Flux.fromIterable(ventas);
		
		Flux.zip(fx1, fx2, (p1, p2) -> String.format("Flux1: %s, Flux2: %s", p1, p2))
		.subscribe(x -> log.info(x.toString()));
		
		
	}
	
	
	public void zipWith() {
		
		List<Persona> personas1 = new ArrayList<>();

		personas1.add(new Persona(1, "Ignacio", 2));
		personas1.add(new Persona(2, "Rafa", 30));
		personas1.add(new Persona(3, "Dani", 30));
		
		
		List<Persona> personas2 = new ArrayList<>();

		personas2.add(new Persona(4, "Anto", 30));
		personas2.add(new Persona(5, "Samuel", 3));
		personas2.add(new Persona(6, "Valeria", 13));
		
		List<Venta> ventas = new ArrayList<>();
		ventas.add(new Venta(1, LocalDate.now()));
		
		
		Flux<Persona> fx1 = Flux.fromIterable(personas1);
		Flux<Persona> fx2 = Flux.fromIterable(personas2);
		Flux<Venta> fx3 = Flux.fromIterable(ventas);
		
		fx1.zipWith(fx3, (p1, v1) -> String.format("Flux1: %s, Flux2: %s", p1, v1))
		.subscribe(x -> log.info(x.toString()));
		
	}
}
