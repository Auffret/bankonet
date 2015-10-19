package com.bankonet.dao.client;

import java.util.Map;

import com.bankonet.Client;

public interface ClientDao {

	static String fileName="client.properties";
	
	Map<String,Client> findAll() throws ClientException;
	public void save(Client c);
	public Client getClient(String login);
	public boolean exist(Client c);
}
