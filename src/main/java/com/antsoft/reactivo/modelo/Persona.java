package com.antsoft.reactivo.modelo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;
import lombok.NoArgsConstructor;


@Document
@Data
@NoArgsConstructor
public class Persona {
	
	@Id
	private String id;
	
	//@Fielcambia nombre del campo en bbddd
	//@Indexed crea un indice para ese campo en bbdd
	//@Transient no persistente en bbdd
	private String nombre;

}
