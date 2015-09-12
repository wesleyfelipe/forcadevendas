package com.pqt.forcadevendas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pqt.forcadevendas.dao.IClienteDAO;
import com.pqt.forcadevendas.entity.Cliente;

@Service
@Transactional
public class ClienteService implements IClienteService{

	@Autowired
	private IClienteDAO dao;
	
	@Override
	public List<Cliente> getClientes() {
		return dao.listarClientes();
	}

}
