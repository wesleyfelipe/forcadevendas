package com.pqt.forcadevendas.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the item_pedido database table.
 * 
 */
@Entity
@Table(name = "item_pedido", schema = "FDV_ONLINE")
public class ItemPedido implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	// bi-directional many-to-one association to Produto
	@ManyToOne
	@JoinColumn(name = "idproduto")
	private Produto produto;

	private Integer quantidade;

	private String tamanho;

	// bi-directional many-to-one association to Pedido
	@ManyToOne
	@JoinColumn(name = "idpedido")
	private Pedido pedido;

	public ItemPedido() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Produto getProduto() {
		return this.produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Integer getQuantidade() {
		return this.quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public String getTamanho() {
		return this.tamanho;
	}

	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}

	public Pedido getPedido() {
		return this.pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

}