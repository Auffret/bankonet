package com.bankonet.dao.client;

import java.util.List;
import java.util.Map;

import com.bankonet.dao.compte.CompteDao;

import classes.Client;

public abstract class ClientDao {

	static String fileName="client.properties";
	
	private ClientDao daoClient;
	private CompteDao daoCompte;
		
	public Map<String,Client> findAll() throws ClientException{return null;};
	public void save(Client c){};
	public Client getClient(String login){return null;};
	public boolean exist(Client c){return true;};
	
	public List<Client> findByFirstName(String prenom){return null;};
	public List<Client> findByLastName(String nom){return null;};
	public Client findByLogin(String login){return null;};
}
