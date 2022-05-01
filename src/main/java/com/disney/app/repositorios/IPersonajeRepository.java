package com.disney.app.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.disney.app.entidades.Personaje;

@Repository
public interface IPersonajeRepository extends JpaRepository<Personaje, Long> {

	
	
}
