package com.bankonet.dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.bankonet.dao.client.ClientDao;
import com.bankonet.dao.client.ClientDaoJpa;
import com.bankonet.dao.compte.CompteDao;
import com.bankonet.dao.compte.CompteDaoJpa;

public class DaoFactoryJpa implements DaoFactory{

	EntityManagerFactory emf;
	
	public DaoFactoryJpa(String s) {
		this.emf=Persistence.createEntityManagerFactory("bankonet-tp-11");//TODO
	}
	
	@Override
	public CompteDao getCompteDao() {
		// TODO Auto-generated method stub
		return new CompteDaoJpa(emf);
	}

	@Override
	public ClientDao getClientDao() {
		// TODO Auto-generated method stub
		return new ClientDaoJpa(emf);
	}

}
