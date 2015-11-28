package com.pqt.forcadevendas.service;

import java.util.List;

import com.pqt.forcadevendas.entity.to.ProdutoDTO;
import com.pqt.forcadevendas.entity.to.ProdutoDadosBasicosDTO;

public interface IProdutoService {

	public List<ProdutoDadosBasicosDTO> listProdutos();
	public ProdutoDTO getProduto(Integer id);
}
