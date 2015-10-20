package com.bankonet.command;

import java.util.Scanner;

import metier.ClientService;

public abstract class IHMcommand {
	
	private String libelle;
	private Integer id;
	private ClientService client;
	Scanner user_input = new Scanner(System.in);
	
	public IHMcommand(Integer id, ClientService client){
		this.id=id;
		this.client=client;
	}
	
	public void setLibelle(String libelle){
		this.libelle=libelle;
	}
	
	public String getLibelle(){
		return this.libelle;
	}
	
	public void execute() {
	}
	
	public Integer getId() {
		return this.id;
	}
	
	public void setId(Integer id){
		this.id=id;
	}
	
	public ClientService getClient(){
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
