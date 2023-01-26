package com.demo.springboot.app.demoreactor.filtrar;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.demo.springboot.app.demoreactor.model.Persona;

import reactor.core.publisher.Flux;

public class Filtrado {
	private final Logger log = LoggerFactory.getLogger(Filtrado.class);

	public void filter() {

		List<Persona> personas = new ArrayList<>();

		personas.add(new Persona(1, "Ignacio", 2));
		personas.add(new Persona(2, "Rafa", 30));
		personas.add(new Persona(3, "Dani", 30));

		Flux.fromIterable(personas)
		.filter(p -> p.getEdad() > 10)
		.subscribe(x -> log.info("filtrado: " + x.toString()));
	}

	public void distinc() {

		List<Persona> personas = new ArrayList<>();

		personas.add(new Persona(1, "Ignacio", 2));
		personas.add(new Persona(1, "Rafa", 30));
		personas.add(new Persona(3, "Dani", 30));

		Flux.fromIterable(personas)
		.distinct()
		.subscribe(x -> log.info(x.toString()));
	}

	public void take() {

		List<Persona> personas = new ArrayList<>();

		personas.add(new Persona(1, "Ignacio", 2));
		personas.add(new Persona(2, "Rafa", 30));
		personas.add(new Persona(3, "Dani", 30));

		Flux.fromIterable(personas)
		.take(2)
		.subscribe(x -> log.info(x.toString()));

	}

	public void takeLast() {
		List<Persona> personas = new ArrayList<>();

		personas.add(new Persona(1, "Ignacio", 2));
		personas.add(new Persona(2, "Rafa", 30));
		personas.add(new Persona(3, "Dani", 30));

		Flux.fromIterable(personas)
		.takeLast(1)
		.subscribe(x -> log.info(x.toString()));

	}

	public void skip() {

		List<Persona> personas = new ArrayList<>();

		personas.add(new Persona(1, "Ignacio", 2));
		personas.add(new Persona(2, "Rafa", 30));
		personas.add(new Persona(3, "Dani", 30));

		Flux.fromIterable(personas)
		.skip(1)
		.subscribe(x -> log.info(x.toString()));

	}

	public void skipLast() {

		List<Persona> personas = new ArrayList<>();

		personas.add(new Persona(1, "Ignacio", 2));
		personas.add(new Persona(2, "Rafa", 30));
		personas.add(new Persona(3, "Dani", 30));

		Flux.fromIterable(personas)
		.skipLast(2)
		.subscribe(x -> log.info(x.toString()));

	}

}
