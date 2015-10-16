package com.bankonet.test;

import com.bankonet.CompteCourant;
import com.bankonet.CompteEpargne;
import com.bankonet.CompteStat;

public class DonneesTest {
	
	public static CompteStat[] construitEchantillonComptes() {
		CompteStat[] comptes = new CompteStat[5];
		comptes[0] = new CompteCourant("CC001", "COMPTE COURANT 1", 100.0, 400.0);
		comptes[1] = new CompteCourant("CC002", "COMPTE COURANT 2", 200.0, 400.0);
		comptes[2] = new CompteCourant("CC003", "COMPTE COURANT 3", -1.0, 400.0);
		comptes[3] = new CompteEpargne("CC002", "COMPTE COURANT 2", 300.0, 2.0);
		comptes[4] = new CompteEpargne("CC003", "COMPTE COURANT 3", 5000.0, 2.0);

		return comptes;
	}

}
