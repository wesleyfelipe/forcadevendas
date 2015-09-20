package com.pqt.forcadevendas.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pqt.forcadevendas.entity.Representante;

@Repository
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
		//TODO: mudar método de cosulta. QueryDSL?
		return (Representante) getCurrentSession().createCriteria(Representante.class)
				.add(Restrictions.eq("username", username).ignoreCase()).uniqueResult();
	}

}
