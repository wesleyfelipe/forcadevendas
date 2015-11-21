package com.pqt.forcadevendas.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pqt.forcadevendas.dao.IProdutoDAO;
import com.pqt.forcadevendas.entity.Produto;
import com.pqt.forcadevendas.entity.to.ProdutoDadosBasicosDTO;

@Service
public class ProdutoService implements IProdutoService {

	@Autowired
	private IProdutoDAO dao;

	@Override
	public List<ProdutoDadosBasicosDTO> listProdutos() {
		List<Produto> produtos = dao.listProdutos();
		List<ProdutoDadosBasicosDTO> dtos = new ArrayList<ProdutoDadosBasicosDTO>();
		for (Produto produto : produtos) {
			dtos.add(new ProdutoDadosBasicosDTO(produto.getId(), produto.getModelo().getNome(), produto.getPreco(),
					produto.getPrecoPromocao(), produto.getImagemPrincipal(), produto.getCor(),
					produto.getModelo().getMarca().getNome()));
		}
		return dtos;
	}
}
