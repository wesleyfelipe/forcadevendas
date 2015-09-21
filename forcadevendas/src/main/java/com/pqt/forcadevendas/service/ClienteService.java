package com.pqt.forcadevendas.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pqt.forcadevendas.dao.IClienteDAO;
import com.pqt.forcadevendas.entity.Cliente;
import com.pqt.forcadevendas.entity.Endereco;
import com.pqt.forcadevendas.entity.EnderecoEntrega;
import com.pqt.forcadevendas.entity.to.ClienteDTO;
import com.pqt.forcadevendas.entity.to.ClienteDadosBasicosDTO;
import com.pqt.forcadevendas.entity.to.EnderecoDTO;

@Service
public class ClienteService implements IClienteService {

	@Autowired
	private IClienteDAO dao;

	@Override
	public List<ClienteDadosBasicosDTO> getClientes() {
		List<Cliente> clientes = dao.listarClientes();
		List<ClienteDadosBasicosDTO> dtos = new ArrayList<ClienteDadosBasicosDTO>();
		for (Cliente cliente : clientes) {
			dtos.add(new ClienteDadosBasicosDTO(cliente.getId(), cliente.getNome(), cliente.getSituacao(),
					cliente.getCnpj()));
		}
		return dtos;
	}

	@Override
	public ClienteDTO getCliente(int id) {
		Cliente cliente = dao.getCliente(id);

		if (cliente == null)
			return null;

		ClienteDTO dto = new ClienteDTO();
		dto.setId(cliente.getId());
		dto.setCnpj(cliente.getCnpj());
		dto.setDatacadastro(cliente.getDatacadastro());
		dto.setEmail(cliente.getEmail());
		dto.setFone(cliente.getFone());
		dto.setLimitePedidos(cliente.getLimitepedidos());
		dto.setNome(cliente.getNome());
		dto.setSituacao(cliente.getSituacao());

		Endereco endereco = cliente.getEndereco();
		dto.setEnderecoComercial(new EnderecoDTO(endereco.getCep(), endereco.getLogradouro(), endereco.getCidade().getNome(),
				endereco.getCidade().getEstado().getNome(), endereco.getCidade().getEstado().getPais().getNome()));
		
		dto.setEnderecosEntrega(new ArrayList<EnderecoDTO>());
		for (EnderecoEntrega enderecoEntrega : cliente.getEnderecoentregas()) {
			Endereco end = enderecoEntrega.getEndereco();
			dto.addEnderecoEntrega(new EnderecoDTO(end.getCep(), end.getLogradouro(), end.getCidade().getNome(),
					end.getCidade().getEstado().getNome(), end.getCidade().getEstado().getPais().getNome()));
		}
		
		return dto;
	}

}
