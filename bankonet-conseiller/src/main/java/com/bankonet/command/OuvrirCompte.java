package com.bankonet.command;

import classes.Compte;
import classes.CompteCourant;
import metier.ClientService;
import metier.CompteService;

public class OuvrirCompte extends IHMcommand{

	public OuvrirCompte(Integer id, CompteService client) {
		super(id, client);
		setLibelle("Ouvrir un compte");
		// TODO Auto-generated constructor stub
	}

	public void execute(){
		System.out.println("Entrez le numéro du compte");
		String numero = user_input.next();
		System.out.println("Entrez l'intitulé du compte");
		String intitule = user_input.next();
		System.out.println("Entrez le solde du compte");
		double solde = user_input.nextDouble();// TODO : test is double
		System.out.println("Entrez le login du client");
		String login=user_input.next();// TODO: exist in client
		
		Compte c=new CompteCourant(numero, intitule,solde,100,login);
		getClient().creerCompte(c);
		
		
	}
}
