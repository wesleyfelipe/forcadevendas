package com.pqt.forcadevendas.entity.to;

public class PedidoKpiMesDTO {
	private int totalClientesPedido;
	private double totalPedidos;
	
	public PedidoKpiMesDTO(int totalClientesPedido, double totalPedidos) {
		super();
		this.totalClientesPedido = totalClientesPedido;
		this.totalPedidos = totalPedidos;
	}
	
	public int getTotalClientesPedido() {
		return totalClientesPedido;
	}
	
	public void setTotalClientesPedido(int totalClientesPedido) {
		this.totalClientesPedido = totalClientesPedido;
	}
	
	public double getTotalPedidos() {
		return totalPedidos;
	}
	
	public void setTotalPedidos(double totalPedidos) {
		this.totalPedidos = totalPedidos;
	}
	
}
