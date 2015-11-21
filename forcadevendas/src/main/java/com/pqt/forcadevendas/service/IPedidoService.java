package com.pqt.forcadevendas.service;

import java.util.List;

import com.pqt.forcadevendas.entity.to.PedidoDTO;
import com.pqt.forcadevendas.entity.to.PedidoDadosBasicosDTO;

public interface IPedidoService {

	public List<PedidoDadosBasicosDTO> listPedidos();
	public PedidoDTO getPedido(Integer id);
	public PedidoDTO persistPedido(PedidoDTO pedidoDto);
}
