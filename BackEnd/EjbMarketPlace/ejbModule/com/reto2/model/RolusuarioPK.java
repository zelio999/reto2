package com.reto2.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the rolusuario database table.
 * 
 */
@Embeddable
public class RolusuarioPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private int idRol;

	@Column(insertable=false, updatable=false)
	private String idUsuario;

	public RolusuarioPK() {
	}
	public int getIdRol() {
		return this.idRol;
	}
	public void setIdRol(int idRol) {
		this.idRol = idRol;
	}
	public String getIdUsuario() {
		return this.idUsuario;
	}
	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof RolusuarioPK)) {
			return false;
		}
		RolusuarioPK castOther = (RolusuarioPK)other;
		return 
			(this.idRol == castOther.idRol)
			&& this.idUsuario.equals(castOther.idUsuario);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idRol;
		hash = hash * prime + this.idUsuario.hashCode();
		
		return hash;
	}
}