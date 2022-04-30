package com.disney.app.entidades;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Genero {

	@Id
	private Long id;
	private String nombre;
	private String imagen;
	@ManyToMany
	private Set<Pelicula> listaPeliculas;
}
