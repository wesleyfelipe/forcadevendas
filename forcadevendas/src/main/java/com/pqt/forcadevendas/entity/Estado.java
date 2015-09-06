package com.pqt.forcadevendas.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table( name = "ESTADO", schema = "FDV_ONLINE") //TODO: remover conf de schema daqui
public class Estado implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 255, nullable = false)
	private String nome;
	
	@Column(length = 3)
	private String sigla;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="IDESTADO", nullable=false)
	private Set<Cidade> cidades;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSigla() {
		return sigla;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	
	public Set<Cidade> getCidades() {
		return cidades;
	}
	
	public void setCidades(Set<Cidade> cidades) {
		this.cidades = cidades;
	}
}
