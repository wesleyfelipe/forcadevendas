package com.pqt.forcadevendas.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pqt.forcadevendas.entity.Pedido;

@Repository
@Transactional
public class PedidoDAO implements IPedidoDAO{

	@Autowired
    private SessionFactory sessionFactory;
     
    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
	
    @SuppressWarnings("unchecked")
    @Override
	public List<Pedido> listPedidos() {
		return getCurrentSession().createQuery("from " + Pedido.class.getSimpleName()).list();
	}

	@Override
	public Pedido getPedido(Integer id) {
		return (Pedido) getCurrentSession().createCriteria(Pedido.class)
				.add(Restrictions.eq("id", id)).uniqueResult();
	}

	@Override
	public Pedido persistPedido(Pedido pedido) {
		getCurrentSession().persist(pedido);
		return pedido;
	}

	@Override
	public Pedido updatePedido(Pedido pedido) {
		getCurrentSession().update(pedido);
		return pedido;
	}
    
	@SuppressWarnings("unchecked")
    @Override
    public List<Pedido> listPedidosByRepresentante(Integer idRepresentante) {
		return (List<Pedido>) getCurrentSession().createCriteria(Pedido.class)
				.add(Restrictions.eq("representante.id", idRepresentante)).list();
    }

}
