package com.reto2.internal.delegate.impl;

import java.util.ArrayList;
import java.util.Collection;

import org.jboss.logging.Logger;

import com.reto2.internal.adapter.MarketPlaceAdapterService;
import com.reto2.internal.connection.MakertPlaceServiceConnection;
import com.reto2.internal.connection.PropertiesManager;
import com.reto2.internal.delegate.api.ICompradorBusinessDelegate;
import com.reto2.internal.dto.CompradorDTO;
import com.reto2.internal.params.GetCompradorParams;
import com.reto2.internal.remote.CompradorModuleRemote;
import com.reto2.internal.vo.CompradorWebVO;

public class CompradorBusinessDelegate implements ICompradorBusinessDelegate {

	private MakertPlaceServiceConnection serviceConnection;
	//private Logger logger = Logger.getLogger(CompradorBusinessDelegate.class.getName());

	public CompradorBusinessDelegate() throws Exception {
		serviceConnection = MakertPlaceServiceConnection.getInstance(PropertiesManager.getInstance());
	}

	private synchronized CompradorModuleRemote getCompradorModuleService() /*throws AcademiaException*/ {
		CompradorModuleRemote service = (CompradorModuleRemote) serviceConnection.getRemoteSession(MakertPlaceServiceConnection.Comprador_Path);
		return service;
	}
	
	@Override
	public Collection<CompradorWebVO> getListComprador(GetCompradorParams params) {
		// TODO Auto-generated method stub
		try {
			CompradorModuleRemote service = getCompradorModuleService();
			Collection<CompradorDTO> listVendedores = service.getListComprador(params);
			Collection<CompradorWebVO> compradores = new ArrayList<CompradorWebVO>();
			for (CompradorDTO comprador : listVendedores) {
				CompradorWebVO comp = MarketPlaceAdapterService.compradorDTO2CompradorWebVO(comprador);
				compradores.add(comp);
			}

			return compradores;
		} catch (Exception e) {
			//throw AcademiaExceptionHandler.handleException(AcademiaErrorLayerConstants.WEB_SERVER, null, null, e);
		}
		return null;
	}

}
