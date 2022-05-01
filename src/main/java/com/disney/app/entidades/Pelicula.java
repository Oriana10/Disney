package com.disney.app.entidades;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.disney.app.enums.ECalificacion;

@Entity
public class Pelicula {

	@Id
	private Long id;
	private String imagen;
	private String titulo;
	private String fechaDeCreacion;
	@Enumerated(EnumType.STRING)
	private ECalificacion calificacion;
	@ManyToMany(mappedBy = "listaPeliculas")
	private Set<Personaje> listaPersonajes;
	
	public Pelicula() {
		super();
	}
	public Pelicula(Long id, String imagen, String titulo, String fechaDeCreacion, ECalificacion calificacion,
			Set<Personaje> listaPersonajes) {
		super();
		this.id = id;
		this.imagen = imagen;
		this.titulo = titulo;
		this.fechaDeCreacion = fechaDeCreacion;
		this.calificacion = calificacion;
		this.listaPersonajes = listaPersonajes;
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
		return listaPersonajes;
	}
	public void setListaPersonajes(Set<Personaje> listaPersonajes) {
		this.listaPersonajes = listaPersonajes;
	}
	
}

