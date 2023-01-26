package com.demo.springboot.app.demoreactor.matematico;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.demo.springboot.app.demoreactor.model.Persona;

import reactor.core.publisher.Flux;

public class Matematico {
	private final Logger log = LoggerFactory.getLogger(Matematico.class);
	
	public void average() {
		
		List<Persona> personas1 = new ArrayList<>();

		personas1.add(new Persona(1, "Ignacio", 2));
		personas1.add(new Persona(2, "Rafa", 30));
		personas1.add(new Persona(3, "Dani", 30));
		
		Flux.fromIterable(personas1)
		.collect(Collectors.averagingInt(Persona::getEdad))
		.subscribe(p -> log.info(p.toString()));
	}
	
	public void count() {
		
		List<Persona> personas1 = new ArrayList<>();

		personas1.add(new Persona(1, "Ignacio", 2));
		personas1.add(new Persona(2, "Rafa", 30));
		personas1.add(new Persona(3, "Dani", 30));
		
		Flux.fromIterable(personas1)
		.count()
		.subscribe(p -> log.info(p.toString()));
		
	}
	
	public void min() {
		
		List<Persona> personas1 = new ArrayList<>();

		personas1.add(new Persona(1, "Ignacio", 2));
		personas1.add(new Persona(2, "Rafa", 30));
		personas1.add(new Persona(3, "Dani", 30));
		
		Flux.fromIterable(personas1)
		.collect(Collectors.minBy(Comparator.comparing(Persona:: getEdad)))
		.subscribe(p -> log.info(p.get().toString()));
		
	}
	
	public void sum() {
		
		List<Persona> personas1 = new ArrayList<>();

		personas1.add(new Persona(1, "Ignacio", 2));
		personas1.add(new Persona(2, "Rafa", 30));
		personas1.add(new Persona(3, "Dani", 30));
		
		Flux.fromIterable(personas1)
		.collect(Collectors.summingInt(Persona::getEdad))
		.subscribe(p -> log.info("Cantidad: "+ p));
	}
	
	
	public void sumarizing() {
		
		List<Persona> personas1 = new ArrayList<>();

		personas1.add(new Persona(1, "Ignacio", 2));
		personas1.add(new Persona(2, "Rafa", 30));
		personas1.add(new Persona(3, "Dani", 30));
		
		 Flux.fromIterable(personas1)
		.collect(Collectors.summarizingDouble(Persona::getEdad))
		.subscribe(p -> log.info("Resumen: "+ p));
		
	}

}
