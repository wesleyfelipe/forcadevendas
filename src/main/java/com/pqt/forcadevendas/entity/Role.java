package com.pqt.forcadevendas.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the role database table.
 * 
 */
@Entity
@Table(schema="FDV_ONLINE")
public class Role implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String nome;

	//bi-directional many-to-one association to Representanterole
	@OneToMany(mappedBy="role")
	private List<RepresentanteRole> representanteRoles;

	public Role() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<RepresentanteRole> getRepresentanteroles() {
		return this.representanteRoles;
	}

	public void setRepresentanteroles(List<RepresentanteRole> representanteroles) {
		this.representanteRoles = representanteroles;
	}

	public RepresentanteRole addRepresentanterole(RepresentanteRole representanterole) {
		getRepresentanteroles().add(representanterole);
		representanterole.setRole(this);

		return representanterole;
	}

	public RepresentanteRole removeRepresentanterole(RepresentanteRole representanterole) {
		getRepresentanteroles().remove(representanterole);
		representanterole.setRole(null);

		return representanterole;
	}

}