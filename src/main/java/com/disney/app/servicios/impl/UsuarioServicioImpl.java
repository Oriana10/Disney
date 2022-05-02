package com.disney.app.servicios.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


import com.disney.app.entidades.Usuario;
import com.disney.app.enums.ERol;
import com.disney.app.repositorios.IUsuarioRepositorio;
import com.disney.app.servicios.MyMailSender;

@Service
public class UsuarioServicioImpl {
//implements UserDetailsService
	
	@Autowired
	private IUsuarioRepositorio IUsuarioRepositorio;
	
	@Autowired
	private MyMailSender myMailSender;

	// Permisos de usuario
	/*
	 * @Override public UserDetails loadUserByUsername(String mail) throws
	 * UsernameNotFoundException { Usuario usuario =
	 * IUsuarioRepositorio.buscarPorMail(mail);
	 * 
	 * if (usuario != null) { List<GrantedAuthority> permisos = new ArrayList<>();
	 * 
	 * GrantedAuthority permisoRol = new SimpleGrantedAuthority("USER_" +
	 * usuario.getRol().toString()); permisos.add(permisoRol);
	 * 
	 * ServletRequestAttributes attributes = (ServletRequestAttributes)
	 * RequestContextHolder .currentRequestAttributes(); HttpSession session =
	 * attributes.getRequest().getSession(); session.setAttribute("usuariosession",
	 * usuario);
	 * 
	 * User user = new User(usuario.getMail(), usuario.getPassword(), permisos);
	 * return user; } else { throw new
	 * UsernameNotFoundException("No se encontro el usuario"); } }
	 */
	// Create

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
	public Usuario create(String nombre, String apellido, String password, String mail, ERol rol) throws Exception {
		Usuario usuario = new Usuario();
		System.err.println("usuario ser 1 > " + usuario);
		usuario.setNombre(nombre);
		usuario.setApellido(apellido);
		usuario.setPassword(password);
		usuario.setPassword(password);
		usuario.setMail(mail);
		usuario.setRol(rol);
		myMailSender.enviarMail(usuario.getNombre(), usuario.getMail(), "¡Bienvenido a Disney API!");
		System.err.println("usuario ser 2 > " + usuario);
		return IUsuarioRepositorio.save(usuario);
	}

	// Read

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
	public List<Usuario> listarUsuarios() {
		return IUsuarioRepositorio.findAll();

	}

	// Update

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
	public Usuario update(Long id, String nombre, String apellido, String password, String mail, ERol rol)
			throws IOException {
		Usuario usuario = IUsuarioRepositorio.getById(id);
		usuario.setNombre(nombre);
		usuario.setApellido(apellido);
		BCryptPasswordEncoder encriptada = new BCryptPasswordEncoder();
		usuario.setPassword(encriptada.encode(usuario.getPassword()));
		usuario.setPassword(password);
		usuario.setMail(mail);
		usuario.setRol(rol);
		return IUsuarioRepositorio.save(usuario);
	}

	// Delete

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
	public void delete(Long id) {
		IUsuarioRepositorio.deleteById(id);
	}

	// Buscar por mail

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
	public Usuario buscarPorMail(String mail) {
		return IUsuarioRepositorio.buscarPorMail(mail);
	}

}
