package com.pqt.forcadevendas.entity.to;

import java.util.ArrayList;
import java.util.List;

public class RepresentanteDTO {

	private int id;
	private String nome;
	private String nomeUsuario;
	private String email;
	private String fone;
	private String cpf;
	private String rg;
	private String situacao;
	private List<PedidoKpiMesDTO> kpiSemestre = new ArrayList<PedidoKpiMesDTO>();
	
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
	
	public String getNomeUsuario() {
		return nomeUsuario;
	}
	
	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getFone() {
		return fone;
	}
	
	public void setFone(String fone) {
		this.fone = fone;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getRg() {
		return rg;
	}
	
	public void setRg(String rg) {
		this.rg = rg;
	}
	
	public String getSituacao() {
		return situacao;
	}
	
	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	
	public List<PedidoKpiMesDTO> getKpiSemestre() {
		return kpiSemestre;
	}
	
	public void setKpiSemestre(List<PedidoKpiMesDTO> kpiSemestre) {
		this.kpiSemestre = kpiSemestre;
	}
	
}
