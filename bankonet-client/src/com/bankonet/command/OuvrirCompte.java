package com.bankonet.command;

import metier.ClientService;

public class OuvrirCompte extends IHMcommand{

	public OuvrirCompte(Integer id, ClientService client) {
		super(id, client);
		// TODO Auto-generated constructor stub
	}

	public void execute(){
		String numero = user_input.next();
		String intitule = user_input.next();
		double solde = user_input.nextDouble();// TODO : test is double
		String login=user_input.next();// TODO: exist in client
		
		getClient().creerCompte(login);
		
		
	}
}
