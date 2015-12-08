package com.pqt.forcadevendas.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pqt.forcadevendas.entity.Representante;

@Repository
@Transactional
public class RepresentanteDAO implements IRepresentanteDAO {

	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public Representante getRepresentante(long id) {
		return (Representante) getCurrentSession().get(Representante.class, id);
	}

	@Override
	public Representante getRepresentante(String username) {
		return (Representante) getCurrentSession().createCriteria(Representante.class)
				.add(Restrictions.eq("username", username).ignoreCase()).uniqueResult();
	}

}
