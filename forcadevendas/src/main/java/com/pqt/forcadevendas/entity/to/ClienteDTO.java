package com.pqt.forcadevendas.entity.to;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ClienteDTO {

	private Integer id;
	private String cnpj;
	private Date datacadastro;
	private String email;
	private String fone;
	private Integer limitePedidos;
	private String nome;
	private String situacao;
	private EnderecoDTO enderecoComercial;
	private List<EnderecoDTO> enderecosEntrega = new ArrayList<EnderecoDTO>();
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getCnpj() {
		return cnpj;
	}
	
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	public Date getDatacadastro() {
		return datacadastro;
	}
	
	public void setDatacadastro(Date datacadastro) {
		this.datacadastro = datacadastro;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getFone() {
		return fone;
	}
	
	public void setFone(String fone) {
		this.fone = fone;
	}
	
	public Integer getLimitePedidos() {
		return limitePedidos;
	}
	
	public void setLimitePedidos(Integer limitePedidos) {
		this.limitePedidos = limitePedidos;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getSituacao() {
		return situacao;
	}
	
	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	
	public EnderecoDTO getEnderecoComercial() {
		return enderecoComercial;
	}
	
	public void setEnderecoComercial(EnderecoDTO endereco) {
		this.enderecoComercial = endereco;
	}
	
	public List<EnderecoDTO> getEnderecosEntrega() {
		return enderecosEntrega;
	}
	
	public void setEnderecosEntrega(List<EnderecoDTO> enderecoentregas) {
		this.enderecosEntrega = enderecoentregas;
	}
	
	public void addEnderecoEntrega(EnderecoDTO endereco){
		enderecosEntrega.add(endereco);
	}
}
