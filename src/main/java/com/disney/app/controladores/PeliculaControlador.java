package com.disney.app.controladores;

import java.util.Date;
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
	public String create(@RequestParam String imagen, @RequestParam String titulo, @RequestParam Date fechaDeCreacion,
			@RequestParam ECalificacion calificacion, @RequestParam Set<Personaje> listaPeliculas,
			@RequestParam Genero genero) {
		try {
			peliculaServicioImpl.create(imagen, titulo, fechaDeCreacion, calificacion, listaPeliculas, genero);
			return "Creacion de pelicula exitosa";
		} catch (Exception e) {
			return "No se pudo crear la pelicula";
		}

	}

	// Update

	@PutMapping(path = "/update/{idMovie}")
	public String update(@PathParam(value = "id") Long id, @RequestParam MultipartFile imagen,
			@RequestParam String titulo, @RequestParam Date fechaDeCreacion, @RequestParam ECalificacion calificacion,
			@RequestParam Genero genero) throws Exception {
		try {
			peliculaServicioImpl.update(id, imagen, titulo, fechaDeCreacion, calificacion, genero);
			return "La pelicula con id " + id + " fue modificada con exito";
		} catch (Exception e) {
			return "No se pudo modificar la pelicula con el id " + id;
		}
	}

	// Read

	@GetMapping(path = "/read")
	public String listarPeliculas() {
		try {
			peliculaServicioImpl.listarPeliculas();
			return "Busqueda de peliculas exitosa";
		} catch (Exception e) {
			return "No se pudo buscar la lista de peliculas";
		}

	}

	// Delete

	@DeleteMapping(path = "/delete/{idMovie}")
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
	public String obtenerPorNombre(@RequestParam String nombre) {
		try {
			peliculaServicioImpl.buscarPorNombre(nombre);
			return "Busqueda por nombre realizada con exito";
		} catch (Exception e) {
			return "No se pudo buscar pelicula por nombre";
		}

	}

	// Busqueda por genero

	@GetMapping(path = "/{genero}")
	public String obtenerPorGenero(@RequestParam String genero) {
		try {
			peliculaServicioImpl.buscarPorNombre(genero);
			return "Busqueda por genero realizada con exito";
		} catch (Exception e) {
			return "No se pudo buscar pelicula por genero";
		}

	}

	// Ordenar de manera ascendente
	/*
	 * @GetMapping(path = "/ordenarFechasAsc") public String
	 * ordenarFechaDeCreacionAscendente() { try {
	 * peliculaServicioImpl.ordenarFechaDeCreacionAscendente(); return
	 * "Ordenamiento de fechas de creacion ascendente realizado con exito"; } catch
	 * (Exception e) { return
	 * "No se pudo ordenar fechas de creacion ascendentemente"; }
	 * 
	 * }
	 * 
	 * // Ordenar de manera descendente
	 * 
	 * @GetMapping(path = "/ordenarFechasAsc") public String
	 * ordenarFechaDeCreacionDescendente() { try {
	 * peliculaServicioImpl.ordenarFechaDeCreacionDescendente(); return
	 * "Ordenamiento de fechas de creacion descendente realizado con exito"; } catch
	 * (Exception e) { return
	 * "No se pudo ordenar fechas de creacion descendentemente"; }
	 * 
	 * }
	 */
	// Borrar personajes por pelicula
	/*
	 * @DeleteMapping("/{idMovie}/characters/{idCharacter}") public String
	 * borrarPersonajesPorPelicula(@PathVariable("id") Long idMovie, @RequestParam
	 * Long idCharacter) { try {
	 * peliculaServicioImpl.borrarPersonajePorPelicula(idMovie, idCharacter); return
	 * "El personaje " + idCharacter + " de la pelicula con id  " + idMovie +
	 * " se eliminó correctamente"; } catch (Exception e) { return
	 * "No se puso eliminar el personaje " + idCharacter + " de la pelicula con " +
	 * idMovie; } }
	 */
	// Agregar personajes por pelicula
	/*
	 * @PostMapping("/{idMovie}/characters/{idCharacter}") public String
	 * agregarPersonajesPorPelicula(@PathVariable("id") Long idMovie, @RequestParam
	 * Long idCharacter) { try {
	 * peliculaServicioImpl.agregarPersonajePorPelicula(idMovie, idCharacter);
	 * return "El personaje " + idCharacter + " de la pelicula con id  " + idMovie +
	 * " se agregó correctamente"; } catch (Exception e) { return
	 * "No se puso eliminar el personaje " + idCharacter + " de la pelicula con " +
	 * idMovie; } }
	 */
}
