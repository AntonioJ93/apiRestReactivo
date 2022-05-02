package com.antsoft.reactivo.controlador;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.antsoft.reactivo.modelo.Persona;
import com.antsoft.reactivo.servicio.PersonaService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(PersonaController.BASE_URL)
@CrossOrigin("*")
public class PersonaController {

	public static final String BASE_URL="/persona";
	public static final String FIND_ALL="/all";
	
	@Autowired
	private PersonaService personaService;
	
	@PostMapping
	public Mono<Persona> crear(@RequestBody Persona persona){
		return personaService.crearPersona(persona);
	}
	
	@GetMapping(PersonaController.FIND_ALL)
	public Flux<Persona> finAll(){
		Flux<Persona> personas=personaService.listarTodas();
		return personas;
	}
}
