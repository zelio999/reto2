package com.reto2.internal.adapter;

import com.reto2.internal.dto.CompradorDTO;
import com.reto2.internal.dto.VendedorDTO;
import com.reto2.internal.vo.CompradorWebVO;
import com.reto2.internal.vo.VendedorWebVO;

public class MarketPlaceAdapterService {

	public static VendedorWebVO vendedorDTO2VendedorWebVO(VendedorDTO vendedor) {
		VendedorWebVO vendedorFinal = new VendedorWebVO();
		
		return vendedorFinal;
	}
	
	public static CompradorWebVO compradorDTO2CompradorWebVO(CompradorDTO comprador) {
		CompradorWebVO compradorFinal = new CompradorWebVO();
		
		return compradorFinal;
	}
}
