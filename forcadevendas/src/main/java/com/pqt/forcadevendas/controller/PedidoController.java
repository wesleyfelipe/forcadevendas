package com.pqt.forcadevendas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pqt.forcadevendas.entity.Representante;
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
}