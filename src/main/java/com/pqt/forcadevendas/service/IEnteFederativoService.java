package com.pqt.forcadevendas.service;

import java.util.List;

import com.pqt.forcadevendas.entity.to.CidadeDTO;
import com.pqt.forcadevendas.entity.to.EstadoDTO;
import com.pqt.forcadevendas.entity.to.PaisDTO;

public interface IEnteFederativoService {

	public List<PaisDTO> listPaises();
	public List<EstadoDTO> listEstados(Integer idPais);
	public List<CidadeDTO> listCidades(Integer idEstado);
}
