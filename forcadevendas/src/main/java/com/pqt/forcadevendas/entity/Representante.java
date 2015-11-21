package com.pqt.forcadevendas.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * The persistent class for the representante database table.
 * 
 */
@Entity
@Table(schema = "FDV_ONLINE")
public class Representante implements Serializable, UserDetails {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String cpf;

	private String email;

	private String fone;

	private String username;

	private String nome;

	private String rg;

	private String senha;

	private String situacao;

	// bi-directional many-to-one association to Representacao
	@OneToMany(mappedBy = "representante")
	private List<Representacao> representacoes;

	// bi-directional many-to-one association to Representanterole
	@OneToMany(mappedBy = "representante")
	private List<RepresentanteRole> representanteRoles;

	// bi-directional many-to-one association to Supervisao
	@OneToMany(mappedBy = "supervisor")
	private List<Supervisao> supervisoes;

	// bi-directional many-to-one association to Supervisao
	@OneToMany(mappedBy = "representante")
	private List<Supervisao> supervisadoPor;

	// bi-directional many-to-one association to ItemPedido
	@OneToMany(mappedBy = "representante", cascade = CascadeType.ALL)
	private List<Pedido> pedidos;

	public Representante() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCpf() {
		return this.cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFone() {
		return this.fone;
	}

	public void setFone(String fone) {
		this.fone = fone;
	}

	public String getUsename() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRg() {
		return this.rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getSenha() {
		return this.senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getSituacao() {
		return this.situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public List<Representacao> getRepresentacoes() {
		return this.representacoes;
	}

	public void setRepresentacoes(List<Representacao> representacoes) {
		this.representacoes = representacoes;
	}

	public Representacao addRepresentacao(Representacao representacao) {
		getRepresentacoes().add(representacao);
		representacao.setRepresentante(this);

		return representacao;
	}

	public Representacao removeRepresentacao(Representacao representacao) {
		getRepresentacoes().remove(representacao);
		representacao.setRepresentante(null);

		return representacao;
	}

	public List<RepresentanteRole> getRepresentanteRoles() {
		return this.representanteRoles;
	}

	public void setRepresentanteroles(List<RepresentanteRole> representanteroles) {
		this.representanteRoles = representanteroles;
	}

	public RepresentanteRole addRepresentanteRole(RepresentanteRole representanterole) {
		getRepresentanteRoles().add(representanterole);
		representanterole.setRepresentante(this);

		return representanterole;
	}

	public RepresentanteRole removeRepresentanterole(RepresentanteRole representanterole) {
		getRepresentanteRoles().remove(representanterole);
		representanterole.setRepresentante(null);

		return representanterole;
	}

	public List<Supervisao> getSupervisoes() {
		return this.supervisoes;
	}

	public void setSupervisoes(List<Supervisao> supervisoes) {
		this.supervisoes = supervisoes;
	}

	public Supervisao addSupervisao(Supervisao supervisao) {
		getSupervisoes().add(supervisao);
		supervisao.setSupervisor(this);

		return supervisao;
	}

	public Supervisao removeSupervisao(Supervisao supervisao) {
		getSupervisoes().remove(supervisao);
		supervisao.setSupervisor(null);

		return supervisao;
	}

	public List<Supervisao> getSupervisadoPor() {
		return this.supervisadoPor;
	}

	public void setSupervisadoPor(List<Supervisao> supervisadoPor) {
		this.supervisadoPor = supervisadoPor;
	}

	public Supervisao addSupervisadoPor(Supervisao supervisao) {
		getSupervisadoPor().add(supervisao);
		supervisao.setRepresentante(this);

		return supervisao;
	}

	public Supervisao removeSupervisadoPor(Supervisao supervisadoPor) {
		getSupervisadoPor().remove(supervisadoPor);
		supervisadoPor.setRepresentante(null);

		return supervisadoPor;
	}
	
	public List<Pedido> getPedidos() {
		return pedidos;
	}
	
	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
	
	public Pedido addPedido(Pedido pedido) {
		getPedidos().add(pedido);
		pedido.setRepresentante(this);

		return pedido;
	}

	public Pedido removePedido(Pedido pedido) {
		getPedidos().remove(pedido);
		pedido.setRepresentante(null);

		return pedido;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		if (representanteRoles == null) {
			return Collections.emptyList();
		}

		Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
		for (RepresentanteRole role : representanteRoles) {
			authorities.add(new SimpleGrantedAuthority(role.getRole().getNome()));
		}

		return authorities;
	}

	@Override
	public String getPassword() {
		return senha;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO: adicionar um enum no lugar do 'A'
		return situacao.equalsIgnoreCase("A");
	}
	
	

}