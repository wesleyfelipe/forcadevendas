package com.pqt.forcadevendas.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pqt.forcadevendas.entity.EnderecoEntrega;

@Repository
@Transactional
public class EnderecoEntregaDAO implements IEnderecoEntregaDAO {

	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public EnderecoEntrega getEnderecoEntrega(Integer id) {
		return (EnderecoEntrega) getCurrentSession().createCriteria(EnderecoEntrega.class)
				.add(Restrictions.eq("id", id)).uniqueResult();
	}

}
