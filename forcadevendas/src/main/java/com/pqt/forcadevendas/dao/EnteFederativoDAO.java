package com.pqt.forcadevendas.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pqt.forcadevendas.entity.Cidade;
import com.pqt.forcadevendas.entity.Estado;
import com.pqt.forcadevendas.entity.Pais;

@Repository
@Transactional
public class EnteFederativoDAO implements IEnteFederativoDAO {

	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Pais> listPaises() {
		return getCurrentSession().createQuery("from " + Pais.class.getSimpleName()).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Estado> listEstados(Integer idPais) {
		return getCurrentSession()
				.createQuery("SELECT r FROM " + Estado.class.getSimpleName() + " r WHERE r.pais.id=:idPais")
				.setParameter("idPais", idPais).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Cidade> listCidades(Integer idEstado) {
		return getCurrentSession()
				.createQuery("SELECT r FROM " + Cidade.class.getSimpleName() + " r WHERE r.estado.id=:idEstado")
				.setParameter("idEstado", idEstado).list();
	}

	@Override
	public Cidade getCidade(String nome) {
		return (Cidade) getCurrentSession()
				.createQuery("SELECT r FROM " + Cidade.class.getSimpleName() + " r WHERE r.nome=:nome")
				.setParameter("nome", nome).uniqueResult();
	}

}
