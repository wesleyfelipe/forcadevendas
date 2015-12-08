package com.pqt.forcadevendas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pqt.forcadevendas.entity.to.PedidoDTO;
import com.pqt.forcadevendas.entity.to.PedidoDadosBasicosDTO;
import com.pqt.forcadevendas.service.IPedidoService;

@RestController
@RequestMapping(value = "/recursos/pedido")
public class PedidoController {

	@Autowired
	private IPedidoService service;
	
	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public List<PedidoDadosBasicosDTO> listPedidos() {
		return service.listPedidos();
	}
	
	@RequestMapping(method = RequestMethod.GET, produces = "application/json", value = "/{id}")
	public PedidoDTO getPedido(@PathVariable("id") Integer id){
		return service.getPedido(id);
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public PedidoDTO persistPedido(@RequestBody PedidoDTO dto) throws Exception{
		return service.persistPedido(dto);
	}
}
