package com.pqt.forcadevendas.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the cliente database table.
 * 
 */
@Entity
@Table(schema="FDV_ONLINE")
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String cnpj;

	@Temporal(TemporalType.DATE)
	private Date datacadastro;

	private String email;

	private String fone;

	private Integer limitePedidos;

	private String nome;

	private String situacao;

	//bi-directional many-to-one association to Endereco
	@ManyToOne
	@JoinColumn(name="idenderecocomercial")
	private Endereco endereco;

	//bi-directional many-to-one association to Enderecoentrega
	@OneToMany(mappedBy="cliente")
	private List<EnderecoEntrega> enderecoentregas;

	public Cliente() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCnpj() {
		return this.cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public Date getDatacadastro() {
		return this.datacadastro;
	}

	public void setDatacadastro(Date datacadastro) {
		this.datacadastro = datacadastro;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFone() {
		return this.fone;
	}

	public void setFone(String fone) {
		this.fone = fone;
	}

	public Integer getLimitepedidos() {
		return this.limitePedidos;
	}

	public void setLimitepedidos(Integer limitepedidos) {
		this.limitePedidos = limitepedidos;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSituacao() {
		return this.situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public Endereco getEndereco() {
		return this.endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public List<EnderecoEntrega> getEnderecoentregas() {
		return this.enderecoentregas;
	}

	public void setEnderecoentregas(List<EnderecoEntrega> enderecoentregas) {
		this.enderecoentregas = enderecoentregas;
	}

	public EnderecoEntrega addEnderecoentrega(EnderecoEntrega enderecoentrega) {
		getEnderecoentregas().add(enderecoentrega);
		enderecoentrega.setCliente(this);

		return enderecoentrega;
	}

	public EnderecoEntrega removeEnderecoentrega(EnderecoEntrega enderecoentrega) {
		getEnderecoentregas().remove(enderecoentrega);
		enderecoentrega.setCliente(null);

		return enderecoentrega;
	}

}