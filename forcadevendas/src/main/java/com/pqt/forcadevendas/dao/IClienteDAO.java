package com.pqt.forcadevendas.dao;

import java.util.List;

import com.pqt.forcadevendas.entity.Cliente;

public interface IClienteDAO {

	public List<Cliente> listarClientes();
	
	public Cliente getCliente(int id);
}
