package com.demo.springboot.app.demoreactor.errores;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.demo.springboot.app.demoreactor.model.Persona;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;



public class ErrorOp {
	
	private final Logger log = LoggerFactory.getLogger(ErrorOp.class);
	
	public void retry() {
		
		List<Persona> personas1 = new ArrayList<>();

		personas1.add(new Persona(1, "Ignacio", 2));
		personas1.add(new Persona(2, "Rafa", 30));
		personas1.add(new Persona(3, "Dani", 30));
		
		Flux.fromIterable(personas1)
		.concatWith(Flux.error(new RuntimeException("UN ERROR")))
		.retry(1)
		.doOnNext(x -> log.info(x.toString()))
		.subscribe();
	}
	
	public void errorReturn() {
		
		List<Persona> personas = new ArrayList<>();

		personas.add(new Persona(1, "Ignacio", 2));
		personas.add(new Persona(2, "Rafa", 30));
		personas.add(new Persona(3, "Dani", 30));
		
		Flux.fromIterable(personas)
		.concatWith(Flux.error(new RuntimeException("UN ERROR")))
		.onErrorReturn(new Persona(0, "XYZ" , 99 ))
		.subscribe(x -> log.info(x.toString()));
		
		
		
	}
	
	public void errorResume() {
		
		List<Persona> personas = new ArrayList<>();

		personas.add(new Persona(1, "Ignacio", 2));
		personas.add(new Persona(2, "Rafa", 30));
		personas.add(new Persona(3, "Dani", 30));
		
		Flux.fromIterable(personas)
		.concatWith(Flux.error(new RuntimeException("UN ERROR")))
		.onErrorResume(e -> Mono.just(new Persona(0, "XYZ", 99)))
		.subscribe(x -> log.info(x.toString()));		
	}
	
	
	public void errorMap() {
		
		List<Persona> personas = new ArrayList<>();

		personas.add(new Persona(1, "Ignacio", 2));
		personas.add(new Persona(2, "Rafa", 30));
		personas.add(new Persona(3, "Dani", 30));
		
		Flux.fromIterable(personas)
		.concatWith(Flux.error(new RuntimeException("UN ERROR")))
		.onErrorMap(e -> new InterruptedException(e.getMessage()))
		.subscribe(x -> log.info(x.toString()));
		
	}

}
