package com.bankonet.dao.compte;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.bankonet.Compte;

public class CompteDaoJpa implements CompteDao{

	EntityManager em;
	
	public CompteDaoJpa(EntityManagerFactory emf) {
		this.em=emf.createEntityManager();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public List<Compte> findAll(String identifiant) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void creerCompte(String identifiant, Compte c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void creerCompte(String identifiant) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean exist(String identifiant) {
		// TODO Auto-generated method stub
		return false;
	}

}
