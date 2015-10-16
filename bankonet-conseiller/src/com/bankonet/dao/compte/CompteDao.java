package com.bankonet.dao.compte;

import java.util.List;

import com.bankonet.Compte;

public interface CompteDao {

	public List<Compte> findAll();
	
	public void save(Compte c);
	
	public void creerCompte(String identifiant, String compte);
}
