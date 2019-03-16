package com.reto2.internal.remote;

import java.util.Collection;

import com.reto2.internal.dto.VendedorDTO;
import com.reto2.internal.params.GetVendedorParams;

public interface VendedorModuleRemote {

	public Collection<VendedorDTO> getListVendedor(GetVendedorParams filters) /*throws AcademiaException*/;

}
