package com.pqt.forcadevendas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.pqt.forcadevendas.dao.IRepresentanteDAO;
import com.pqt.forcadevendas.entity.Representante;
import com.pqt.forcadevendas.entity.to.PedidoKpiMesDTO;
import com.pqt.forcadevendas.entity.to.RepresentanteDTO;

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

	@Override
	public RepresentanteDTO getMeusDados() {
		Representante representante = (Representante) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
		return buildRepresentanteDTOFromRepresentante(representante);
	}
	
	private RepresentanteDTO buildRepresentanteDTOFromRepresentante(Representante representante){
		RepresentanteDTO dto = new RepresentanteDTO();
		dto.setCpf(representante.getCpf());
		dto.setEmail(representante.getEmail());
		dto.setFone(representante.getFone());
		dto.setId(representante.getId());
		dto.setNome(representante.getNome());
		dto.setNomeUsuario(representante.getUsename());
		dto.setRg(representante.getRg());
		dto.setSituacao(representante.getSituacao());
		
		return dto;
	}
	
	//TODO
	private List<PedidoKpiMesDTO> getDesempenhoSemestral(Representante representante){
		return null;
	}
}
