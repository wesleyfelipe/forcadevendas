package com.pqt.forcadevendas.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the enderecoentrega database table.
 * 
 */
@Entity
@Table(schema="FDV_ONLINE")
public class EnderecoEntrega implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	//bi-directional many-to-one association to Cliente
	@ManyToOne
	@JoinColumn(name="idcliente")
	private Cliente cliente;

	//bi-directional many-to-one association to Endereco
	@ManyToOne
	@JoinColumn(name="idendereco")
	private Endereco endereco;

	public EnderecoEntrega() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Endereco getEndereco() {
		return this.endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

}