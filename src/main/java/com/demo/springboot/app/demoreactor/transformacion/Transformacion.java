package com.demo.springboot.app.demoreactor.transformacion;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.demo.springboot.app.demoreactor.model.Persona;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Transformacion {

	private final Logger log = LoggerFactory.getLogger(Transformacion.class);

	public void map() {
		
		List<Persona> personas = new ArrayList<>();

		personas.add(new Persona(1, "Ignacio", 2));
		personas.add(new Persona(2, "Rafa", 30));
		personas.add(new Persona(3, "Dani", 30));

		Flux.fromIterable(personas).map(p -> {
			p.setEdad(p.getEdad() + 10);
			return p;
		}).subscribe(p -> log.info("Persona: " + p.toString()));
	}

	public void flatMap() {

		List<Persona> personas = new ArrayList<>();

		personas.add(new Persona(1, "Ignacio", 2));
		personas.add(new Persona(2, "Rafa", 30));
		personas.add(new Persona(3, "Dani", 30));

		Flux.fromIterable(personas).flatMap(p -> {
			p.setEdad(p.getEdad() + 10);
			return Mono.just(p);
		}).subscribe(p -> log.info("persona: " + p.toString()));
	}

	public void groupBy() {

		List<Persona> personas = new ArrayList<>();

		personas.add(new Persona(1, "Ignacio", 2));
		personas.add(new Persona(2, "Rafa", 30));
		personas.add(new Persona(3, "Dani", 30));

		Flux.fromIterable(personas).groupBy(Persona::getIdPersona).flatMap(idFlux -> idFlux.collectList())
				.subscribe(x -> log.info(x.toString()));
	}

}
