package com.reto2.ejb;

import java.util.Collection;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.jboss.logging.Logger;

import com.reto2.internal.adapter.MarketPlaceAdapter;
import com.reto2.internal.dto.CompradorDTO;
import com.reto2.internal.params.GetCompradorParams;
import com.reto2.internal.remote.CompradorModuleRemote;
import com.reto2.model.Usuario;

@Stateless
public class CompradorModule implements CompradorModuleRemote{
	
	@PersistenceContext(unitName = "EjbMarketPlace")
	protected EntityManager entityManager;
	
	private static Logger logger = Logger.getLogger(VendedorModule.class.getName());

	@Override
	public Collection<CompradorDTO> getListComprador(GetCompradorParams filters) {
		// TODO Auto-generated method stub
		try {
			Query query = entityManager.createNamedQuery("Usuario.getComprador");	
			Collection<Usuario> usuarios = query.getResultList();
			return MarketPlaceAdapter.comprador2CompradorDTO(usuarios);			
		} catch (Exception e) {
			String error = "Error consultando dependencias";
			logger.error(error);
			//throw AcademiaExceptionHandler.handleException(AcademiaErrorLayerConstants.EBJ_INTEGRATION, null, error, e);
		}
		return null;
	}
}
