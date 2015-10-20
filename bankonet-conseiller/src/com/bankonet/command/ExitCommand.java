package com.bankonet.command;

import metier.ClientService;

public class ExitCommand extends IHMcommand{

	public ExitCommand(Integer id, ClientService client) {
		super(id, client);
		setLibelle("Sortir de l'application");
		// TODO Auto-generated constructor stub
	}

	public void execute(){
		System.out.println("Arr�t de l�application");
		System.exit(0);
	}


}
