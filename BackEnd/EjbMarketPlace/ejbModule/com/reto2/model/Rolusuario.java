package com.reto2.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the rolusuario database table.
 * 
 */
@Entity
@NamedQuery(name="Rolusuario.findAll", query="SELECT r FROM Rolusuario r")
public class Rolusuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private RolusuarioPK id;

	private String contrasena;

	private String login;

	//bi-directional many-to-one association to Estado
	@ManyToOne
	@JoinColumn(name="idEstado")
	private Estado estado;

	//bi-directional many-to-one association to Rol
	@ManyToOne
	@JoinColumn(name="idRol")
	private Rol rol;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idUsuario")
	private Usuario usuario;

	public Rolusuario() {
	}

	public RolusuarioPK getId() {
		return this.id;
	}

	public void setId(RolusuarioPK id) {
		this.id = id;
	}

	public String getContrasena() {
		return this.contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public Estado getEstado() {
		return this.estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Rol getRol() {
		return this.rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}