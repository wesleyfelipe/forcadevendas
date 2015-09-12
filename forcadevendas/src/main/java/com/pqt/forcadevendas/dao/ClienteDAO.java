package com.pqt.forcadevendas.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
	public List<Cliente> listarClientes() {
		return getCurrentSession().createQuery("from " + Cliente.class.getSimpleName()).list();
	}

}
