package com.pqt.forcadevendas.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the supervisao database table.
 * 
 */
@Entity
@Table(schema="FDV_ONLINE")
public class Supervisao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	//bi-directional many-to-one association to Representante
	@ManyToOne
	@JoinColumn(name="idrepresentante")
	private Representante representante;

	//bi-directional many-to-one association to Representante
	@ManyToOne
	@JoinColumn(name="idsupervisor")
	private Representante supervisor;

	public Supervisao() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Representante getRepresentante() {
		return this.representante;
	}

	public void setRepresentante(Representante representante) {
		this.representante = representante;
	}

	public Representante getSupervisor() {
		return this.supervisor;
	}

	public void setSupervisor(Representante supervisor) {
		this.supervisor = supervisor;
	}

}