package com.pqt.forcadevendas.entity.to;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PedidoDTO {

	private Integer id;
	@JsonProperty(required=true)
	private Integer idCliente;
	private String nomeCliente;
	private String nomeRepresentante;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy HH:mm")
	private Date dataCriacao;
	private double totalPedido;
	private EnderecoDTO enderecoEntrega;
	private List<ItemPedidoDTO> itensPedido = new ArrayList<ItemPedidoDTO>();
	
	public PedidoDTO(){
	}
	
	public PedidoDTO(Integer id, String nomeCliente, String nomeRepresentante, Date dataCriacao,
			double totalPedido, Integer idCliente, EnderecoDTO enderecoEntrega) {
		super();
		this.id = id;
		this.nomeCliente = nomeCliente;
		this.nomeRepresentante = nomeRepresentante;
		this.dataCriacao = dataCriacao;
		this.totalPedido = totalPedido;
		this.idCliente = idCliente;
		this.enderecoEntrega = enderecoEntrega;
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
	
	public double getTotalPedido() {
		return totalPedido;
	}
	
	public void setTotalPedido(double totalPedido) {
		this.totalPedido = totalPedido;
	}
	
	public List<ItemPedidoDTO> getItensPedido() {
		return itensPedido;
	}
	
	public void setItensPedido(List<ItemPedidoDTO> itensPedido) {
		this.itensPedido = itensPedido;
	}
	
	public Integer getIdCliente() {
		return idCliente;
	}
	
	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}
	
	public EnderecoDTO getEnderecoEntrega() {
		return enderecoEntrega;
	}
	
	public void setEnderecoEntrega(EnderecoDTO enderecoEntrega) {
		this.enderecoEntrega = enderecoEntrega;
	}
}
