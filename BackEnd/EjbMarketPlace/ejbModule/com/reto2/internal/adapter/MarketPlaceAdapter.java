package com.reto2.internal.adapter;

import java.util.ArrayList;
import java.util.Collection;

import com.reto2.internal.dto.CompradorDTO;
import com.reto2.internal.dto.TipodocumentoDTO;
import com.reto2.internal.dto.VendedorDTO;
import com.reto2.model.Tipodocumento;
import com.reto2.model.Usuario;

public class MarketPlaceAdapter {

	public static Collection<VendedorDTO> vendedor2vendedorDTO(Collection<Usuario> vendedores) {
		Collection<VendedorDTO> vendedoresFinal = new ArrayList<VendedorDTO>();
		
		if(vendedores != null && vendedores.size()>0) {
			for(Usuario vendedor : vendedores){
				VendedorDTO d = MarketPlaceAdapter.vendedor2vendedorDTO(vendedor);
				vendedoresFinal.add(d);
			}
		}
		
		return vendedoresFinal;
	}
	
	public static Collection<CompradorDTO> comprador2CompradorDTO(Collection<Usuario> compradores) {
		Collection<CompradorDTO> compradorFinal = new ArrayList<CompradorDTO>();
		
		if(compradores != null && compradores.size()>0){
			for(Usuario comprador : compradores){
				CompradorDTO d = comprador2compradorDTO(comprador);
				compradorFinal.add(d);
			}
		}
		return compradorFinal;
	}
	
	
	public static VendedorDTO vendedor2vendedorDTO(Usuario usuario){
		VendedorDTO v = null;
		if (usuario != null) {
			v = new VendedorDTO();
			v.setIdUsuario(usuario.getIdUsuario());
			v.setCedula(usuario.getCedula());
			v.setNombres(usuario.getNombres());
			v.setApellidos(usuario.getApellidos());
			v.setDireccion(usuario.getDireccion());
			v.setEmail(usuario.getEmail());
			v.setFechaNacimiento(usuario.getFechaNacimiento());
			v.setGenero(usuario.getGenero());
			v.setCelular(usuario.getCelular());
			v.setNroTarjeta(usuario.getNroTarjeta());
			v.setTelefono(usuario.getTelefono());
			v.setTipodocumento(MarketPlaceAdapter.tipoDocumento2tipoDocumentoDTO(usuario.getTipodocumento()));
		}
		return v;
	}
	
	public static CompradorDTO comprador2compradorDTO(Usuario usuario){
		CompradorDTO c = null;
		if (usuario != null) {
			c = new CompradorDTO();
			c.setIdUsuario(usuario.getIdUsuario());
			c.setCedula(usuario.getCedula());
			c.setNombres(usuario.getNombres());
			c.setApellidos(usuario.getApellidos());
			c.setDireccion(usuario.getDireccion());
			c.setEmail(usuario.getEmail());
			c.setFechaNacimiento(usuario.getFechaNacimiento());
			c.setGenero(usuario.getGenero());
			c.setCelular(usuario.getCelular());
			c.setNroTarjeta(usuario.getNroTarjeta());
			c.setTelefono(usuario.getTelefono());
			c.setTipodocumento(MarketPlaceAdapter.tipoDocumento2tipoDocumentoDTO(usuario.getTipodocumento()));
		}
		return c;
	}
	
	public static TipodocumentoDTO tipoDocumento2tipoDocumentoDTO(Tipodocumento documento){
		TipodocumentoDTO td = null;
		if (documento != null) {
			td = new TipodocumentoDTO();
			td.setIdTipoDocumento(documento.getIdTipoDocumento());
			td.setNombreTipoDocumento(documento.getNombreTipoDocumento());
		}
		return td;
	}
		
}
