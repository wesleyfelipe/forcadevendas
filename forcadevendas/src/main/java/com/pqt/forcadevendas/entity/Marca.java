package com.pqt.forcadevendas.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the marca database table.
 * 
 */
@Entity
@Table(schema="FDV_ONLINE")
public class Marca implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String nome;

	//bi-directional many-to-one association to Representacao
	@OneToMany(mappedBy="marca")
	private List<Representacao> representacoes;

	public Marca() {
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

	public List<Representacao> getRepresentacoes() {
		return this.representacoes;
	}

	public void setRepresentacoes(List<Representacao> representacoes) {
		this.representacoes = representacoes;
	}

	public Representacao addRepresentacao(Representacao representacao) {
		getRepresentacoes().add(representacao);
		representacao.setMarca(this);

		return representacao;
	}

	public Representacao removeRepresentacao(Representacao representacao) {
		getRepresentacoes().remove(representacao);
		representacao.setMarca(null);

		return representacao;
	}

}