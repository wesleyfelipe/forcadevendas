package com.pqt.forcadevendas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pqt.forcadevendas.entity.to.EstadoDTO;
import com.pqt.forcadevendas.entity.to.PaisDTO;
import com.pqt.forcadevendas.service.IEnteFederativoService;

@RestController
@RequestMapping(value="/recursos")
public class EnteFederativoController {

	@Autowired
	private IEnteFederativoService service;
	
	@RequestMapping(value="/pais", method=RequestMethod.GET, produces="application/json")
	public List<PaisDTO> listPaises(){
		return service.listPaises();
	}
	
	@RequestMapping(value="/estado", method=RequestMethod.GET, produces="application/json")
	public List<EstadoDTO> listEstados(@RequestParam("pais") Integer pais){
		return service.listEstados(pais);
	}
}
