package com.bankonet.dao.compte;

import java.util.List;

import com.bankonet.Compte;

public interface CompteDao {

	public List<Compte> findAll(String identifiant);
	static String fileName="compte.properties";
	
	//public void save(Compte c);
	
	public void creerCompte(String identifiant, Compte c);
	public void creerCompte(String identifiant);
	public boolean exist(String identifiant);
}
