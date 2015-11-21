package com.pqt.forcadevendas.entity.to;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

public class PedidoDTO {

	private Integer id;
	private String nomeCliente;
	private String nomeRepresentante;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy HH:mm")
	private Date dataCriacao;
	private BigDecimal totalPedido;
	private List<ItemPedidoDTO> itensPedido = new ArrayList<ItemPedidoDTO>();
	
	public PedidoDTO(){
	}
	
	public PedidoDTO(Integer id, String nomeCliente, String nomeRepresentante, Date dataCriacao,
			BigDecimal totalPedido) {
		super();
		this.id = id;
		this.nomeCliente = nomeCliente;
		this.nomeRepresentante = nomeRepresentante;
		this.dataCriacao = dataCriacao;
		this.totalPedido = totalPedido;
	}

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getNomeCliente() {
		return nomeCliente;
	}
	
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	
	public String getNomeRepresentante() {
		return nomeRepresentante;
	}
	
	public void setNomeRepresentante(String nomeRepresentante) {
		this.nomeRepresentante = nomeRepresentante;
	}
	
	public Date getDataCriacao() {
		return dataCriacao;
	}
	
	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	
	public BigDecimal getTotalPedido() {
		return totalPedido;
	}
	
	public void setTotalPedido(BigDecimal totalPedido) {
		this.totalPedido = totalPedido;
	}
	
	public List<ItemPedidoDTO> getItensPedido() {
		return itensPedido;
	}
	
	public void setItensPedido(List<ItemPedidoDTO> itensPedido) {
		this.itensPedido = itensPedido;
	}
	
}
