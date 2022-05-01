package com.disney.app.servicios;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.disney.app.entidades.Genero;
import com.disney.app.entidades.Pelicula;
import com.disney.app.entidades.Personaje;
import com.disney.app.enums.ECalificacion;

@Service
public interface IPeliculaservicio {

	Pelicula create(String imagen, String titulo, String fechaDeCreacion, ECalificacion calificacion, Set<Personaje> listaPersonajes, Genero genero);
    
    void delete(Long id);
    
    // Personaje update(String imagen, String titulo, String fechaDeCreacion, ECalificacion calificacion, Set<Personaje> listaPersonajes, Genero genero); comentado porque sino entra en conflicto el valor de imagen con Multiparfile y String
    
    List<Pelicula> listarPeliculas();
	
}
