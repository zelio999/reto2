package com.reto2.internal.delegate.impl;

import java.util.ArrayList;
import java.util.Collection;

import org.jboss.logging.Logger;

import com.reto2.internal.adapter.MarketPlaceAdapterService;
import com.reto2.internal.connection.MakertPlaceServiceConnection;
import com.reto2.internal.connection.PropertiesManager;
import com.reto2.internal.delegate.api.IVendedorBusinessDelegate;
import com.reto2.internal.dto.VendedorDTO;
import com.reto2.internal.params.GetVendedorParams;
import com.reto2.internal.remote.VendedorModuleRemote;
import com.reto2.internal.vo.VendedorWebVO;

public class VendedorBusinessDelegate implements IVendedorBusinessDelegate{

	private MakertPlaceServiceConnection serviceConnection;

	//private Logger logger = Logger.getLogger(VendedorBusinessDelegate.class.getName());

	public VendedorBusinessDelegate() throws Exception {
		serviceConnection = MakertPlaceServiceConnection.getInstance(PropertiesManager.getInstance());
	}

	private synchronized VendedorModuleRemote getVendedorModuleService() /*throws AcademiaException*/ {
		VendedorModuleRemote service = (VendedorModuleRemote) serviceConnection.getRemoteSession(MakertPlaceServiceConnection.Vendedor_Path);
		return service;
	}

	@Override
	public Collection<VendedorWebVO> getListVendedor(GetVendedorParams params) {
		// TODO Auto-generated method stub
		try {
			VendedorModuleRemote service = getVendedorModuleService();
			Collection<VendedorDTO> listVendedores = service.getListVendedor(params);
			Collection<VendedorWebVO> vendedores = new ArrayList<VendedorWebVO>();
			for (VendedorDTO vendedor : listVendedores) {
				VendedorWebVO vend = MarketPlaceAdapterService.vendedorDTO2VendedorWebVO(vendedor);
				vendedores.add(vend);
			}

			return vendedores;
		} catch (Exception e) {
			//throw AcademiaExceptionHandler.handleException(AcademiaErrorLayerConstants.WEB_SERVER, null, null, e);
		}
		return null;
	}
}
