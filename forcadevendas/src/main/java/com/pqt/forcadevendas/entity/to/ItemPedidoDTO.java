package com.pqt.forcadevendas.entity.to;

import java.math.BigDecimal;

public class ItemPedidoDTO {

	private Integer idProduto;
	private String produto;
	private String marca;
	private BigDecimal preco;
	private Integer quantidade;
	private String tamanho;
	
	public ItemPedidoDTO(Integer idProduto, String produto, String marca, BigDecimal preco, Integer quantidade,
			String tamanho) {
		super();
		this.idProduto = idProduto;
		this.produto = produto;
		this.marca = marca;
		this.preco = preco;
		this.quantidade = quantidade;
		this.tamanho = tamanho;
	}

	public Integer getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Integer idProduto) {
		this.idProduto = idProduto;
	}

	public String getProduto() {
		return produto;
	}

	public void setProduto(String produto) {
		this.produto = produto;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public String getTamanho() {
		return tamanho;
	}

	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}
	
}
