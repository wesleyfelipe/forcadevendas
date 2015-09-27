package com.pqt.forcadevendas.dao;

import java.util.List;

import com.pqt.forcadevendas.entity.Cliente;

public interface IClienteDAO {

	public List<Cliente> listClientes();
	public Cliente getCliente(int id);
	public Cliente persistCliente(Cliente cliente);
	public Cliente updateCliente(Cliente cliente);
}
