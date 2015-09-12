package com.pqt.forcadevendas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pqt.forcadevendas.entity.Cliente;
import com.pqt.forcadevendas.service.IClienteService;

@RestController
public class ClienteController {

	@Autowired
	private IClienteService service;
	
	@RequestMapping(value="/cliente", method=RequestMethod.GET)
	public List<Cliente> getClientes(){
		return service.getClientes();
	}
}
