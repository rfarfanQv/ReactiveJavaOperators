package com.demo.springboot.app.demoreactor.condicional;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.demo.springboot.app.demoreactor.model.Persona;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public class Condicional {
	
	private final Logger log = LoggerFactory.getLogger(Condicional.class);
	
	public void defaultIfEmpty() {
		
		Mono.just(new Persona(1, "Rafa", 33))
		//Mono.empty()
		//Flux.empty()
		.defaultIfEmpty(new Persona(0, "DEFAULT", 99))
		.subscribe(x -> log.info(x.toString()));
		
	}
	
	public void takeUntill() {
		
		List<Persona> personas1 = new ArrayList<>();

		personas1.add(new Persona(1, "Ignacio", 2));
		personas1.add(new Persona(2, "Rafa", 3));
		personas1.add(new Persona(3, "Dani", 60));
		
		
		Flux.fromIterable(personas1)
		.takeUntil(p -> p.getEdad() > 2)
		.subscribe(x -> log.info(x.toString()));
	}
	
	public void timeOut() throws InterruptedException  {
		
		List<Persona> personas1 = new ArrayList<>();

		personas1.add(new Persona(1, "Ignacio", 2));
		personas1.add(new Persona(2, "Rafa", 3));
		personas1.add(new Persona(3, "Dani", 60));
		
		
		Flux.fromIterable(personas1)
		.delayElements(Duration.ofSeconds(1))
		.timeout(Duration.ofSeconds(2))
		.subscribe(x -> log.info(x.toString()));
		
		
		Thread.sleep(10000);
	}
	
}
