package com.bankonet.dao.client;

import com.bankonet.Client;

public interface ClientDao {

	static String fileName="client.properties";
	
	public void save(Client c);
	public Client getClient(String login);
	public boolean exist(Client c);
}
