package com.reto2.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
@NamedQuery(name="Usuario.getVendedor", query="SELECT u FROM Usuario u, RolusuarioPK r WHERE r.idUsuario = u.idUsuario AND r.idRol = 2")
@NamedQuery(name="Usuario.getComprador", query="SELECT u FROM Usuario u, RolusuarioPK r WHERE r.idUsuario = u.idUsuario AND r.idRol = 3")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String idUsuario;

	private String apellidos;

	private int cedula;

	private String celular;

	private String direccion;

	private String email;

	@Temporal(TemporalType.DATE)
	private Date fechaNacimiento;

	private String genero;

	private String nombres;

	private String nroTarjeta;

	private String telefono;

	//bi-directional many-to-one association to Auditoria
	@OneToMany(mappedBy="usuario")
	private List<Auditoria> auditorias;

	//bi-directional many-to-one association to Rolusuario
	@OneToMany(mappedBy="usuario")
	private List<Rolusuario> rolusuarios;

	//bi-directional many-to-one association to Tipodocumento
	@ManyToOne
	@JoinColumn(name="idTipoDocumento")
	private Tipodocumento tipodocumento;

	public Usuario() {
	}

	public String getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public int getCedula() {
		return this.cedula;
	}

	public void setCedula(int cedula) {
		this.cedula = cedula;
	}

	public String getCelular() {
		return this.celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getFechaNacimiento() {
		return this.fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getGenero() {
		return this.genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getNombres() {
		return this.nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getNroTarjeta() {
		return this.nroTarjeta;
	}

	public void setNroTarjeta(String nroTarjeta) {
		this.nroTarjeta = nroTarjeta;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<Auditoria> getAuditorias() {
		return this.auditorias;
	}

	public void setAuditorias(List<Auditoria> auditorias) {
		this.auditorias = auditorias;
	}

	public Auditoria addAuditoria(Auditoria auditoria) {
		getAuditorias().add(auditoria);
		auditoria.setUsuario(this);

		return auditoria;
	}

	public Auditoria removeAuditoria(Auditoria auditoria) {
		getAuditorias().remove(auditoria);
		auditoria.setUsuario(null);

		return auditoria;
	}

	public List<Rolusuario> getRolusuarios() {
		return this.rolusuarios;
	}

	public void setRolusuarios(List<Rolusuario> rolusuarios) {
		this.rolusuarios = rolusuarios;
	}

	public Rolusuario addRolusuario(Rolusuario rolusuario) {
		getRolusuarios().add(rolusuario);
		rolusuario.setUsuario(this);

		return rolusuario;
	}

	public Rolusuario removeRolusuario(Rolusuario rolusuario) {
		getRolusuarios().remove(rolusuario);
		rolusuario.setUsuario(null);

		return rolusuario;
	}

	public Tipodocumento getTipodocumento() {
		return this.tipodocumento;
	}

	public void setTipodocumento(Tipodocumento tipodocumento) {
		this.tipodocumento = tipodocumento;
	}

}