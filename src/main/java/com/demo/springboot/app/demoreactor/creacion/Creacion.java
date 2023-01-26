package com.demo.springboot.app.demoreactor.creacion;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.demo.springboot.app.demoreactor.model.Persona;

import io.reactivex.Observable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Creacion {

	private final Logger log = LoggerFactory.getLogger(Creacion.class);

	public void justFrom() {

		Mono.just(new Persona(1, "Dani", 29));
//		Flux.fromIterable(collection);
//		Observable.just();

	}

	public void empty() {

		Mono.empty();
		Flux.empty();
		Observable.empty();
	}
	
	public void range() {
		
		
		Flux.range(0, 3)
		.doOnNext(i -> log.info("i: " + i))
		.subscribe();
	}
	
	public void repeat() {
		
		
		List<Persona> personas = new ArrayList<>();
		
		personas.add(new Persona(1, "Ignacio", 2));
		personas.add(new Persona(2, "Rafa", 30));
		personas.add(new Persona(3, "Dani", 30));
		
		Flux.fromIterable(personas)
			.repeat(3)
			.subscribe(p -> log.info("P: " + p.toString()));
	}
}
