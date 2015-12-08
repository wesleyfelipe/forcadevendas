package com.pqt.forcadevendas.entity.to;

public class ClienteDadosBasicosDTO {

	private Integer id;
	private String nome;
	private String situacao;
	private String cnpj;
	
	public ClienteDadosBasicosDTO(Integer id, String nome, String situacao, String cnpj) {
		super();
		this.id = id;
		this.nome = nome;
		this.situacao = situacao;
		this.cnpj = cnpj;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
}
