package com.pqt.forcadevendas.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pqt.forcadevendas.entity.Cidade;
import com.pqt.forcadevendas.entity.Estado;
import com.pqt.forcadevendas.entity.Pais;

@Repository
public class EnteFederativoDAO implements IEnteFederativoDAO{

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
				.setParameter("idPais", idPais)
				.list();
	}

	@Override
	public List<Cidade> listCidades(Estado estado) {
		// TODO Auto-generated method stub
		return null;
	}

}
