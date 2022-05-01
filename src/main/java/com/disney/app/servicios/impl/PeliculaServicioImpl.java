package com.disney.app.servicios.impl;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.disney.app.entidades.Genero;
import com.disney.app.entidades.Pelicula;
import com.disney.app.entidades.Personaje;
import com.disney.app.enums.ECalificacion;
import com.disney.app.servicios.IPeliculaservicio;
import com.disney.app.repositorios.IPeliculaRepositorio;

import java.io.IOException;
import java.util.Base64;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class PeliculaServicioImpl implements IPeliculaservicio {

	@Autowired
	IPeliculaRepositorio IPeliculaRepositorio;

	// Create

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
	public Pelicula create(String imagen, String titulo, String fechaDeCreacion, ECalificacion calificacion,
			Set<Personaje> listaPeliculas, Genero genero) {
		Pelicula pelicula = new Pelicula();
		pelicula.setImagen(imagen);
		pelicula.setTitulo(titulo);
		pelicula.setFechaDeCreacion(fechaDeCreacion);
		pelicula.setCalificacion(calificacion);
		pelicula.setListaPersonajes(listaPeliculas);
		pelicula.setGenero(genero);
		return IPeliculaRepositorio.save(pelicula);
	}

	// Read

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
	public List<Pelicula> listarPeliculas() {
		return IPeliculaRepositorio.findAll();

	}

	// Update

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
	public Pelicula update(Long id, MultipartFile imagen, String titulo, String fechaDeCreacion,
			ECalificacion calificacion, Genero genero) throws IOException {
		Pelicula pelicula = IPeliculaRepositorio.getById(id);
		String fileName = StringUtils.cleanPath(imagen.getOriginalFilename());
		pelicula.setImagen((Base64.getEncoder().encodeToString(imagen.getBytes())));
		pelicula.setTitulo(titulo);
		pelicula.setFechaDeCreacion(fechaDeCreacion);
		pelicula.setCalificacion(calificacion);
		pelicula.setGenero(genero);
		return IPeliculaRepositorio.save(pelicula);
	}

	// Delete

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
	public void delete(Long id) {
		IPeliculaRepositorio.deleteById(id);
	}

	// Buscar por nombre

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
	public Optional<Pelicula> buscarPorNombre(String nombre) {
		return IPeliculaRepositorio.buscarPorNombre(nombre);
	}

	// Buscar por genero

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
	public Optional<Pelicula> buscarPorGenero(String genero) {
		return IPeliculaRepositorio.buscarPorNombre(genero);
	}

	// Ordenar de manera ascendente

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
	public Optional<Pelicula> ordenarFechaDeCreacionAscendente() {
		return IPeliculaRepositorio.ordenarPorFechaDeCreacionAscendente();
	}

	// Ordenar de manera descendente

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
		public Optional<Pelicula> ordenarFechaDeCreacionDescendente() {
		return IPeliculaRepositorio.ordenarPorFechaDeCreacionDescendente();
	}

}
