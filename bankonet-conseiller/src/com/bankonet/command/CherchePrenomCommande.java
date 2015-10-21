package com.bankonet.command;

import java.util.List;

import com.bankonet.Client;

import metier.ClientService;

public class CherchePrenomCommande extends IHMcommand{

	public CherchePrenomCommande(Integer id, ClientService client) {
		super(id, client);
		setLibelle("Chercher client par prenom");
		// TODO Auto-generated constructor stub	
	}

	public void execute(){
		System.out.println("Entrez le prenom");
		String prenom = user_input.next();
		List<Client> li=getClient().getClientDao().findByFirstName(prenom);
		for(Client c:li){
			System.out.println(c);
		}
	}
}
