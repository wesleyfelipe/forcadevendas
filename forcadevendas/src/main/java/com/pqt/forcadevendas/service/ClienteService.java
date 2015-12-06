package com.pqt.forcadevendas.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ws.rs.NotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pqt.forcadevendas.dao.IClienteDAO;
import com.pqt.forcadevendas.dao.IEnteFederativoDAO;
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

	@Autowired
	private IEnteFederativoDAO enteFederativoDao;

	@Override
	public List<ClienteDadosBasicosDTO> listClientes() {
		List<Cliente> clientes = dao.listClientes();
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
			throw new NotFoundException("Cliente com identificador " + id + " não existe.");
		return buildClienteDtoFromCliente(cliente);
	}

	@Override
	public ClienteDTO persistCliente(ClienteDTO clienteDto) {
		Cliente cliente = new Cliente();
		clienteDto.setDataCadastro(new Date());

		cliente = updateClienteFromClienteDto(cliente, clienteDto);
		cliente.setDatacadastro(new Date());
		cliente.setSituacao("A");
		cliente.setLimitepedidos(5000);
		
		cliente = dao.persistCliente(cliente);

		return buildClienteDtoFromCliente(cliente);
	}
	
	@Override
	public ClienteDTO updateCliente(Integer idCliente, ClienteDTO clienteDto) {
		Cliente cliente = dao.getCliente(idCliente);
		if(cliente == null)
			throw new NotFoundException("Cliente com identificador " + idCliente + " não existe.");
		updateClienteFromClienteDto(cliente, clienteDto);
		dao.updateCliente(cliente);
		return buildClienteDtoFromCliente(cliente);
	}

	private Cliente updateClienteFromClienteDto(Cliente cliente, ClienteDTO dto) {
		if (cliente == null || dto == null)
			return cliente;

		cliente.setCnpj(dto.getCnpj() == null ? cliente.getCnpj() : dto.getCnpj());
		cliente.setDatacadastro(dto.getDataCadastro() == null ? cliente.getDatacadastro() : dto.getDataCadastro());
		cliente.setEmail(dto.getEmail() == null ? cliente.getEmail() : dto.getEmail());
		cliente.setEndereco(dto.getEnderecoComercial() == null ? cliente.getEndereco()
				: updateEnderecoFromEnderecoDto(new Endereco(), dto.getEnderecoComercial()));
		if(dto.getEnderecosEntrega() != null){
			cliente.setEnderecoentregas(new ArrayList<EnderecoEntrega>());
			for (EnderecoDTO endEntregaDto : dto.getEnderecosEntrega()) {
				EnderecoEntrega endEntrega = new EnderecoEntrega();
				endEntrega.setEndereco(updateEnderecoFromEnderecoDto(new Endereco(), endEntregaDto));
				cliente.addEnderecoentrega(endEntrega);
			}
		}
		cliente.setFone(dto.getFone() == null ? cliente.getFone() : dto.getFone());
		cliente.setLimitepedidos(dto.getLimitePedidos() == null ? cliente.getLimitepedidos() : dto.getLimitePedidos());
		cliente.setNome(dto.getNome() == null ? cliente.getNome() : dto.getNome());
		cliente.setSituacao(dto.getSituacao() == null ? cliente.getSituacao() : dto.getSituacao());
		return cliente;
	}

	private Endereco updateEnderecoFromEnderecoDto(Endereco endereco, EnderecoDTO dto) {
		if (endereco == null || dto == null)
			return endereco;

		endereco.setCep(dto.getCep() == null ? endereco.getCep() : dto.getCep());
		endereco.setLogradouro(dto.getLogradouro() == null ? endereco.getLogradouro() : dto.getLogradouro());
		endereco.setCidade(
				dto.getCidade() == null ? endereco.getCidade() : enteFederativoDao.getCidade(dto.getCidade()));

		return endereco;
	}

	private ClienteDTO buildClienteDtoFromCliente(Cliente cliente) {
		ClienteDTO dto = new ClienteDTO();
		dto.setId(cliente.getId());
		dto.setCnpj(cliente.getCnpj());
		dto.setDataCadastro(cliente.getDatacadastro());
		dto.setEmail(cliente.getEmail());
		dto.setFone(cliente.getFone());
		dto.setLimitePedidos(cliente.getLimitepedidos());
		dto.setNome(cliente.getNome());
		dto.setSituacao(cliente.getSituacao());
		dto.setEnderecoComercial(buildEnderecoDtoFromEndereco(cliente.getEndereco()));
		dto.setEnderecosEntrega(new ArrayList<EnderecoDTO>());

		for (EnderecoEntrega enderecoEntrega : cliente.getEnderecoentregas()) {
			dto.addEnderecoEntrega(buildEnderecoDtoFromEndereco(enderecoEntrega.getEndereco()));
		}

		return dto;
	}

	private EnderecoDTO buildEnderecoDtoFromEndereco(Endereco endereco) {
		return endereco == null ? null
				: new EnderecoDTO(endereco.getId(), endereco.getCep(), endereco.getLogradouro(), endereco.getCidade().getNome(),
						endereco.getCidade().getEstado().getNome(),
						endereco.getCidade().getEstado().getPais().getNome());
	}
}
