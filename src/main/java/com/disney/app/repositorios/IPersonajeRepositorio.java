package com.disney.app.repositorios;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.disney.app.entidades.Personaje;

@Repository
public interface IPersonajeRepositorio extends JpaRepository<Personaje, Long> {

	@Query("SELECT p FROM Personaje p where p.nombre = :nombre")
	public Optional<Personaje> buscarPorNombre(@Param("nombre") String nombre);
	
	@Query("SELECT a FROM Personaje a WHERE a.edad = :edad")
	public Optional<Personaje> buscarPorEdad(@Param("edad") Integer edad);
	
	@Query("SELECT a FROM Personaje a WHERE a.peso = :peso")
	public Optional<Personaje> buscarPorPeso(@Param("peso") Double peso);
	
}
