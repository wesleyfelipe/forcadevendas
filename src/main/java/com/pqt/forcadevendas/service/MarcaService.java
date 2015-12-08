package com.pqt.forcadevendas.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pqt.forcadevendas.dao.ICategoriaDAO;
import com.pqt.forcadevendas.entity.Categoria;
import com.pqt.forcadevendas.entity.Modelo;
import com.pqt.forcadevendas.entity.to.CategoriaDTO;

@Service
public class MarcaService implements ICategoriaService {

	@Autowired
	private ICategoriaDAO dao;

	@Override
	public List<CategoriaDTO> listCategorias() {
		List<Categoria> categorias = dao.listCategorias();
		List<CategoriaDTO> dtos = new ArrayList<CategoriaDTO>();
		for (Categoria categoria : categorias) {
			dtos.add(new CategoriaDTO(categoria.getId(), categoria.getNome(), getTotalProdutos(categoria)));
		}
		return dtos;
	}
	
	private int getTotalProdutos(Categoria categoria){
		int total = 0;
		for (Modelo modelo : categoria.getModelos()) {
			total += modelo.getProdutos().size();
		}
		return total;
	}
	
}
