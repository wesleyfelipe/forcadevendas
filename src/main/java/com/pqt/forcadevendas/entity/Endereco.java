package com.pqt.forcadevendas.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the endereco database table.
 * 
 */
@Entity
@Table(schema="FDV_ONLINE")
public class Endereco implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String cep;

	private String logradouro;

	//bi-directional many-to-one association to Cliente
	@OneToMany(mappedBy="endereco")
	private List<Cliente> clientes;

	//bi-directional many-to-one association to Cidade
	@ManyToOne
	@JoinColumn(name="idcidade")
	private Cidade cidade;

	//bi-directional many-to-one association to Enderecoentrega
	@OneToMany(mappedBy="endereco")
	private List<EnderecoEntrega> enderecoEntregas;

	public Endereco() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCep() {
		return this.cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getLogradouro() {
		return this.logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public List<Cliente> getClientes() {
		return this.clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public Cliente addCliente(Cliente cliente) {
		getClientes().add(cliente);
		cliente.setEndereco(this);

		return cliente;
	}

	public Cliente removeCliente(Cliente cliente) {
		getClientes().remove(cliente);
		cliente.setEndereco(null);

		return cliente;
	}

	public Cidade getCidade() {
		return this.cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public List<EnderecoEntrega> getEnderecoentregas() {
		return this.enderecoEntregas;
	}

	public void setEnderecoentregas(List<EnderecoEntrega> enderecoentregas) {
		this.enderecoEntregas = enderecoentregas;
	}

	public EnderecoEntrega addEnderecoentrega(EnderecoEntrega enderecoentrega) {
		getEnderecoentregas().add(enderecoentrega);
		enderecoentrega.setEndereco(this);

		return enderecoentrega;
	}

	public EnderecoEntrega removeEnderecoentrega(EnderecoEntrega enderecoentrega) {
		getEnderecoentregas().remove(enderecoentrega);
		enderecoentrega.setEndereco(null);

		return enderecoentrega;
	}

}