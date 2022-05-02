package com.disney.app.entidades;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import com.disney.app.enums.ERol;

@Entity
public class Usuario {

private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotEmpty(message = "El nombre no puede ser nulo o estar vacio")
	@NotBlank(message = "El nombre no puede ser whitespace")
    private String nombre;
    
    @NotEmpty(message = "El apelllido no puede ser nulo o estar vacio")
	@NotBlank(message = "El apelllido no puede ser whitespace")
    private String apellido;
    
    private String password;
    
    @Email(message = "Ingrese el correo electrónico correcto")
    private String mail;
    
    @Enumerated(EnumType.STRING)
	private ERol rol;

    /*Constructors, Getters, Setters*/
    
	public Usuario() {
		super();
	}

	public Usuario(Long id,
			@NotEmpty(message = "El nombre no puede ser nulo o estar vacio") @NotBlank(message = "El nombre no puede ser whitespace") String nombre,
			@NotEmpty(message = "El apelllido no puede ser nulo o estar vacio") @NotBlank(message = "El apelllido no puede ser whitespace") String apellido,
			String password, @Email(message = "Ingrese el correo electrónico correcto") String mail, ERol rol) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.password = password;
		this.mail = mail;
		this.rol = rol;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public ERol getRol() {
		return rol;
	}

	public void setRol(ERol rol) {
		this.rol = rol;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", password=" + password
				+ ", mail=" + mail + ", rol=" + rol + "]";
	}

}
