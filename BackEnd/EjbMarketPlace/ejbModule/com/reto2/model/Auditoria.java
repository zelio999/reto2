package com.reto2.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the auditoria database table.
 * 
 */
@Entity
@NamedQuery(name="Auditoria.findAll", query="SELECT a FROM Auditoria a")
public class Auditoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String idAuditoria;

	private String fechaTransaccion;

	private String ipTransaccion;

	private String modulo;

	private String transaccion;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idUsuario")
	private Usuario usuario;

	public Auditoria() {
	}

	public String getIdAuditoria() {
		return this.idAuditoria;
	}

	public void setIdAuditoria(String idAuditoria) {
		this.idAuditoria = idAuditoria;
	}

	public String getFechaTransaccion() {
		return this.fechaTransaccion;
	}

	public void setFechaTransaccion(String fechaTransaccion) {
		this.fechaTransaccion = fechaTransaccion;
	}

	public String getIpTransaccion() {
		return this.ipTransaccion;
	}

	public void setIpTransaccion(String ipTransaccion) {
		this.ipTransaccion = ipTransaccion;
	}

	public String getModulo() {
		return this.modulo;
	}

	public void setModulo(String modulo) {
		this.modulo = modulo;
	}

	public String getTransaccion() {
		return this.transaccion;
	}

	public void setTransaccion(String transaccion) {
		this.transaccion = transaccion;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}