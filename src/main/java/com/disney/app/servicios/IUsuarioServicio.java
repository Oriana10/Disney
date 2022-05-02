package com.disney.app.servicios;

import java.util.List;

import org.springframework.stereotype.Service;

import com.disney.app.entidades.Usuario;
import com.disney.app.enums.ERol;

@Service
public interface IUsuarioServicio {

	Usuario create(String nombre, String apellido, String password, String mail, ERol rol);

	void delete(Long id);

	Usuario update(Long id, String nombre, String apellido, String password, String mail, ERol rol);

	List<Usuario> listarUsuarios();
}
