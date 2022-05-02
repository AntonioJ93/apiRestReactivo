package com.antsoft.reactivo.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.antsoft.reactivo.modelo.Persona;
import com.antsoft.reactivo.repositorio.PersonaRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@Service
public class PersonaServiceImpl implements PersonaService {
	
	@Autowired
	PersonaRepository personaRepository;

	@Override
	public Mono<Persona> crearPersona(Persona persona) {
		// TODO Auto-generated method stub
		return personaRepository.save(persona);
	}

	@Override
	public Flux<Persona> listarTodas() {
		// TODO Auto-generated method stub
		return personaRepository.findAll();
	}

}
