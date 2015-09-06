package com.pqt.forcadevendas.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Test {

	public static void main(String[] args) {
		
		Estado estado1 = new Estado();
		estado1.setNome("ABC");
		
		Estado estado2 = new Estado();
		estado2.setNome("DEF");
		
		Set<Estado> estados = new HashSet<Estado>();
		estados.add(estado1);
		estados.add(estado2);
		
		Pais pais  = new Pais();
		pais.setNome("Áustria");
		pais.setSigla("AUS");
		pais.setEstados(estados);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("FDV");
		EntityManager em = emf.createEntityManager();

		System.out.println("Iniciando transação.");
		em.getTransaction().begin();
		
		em.persist(pais);
		
		em.getTransaction().commit();
		
		emf.close();

	}

}
