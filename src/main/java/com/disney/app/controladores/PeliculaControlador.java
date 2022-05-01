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
import com.disney.app.servicios.impl.PeliculaServicioImpl;
import com.disney.app.entidades.Genero;
import com.disney.app.entidades.Pelicula;
import com.disney.app.entidades.Personaje;
import com.disney.app.enums.ECalificacion;

@RestController
@RequestMapping("/movies")
public class PeliculaControlador {

	@Autowired
	PeliculaServicioImpl peliculaServicioImpl;

	// Create

	@PostMapping(path = "/create")
	private String create(@RequestParam String imagen, @RequestParam String titulo,
			@RequestParam String fechaDeCreacion, @RequestParam ECalificacion calificacion,
			@RequestParam Set<Personaje> listaPeliculas, @RequestParam Genero genero) {
		try {
			peliculaServicioImpl.create(imagen, titulo, fechaDeCreacion, calificacion, listaPeliculas, genero);
			return "Creacion de pelicula exitosa";
		} catch (Exception e) {
			return "No se pudo crear la pelicula";
		}

	}

	// Update

	@PutMapping(path = "/update/{id}")
	private String update(@PathParam(value = "id") Long id, @RequestParam MultipartFile imagen,
			@RequestParam String titulo, @RequestParam String fechaDeCreacion, @RequestParam ECalificacion calificacion,
			@RequestParam Genero genero) throws Exception {
		try {
			peliculaServicioImpl.update(id, imagen, titulo, fechaDeCreacion, calificacion, genero);
			return "La pelicula con id " + id + " fue modificada con exito";
		} catch (Exception e) {
			return "No se pudo modificar la pelicula con el id + id";
		}
	}

	// Read

	@GetMapping(path = "/read")
	private String listarPeliculas() {
		try {
			peliculaServicioImpl.listarPeliculas();
			return "Busqueda de peliculas exitosa";
		} catch (Exception e) {
			return "No se pudo buscar la lista de peliculas";
		}

	}

	// Delete

	@DeleteMapping(path = "/delete/{id}")
	public String borrarPorId(@PathVariable("id") Long id) {
		try {
			peliculaServicioImpl.delete(id);
			return "La pelicula con id  " + id + " se eliminó correctamente";
		} catch (Exception e) {
			return "No se pudo eliminar la pelicula con " + id;
		}
	}

	// Busqueda por nombre

	@GetMapping(path = "/{nombre}")
	private String obtenerPorNombre(@RequestParam String nombre) {
		try {
			peliculaServicioImpl.buscarPorNombre(nombre);
			return "Busqueda por nombre realizada con exito";
		} catch (Exception e) {
			return "No se pudo buscar pelicula por nombre";
		}

	}

	// Busqueda por genero

	@GetMapping(path = "/{genero}")
	private String obtenerPorGenero(@RequestParam String genero) {
		try {
			peliculaServicioImpl.buscarPorNombre(genero);
			return "Busqueda por genero realizada con exito";
		} catch (Exception e) {
			return "No se pudo buscar pelicula por genero";
		}

	}

	// Ordenar de manera ascendente

	@GetMapping(path = "/ordenarFechasAsc")
	private String ordenarFechaDeCreacionAscendente() {
		try {
			peliculaServicioImpl.ordenarFechaDeCreacionAscendente();
			return "Ordenamiento de fechas de creacion ascendente realizado con exito";
		} catch (Exception e) {
			return "No se pudo ordenar fechas de creacion ascendentemente";
		}

	}

	// Ordenar de manera descendente

	@GetMapping(path = "/ordenarFechasAsc")
	private String ordenarFechaDeCreacionDescendente() {
		try {
			peliculaServicioImpl.ordenarFechaDeCreacionDescendente();
			return "Ordenamiento de fechas de creacion descendente realizado con exito";
		} catch (Exception e) {
			return "No se pudo ordenar fechas de creacion descendentemente";
		}

	}

}
