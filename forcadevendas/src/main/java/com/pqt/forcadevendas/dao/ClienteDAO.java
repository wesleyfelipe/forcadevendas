package com.pqt.forcadevendas.dao;

import java.util.List;

import com.pqt.forcadevendas.entity.Cliente;

public class ClienteDAO extends DAO{

	public List<Cliente> listarClientes(){
		return executarQuery("FROM " + Cliente.class.getSimpleName());
	}
}
