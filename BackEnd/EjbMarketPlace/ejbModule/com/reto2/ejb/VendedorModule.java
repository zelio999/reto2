package com.reto2.ejb;

import java.util.Collection;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.jboss.logging.Logger;

import com.reto2.internal.adapter.MarketPlaceAdapter;
import com.reto2.internal.dto.VendedorDTO;
import com.reto2.internal.params.GetVendedorParams;
import com.reto2.internal.remote.VendedorModuleRemote;
import com.reto2.model.Usuario;

@Stateless
public class VendedorModule implements VendedorModuleRemote{
	
	@PersistenceContext(unitName = "EjbMarketPlace")
	protected EntityManager entityManager;
	
	private static Logger logger = Logger.getLogger(VendedorModule.class.getName());

	@Override
	public Collection<VendedorDTO> getListVendedor(GetVendedorParams filters) {
		// TODO Auto-generated method stub
		try {
			Query query = entityManager.createNamedQuery("Usuario.getVendedor");	
			Collection<Usuario> usuarios = query.getResultList();
			return MarketPlaceAdapter.vendedor2vendedorDTO(usuarios);			
		} catch (Exception e) {
			String error = "Error consultando dependencias";
			logger.error(error);
			//throw AcademiaExceptionHandler.handleException(AcademiaErrorLayerConstants.EBJ_INTEGRATION, null, error, e);
		}
		return null;
	}

}
