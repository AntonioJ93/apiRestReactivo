package com.antsoft.reactivo.repositorio;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.reactive.ReactiveSortingRepository;

import com.antsoft.reactivo.modelo.Persona;

import reactor.core.publisher.Mono;

public interface PersonaRepository extends ReactiveMongoRepository<Persona, String> {
	
	Mono<Persona>findByNombre(String nombre);

}
