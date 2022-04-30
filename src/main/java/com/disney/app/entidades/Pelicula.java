package com.disney.app.entidades;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.disney.app.enums.Calificacion;

@Entity
public class Pelicula {

	@Id
	private Long id;
	private String imagen;
	private String titulo;
	private String fechaDeCreacion;
	private Calificacion calificacion;
	@ManyToMany(mappedBy = "listaPeliculas")
	private Set<Personaje> listaPersonajes;
}
