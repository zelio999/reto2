package com.reto2.internal.facade;

import com.reto2.internal.delegate.api.ICompradorBusinessDelegate;
import com.reto2.internal.delegate.api.IVendedorBusinessDelegate;
import com.reto2.internal.delegate.impl.CompradorBusinessDelegate;
import com.reto2.internal.delegate.impl.VendedorBusinessDelegate;

public class MarketPlaceFacade {

	private static MarketPlaceFacade instance;
	
	private IVendedorBusinessDelegate vendedorService;
	private ICompradorBusinessDelegate compradorService;

	private MarketPlaceFacade() {

	}

	public synchronized static MarketPlaceFacade getInstance() {
		if (instance == null) {
			instance = new MarketPlaceFacade();
		}

		return instance;
	}

	public synchronized IVendedorBusinessDelegate getVendedorService() throws Exception {
		if (vendedorService == null) {
			vendedorService = new VendedorBusinessDelegate();
		}
		return vendedorService;
	}

	public synchronized ICompradorBusinessDelegate getCompradorService() throws Exception {
		if (compradorService == null) {
			compradorService = new CompradorBusinessDelegate();
		}
		return compradorService;
	}

}
