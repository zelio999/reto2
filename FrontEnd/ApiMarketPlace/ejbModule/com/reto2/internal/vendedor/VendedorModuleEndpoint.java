package com.reto2.internal.vendedor;

import java.util.Collection;

import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.reto2.internal.facade.MarketPlaceFacade;
import com.reto2.internal.params.GetVendedorParams;
import com.reto2.internal.vo.VendedorWebVO;


@Stateless
@Path("/vendedor")
public class VendedorModuleEndpoint {

	@POST
	@Path("/getListVendedor")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<VendedorWebVO> getListVendedor(GetVendedorParams params) /*throws AcademiaCoreWebServiceException*/ {
		
		try {
			return MarketPlaceFacade.getInstance().getVendedorService().getListVendedor(params);
		} catch (Exception e) {			
			//throw new AcademiaCoreWebServiceException(e,Status.INTERNAL_SERVER_ERROR);
		}
		return null;
	}


}
