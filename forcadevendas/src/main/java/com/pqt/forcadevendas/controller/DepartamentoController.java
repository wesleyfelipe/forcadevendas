package com.pqt.forcadevendas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pqt.forcadevendas.entity.to.DepartamentoDTO;
import com.pqt.forcadevendas.service.IDepartamentoService;

@RestController
@RequestMapping(value = "/recursos/departamento")
public class DepartamentoController {

	@Autowired
	private IDepartamentoService service;

	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public List<DepartamentoDTO> listDepartamentos() {
		return service.listDepartamentos();
	}

}
