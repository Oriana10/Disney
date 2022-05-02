package com.disney.app.controladores;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.disney.app.entidades.Usuario;
import com.disney.app.enums.ERol;
import com.disney.app.servicios.impl.UsuarioServicioImpl;

@RestController
@RequestMapping("/usuario")
public class UsuarioControlador {

	@Autowired
	UsuarioServicioImpl usuarioServicioImpl;

	// Create
	
	@PostMapping(path = "/create")
	public String create(@RequestBody Usuario usuario) {
		try {
			usuarioServicioImpl.create(usuario.getNombre(), usuario.getApellido(), usuario.getPassword(), usuario.getMail(), usuario.getRol());
			return "Creacion de usuario exitosa";
		} catch (Exception e) {
			return "No se pudo crear el usuario";
		}

	}
	
/*
	@PostMapping(path = "/create")
	public String create(@RequestParam String nombre, @RequestParam String apellido, @RequestParam String password,
			@RequestParam String mail, @RequestParam ERol rol) {
		try {
			usuarioServicioImpl.create(nombre, apellido, password, mail, rol);
			return "Creacion de usuario exitosa";
		} catch (Exception e) {
			return "No se pudo crear el usuario";
		}

	}
*/
	// Read

	@GetMapping(path = "/read")
	public String listarUsuarios() {
		try {
			usuarioServicioImpl.listarUsuarios();
			return "Busqueda de usuarios exitosa";
		} catch (Exception e) {
			return "No se pudo buscar el lista de usuarios";
		}

	}

	// Update

	@PutMapping(path = "/update/{id}")
	public String update(@PathParam(value = "id") Long id, @RequestParam String nombre, @RequestParam String apellido,
			@RequestParam String password, @RequestParam String mail, @RequestParam ERol rol) throws Exception {
		try {
			usuarioServicioImpl.update(id, nombre, apellido, password, mail, rol);
			return "El usuario con id " + id + " fue modificada con exito";
		} catch (Exception e) {
			return "No se pudo modificar el usuario con el id " + id;
		}
	}

	// Delete

	@DeleteMapping(path = "/delete/{idMovie}")
	public String borrarPorId(@PathVariable("id") Long id) {
		try {
			usuarioServicioImpl.delete(id);
			return "El usuario con id  " + id + " se eliminó correctamente";
		} catch (Exception e) {
			return "No se pudo eliminar el usuario con " + id;
		}
	}

	// Busqueda por mail

	@GetMapping(path = "/{mail}")
	public String obtenerPorNombre(@RequestParam String mail) {
		try {
			usuarioServicioImpl.buscarPorMail(mail);
			return "Busqueda por nombre realizada con exito";
		} catch (Exception e) {
			return "No se pudo buscar usuario por nombre";
		}

	}
}
