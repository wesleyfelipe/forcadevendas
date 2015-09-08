package com.pqt.forcadevendas.entity.to;

public class ClienteDTO {

	private Long id;
	private String nome;
	private Character situacao;
	private String cnpj;
	
	public ClienteDTO(Long id, String nome, Character situacao, String cnpj) {
		super();
		this.id = id;
		this.nome = nome;
		this.situacao = situacao;
		this.cnpj = cnpj;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Character getSituacao() {
		return situacao;
	}

	public void setSituacao(Character situacao) {
		this.situacao = situacao;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
}
