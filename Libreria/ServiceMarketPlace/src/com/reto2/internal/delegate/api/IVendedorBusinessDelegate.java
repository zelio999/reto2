package com.reto2.internal.delegate.api;

import java.util.Collection;

import com.reto2.internal.params.GetVendedorParams;
import com.reto2.internal.vo.VendedorWebVO;

public interface IVendedorBusinessDelegate {
	
	public Collection<VendedorWebVO> getListVendedor(GetVendedorParams filters) /*throws AcademiaException*/;


}
