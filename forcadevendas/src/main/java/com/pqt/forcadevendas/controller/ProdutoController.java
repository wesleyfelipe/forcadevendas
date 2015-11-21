package com.pqt.forcadevendas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pqt.forcadevendas.entity.to.ProdutoDadosBasicosDTO;
import com.pqt.forcadevendas.service.IProdutoService;

@RestController
@RequestMapping(value = "/recursos/produto")
public class ProdutoController {

	@Autowired
	private IProdutoService service;

	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public List<ProdutoDadosBasicosDTO> listProdutos() {
		return service.listProdutos();
	}

}
