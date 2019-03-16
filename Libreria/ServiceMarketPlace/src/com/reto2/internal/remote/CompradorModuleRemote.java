package com.reto2.internal.remote;

import java.util.Collection;

import com.reto2.internal.dto.CompradorDTO;
import com.reto2.internal.params.GetCompradorParams;

public interface CompradorModuleRemote {

	public Collection<CompradorDTO> getListComprador(GetCompradorParams filters) /*throws AcademiaException*/;

}
