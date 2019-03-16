package com.reto2.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the estado database table.
 * 
 */
@Entity
@NamedQuery(name="Estado.findAll", query="SELECT e FROM Estado e")
public class Estado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idEstado;

	private String nombreEstado;

	private int tabla;

	//bi-directional many-to-one association to Rolusuario
	@OneToMany(mappedBy="estado")
	private List<Rolusuario> rolusuarios;

	public Estado() {
	}

	public int getIdEstado() {
		return this.idEstado;
	}

	public void setIdEstado(int idEstado) {
		this.idEstado = idEstado;
	}

	public String getNombreEstado() {
		return this.nombreEstado;
	}

	public void setNombreEstado(String nombreEstado) {
		this.nombreEstado = nombreEstado;
	}

	public int getTabla() {
		return this.tabla;
	}

	public void setTabla(int tabla) {
		this.tabla = tabla;
	}

	public List<Rolusuario> getRolusuarios() {
		return this.rolusuarios;
	}

	public void setRolusuarios(List<Rolusuario> rolusuarios) {
		this.rolusuarios = rolusuarios;
	}

	public Rolusuario addRolusuario(Rolusuario rolusuario) {
		getRolusuarios().add(rolusuario);
		rolusuario.setEstado(this);

		return rolusuario;
	}

	public Rolusuario removeRolusuario(Rolusuario rolusuario) {
		getRolusuarios().remove(rolusuario);
		rolusuario.setEstado(null);

		return rolusuario;
	}

}