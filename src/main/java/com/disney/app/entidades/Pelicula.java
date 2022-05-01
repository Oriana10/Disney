package com.disney.app.entidades;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.disney.app.enums.ECalificacion;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Pelicula {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String imagen;

	@NotEmpty(message = "El titulo no puede ser nulo o estar vacio")
	@NotBlank(message = "El titulo no puede ser whitespace")
	private String titulo;

	@NotEmpty(message = "La fecha no puede ser nula o estar vacia")
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern = "yyyy-MM-dd")
	private String fechaDeCreacion;

	@Enumerated(EnumType.STRING)
	private ECalificacion calificacion;

	@NotNull(message = "La lista de peliculas no puede ser nula")
	@ManyToMany(mappedBy = "listaPeliculas", fetch = FetchType.LAZY)
	private Set<Personaje> listaPeliculas;

	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	private Genero genero;

	/* Constructors, Getters, Setters */

	public Pelicula() {
		super();
	}

	public Pelicula(Long id, String imagen,
			@NotEmpty(message = "El titulo no puede ser nulo o estar vacio") @NotBlank(message = "El titulo no puede ser whitespace") String titulo,
			@NotEmpty(message = "La fecha no puede ser nula o estar vacia") String fechaDeCreacion,
			ECalificacion calificacion,
			@NotNull(message = "La lista de peliculas no puede ser nula") Set<Personaje> listaPersonajes,
			Genero genero) {
		super();
		this.id = id;
		this.imagen = imagen;
		this.titulo = titulo;
		this.fechaDeCreacion = fechaDeCreacion;
		this.calificacion = calificacion;
		this.listaPeliculas = listaPersonajes;
		this.genero = genero;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getFechaDeCreacion() {
		return fechaDeCreacion;
	}

	public void setFechaDeCreacion(String fechaDeCreacion) {
		this.fechaDeCreacion = fechaDeCreacion;
	}

	public ECalificacion getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(ECalificacion calificacion) {
		this.calificacion = calificacion;
	}

	public Set<Personaje> getListaPersonajes() {
		return listaPeliculas;
	}

	public void setListaPersonajes(Set<Personaje> listaPersonajes) {
		this.listaPeliculas = listaPersonajes;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

}
