package com.bankonet.test;

import com.bankonet.Civilite;
import com.bankonet.Client;
import com.bankonet.CompteCourant;
import com.bankonet.CompteEpargne;
import com.bankonet.CompteException;
import com.bankonet.CompteNonTrouveException;
import com.bankonet.Stockage;

public class TestClient {

	public static void main(String[] args) throws CompteException, CompteNonTrouveException {
		CompteCourant cc1 = new CompteCourant("CC001", "COMPTE COURANT 1", 100.0, 400.0);
		CompteEpargne ce1 = new CompteEpargne("CE002", "COMPTE COURANT 2", 300.0, 2.0);
		
		ce1.effectuerVirement(cc1, 50);
		
		System.out.println(cc1);
		System.out.println(ce1);
		
		
		Client client = new Client(Civilite.MONSIEUR, "Paul", "Hugues", "C001");
		
		
		client.creerCompte(cc1);
		client.creerCompte(ce1);
		System.out.println(client);
		
		System.out.println("Recherche compte numéro CE002");
		System.out.println(client.retournerCompte("CE002"));
		
		System.out.println("Suppression compte courant");
		client.supprimerCompte(cc1);
		System.out.println(client);
		
		
		System.out.println("Suppression compte epargne");
		client.supprimerCompte("CE002");
		System.out.println(client);
	
		
		
	}

}
