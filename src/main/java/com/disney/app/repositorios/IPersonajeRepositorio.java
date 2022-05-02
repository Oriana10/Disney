package com.disney.app.repositorios;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.disney.app.entidades.Pelicula;
import com.disney.app.entidades.Personaje;

@Repository
public interface IPersonajeRepositorio extends JpaRepository<Personaje, Long> {

	@Query("SELECT p FROM Personaje p where p.nombre = :nombre")
	public Optional<Personaje> buscarPorNombre(@Param("nombre") String nombre);

	@Query("SELECT p FROM Personaje p WHERE p.edad = :edad")
	public Optional<Personaje> buscarPorEdad(@Param("edad") Integer edad);

	@Query("SELECT p FROM Personaje p WHERE p.peso = :peso")
	public Optional<Personaje> buscarPorPeso(@Param("peso") Double peso);
/*
	@Query("SELECT \r\n" + "	personaje.nombre as 'Personaje'\r\n" + "	pelicula.titulo as 'Pelicula'\r\n"
			+ "	FROM Personaje personaje\r\n" + "	RIGHT JOIN Pelicula pelicula\r\n"
			+ "	ON personaje.PeliculaId = pelicula.Id")
	public Optional<Pelicula> detallesPeliculas();
*/
	/*
	 * ejemplo:
	 * SELECT E.Nombre as 'Empleado', D.Nombre as 'Departamento' FROM Empleados E
	 * RIGHT JOIN Departamentos D ON E.DepartamentoId = D.Id
	 * 
	 * SELECT personaje.nombre as 'Personaje' pelicula.titulo as 'Pelicula' FROM
	 * Personaje personaje RIGHT JOIN Pelicula pelicula ON personaje.PeliculaId =
	 * pelicula.Id
	 * 
	 * revisar
	 */
}
