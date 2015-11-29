package com.pqt.forcadevendas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pqt.forcadevendas.entity.to.CategoriaDTO;
import com.pqt.forcadevendas.service.ICategoriaService;

@RestController
@RequestMapping(value = "/recursos/categoria")
public class CategoriaController {

	@Autowired
	private ICategoriaService service;

	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public List<CategoriaDTO> listCategorias() {
		return service.listCategorias();
	}

}
