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

import com.disney.app.entidades.Pelicula;
import com.disney.app.servicios.impl.PersonajeServicioImpl;

@RestController
@RequestMapping("/characters")
public class PersonajeControlador {

	@Autowired
	PersonajeServicioImpl personajeServicioImpl;

	// Create

	@PostMapping(path = "/create/{id}")
	private String create(String imagen, String nombre, Integer edad, Integer peso, String historia,
			Set<Pelicula> listaPeliculas) {
		try {
			personajeServicioImpl.create(imagen, nombre, edad, peso, historia, listaPeliculas);
			return "Creacion de personaje exitosa";
		} catch (Exception e) {
			return "No se pudo crear el personaje";
		}

	}

	// Update

	@PutMapping(path = "/update/{id}")
	private String update(@PathParam(value = "id") Long id, @RequestParam MultipartFile imagen,
			@RequestParam String nombre, @RequestParam Integer edad, @RequestParam Double peso,
			@RequestParam String historia) throws Exception {
		try {
			personajeServicioImpl.update(id, imagen, nombre, edad, peso, historia);
			return "El personaje con id " + id + " fue modificado con exito";
		} catch (Exception e) {
			return "No se pudo modificar el personaje con el id + id";
		}
	}

	// Read

	@GetMapping(path = "/read")
	private String listarPersonaje() {
		try {
			personajeServicioImpl.listarPersonajes();
			return "Busqueda de personajes exitosa";
		} catch (Exception e) {
			return "No se pudo buscar la lista de personajes";
		}

	}

	// Delete

	@DeleteMapping(path = "/delete/{id}")
	public String borrarPorId(@PathVariable("id") Long id) {
		try {
			personajeServicioImpl.delete(id);
			return "El personaje con id  " + id + " se eliminó correctamente";
		} catch (Exception e) {
			return "No se pudo eliminar el personaje con " + id;
		}
	}

	@GetMapping(path = "/{nombre}")
	private String obtenerPorNombre(@RequestParam String nombre) {
		try {
			personajeServicioImpl.buscarPorNombre(nombre);
			return "Peticion realizada con exito";
		} catch (Exception e) {
			return "Hubo un error";
		}

	}

	@GetMapping(path = "/{edad}")
	private String obtenerPorEdad(@RequestParam Integer edad) {
		try {
			personajeServicioImpl.buscarPorEdad(edad);
			return "Peticion realizada con exito";
		} catch (Exception e) {
			return "Hubo un error";
		}

	}

	@GetMapping(path = "/{peso}")
	private String obtenerPorPeso(@RequestParam Double peso) {
		try {
			personajeServicioImpl.buscarPorPeso(peso);
			return "Peticion realizada con exito";
		} catch (Exception e) {
			return "Hubo un error";
		}

	}

}