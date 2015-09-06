package com.pqt.forcadevendas.entity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Test {

	public static void main(String[] args) {
		Pais pais  = new Pais();
		pais.setNome("�ustria");
		pais.setSigla("AUS");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("FDV");
		EntityManager em = emf.createEntityManager();

		System.out.println("Iniciando transa��o.");
		em.getTransaction().begin();
		
		em.persist(pais);
		
		em.getTransaction().commit();
		
		emf.close();

	}

}
