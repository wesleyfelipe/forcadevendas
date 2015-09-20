package com.pqt.forcadevendas.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the representanteroles database table.
 * 
 */
@Entity
@Table(name="representanteroles", schema="FDV_ONLINE")
public class RepresentanteRole implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	//bi-directional many-to-one association to Representante
	@ManyToOne
	@JoinColumn(name="idrepresentante")
	private Representante representante;

	//bi-directional many-to-one association to Role
	@ManyToOne
	@JoinColumn(name="idrole")
	private Role role;

	public RepresentanteRole() {
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

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}