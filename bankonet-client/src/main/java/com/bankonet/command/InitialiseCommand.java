package com.bankonet.command;

import metier.ClientService;

public class InitialiseCommand extends IHMcommand {

	public InitialiseCommand(Integer id, ClientService client) {
		super(id, client);
		setLibelle("Initialisation du compte");
		// TODO Auto-generated constructor stub
	}
	
	public void execute(){
		getClient().init();
	}

}
