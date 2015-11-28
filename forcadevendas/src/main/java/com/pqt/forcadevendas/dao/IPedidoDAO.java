package com.pqt.forcadevendas.dao;

import java.util.List;

import com.pqt.forcadevendas.entity.Pedido;

public interface IPedidoDAO {

	public List<Pedido> listPedidos();
	public Pedido getPedido(Integer id);
	public Pedido persistPedido(Pedido pedido);
	public Pedido updatePedido(Pedido pedido);
	public List<Pedido> listPedidosByRepresentante(Integer idRepresentante);
}
