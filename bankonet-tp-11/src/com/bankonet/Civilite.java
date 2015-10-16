package com.bankonet;

public enum Civilite {
	MONSIEUR("Monsieur"), MADAME("Madame"), MADEMOISELLE("Mademoiselle");
	
	private String libelle;
	
	private Civilite(String libelle) {
		this.libelle = libelle;
	}
	
	public String getLibelle() {
		return libelle;
	}
	
	

}
