package com.reto2.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the rol database table.
 * 
 */
@Entity
@NamedQuery(name="Rol.findAll", query="SELECT r FROM Rol r")
public class Rol implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idRol;

	private String nombreRol;

	//bi-directional many-to-many association to Permiso
	@ManyToMany
	@JoinTable(
		name="rolpermiso"
		, joinColumns={
			@JoinColumn(name="idRol")
			}
		, inverseJoinColumns={
			@JoinColumn(name="idPermiso")
			}
		)
	private List<Permiso> permisos;

	//bi-directional many-to-one association to Rolusuario
	@OneToMany(mappedBy="rol")
	private List<Rolusuario> rolusuarios;

	public Rol() {
	}

	public int getIdRol() {
		return this.idRol;
	}

	public void setIdRol(int idRol) {
		this.idRol = idRol;
	}

	public String getNombreRol() {
		return this.nombreRol;
	}

	public void setNombreRol(String nombreRol) {
		this.nombreRol = nombreRol;
	}

	public List<Permiso> getPermisos() {
		return this.permisos;
	}

	public void setPermisos(List<Permiso> permisos) {
		this.permisos = permisos;
	}

	public List<Rolusuario> getRolusuarios() {
		return this.rolusuarios;
	}

	public void setRolusuarios(List<Rolusuario> rolusuarios) {
		this.rolusuarios = rolusuarios;
	}

	public Rolusuario addRolusuario(Rolusuario rolusuario) {
		getRolusuarios().add(rolusuario);
		rolusuario.setRol(this);

		return rolusuario;
	}

	public Rolusuario removeRolusuario(Rolusuario rolusuario) {
		getRolusuarios().remove(rolusuario);
		rolusuario.setRol(null);

		return rolusuario;
	}

}