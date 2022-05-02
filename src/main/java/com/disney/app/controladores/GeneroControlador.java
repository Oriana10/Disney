package com.disney.app.controladores;

import java.util.Set;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.disney.app.entidades.Genero;
import com.disney.app.entidades.Pelicula;
import com.disney.app.enums.ECalificacion;
import com.disney.app.servicios.impl.GeneroServicioImpl;

@RestController
@RequestMapping("/generso")
public class GeneroControlador {
	@Autowired
	GeneroServicioImpl generoServicioImpl;

	// Create

	@PostMapping(path = "/create")
	public String create(@RequestParam String nombre, @RequestParam String imagen,
			@RequestParam Set<Pelicula> listaPeliculas) {
		try {
			generoServicioImpl.create(nombre, imagen, listaPeliculas);
			return "Creacion de genero exitosa";
		} catch (Exception e) {
			return "No se pudo crear el genero";
		}

	}

	// Update

	@PutMapping(path = "/update/{idMovie}")
	public String update(@PathParam(value = "id") Long id, @RequestParam String nombre, @RequestParam MultipartFile imagen,
			@RequestParam Set<Pelicula> listaPeliculas) throws Exception {
		try {
			generoServicioImpl.update(id, nombre, imagen, listaPeliculas);
			return "El genero con id " + id + " fue modificado con exito";
		} catch (Exception e) {
			return "No se pudo modificar el genero con el id " + id;
		}
	}

	// Read

	@GetMapping(path = "/read")
	public String listarGeneros() {
		try {
			generoServicioImpl.listarGeneros();
			return "Busqueda de generos exitosa";
		} catch (Exception e) {
			return "No se pudo buscar la lista de generos";
		}

	}

	// Delete

	@DeleteMapping(path = "/delete/{idMovie}")
	public String borrarPorId(@PathVariable("id") Long id) {
		try {
			generoServicioImpl.delete(id);
			return "El genero con id  " + id + " se eliminó correctamente";
		} catch (Exception e) {
			return "No se pudo eliminar el genero con " + id;
		}
	}
}
