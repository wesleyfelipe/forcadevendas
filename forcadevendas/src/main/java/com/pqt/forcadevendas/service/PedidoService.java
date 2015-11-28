package com.pqt.forcadevendas.service;

import java.math.BigDecimal;
import java.security.AccessControlException;
import java.security.UnrecoverableKeyException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ws.rs.NotFoundException;

import org.hibernate.metamodel.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.pqt.forcadevendas.dao.IClienteDAO;
import com.pqt.forcadevendas.dao.IPedidoDAO;
import com.pqt.forcadevendas.dao.IProdutoDAO;
import com.pqt.forcadevendas.entity.Cliente;
import com.pqt.forcadevendas.entity.ItemPedido;
import com.pqt.forcadevendas.entity.Pedido;
import com.pqt.forcadevendas.entity.Produto;
import com.pqt.forcadevendas.entity.Representante;
import com.pqt.forcadevendas.entity.to.ItemPedidoDTO;
import com.pqt.forcadevendas.entity.to.PedidoDTO;
import com.pqt.forcadevendas.entity.to.PedidoDadosBasicosDTO;

@Service
public class PedidoService implements IPedidoService {

	@Autowired
	private IPedidoDAO dao;

	@Autowired
	private IClienteDAO clienteDao;

	@Autowired
	private IProdutoDAO produtoDao;

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

		if (pedido == null) {
			throw new NotFoundException("Pedido com identificador " + id + " não existe.");
		}

		Representante representante = (Representante) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();

		if (!pedido.getRepresentante().getId().equals(representante.getId())) {
			throw new AccessControlException("Pedido com identificador " + id + " não pertence ao usuario logado.");
		}

		return buildPedidoDtoFromPedido(pedido);
	}

	@Override
	public PedidoDTO persistPedido(PedidoDTO pedidoDto) throws Exception {
		Pedido pedido = updatePedidoFromPedidoDto(new Pedido(), pedidoDto);
		dao.persistPedido(pedido);
		return buildPedidoDtoFromPedido(pedido);
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
		dto.setIdCliente(pedido.getCliente().getId());
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

	private Pedido updatePedidoFromPedidoDto(Pedido pedido, PedidoDTO dto) throws Exception {
		if (pedido == null || dto == null)
			return pedido;

		pedido.setDataPedido(new Date());
		pedido.setRepresentante((Representante) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
		pedido.setCliente(findClienteForPedido(dto.getIdCliente()));

		if(dto.getItensPedido().isEmpty()){
			throw new ValidationException("É necessário incluir ao menos um item para realizar um pedido.");
		}
		
		pedido.getItemPedidos().clear();
		for (ItemPedidoDTO itemDto : dto.getItensPedido()) {
			ItemPedido itemPedido = new ItemPedido(findProdutoForPedido(itemDto.getIdProduto()), itemDto.getQuantidade(),
					itemDto.getTamanho());
			validateItemPedido(itemPedido);
			pedido.addItemPedido(itemPedido);
		}

		return pedido;
	}
	
	private void validateItemPedido(ItemPedido itemPedido){
		if(itemPedido.getQuantidade() == null)
			throw new ValidationException("É necessário informar a quantidade de todos os itens para realizar um pedido.");
		if(itemPedido.getTamanho() == null)
			throw new ValidationException("É necessário informar o tamanho de todos os itens para realizar um pedido.");
	}

	private Cliente findClienteForPedido(Integer idCliente) throws Exception {
		if (idCliente != null) {
			Cliente cliente = clienteDao.getCliente(idCliente);
			if (cliente != null) {
				return cliente;
			} else {
				throw new UnrecoverableKeyException(
						"Cliente com id " + idCliente + " não existe. Não foi possível criar pedido.");
			}
		}
		throw new UnrecoverableKeyException("Cliente não informado. Não foi possível criar pedido.");
	}

	private Produto findProdutoForPedido(Integer idProduto) throws Exception {
		if (idProduto != null) {
			Produto produto = produtoDao.getProduto(idProduto);
			if (produto != null) {
				return produto;
			} else {
				throw new UnrecoverableKeyException(
						"Produto com id " + idProduto + " não existe. Não foi possível criar pedido.");
			}
		}
		throw new UnrecoverableKeyException("Produto não informado em item. Não foi possível criar pedido.");
	}

}
