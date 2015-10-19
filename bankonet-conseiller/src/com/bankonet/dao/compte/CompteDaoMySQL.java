package com.bankonet.dao.compte;

import java.util.List;

import com.bankonet.Compte;

public class CompteDaoMySQL implements CompteDao{

	/*
	@Override
	public void save(Compte c) {
		// TODO Auto-generated method stub
		
	}
	 */
	
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
	
	public boolean exist(String identifiant){
		return true;
	}

}
