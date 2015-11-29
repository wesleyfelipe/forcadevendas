package com.pqt.forcadevendas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pqt.forcadevendas.entity.to.MarcaDTO;
import com.pqt.forcadevendas.service.IMarcaService;

@RestController
@RequestMapping(value = "/recursos/marca")
public class MarcaController {

	@Autowired
	private IMarcaService service;

	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public List<MarcaDTO> listMarcas() {
		return service.listMarcas();
	}

}
