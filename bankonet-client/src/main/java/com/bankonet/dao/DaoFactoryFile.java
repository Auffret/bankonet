package com.bankonet.dao;

import com.bankonet.dao.client.ClientDao;
import com.bankonet.dao.client.ClientDaoFile;
import com.bankonet.dao.compte.CompteDao;
import com.bankonet.dao.compte.CompteDaoFile;

public class DaoFactoryFile implements DaoFactory{

	@Override
	public CompteDao getCompteDao() {
		// TODO Auto-generated method stub
		return new CompteDaoFile();
	}

	@Override
	public ClientDao getClientDao() {
		// TODO Auto-generated method stub
		return new ClientDaoFile();
	}

	 
}
