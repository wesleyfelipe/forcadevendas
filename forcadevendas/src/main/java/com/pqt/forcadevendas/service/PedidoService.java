package com.pqt.forcadevendas.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.pqt.forcadevendas.dao.IPedidoDAO;
import com.pqt.forcadevendas.entity.ItemPedido;
import com.pqt.forcadevendas.entity.Pedido;
import com.pqt.forcadevendas.entity.Representante;
import com.pqt.forcadevendas.entity.to.PedidoDTO;
import com.pqt.forcadevendas.entity.to.PedidoDadosBasicosDTO;

@Service
public class PedidoService implements IPedidoService {

	@Autowired
	private IPedidoDAO dao;

	@Override
	public List<PedidoDadosBasicosDTO> listPedidos() {
		Representante representante = (Representante) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();

		List<Pedido> pedidos = dao.listPedidosByRepresentante(representante.getId());
		List<PedidoDadosBasicosDTO> dtos = new ArrayList<PedidoDadosBasicosDTO>();
		for (Pedido pedido : pedidos) {
			dtos.add(new PedidoDadosBasicosDTO(pedido.getId(), pedido.getCliente().getNome(),
					pedido.getRepresentante().getNome(), pedido.getDataPedido(), getTotalPedido(pedido)));
		}
		return dtos;
	}

	@Override
	public PedidoDTO getPedido(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PedidoDTO persistPedido(PedidoDTO pedidoDto) {
		// TODO Auto-generated method stub
		return null;
	}

	private BigDecimal getTotalPedido(Pedido pedido) {
		BigDecimal total = new BigDecimal(0);
		for (ItemPedido item : pedido.getItemPedidos()) {
			if (item.getProduto().getPrecoPromocao() != null)
				total = total.add(item.getProduto().getPrecoPromocao());
			else
				total = total.add(item.getProduto().getPreco());
		}
		return total;
	}

}
