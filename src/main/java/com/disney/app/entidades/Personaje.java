package com.disney.app.entidades;

import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Personaje {

	@Id
	private Long id;
	
	private String imagen;
	
	@NotEmpty(message = "El nombre no puede ser nulo o estar vacio")
	@NotBlank(message = "El nombre no puede ser whitespace")
	private String nombre;
	
	@Min(value = 18, message = "La edad no puede ser menor a 19")
    @Max(value = 150, message = "La edad no puede ser mayor a 100")
	private Integer edad;
	
	@Min(value = 30, message = "El peso no puede ser menor a 30kg")
    @Max(value = 300, message = "El peso no puede ser mayor a 300kg")
	private Double peso;
	
	@NotEmpty(message = "La historia no puede ser nulo o estar vacio")
	@NotBlank(message = "La historia no puede ser whitespace")
	private String historia;
	
	@ManyToMany
	@JoinTable(
			  name = "personajes_peliculas", 
			  joinColumns = @JoinColumn(name = "personaje_id"), 
			  inverseJoinColumns = @JoinColumn(name = "pelicula_id"))
	private Set<Pelicula> listaPeliculas;
	
	
	/*Constructors, Getters, Setters*/
	
	public Personaje() {
		super();
	}
	public Personaje(Long id, String imagen, String nombre, Integer edad, Double peso, String historia,
			Set<Pelicula> listaPeliculas) {
		super();
		this.id = id;
		this.imagen = imagen;
		this.nombre = nombre;
		this.edad = edad;
		this.peso = peso;
		this.historia = historia;
		this.listaPeliculas = listaPeliculas;
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
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getEdad() {
		return edad;
	}
	public void setEdad(Integer edad) {
		this.edad = edad;
	}
	public Double getPeso() {
		return peso;
	}
	public void setPeso(Double peso) {
		this.peso = peso;
	}
	public String getHistoria() {
		return historia;
	}
	public void setHistoria(String historia) {
		this.historia = historia;
	}
	public Set<Pelicula> getListaPeliculas() {
		return listaPeliculas;
	}
	public void setListaPeliculas(Set<Pelicula> listaPeliculas) {
		this.listaPeliculas = listaPeliculas;
	}
	
}
