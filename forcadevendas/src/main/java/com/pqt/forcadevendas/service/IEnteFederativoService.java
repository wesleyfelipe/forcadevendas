package com.pqt.forcadevendas.service;

import java.util.List;

import com.pqt.forcadevendas.entity.Cidade;
import com.pqt.forcadevendas.entity.Estado;
import com.pqt.forcadevendas.entity.to.EstadoDTO;
import com.pqt.forcadevendas.entity.to.PaisDTO;

public interface IEnteFederativoService {

	public List<PaisDTO> listPaises();
	public List<EstadoDTO> listEstados(Integer pais);
	public List<Cidade> listCidades(Estado estado);
}
