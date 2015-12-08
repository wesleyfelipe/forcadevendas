package com.pqt.forcadevendas.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.pqt.forcadevendas.entity.to.RepresentanteDTO;

public interface IRepresentanteService extends UserDetailsService{

	public RepresentanteDTO getMeusDados();
}
