package com.disney.app.repositorios;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.disney.app.entidades.Pelicula;

@Repository
public interface IPeliculaRepositorio extends JpaRepository<Pelicula, Long> {

	/* Busquedas */
	
	@Query("SELECT p FROM Pelicula p WHERE p.titulo = :titulo")
	public Optional<Pelicula> buscarPorNombre(@Param("titulo") String titulo);

	@Query("SELECT p FROM Pelicula p WHERE p.genero.nombre = :genero")
	public Optional<Pelicula> buscarPorGenero(@Param("genero") String genero);

	/* Orden */
	/*
	@Query("SELECT p FROM Pelicula p ORDER BY fecha_de_creacion ASC")
	public Optional<Pelicula> ordenarPorFechaDeCreacionAscendente();

	@Query("SELECT p FROM Pelicula p ORDER BY fecha_de_creacion DESC")
	public Optional<Pelicula> ordenarPorFechaDeCreacionDescendente();
*/
	/* Modificar personajes desde pelicula */
	/*
	@Query("DELETE pp.personaje_id \r\n" + "FROM personajes_peliculas pp \r\n" + "WHERE pp.pelicula_id = :idMovie\r\n"
			+ "AND * pp.personaje_id = :idCharacter")
	public Optional<Pelicula> borrarPersonajePorPelicula(@Param("idMovie") Long idMovie,
			@Param("idCharacter") Long idCharacter);
			*/
/*
	@Query("")
	public Optional<Pelicula> agregarPersonajePorPelicula(@Param("idMovie") Long idMovie,
			@Param("idCharacter") Long idCharacter);
*/
	
	/*
	 * ideas 
	 * 
	 * SELECT table1.column1, table1.column2, table2.column1, ... FROM table1 INNER
	 * JOIN table2 ON table1.matching_column = table2.matching_column;
	 * 
	 * 
	 * @Query("SELECT use from Useres fetch join use.profiles where user.id = use.idusuario = (?1)"
	 * ) List<Users> userdata(int id);
	 * 
	 * SELECT c FROM Category c WHERE c.categoryName LIKE :categoryName ORDER BY
	 * c.categoryId
	 * 
	 * -------
	 * 
	 * DELETE pp.personaje_id FROM personajes_peliculas pp WHERE pp.pelicula_id =
	 * :idMovie AND * pp.personaje_id = :idCharacter
	 * 
	 * 
	 * CREATE pp.personaje_id FROM personajes_peliculas pp WHERE pp.pelicula_id =
	 * :idMovie AND * pp.personaje_id = :idCharacter
	 * 
	 * 
	 */

}
