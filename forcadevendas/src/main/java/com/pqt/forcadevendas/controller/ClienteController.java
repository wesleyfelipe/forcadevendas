package com.pqt.forcadevendas.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pqt.forcadevendas.dao.ClienteDAO;
import com.pqt.forcadevendas.entity.Cliente;
import com.pqt.forcadevendas.entity.to.ClienteDTO;

@RestController
public class ClienteController {

	public static ClienteDAO dao = new ClienteDAO();
	
	@RequestMapping(value = "/cliente/{id}", method = RequestMethod.GET)
	public ClienteDTO getCliente(@PathVariable String id){
		System.out.println(">>>>>>>>>>>>>"  + id);
		List<Cliente> lista = dao.listarClientes();
		Cliente cliente = lista.get(0);
		
		ClienteDTO dto = new ClienteDTO(cliente.getId(), cliente.getNome(), cliente.getSituacao(), cliente.getCnpj());
		return dto;
	}
}
