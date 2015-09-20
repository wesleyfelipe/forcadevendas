package com.pqt.forcadevendas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pqt.forcadevendas.configuration.security.TokenUtils;
import com.pqt.forcadevendas.entity.to.TokenDTO;
import com.pqt.forcadevendas.entity.to.UsuarioDTO;
import com.pqt.forcadevendas.service.IRepresentanteService;

@RestController
public class AcessoController {

	@Autowired
	private IRepresentanteService service;

	@Autowired
	@Qualifier("authenticationManager")
	private AuthenticationManager authManager;

	@RequestMapping(method = RequestMethod.POST, produces = "application/json", value = "/login")
	public TokenDTO authenticate(@RequestBody UsuarioDTO usuario) {
		UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
				usuario.getUsername(), usuario.getPassword());
		Authentication authentication = this.authManager.authenticate(authenticationToken);
		SecurityContextHolder.getContext().setAuthentication(authentication);

		/*
		 * Reload user as password of authentication principal will be null
		 * after authorization and password is needed for token generation
		 */
		UserDetails userDetails = this.service.loadUserByUsername(usuario.getUsername());

		return new TokenDTO(TokenUtils.createToken(userDetails));
	}
}
