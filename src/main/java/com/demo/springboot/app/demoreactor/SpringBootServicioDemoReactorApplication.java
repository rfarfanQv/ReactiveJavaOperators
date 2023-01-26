package com.demo.springboot.app.demoreactor;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.demo.springboot.app.demoreactor.combinacion.Combinacion;
import com.demo.springboot.app.demoreactor.condicional.Condicional;
import com.demo.springboot.app.demoreactor.errores.ErrorOp;
import com.demo.springboot.app.demoreactor.filtrar.Filtrado;
import com.demo.springboot.app.demoreactor.matematico.Matematico;
import com.demo.springboot.app.demoreactor.model.Persona;


import io.reactivex.Observable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@SpringBootApplication
public class SpringBootServicioDemoReactorApplication implements CommandLineRunner {

	private final Logger log = LoggerFactory.getLogger(SpringBootServicioDemoReactorApplication.class);

	public void reactor() {

		Mono.just(new Persona(1, "Dani", 30))
		.doOnNext(p-> {
			
			//Logica requerida si se requieren mas de dos líneas
			log.info("[Reactor] Persona: " + p);
		})
		.subscribe(p-> log.info("[Reactor] Persona: " + p));
		

	}
	
	public void mono() {
		
		Mono.just(new Persona(1, "Rafa", 30))
		.subscribe(p-> log.info("[Reactor] Persona: " + p));
		
		
	}
	
	public void flux() {
		
		List<Persona> personas = new ArrayList<>();
		
		personas.add(new Persona(1, "Ignacio", 2));
		personas.add(new Persona(2, "Rafa", 30));
		personas.add(new Persona(3, "Dani", 30));
		//flujo de datos asincorono a partir de la coleccion personas
		Flux.fromIterable(personas).subscribe(p->log.info(p.toString()));
		
	}
	
	
	public void fluxMono() {
		
		List<Persona> personas = new ArrayList<>();
		
		personas.add(new Persona(1, "Ignacio", 2));
		personas.add(new Persona(2, "Rafa", 30));
		personas.add(new Persona(3, "Dani", 30));
		
		
		Flux<Persona>fx= Flux.fromIterable(personas);
		fx.collectList().subscribe(lista -> log.info(lista.toString()));
	}

	public void rxjava2() {

		Observable.just(new Persona(1, "Dani", 30))
		.doOnNext(p-> log.info("[Reactor] Persona: " + p))
		.subscribe(p-> log.info("[rxJava2] Persona: " + p));

	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootServicioDemoReactorApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Matematico app = new Matematico();
		
		
		app.sumarizing();
	}

}
