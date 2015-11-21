package com.pqt.forcadevendas.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

/**
 * The persistent class for the pedido database table.
 * 
 */
@Entity
@Table(schema = "FDV_ONLINE")
public class Pedido implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "data_pedido")
	private Timestamp dataPedido;

	// bi-directional many-to-one association to Cliente
	@ManyToOne
	@JoinColumn(name = "idcliente")
	private Cliente cliente;

	// bi-directional many-to-one association to Representante
	@ManyToOne
	@JoinColumn(name = "idrepresentante")
	private Representante representante;

	// bi-directional many-to-one association to ItemPedido
	@OneToMany(mappedBy = "pedido")
	private List<ItemPedido> itemPedidos;

	public Pedido() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Timestamp getDataPedido() {
		return this.dataPedido;
	}

	public void setDataPedido(Timestamp dataPedido) {
		this.dataPedido = dataPedido;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Representante getRepresentante() {
		return this.representante;
	}

	public void setRepresentante(Representante representante) {
		this.representante = representante;
	}

	public List<ItemPedido> getItemPedidos() {
		return this.itemPedidos;
	}

	public void setItemPedidos(List<ItemPedido> itemPedidos) {
		this.itemPedidos = itemPedidos;
	}

	public ItemPedido addItemPedido(ItemPedido itemPedido) {
		getItemPedidos().add(itemPedido);
		itemPedido.setPedido(this);

		return itemPedido;
	}

	public ItemPedido removeItemPedido(ItemPedido itemPedido) {
		getItemPedidos().remove(itemPedido);
		itemPedido.setPedido(null);

		return itemPedido;
	}

}