package com.pqt.forcadevendas.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pqt.forcadevendas.dao.IMarcaDAO;
import com.pqt.forcadevendas.entity.Marca;
import com.pqt.forcadevendas.entity.Modelo;
import com.pqt.forcadevendas.entity.to.MarcaDTO;

@Service
public class MarcaService implements IMarcaService {

	@Autowired
	private IMarcaDAO dao;

	@Override
	public List<MarcaDTO> listMarcas() {
		List<Marca> marcas = dao.listMarcas();
		List<MarcaDTO> dtos = new ArrayList<MarcaDTO>();
		for (Marca marca : marcas) {
			dtos.add(new MarcaDTO(marca.getId(), marca.getNome(), getTotalProdutos(marca)));
		}
		return dtos;
	}
	
	private int getTotalProdutos(Marca marca){
		int total = 0;
		for (Modelo modelo : marca.getModelos()) {
			total += modelo.getProdutos().size();
		}
		return total;
	}
	
}
