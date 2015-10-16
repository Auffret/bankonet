import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;

import com.bankonet.Client;
import com.bankonet.Compte;
import com.bankonet.CompteCourant;

//import com.bankonet.CompteCourant;


public class Console {

	Integer choix;
	
	Scanner user_input = new Scanner( System.in );
	public Console(){
		commencer();
	}
	
	
	public void commencer()
	{
		System.out.println("***** APPLICATION CONSEILLER BANCAIRE ******\n"
				+ "0. Arr�ter le programme\n"
				+ "1. Ouvrir un compte courant\n"
				+ "2. Lister tous les clients\n"
				+ "Veuillez choisir une action.");
		
		choix = user_input.nextInt();
		
		switch (choix) {
		case 0:
			//TODO Ferme toutes les �ventuelles connexions � la base Mongo
			System.out.println("Arr�t de l�application");

			break;
		case 1:				
			ouvrirCompteCourant();
			commencer();			
			break;
		case 2:
			listeClient();			
			commencer();
			break;		
		default:
			commencer();
			break;
		}
	}
	
	public void listeClient(){
		File file2 = new File("client.properties");
		FileInputStream fileInput = null;
		try {						
		fileInput = new FileInputStream(file2);
		Properties propPrint = new Properties();			
		//load a properties file from class path, inside static method
		propPrint.load(fileInput);
		Enumeration<Object> enuKeys = propPrint.keys();			
		while (enuKeys.hasMoreElements()) {
				
				String retour="";
				String key = (String) enuKeys.nextElement();
				retour+=key + ": ";
				String[] propertyArray=propPrint.getProperty(key).split("&");
				Map<String, String> m = new HashMap<>();
				for(String s:propertyArray){
					String[] keyVal=s.split(":");
					m.put(keyVal[0], keyVal[1]);
				}				
				retour += " login:"+key+" prenom:"+m.get("prenom")+" nom:"+m.get("nom");
				if(m.containsKey("compte_courant")){
					retour +=" nbCC:"+m.get("compte_courant").split(",").length;
				}
				if(m.containsKey("compte_epargne")){
					retour +=" nbCE:"+m.get("compte_epargne").split(",").length;			
				}
				System.out.println(retour);
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
	
	public void ouvrirCompteCourant(){
		//formulaire
		Client client=new Client();
		boolean b=true;
		while(b){						// nom
			System.out.println("Votre nom : ");
			client.setNom(user_input.next());
			b=!Confirmation(client.getNom());
		}
		b=true;
		
		while(b){						// prenom
			System.out.println("Votre prenom : ");
			client.setPrenom(user_input.next());
			b=!Confirmation(client.getPrenom());
		}
		b=true;
		
		while(b){						// login
			System.out.println("Votre login : ");
			client.setIdentifiant(user_input.next());
			b=!Confirmation(client.getIdentifiant());		
		}
		b=true;
		
		String secret = client.getIdentifiant();					// MdP par d�faut
		
		System.out.println("Le MdP par d�faut est votre login, veillez � le changer");	
		
		// Verifie existence de client et charge les donn�es au besoin
		
		boolean existe=false;
		Map<String, String> m= new HashMap<>();
		Map<String, String> me= new HashMap<>();
		File file = new File("client.properties");
		FileInputStream fileInput = null;
		try {								
			fileInput = new FileInputStream(file);
			Properties propPrint = new Properties();			
			//load a properties file from class path, inside static method
			propPrint.load(fileInput);
			if(propPrint.getProperty(client.getIdentifiant())!=null){				// Client d�ja pr�sent
				System.out.println("Client d�ja existant");		
				existe=true;
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
		
		if(!existe){

			// Ajout de client
			
			Properties prop = new Properties();
			FileOutputStream output = null;
			try {
				output = new FileOutputStream(file,true);
				prop.setProperty(client.getIdentifiant(), "nom:" + client.getNom() + "&prenom:" + client.getPrenom() + "&mdp:"+ secret + "&compte_courant:CC1");//TODO define cc
				prop.store(output, null);
			} catch (IOException io) {
				io.printStackTrace();
			} finally {
				if (output != null) {
					try {
						output.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
			// Ajout de compte courant
			try {
				Properties propCompte = new Properties();
				FileOutputStream outputCompte = null;
				File fileCompte = new File("compte.properties");	
				String retour="";
				retour+=client.getIdentifiant()+"=numero:" + 1 + "&intitul�:CC"+ client.getComptesList().size()+1 + "&solde:"+ 0;
				outputCompte = new FileOutputStream(fileCompte,true);
				propCompte.setProperty(client.getIdentifiant(), retour);//TODO d�couvert			
				propCompte.store(outputCompte, null);										
			} catch (IOException io) {
				io.printStackTrace();
			} finally {
				if (output != null) {
					try {
						output.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
		
		
		
		

	
	public void ajouterCompteCourant(){
		//formulaire
				Client client=new Client();
				boolean b=true;
				while(b){						// nom
					System.out.println("Votre nom : ");
					client.setNom(user_input.next());
					b=!Confirmation(client.getNom());
				}
				b=true;
				
				while(b){						// prenom
					System.out.println("Votre prenom : ");
					client.setPrenom(user_input.next());
					b=!Confirmation(client.getPrenom());
				}
				b=true;
				
				while(b){						// login
					System.out.println("Votre login : ");
					client.setIdentifiant(user_input.next());
					b=!Confirmation(client.getIdentifiant());		
				}
				b=true;
				
				String secret = client.getIdentifiant();					// MdP par d�faut
				
				System.out.println("Le MdP par d�faut est votre login, veillez � le changer");	
				
				// Verifie existence de client et charge les donn�es au besoin
				
				//String CC;//CC=m.get("compte_courant");
				//String CE;//CE=m.get("compte_epargne");
				Map<String, String> m= new HashMap<>();
				Map<String, String> me= new HashMap<>();
				File file = new File("client.properties");
				FileInputStream fileInput = null;
				try {								
					fileInput = new FileInputStream(file);
					Properties propPrint = new Properties();			
					//load a properties file from class path, inside static method
					propPrint.load(fileInput);
					if(propPrint.getProperty(client.getIdentifiant())!=null){				// Client d�ja pr�sent
						System.out.println("Client d�ja existant");
						System.out.println(propPrint.getProperty(client.getIdentifiant()));
						String[] propertyArray=propPrint.getProperty(client.getIdentifiant()).split("&");
						for(String s:propertyArray){
							String[] keyVal=s.split(":");
							m.put(keyVal[0], keyVal[1]);
						}				
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
				System.out.println("tttt");
				System.out.println(client.getIdentifiant());
				// Verifie existence de comptes et charge les donn�es au besoin
				if(m.containsKey("mdp") && m.get("mdp").equals(client.getIdentifiant())){
					System.out.println("test0");
					File fileProp = new File("compte.properties");
					FileInputStream fileInputProp = null;
					try {								
						fileInput = new FileInputStream(fileProp);
						Properties propInt = new Properties();			
						//load a properties file from class path, inside static method
						propInt.load(fileInputProp);
						if(propInt.getProperty(client.getIdentifiant())!=null){				// Client d�ja pr�sent
							
							
							String[] listeCompte=propInt.getProperty(client.getIdentifiant()).split(";");
							for(String s:listeCompte){
								String[] keyVal=s.split("&");
								me.put(keyVal[0], s);
							}				
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
				// Ajout/modification de client
				
				Properties prop = new Properties();
				FileOutputStream output = null;
				try {
					output = new FileOutputStream(file,true);
					if(!me.isEmpty()){
						System.out.println("test1");
						prop.setProperty(client.getIdentifiant(), "nom:" + client.getNom() + "&prenom:" + client.getPrenom() + "&mdp:"+ secret + "&"+m.get("compte_courant")+",CC"+m.get("compte_courant").split(",").length);//TODO define cc
					}else{
						prop.setProperty(client.getIdentifiant(), "nom:" + client.getNom() + "&prenom:" + client.getPrenom() + "&mdp:"+ secret + "&compte_courant:CC1");//TODO define cc
					}	
					prop.store(output, null);
				} catch (IOException io) {
					io.printStackTrace();
				} finally {
					if (output != null) {
						try {
							output.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
				
				// Ajout de compte courant
				
				Properties propCompte = new Properties();
				FileOutputStream outputCompte = null;
				File fileCompte = new File("compte.properties");	
				try {
					if(!me.isEmpty()){
						System.out.println("test2");
						for(String compte:me.keySet()){
							Map<String,String> t=new HashMap();
							for(String s:me.get(compte).split("&")){
								String[] keyVal=s.split(":");
								t.put(keyVal[0], keyVal[1]);
								Compte c=new CompteCourant(t.get("num�ro"), t.get("intitul�"), Double.parseDouble(t.get("solde")), Double.parseDouble(t.get("decouvert")));
								client.creerCompte(c);		
						}
						String retour="";
						for(Compte c:client.getComptesList()){
							retour+="numero:" + c.getNumero() + "&intitul�:CC"+ c.getIntitule() + "&solde:"+ c.getSolde()+"," ;
						}
						retour+="numero:" + 1 + "&intitul�:CC"+ client.getComptesList().size()+1 + "&solde:"+ 0;
						outputCompte = new FileOutputStream(fileCompte,true);
						propCompte.setProperty(client.getIdentifiant(), retour);//TODO d�couvert			
						
						}
						
					}
					else{
						outputCompte = new FileOutputStream(fileCompte,true);
						propCompte.setProperty(client.getIdentifiant(), "numero:" + 1 + "&intitul�:CC"+ 1 + "&solde:"+ 0+"&decouvert"+0);
					}
					propCompte.store(outputCompte, null);
					
				} catch (IOException io) {
					io.printStackTrace();
				} finally {
					if (output != null) {
						try {
							output.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
	}
	
	public boolean Confirmation(String s){// TODO: d�commenter et juger de l'inter�t.
		/*
		while(true){
			System.out.println("Vous avez entr� : "+s+"\n"
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
