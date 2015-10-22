package com.bankonet.command;

import java.util.Scanner;

import com.bankonet.dao.client.ClientException;

import metier.ClientService;
import metier.CompteService;

public abstract class IHMcommand {
	
	private String libelle;
	private Integer id;
	private CompteService client;
	Scanner user_input = new Scanner(System.in);
	
	public IHMcommand(Integer id, CompteService client2){
		this.id=id;
		this.client=client2;
	}
	
	public void setLibelle(String libelle){
		this.libelle=libelle;
	}
	
	public String getLibelle(){
		return this.libelle;
	}
	
	public void execute() throws ClientException {
	}
	
	public Integer getId() {
		return this.id;
	}
	
	public void setId(Integer id){
		this.id=id;
	}
	
	public CompteService getClient(){
		return client;
	}
	
	public boolean Confirmation(String s) {
		// TODO: décommenter et juger de l'interêt.
		/*
		 * while(true){ System.out.println("Vous avez entré : "+s+"\n" +
		 * "0. pour confirmer\n" + "1. pour nier\n");
		 * 
		 * int i = user_input.nextInt(); switch (i) { case 0: return true; case
		 * 1: return false; default: break; }
		 * 
		 * }
		 */ return true;
	}
}
