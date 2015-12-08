package com.pqt.forcadevendas.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the representacao database table.
 * 
 */
@Entity
@Table(schema="FDV_ONLINE")
public class Representacao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	//bi-directional many-to-one association to Marca
	@ManyToOne
	@JoinColumn(name="idmarca")
	private Marca marca;

	//bi-directional many-to-one association to Representante
	@ManyToOne
	@JoinColumn(name="idrepresentante")
	private Representante representante;

	public Representacao() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Marca getMarca() {
		return this.marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public Representante getRepresentante() {
		return this.representante;
	}

	public void setRepresentante(Representante representante) {
		this.representante = representante;
	}

}