package com.bankonet.command;

import java.util.Comparator;
import java.util.Map;

import com.bankonet.Client;
import com.bankonet.dao.client.ClientException;

import metier.ClientService;

public class ListerClientsCommand extends IHMcommand {

	public ListerClientsCommand(Integer id, ClientService client) {
		super(id, client);
		setLibelle("Afficher liste de clients");
		// TODO Auto-generated constructor stub
	}

	public void execute() throws ClientException {
		//System.out.println("execute");
		//Map<String,Client> m=getClient().findAllClient();
/*
		for (Client c : getClient().findAllClient().values()) {
			System.out.println(c.toString());
		}
*/
		for (Client c : getClient().findAllClient().values()) {
			System.out.println(c.toString());
		}
		
	}
}
