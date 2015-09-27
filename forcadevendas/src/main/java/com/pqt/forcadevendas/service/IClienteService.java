package com.pqt.forcadevendas.service;

import java.util.List;

import com.pqt.forcadevendas.entity.to.ClienteDTO;
import com.pqt.forcadevendas.entity.to.ClienteDadosBasicosDTO;

public interface IClienteService {

	public List<ClienteDadosBasicosDTO> listClientes();
	
	public ClienteDTO getCliente(int id);
	
	public ClienteDTO persistCliente(ClienteDTO clienteDto);
}
