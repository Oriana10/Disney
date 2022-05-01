package com.disney.app.repositorios;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.disney.app.entidades.Pelicula;

@Repository
public interface IPeliculaRepositorio extends JpaRepository<Pelicula, Long> {
	
	@Query("SELECT p FROM PeliculaSerie p WHERE p.titulo = :titulo")
	public Optional<Pelicula> buscarPorNombre(@Param("titulo") String titulo);
	
	@Query("SELECT p FROM PeliculaSerie p WHERE p.genero.nombre = :genero")
	public Optional<Pelicula> buscarPorGenero(@Param("genero") String genero);
	
	@Query("SELECT p FROM PeliculaSerie p ORDER BY fecha_de_creacion ASC")
	public Optional<Pelicula> ordenarPorFechaDeCreacionAscendente();
	
	@Query("SELECT p FROM PeliculaSerie p ORDER BY fecha_de_creacion DESC")
	public Optional<Pelicula> ordenarPorFechaDeCreacionDescendente();
	
}
