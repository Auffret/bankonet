package com.bankonet.dao.client;

import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.bankonet.Client;

public class ClientDaoJpa implements ClientDao{

	
	EntityManager em;
	
	public ClientDaoJpa(EntityManagerFactory emf) {
		this.em=emf.createEntityManager();
	}

	@Override
	public Map<String, Client> findAll() throws ClientException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Client c) {
		EntityTransaction transaction = em.getTransaction();

		transaction.begin();
		em.persist(c);
		transaction.commit();
		
		// TODO Auto-generated method stub
		
	}

	@Override
	public Client getClient(String login) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean exist(Client c) {
		// TODO Auto-generated method stub
		return false;
	}

}
