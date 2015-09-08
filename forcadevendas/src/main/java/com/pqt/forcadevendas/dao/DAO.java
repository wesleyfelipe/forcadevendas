package com.pqt.forcadevendas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DAO {

	protected EntityManagerFactory emf;
	protected EntityManager em;
	
	public void iniciarOperacao(){
		emf = Persistence.createEntityManagerFactory("FDV"); // TODO: remover esta conf daqui
		em = emf.createEntityManager();
	}
	
	public void encerrarOperacao(){
		emf.close();
	}
	
	public List executarQuery(String hql){
		iniciarOperacao();
		List resultado =  em.createQuery(hql).getResultList();
		encerrarOperacao();
		return resultado;
	}
}
