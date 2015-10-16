package com.bankonet.test;

import com.bankonet.CompteStat;

public class TestAutomate {

	public static void main(String[] args) {
		CompteStat[] comptes = DonneesTest.construitEchantillonComptes();
		
		double somme = 0.0;
		
		for(CompteStat compte : comptes) {
			somme += compte.getSolde();
		}
		
		double moyenne = somme / comptes.length;
		
		System.out.println("Moyenne = " + moyenne);
		
	}

}
