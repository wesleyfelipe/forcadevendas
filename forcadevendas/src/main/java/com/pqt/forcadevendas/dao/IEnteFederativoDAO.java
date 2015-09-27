package com.pqt.forcadevendas.dao;

import java.util.List;

import com.pqt.forcadevendas.entity.Cidade;
import com.pqt.forcadevendas.entity.Estado;
import com.pqt.forcadevendas.entity.Pais;

public interface IEnteFederativoDAO{

	public List<Pais> listPaises();
	public List<Estado> listEstados(Integer idPais);
	public List<Cidade> listCidades(Integer idEstado);
}
