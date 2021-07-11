package br.fuctura.desafio;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.fuctura.model.Cliente;
import br.fuctura.util.JPAUtil;

public class Principal {

	public static void main(String[] args) {
		EntityManager entityManager = JPAUtil.getEntityManager();
		EntityTransaction tx = entityManager.getTransaction();
		
		tx.begin();
		
		Cliente cliente = new Cliente();
		cliente.setId(2L);
		cliente.setNome("Sérgio Oliveira");
		cliente.setSexo("M");
		cliente.setCpf("620.413.044-76");
		cliente.setAnoNasci("140965");
		
		entityManager.persist(cliente);
		
		tx.commit();
		entityManager.close();
		JPAUtil.close();
		
	}

}
