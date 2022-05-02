package com.disney.app.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.disney.app.entidades.Genero;

@Repository
public interface IGeneroRepositorio extends JpaRepository<Genero, Long> {

}
