package com.bankonet;

public class TestCompteCourant {
	
	public static void main(String[] args) throws CompteException {
		CompteCourant cc1 = new CompteCourant("CC001", "COMPTE COURANT 1", 0.0, 400.0);
		CompteCourant cc2 = new CompteCourant("CC002", "COMPTE COURANT 2", 0.0, 400.0);
		CompteCourant cc3 = new CompteCourant("CC003", "COMPTE COURANT 3", -1.0, 400.0);
		
		System.out.println("Nombre de comptes = " + CompteCourant.getNbCompteCourant());
		
		cc1.crediter(300.0);
		cc1.debiter(150.0);
		
		cc2.crediter(400.0);
		
		try {
			cc3.debiter(100.0);
		} catch(DebitException e) {
			System.out.println(e.getMessage());
		}
		
		
		CompteCourant[] compteCourantTab = {cc1, cc2, cc3};
		
		for(CompteCourant cc : compteCourantTab) {
			System.out.println(cc);
		}
	}

}
