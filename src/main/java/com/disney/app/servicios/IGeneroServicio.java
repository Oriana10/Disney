package com.disney.app.servicios;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.disney.app.entidades.Genero;
import com.disney.app.entidades.Pelicula;
import com.disney.app.entidades.Personaje;
import com.disney.app.enums.ECalificacion;

@Service
public interface IGeneroServicio {

Genero create(String nombre, String imagen, Set<Pelicula> listaPeliculas);
    
    void delete(Long id);
    
    // Genero update(String nombre, String imagen, Set<Pelicula> listaPeliculas); comentado porque sino entra en conflicto el valor de imagen con Multiparfile y String
    
    List<Genero> listarGeneros();
}
