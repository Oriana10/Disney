package com.disney.app.servicios.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.disney.app.entidades.Pelicula;
import com.disney.app.entidades.Personaje;
import com.disney.app.servicios.IPersonajeService;

import com.disney.app.repositorios.IPersonajeRepository;

@Service
public class PersonajeServiceImpl implements IPersonajeService {

	@Autowired
	private IPersonajeRepository IPersonajeRepository;

	// Create

	@Override
	public Personaje create(Long id, String imagen, String nombre, Integer edad, Integer peso, String historia,
			Set<Pelicula> listaPeliculas) {
		Personaje personaje = new Personaje();
		personaje.setImagen(imagen);
		personaje.setNombre(nombre);
		personaje.setEdad(edad);
		personaje.setHistoria(historia);
		//personaje.setListaPeliculas(listaPeliculas); no se actualiza la lista de peliculas
		return IPersonajeRepository.save(personaje);
	}

	// Update

	@Override
	public Personaje update(Long id, String imagen, String nombre, Integer edad, Integer peso, String historia,
			Set<Pelicula> listaPeliculas) {
		Personaje personaje = IPersonajeRepository.getById(id);
		personaje.setImagen(imagen);
		personaje.setNombre(nombre);
		personaje.setEdad(edad);
		personaje.setHistoria(historia);
		personaje.setListaPeliculas(listaPeliculas);
		return IPersonajeRepository.save(personaje);
	}

	// Delete

	@Override
	public void delete(Long id) {
		IPersonajeRepository.deleteById(id);
	}

	// Read

	@Override
	public List<Personaje> listarPersonaje() {
		IPersonajeRepository.findAll();
		return null;
	}

}