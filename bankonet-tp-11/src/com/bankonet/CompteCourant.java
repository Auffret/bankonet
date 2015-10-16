package com.bankonet;

public class CompteCourant extends Compte {
	

	private double montantDecouvertAutorise;
	private static int nbCompteCourants = 0;
	
	
		
	public CompteCourant(String numero, String intitule, double solde, double montantDecouvertAutorise) {
		super(numero, intitule, solde);		
		this.montantDecouvertAutorise = montantDecouvertAutorise;
		nbCompteCourants++;
	}


	public double getMontantDecouvertAutorise() {
		return montantDecouvertAutorise;
	}
	public void setMontantDecouvertAutorise(double montantDecouvertAutorise) {
		this.montantDecouvertAutorise = montantDecouvertAutorise;
	}
	
	public static int getNbCompteCourant() {
		return nbCompteCourants;
	}
	
	


	@Override
	public String toString() {
		return String.format("CompteCourant [numero=%s, intitule=%s, solde=%s, montantDecouvertAutorise=%s]", getNumero(),
				getIntitule(), getSolde(), montantDecouvertAutorise);
	}


	@Override
	protected double calculerDebitMaximum() {
		return montantDecouvertAutorise + getSolde();
	}
	
	

}
