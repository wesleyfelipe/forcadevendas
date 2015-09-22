package com.pqt.forcadevendas.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pqt.forcadevendas.entity.Cliente;

@Repository
public class ClienteDAO implements IClienteDAO{

	@Autowired
    private SessionFactory sessionFactory;
     
    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
	
    @SuppressWarnings("unchecked")
    @Override
	public List<Cliente> listClientes() {
		return getCurrentSession().createQuery("from " + Cliente.class.getSimpleName()).list();
	}

	@Override
	public Cliente getCliente(int id) {
		return (Cliente) getCurrentSession().createCriteria(Cliente.class)
				.add(Restrictions.eq("id", id)).uniqueResult();
	}
    
    

}
