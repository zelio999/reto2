package com.reto2.internal.comprador;

import java.util.Collection;

import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.reto2.internal.facade.MarketPlaceFacade;
import com.reto2.internal.params.GetCompradorParams;
import com.reto2.internal.vo.CompradorWebVO;



@Stateless
@Path("/comprador")
public class CompradorModuleEndpoint {

	@POST
	@Path("/getListComprador")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<CompradorWebVO> getListComprador(GetCompradorParams params) /*throws AcademiaCoreWebServiceException*/ {
		
		try {
			return MarketPlaceFacade.getInstance().getCompradorService().getListComprador(params);
		} catch (Exception e) {			
			//throw new AcademiaCoreWebServiceException(e,Status.INTERNAL_SERVER_ERROR);
		}
		return null;
	}


}
