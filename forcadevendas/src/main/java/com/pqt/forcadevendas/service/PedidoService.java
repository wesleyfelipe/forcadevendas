package com.pqt.forcadevendas.service;

import java.math.BigDecimal;
import java.security.AccessControlException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.NotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.pqt.forcadevendas.dao.IPedidoDAO;
import com.pqt.forcadevendas.entity.ItemPedido;
import com.pqt.forcadevendas.entity.Pedido;
import com.pqt.forcadevendas.entity.Representante;
import com.pqt.forcadevendas.entity.to.ItemPedidoDTO;
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
		Pedido pedido = dao.getPedido(id);
		
		if(pedido == null){
			throw new NotFoundException("Pedido com identificador " + id + " não existe.");
		}
		
		Representante representante = (Representante) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
		
		if(!pedido.getRepresentante().getId().equals(representante.getId())){
			throw new AccessControlException("Pedido com identificador " + id + " não pertence ao usuario logado.");
		}
		
		return buildPedidoDtoFromPedido(pedido);
	}

	@Override
	public PedidoDTO persistPedido(PedidoDTO pedidoDto) {
		// TODO Auto-generated method stub
		return null;
	}

	private BigDecimal getTotalPedido(Pedido pedido) {
		BigDecimal total = new BigDecimal(0);
		for (ItemPedido item : pedido.getItemPedidos()) {
			total = total.add(item.getProduto().getPrecoValido());
		}
		return total;
	}

	private PedidoDTO buildPedidoDtoFromPedido(Pedido pedido) {
		PedidoDTO dto = new PedidoDTO();
		dto.setDataCriacao(pedido.getDataPedido());
		dto.setId(pedido.getId());
		dto.setNomeCliente(pedido.getCliente().getNome());
		dto.setNomeRepresentante(pedido.getRepresentante().getNome());
		dto.setTotalPedido(getTotalPedido(pedido));
		
		for (ItemPedido item : pedido.getItemPedidos()) {
			dto.getItensPedido()
					.add(new ItemPedidoDTO(item.getProduto().getId(), item.getProduto().getModelo().getNome(),
							item.getProduto().getModelo().getMarca().getNome(), item.getProduto().getPrecoValido(),
							item.getQuantidade(), item.getTamanho()));
		}
		
		return dto;
	}

}
