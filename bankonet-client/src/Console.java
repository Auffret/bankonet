import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;

import com.bankonet.Client;

public class Console {

	Scanner user_input = new Scanner( System.in );
	String login;
	Client client=new Client();
	
	public Console(){
		commencer();
	}

	public void commencer()
	{
		Connexion();
		ModePrincipal();
		
	}
	
	public void ModePrincipal(){
		System.out.println("***** APPLICATION Client ******\n"
				+ "0. Arrêter le programme\n"
				+ "1. Consulter les soldes des comptes\n"
				+ "Veuillez choisir une action.");
		
		Integer choix = user_input.nextInt();
		
		switch (choix) {
		case 0:
			System.out.println("Arrêt de l’application");
			break;
		case 1:
			Consulter();
			break;
		default:
			ModePrincipal();
		}
	}
	
	public void Consulter(){
		File file = new File("C:/Users/ETY/workspace/bankonet-conseiller/compte.properties");
		FileInputStream fileInput = null;
		try {						
			fileInput = new FileInputStream(file);
			Properties propPrint = new Properties();			
			//load a properties file from class path, inside static method
			propPrint.load(fileInput);
			
					
			
			for(String s:propPrint.getProperty(client.getIdentifiant()).split(",")){
				System.out.println(s);
				Map<String, String> m = new HashMap<>();
				for(String s2:s.split("&")){
						String[] keyVal=s2.split(":");
						m.put(keyVal[0], keyVal[1]);
				}
				System.out.println(m.get("intitulé")+" numéro:"+m.get("numero")+" solde:"+m.get("solde"));// TODO : objet compte + toString()
			}
		} 
		catch (IOException ex) {
		    ex.printStackTrace();
		}
		finally {
			if (fileInput != null) {
				try {
					fileInput.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public void Connexion(){
		boolean b=false;
		
		while(!b){
			System.out.println("*** Login ***");
			client.setIdentifiant(user_input.next());
			System.out.println("*** MdP ***");
			String secret = user_input.next();
			
			File file = new File("C:/Users/ETY/workspace/bankonet-conseiller/client.properties");
			FileInputStream fileInput = null;
			try {						
			fileInput = new FileInputStream(file);
			Properties propPrint = new Properties();			
			//load a properties file from class path, inside static method
			propPrint.load(fileInput);
				if (propPrint.containsKey(client.getIdentifiant())) {
						String[] propertyArray=propPrint.getProperty(client.getIdentifiant()).split("&");
						Map<String, String> m = new HashMap<>();
						for(String s:propertyArray){
							String[] keyVal=s.split(":");
							m.put(keyVal[0], keyVal[1]);
						}
						while(!b){
							if(m.get("mdp").equals(secret)){
								System.out.println("Connexion réussie");
								b=true;
							}else{							
								System.out.println("Le mot de passe est incorrect");		
								secret = user_input.next();
							}
						}																
				}
				else{
					System.out.println("Login non référencé");
				}

			} 
			catch (IOException ex) {
			    ex.printStackTrace();
			}
			finally {
				if (fileInput != null) {
					try {
						fileInput.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
	
	public boolean Confirmation(String s){// TODO: décommenter et juger de l'interêt.
		/*
		while(true){
			System.out.println("Vous avez entré : "+s+"\n"
					+ "0. pour confirmer\n"
					+ "1. pour nier\n");
			
			int i = user_input.nextInt();
			switch (i) {
			case 0:
				return true;
			case 1:
				return false;
			default:
				break;
			}
			
		}
		*/ return true;
	}
}
