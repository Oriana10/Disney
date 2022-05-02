package com.disney.app.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.disney.app.entidades.Usuario;

@Repository
public interface IUsuarioRepositorio extends JpaRepository<Usuario, Long> {

	@Query("SELECT u FROM Usuario u WHERE u.mail = :mail")
	public Usuario buscarPorMail(@Param("mail") String mail);
}
