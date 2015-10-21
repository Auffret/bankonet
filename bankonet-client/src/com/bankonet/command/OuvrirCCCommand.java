package com.bankonet.command;

import metier.ClientService;

public class OuvrirCCCommand extends IHMcommand{

	public OuvrirCCCommand(Integer id, ClientService client) {
		super(id, client);
		setLibelle("Ouvrir un compte");
		// TODO Auto-generated constructor stub
	}
	
	public void execute(){
		String nom=null;
		String prenom=null;
		String login=null;
		login=null;
		boolean b = true;
		while (b) { // nom
			System.out.println("Votre nom : ");
			nom = user_input.next();
			b = !Confirmation(nom);
		}
		b = true;
		while (b) { // prenom
			System.out.println("Votre prenom : ");
			prenom = user_input.next();
			b = !Confirmation(prenom);
		}
		b = true;
		while (b) { // login
			System.out.println("Votre login : ");
			login = user_input.next();
			b = !Confirmation(login);
		}
		b = true;
		String password = login; // MdP par défaut

		System.out.println("Le MdP par défaut est votre login, veillez à le changer");

		try {
			getClient().creerClient(nom, prenom, login, password);
			//getClient().creerCompte(login);

		} catch (Exception e) {
			System.out.println("Ce client existe déja");
		}

	}


}
