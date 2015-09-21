package com.pqt.forcadevendas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pqt.forcadevendas.entity.to.ClienteDTO;
import com.pqt.forcadevendas.entity.to.ClienteDadosBasicosDTO;
import com.pqt.forcadevendas.service.IClienteService;

@RestController
@RequestMapping(value="/recursos/cliente")
public class ClienteController{

	@Autowired
	private IClienteService service;
	
	@RequestMapping(method=RequestMethod.GET, produces="application/json")
	public List<ClienteDadosBasicosDTO> getClientes(){
		return service.getClientes();
	}
	
	@RequestMapping(method=RequestMethod.GET, produces="application/json", value="/{id}")
	public ClienteDTO getCliente(@PathVariable("id") Integer id) throws Exception{
		return service.getCliente(id);
	}
}
