package com.pqt.forcadevendas.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pqt.forcadevendas.dao.IDepartamentoDAO;
import com.pqt.forcadevendas.entity.Departamento;
import com.pqt.forcadevendas.entity.Modelo;
import com.pqt.forcadevendas.entity.to.DepartamentoDTO;

@Service
public class DepartamentoService implements IDepartamentoService {

	@Autowired
	private IDepartamentoDAO dao;

	@Override
	public List<DepartamentoDTO> listDepartamentos() {
		List<Departamento> departamentos = dao.listDepartamentos();
		List<DepartamentoDTO> dtos = new ArrayList<DepartamentoDTO>();
		for (Departamento departamento : departamentos) {
			dtos.add(new DepartamentoDTO(departamento.getId(), departamento.getNome(), getTotalProdutos(departamento)));
		}
		return dtos;
	}
	
	private int getTotalProdutos(Departamento departamento){
		int total = 0;
		for (Modelo modelo : departamento.getModelos()) {
			total += modelo.getProdutos().size();
		}
		return total;
	}
	
}
