package com.antsoft.reactivo.repositorio;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import com.antsoft.reactivo.modelo.Persona;

public interface PersonaRepository extends ReactiveMongoRepository<Persona, String> {

}
