package com.pqt.forcadevendas.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pqt.forcadevendas.dao.IEnteFederativoDAO;
import com.pqt.forcadevendas.entity.Cidade;
import com.pqt.forcadevendas.entity.Estado;
import com.pqt.forcadevendas.entity.Pais;
import com.pqt.forcadevendas.entity.to.EstadoDTO;
import com.pqt.forcadevendas.entity.to.PaisDTO;

@Service
public class EnteFederativoService implements IEnteFederativoService {

	@Autowired
	private IEnteFederativoDAO dao;
	
	@Override
	public List<PaisDTO> listPaises() {
		List<PaisDTO> dtos = new ArrayList<PaisDTO>();
		for (Pais pais : dao.listPaises()) {
			dtos.add(new PaisDTO(pais.getId(), pais.getNome()));
		}
		return dtos;
	}

	@Override
	public List<EstadoDTO> listEstados(Integer pais) {
		List<EstadoDTO> dtos = new ArrayList<EstadoDTO>();
		for (Estado estado : dao.listEstados(pais)) {
			dtos.add(new EstadoDTO(estado.getId(), estado.getNome()));
		}
		return dtos;
	}

	@Override
	public List<Cidade> listCidades(Estado estado) {
		// TODO Auto-generated method stub
		return null;
	}

}
