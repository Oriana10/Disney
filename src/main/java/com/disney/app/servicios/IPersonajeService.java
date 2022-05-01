package com.disney.app.servicios;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.disney.app.entidades.Pelicula;
import com.disney.app.entidades.Personaje;

@Service
public interface IPersonajeService {

	Personaje create(Long id, String imagen, String nombre, Integer edad, Integer peso, String historia,
			Set<Pelicula> listaPeliculas);
    
    void delete(Long id);
    
    Personaje update(Long id, String imagen, String nombre, Integer edad, Integer peso, String historia,
			Set<Pelicula> listaPeliculas);
    
    List<Personaje> listarPersonaje();
	
}
