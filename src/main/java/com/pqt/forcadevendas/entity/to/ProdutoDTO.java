package com.pqt.forcadevendas.entity.to;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDTO {

	private Integer id;
	private String nomeModelo;
	private BigDecimal preco;
	private BigDecimal precoPromocional;
	private String imagem;
	private String cor;
	private String marca;
	private List<String> imagensAdicionais = new ArrayList<String>();
	private String colecao;
	private String categoria;
	private String departamento;
	
	public ProdutoDTO(){
	}
	
	public ProdutoDTO(Integer id, String nomeModelo, BigDecimal preco, BigDecimal precoPromocional, String imagem,
			String cor, String marca, String colecao, String categoria,
			String departamento) {
		super();
		this.id = id;
		this.nomeModelo = nomeModelo;
		this.preco = preco;
		this.precoPromocional = precoPromocional;
		this.imagem = imagem;
		this.cor = cor;
		this.marca = marca;
		this.colecao = colecao;
		this.categoria = categoria;
		this.departamento = departamento;
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

	public List<String> getImagensAdicionais() {
		return imagensAdicionais;
	}

	public void setImagensAdicionais(List<String> imagensAdicionais) {
		this.imagensAdicionais = imagensAdicionais;
	}

	public String getColecao() {
		return colecao;
	}

	public void setColecao(String colecao) {
		this.colecao = colecao;
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
