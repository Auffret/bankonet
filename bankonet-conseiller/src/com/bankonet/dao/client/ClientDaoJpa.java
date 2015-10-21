package com.bankonet.dao.client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import com.bankonet.Client;

public class ClientDaoJpa implements ClientDao{

	
	private EntityManagerFactory emf;
	
	public ClientDaoJpa(EntityManagerFactory emf) {
		this.emf=emf;
	}

	public Client findByFirstName(String nom){
		EntityManager em= emf.createEntityManager();
		Client c = em.createNamedQuery("client.findByLastName", Client.class)
				.setParameter("name", nom)
				.getSingleResult();
		em.close();
		return c;
	}
	
	public Client findByLogin(String login){
		EntityManager em= emf.createEntityManager();
		Client c = em.createNamedQuery("client.findByLogin", Client.class)
				.setParameter("name", login)
				.getSingleResult();
		em.close();
		return c;
	}
	
	@Override
	public Map<String, Client> findAll() throws ClientException {
		//Map
		Map<String,Client> map=new HashMap();
		EntityManager em= emf.createEntityManager();
		List<Client> li = em.createQuery("SELECT c FROM Client c",Client.class).getResultList();//client ?
		System.out.println("la liste contient tant d'elements:"+li.size());
		for(Client c:li){
			System.out.println(c);
			map.put(c.getIdentifiant(), c);
		}
		
		em.close();
		// TODO Auto-generated method stub
		return map;
	}

	@Override
	public void save(Client c) {
		System.out.println("save?");
		EntityManager em= emf.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		em.persist(c);
		transaction.commit();//transaction.rollback();
		em.close();
		
		
	}

	@Override
	public Client getClient(String login) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean exist(Client c) {
		//System.out.println(findByLogin(c.getIdentifiant()));
		if(findByLogin(c.getIdentifiant())!=null){
			return true;
		}
		return false;
	}

}
