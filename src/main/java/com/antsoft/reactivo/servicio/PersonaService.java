package com.antsoft.reactivo.servicio;

import com.antsoft.reactivo.modelo.Persona;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public interface PersonaService {

	Mono<Persona> crearPersona(Persona persona);
	Flux<Persona> listarTodas();
}
