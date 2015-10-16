package com.bankonet.dao;

import com.bankonet.dao.client.ClientDao;
import com.bankonet.dao.compte.CompteDao;

public interface DaoFactory {

	public CompteDao getCompteDao();
	
	public ClientDao getClientDao();
	
}
