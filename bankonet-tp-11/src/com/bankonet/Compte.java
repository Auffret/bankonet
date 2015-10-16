package com.bankonet;


public abstract class Compte implements CompteStat {
	
	private String numero;
	private String intitule;
	private double solde;
	
	public Compte(String numero, String intitule, double solde) {
		super();
		this.numero = numero;
		this.intitule = intitule;
		if(solde >= 0.0) {
			this.solde = solde;
		} else {
			System.out.println("Impossible de créer un compte avec un solde négatif");
		}
	}
	
	public Compte(){
		
	};
	
	abstract protected double calculerDebitMaximum();
	
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getIntitule() {
		return intitule;
	}
	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}
	public double getSolde() {
		return solde;
	}
	public void setSolde(double solde) {
		this.solde = solde;
	}
	
	
	public void crediter(double montant) throws CompteException {
		solde = solde + montant;
	}
	
	public void debiter(double montant) throws CompteException {
		double debitMax = calculerDebitMaximum();
		if(montant <= debitMax) {
			solde = solde - montant;
		} else {
			throw new DebitException("Débit maximum atteint : " + debitMax);
		}
	}
	
	public void effectuerVirement(Compte compte, double montant) throws CompteException {
		this.debiter(montant);
		compte.crediter(montant);
	}
	
	@Override
	public String toString() {
		return String.format("CompteCourant [numero=%s, intitule=%s, solde=%s]", numero,
				intitule, solde);
	}

}
