package com.disney.app.entidades;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Entity
public class Genero {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty(message = "El nombre no puede ser nulo o estar vacio")
	@NotBlank(message = "El nombre no puede ser whitespace")
	private String nombre;

	private String imagen;

	@OneToMany(mappedBy = "genero", cascade = CascadeType.PERSIST)
	private Set<Pelicula> listaPeliculas;

	/* Constructors, Getters, Setters */
	
	public Genero() {
		super();
	}

	public Genero(Long id,
			@NotEmpty(message = "El nombre no puede ser nulo o estar vacio") @NotBlank(message = "El nombre no puede ser whitespace") String nombre,
			String imagen, Set<Pelicula> listaPeliculas) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.imagen = imagen;
		this.listaPeliculas = listaPeliculas;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public Set<Pelicula> getListaPeliculas() {
		return listaPeliculas;
	}

	public void setListaPeliculas(Set<Pelicula> listaPeliculas) {
		this.listaPeliculas = listaPeliculas;
	}

}
