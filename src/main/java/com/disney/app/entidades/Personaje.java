package com.disney.app.entidades;

import java.util.Set;

import javax.persistence.*;

@Entity
public class Personaje {

	@Id
	private Long id;
	private String imagen;
	private String nombre;
	private String edad;
	private String peso;
	private String historia;
	@ManyToMany
	@JoinTable(
			  name = "personajes_peliculas", 
			  joinColumns = @JoinColumn(name = "personaje_id"), 
			  inverseJoinColumns = @JoinColumn(name = "pelicula_id"))
	private Set<Pelicula> listaPeliculas;
}
