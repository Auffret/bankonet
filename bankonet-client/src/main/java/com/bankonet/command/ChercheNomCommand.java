package com.bankonet.command;

import java.util.List;

import classes.Client;
import metier.ClientService;

public class ChercheNomCommand extends IHMcommand{

	public ChercheNomCommand(Integer id, ClientService client) {
		super(id, client);
		setLibelle("Chercher client par nom");
		// TODO Auto-generated constructor stub
	}

	public void execute(){
		System.out.println("Entrez le nom");
		String nom = user_input.next();
		List<Client> li=getClient().getClientDao().findByLastName(nom);
		for(Client c:li){
			System.out.println(c);
		}
	}
}
