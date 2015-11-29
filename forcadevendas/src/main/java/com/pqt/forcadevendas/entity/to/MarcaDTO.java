package com.pqt.forcadevendas.entity.to;

public class MarcaDTO {
	
	private int id;
	private String nome;
	private int totalProdutos;
	
	public MarcaDTO(int id, String nome, int totalProdutos) {
		super();
		this.id = id;
		this.nome = nome;
		this.totalProdutos = totalProdutos;
	};
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getTotalProdutos() {
		return totalProdutos;
	}
	
	public void setTotalProdutos(int totalProdutos) {
		this.totalProdutos = totalProdutos;
	}
	
}
