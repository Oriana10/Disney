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
import com.disney.app.entidades.Genero;
import com.disney.app.entidades.Personaje;
import com.disney.app.enums.ECalificacion;
import com.disney.app.repositorios.IGeneroRepositorio;

import java.io.IOException;
import java.util.Base64;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class GeneroServicioImpl {

	@Autowired
	private IGeneroRepositorio IGeneroRepositorio;

	// Create

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
	public Genero create(String nombre, String imagen, Set<Pelicula> listaPeliculas) {
		Genero genero = new Genero();
		genero.setNombre(nombre);
		genero.setImagen(imagen);
		genero.setListaPeliculas(listaPeliculas);
		return IGeneroRepositorio.save(genero);
	}

	// Read

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
	public List<Genero> listarGeneros() {
		return IGeneroRepositorio.findAll();

	}

	// Update

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
	public Genero update(Long id, String nombre, MultipartFile imagen, Set<Pelicula> listaPeliculas)
			throws IOException {
		Genero genero = IGeneroRepositorio.getById(id);
		String fileName = StringUtils.cleanPath(imagen.getOriginalFilename());
		genero.setImagen((Base64.getEncoder().encodeToString(imagen.getBytes())));
		genero.setNombre(nombre);
		genero.setListaPeliculas(listaPeliculas);
		return IGeneroRepositorio.save(genero);
	}

	// Delete

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
	public void delete(Long id) {
		IGeneroRepositorio.deleteById(id);
	}
}
