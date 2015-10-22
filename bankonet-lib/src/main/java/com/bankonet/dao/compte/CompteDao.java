package com.bankonet.dao.compte;

import java.util.List;

import classes.Compte;


public interface CompteDao {

	public List<Compte> findAll(String identifiant);
	static String fileName="compte.properties";
	
	//public void save(Compte c);
	
	public void creerCompte(Compte c);
	public boolean exist(String identifiant);
}
