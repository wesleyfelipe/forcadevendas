package com.pqt.forcadevendas.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pqt.forcadevendas.dao.IClienteDAO;
import com.pqt.forcadevendas.entity.Cliente;
import com.pqt.forcadevendas.entity.to.ClienteDTO;

@Service
@Transactional
public class ClienteService implements IClienteService{

	@Autowired
	private IClienteDAO dao;
	
	@Override
	public List<ClienteDTO> getClientes() {
		List<Cliente> clientes = dao.listarClientes();
		List<ClienteDTO> dtos = new ArrayList<ClienteDTO>();
		for (Cliente cliente : clientes) {
			dtos.add(new ClienteDTO(cliente.getId(), cliente.getNome(), cliente.getSituacao(), cliente.getCnpj()));
		}
		return dtos;
	}

}
