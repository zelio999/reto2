package com.reto2.internal.delegate.api;

import java.util.Collection;

import com.reto2.internal.params.GetCompradorParams;
import com.reto2.internal.vo.CompradorWebVO;

public interface ICompradorBusinessDelegate {

	public Collection<CompradorWebVO> getListComprador(GetCompradorParams params) /*throws AcademiaException*/;

}
