package com.pqt.forcadevendas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pqt.forcadevendas.entity.to.RepresentanteDTO;
import com.pqt.forcadevendas.service.IRepresentanteService;

@RestController
@RequestMapping(value = "/recursos/representante")
public class RepresentanteController {

	@Autowired
	private IRepresentanteService service;

	@RequestMapping(method = RequestMethod.GET, produces = "application/json", value = "/meus-dados")
	public RepresentanteDTO getMeusDados() {
		return service.getMeusDados();
	}

}
