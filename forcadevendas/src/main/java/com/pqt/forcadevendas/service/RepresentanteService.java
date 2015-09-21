package com.pqt.forcadevendas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.pqt.forcadevendas.dao.IRepresentanteDAO;
import com.pqt.forcadevendas.entity.Representante;

@Service
public class RepresentanteService implements IRepresentanteService{

	@Autowired
	private IRepresentanteDAO dao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Representante representante = dao.getRepresentante(username);
		if(representante == null)
			throw new UsernameNotFoundException("Usuário " + username + " não encontrado.");
		return representante;
	}
}
