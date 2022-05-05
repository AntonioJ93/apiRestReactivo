package com.antsoft.reactivo.controlador;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.antsoft.reactivo.modelo.Persona;
import com.antsoft.reactivo.servicio.PersonaService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(PersonaController.BASE_URL)
@CrossOrigin("*")//para peticion React
public class PersonaController {

	public static final String BASE_URL="/persona";
	public static final String FIND_ALL="/all";
	public static final String ID="/{id}";

	@Autowired
	private PersonaService personaService;
	
	@PostMapping
	public Mono<Persona> crear(@RequestBody Persona persona){
		return personaService.crearPersona(persona);
	}
	
	@GetMapping(PersonaController.FIND_ALL)
	public Flux<Persona> finAll(){
		//List<Persona>lista=new ArrayList<>();
		Flux<Persona> personas=personaService.listarTodas();
		//personas.log().subscribe(p->lista.add(p));//para depurar
		return personas;
	}
	
	@GetMapping(PersonaController.ID)
	public Mono<Persona> findById(@PathVariable String id){
		return personaService.buscarPorId(id);
	}
	
	@GetMapping
	public Mono<Persona> findBynombre(@RequestParam String nombre){
		return personaService.buscarPornombre(nombre);
	}
}
