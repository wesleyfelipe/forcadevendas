package com.pqt.forcadevendas.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pqt.forcadevendas.entity.Departamento;

@Repository
@Transactional
public class DepartamentoDAO implements IDepartamentoDAO{

	@Autowired
    private SessionFactory sessionFactory;
     
    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @SuppressWarnings("unchecked")
	@Override
	public List<Departamento> listDepartamentos() {
		return getCurrentSession().createQuery("from " + Departamento.class.getSimpleName()).list();
	}
	
}
