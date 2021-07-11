package br.fuctura.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	//singleton
	private static EntityManagerFactory factory;
	static {
		factory = Persistence.createEntityManagerFactory("fuctura-pu");
	}

	public static EntityManager getEntityManager() {
		return factory.createEntityManager();
	}

	public static void close() {
		factory.close();
	}

}

