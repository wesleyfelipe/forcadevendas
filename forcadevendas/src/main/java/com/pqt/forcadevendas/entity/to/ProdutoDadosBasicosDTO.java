package com.pqt.forcadevendas.entity.to;

import java.math.BigDecimal;

public class ProdutoDadosBasicosDTO {

	private Integer id;
	private String nomeModelo;
	private BigDecimal preco;
	private BigDecimal precoPromocional;
	private String imagem;
	private String cor;
	private String marca;
	private String departamento;
	private String categoria;
	
	public ProdutoDadosBasicosDTO(Integer id, String nomeModelo, BigDecimal preco, BigDecimal precoPromocional,
			String imagem, String cor, String marca, String departamento, String categoria) {
		super();
		this.id = id;
		this.nomeModelo = nomeModelo;
		this.preco = preco;
		this.precoPromocional = precoPromocional;
		this.imagem = imagem;
		this.cor = cor;
		this.marca = marca;
		this.departamento = departamento;
		this.categoria = categoria;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeModelo() {
		return nomeModelo;
	}

	public void setNomeModelo(String nomeModelo) {
		this.nomeModelo = nomeModelo;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public BigDecimal getPrecoPromocional() {
		return precoPromocional;
	}

	public void setPrecoPromocional(BigDecimal precoPromocional) {
		this.precoPromocional = precoPromocional;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}
	
	public String getMarca() {
		return marca;
	}
	
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	public String getCategoria() {
		return categoria;
	}
	
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	public String getDepartamento() {
		return departamento;
	}
	
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	
}
