package com.disney.app.servicios.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.disney.app.entidades.Pelicula;
import com.disney.app.entidades.Personaje;
import com.disney.app.servicios.IPersonajeServicio;

import java.io.IOException;
import java.util.Base64;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.disney.app.repositorios.IPersonajeRepositorio;

@Service
public class PersonajeServicioImpl implements IPersonajeServicio {

	@Autowired
	private IPersonajeRepositorio IPersonajeRepository;

	// Create

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
	public Personaje create(String imagen, String nombre, Integer edad, Integer peso, String historia,
			Set<Pelicula> listaPeliculas) {
		Personaje personaje = new Personaje();
		personaje.setImagen(imagen);
		personaje.setNombre(nombre);
		personaje.setEdad(edad);
		personaje.setHistoria(historia);
		personaje.setListaPeliculas(listaPeliculas);
		return IPersonajeRepository.save(personaje);
	}

	// Update

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
	public Personaje update(Long id, MultipartFile imagen, String nombre, Integer edad, Double peso, String historia)
			throws IOException {
		Personaje personaje = IPersonajeRepository.getById(id);
		String fileName = StringUtils.cleanPath(imagen.getOriginalFilename());
		personaje.setImagen((Base64.getEncoder().encodeToString(imagen.getBytes())));
		personaje.setNombre(nombre);
		personaje.setEdad(edad);
		personaje.setHistoria(historia);
		return IPersonajeRepository.save(personaje);
	}

	// Delete

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
	public void delete(Long id) {
		IPersonajeRepository.deleteById(id);
	}

	// Read

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
	public List<Personaje> listarPersonajes() {
		return IPersonajeRepository.findAll();
	}

	// Buscar por nombre

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
	public Optional<Personaje> buscarPorNombre(String nombre) {
		return IPersonajeRepository.buscarPorNombre(nombre);
	}

	// Buscar por edad

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
	public Optional<Personaje> buscarPorEdad(Integer edad) {
		return IPersonajeRepository.buscarPorEdad(edad);
	}

	// Buscar por peso

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
	public Optional<Personaje> buscarPorPeso(Double peso) {
		return IPersonajeRepository.buscarPorPeso(peso);
	}

	// Detalle personajes - peliculas
/*
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
	public Optional<Pelicula> detallesPeliculas() {
		return IPersonajeRepository.detallesPeliculas();
	}
*/
}