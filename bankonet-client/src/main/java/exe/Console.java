package exe;
import java.util.Scanner;


import com.bankonet.dao.DaoFactory;
import com.bankonet.dao.DaoFactoryMySQL;
import com.bankonet.dao.client.ClientException;

import metier.ClientService;
import metier.ClientServiceImpl;

//import com.bankonet.CompteCourant;

// ajouts: rollback (annuler les changements faits, avantage: ne pas avoir de client sans compte si l'ajout de compte a une erreur)
// try ()
// URL, USER, MDP

public class Console {

	Integer choix;
	//private DaoFactory daoFactory = new DaoFactoryFile();
	private DaoFactory daoFactory = new DaoFactoryMySQL();
	private ClientService client = new ClientServiceImpl(daoFactory.getClientDao(), daoFactory.getCompteDao());

	Scanner user_input = new Scanner(System.in);

	public Console() {
		menu();
	}

	/**
	 * Menu de selection.
	 */
	public void menu() {
		System.out.println("***** APPLICATION CONSEILLER BANCAIRE ******\n" + "0. Arrêter le programme\n"
				+ "1. Ouvrir un compte courant\n" + "2. Lister tous les clients\n" + "Veuillez choisir une action.");

		choix = user_input.nextInt();

		switch (choix) {
		case 0:
			// TODO Ferme toutes les éventuelles connexions à la base Mongo
			System.out.println("Arrêt de l’application");
			break;
		case 1:
			ouvrirCompteCourant();
			menu();
			break;
		case 2:
			try {
				client.findAllClient();
			} catch (ClientException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			menu();
			break;
		default:
			menu();
			break;
		}
	}

	public void ouvrirCompteCourant() {
		// formulaire
		String nom=null;
		String prenom=null;
		String login=null;
		login=null;
		boolean b = true;
		while (b) { // nom
			System.out.println("Votre nom : ");
			nom = user_input.next();
			b = !Confirmation(nom);
		}
		b = true;
		while (b) { // prenom
			System.out.println("Votre prenom : ");
			prenom = user_input.next();
			b = !Confirmation(prenom);
		}
		b = true;
		while (b) { // login
			System.out.println("Votre login : ");
			login = user_input.next();
			b = !Confirmation(login);
		}
		b = true;
		String password = login; // MdP par défaut

		System.out.println("Le MdP par défaut est votre login, veillez à le changer");

		try {
			client.creerClient(nom, prenom, login, password);
			client.creerCompte(login);

		} catch (Exception e) {
			System.out.println("Ce client existe déja");
		}

	}

	/*
	 * 
	 * public void ajouterCompteCourant(){ //formulaire Client client=new
	 * Client(); boolean b=true; while(b){ // nom System.out.println(
	 * "Votre nom : "); client.setNom(user_input.next());
	 * b=!Confirmation(client.getNom()); } b=true;
	 * 
	 * while(b){ // prenom System.out.println("Votre prenom : ");
	 * client.setPrenom(user_input.next()); b=!Confirmation(client.getPrenom());
	 * } b=true;
	 * 
	 * while(b){ // login System.out.println("Votre login : ");
	 * client.setIdentifiant(user_input.next());
	 * b=!Confirmation(client.getIdentifiant()); } b=true;
	 * 
	 * String secret = client.getIdentifiant(); // MdP par défaut
	 * 
	 * System.out.println(
	 * "Le MdP par défaut est votre login, veillez à le changer");
	 * 
	 * 
	 * System.out.println("tttt"); System.out.println(client.getIdentifiant());
	 * // Verifie existence de comptes et charge les données au besoin
	 * if(m.containsKey("mdp") && m.get("mdp").equals(client.getIdentifiant())){
	 * System.out.println("test0"); File fileProp = new
	 * File("compte.properties"); FileInputStream fileInputProp = null; try {
	 * fileInput = new FileInputStream(fileProp); Properties propInt = new
	 * Properties(); //load a properties file from class path, inside static
	 * method propInt.load(fileInputProp);
	 * if(propInt.getProperty(client.getIdentifiant())!=null){ // Client déja
	 * présent
	 * 
	 * 
	 * String[]
	 * listeCompte=propInt.getProperty(client.getIdentifiant()).split(";");
	 * for(String s:listeCompte){ String[] keyVal=s.split("&");
	 * me.put(keyVal[0], s); } } } catch (IOException ex) {
	 * ex.printStackTrace(); } finally { if (fileInput != null) { try {
	 * fileInput.close(); } catch (IOException e) { e.printStackTrace(); } } } }
	 * 
	 */
	
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

/*
 * 
 * //lister client
 * 
 * Enumeration<Object> enuKeys = propPrint.keys(); while
 * (enuKeys.hasMoreElements()) {
 * 
 * String retour=""; String key = (String) enuKeys.nextElement(); retour+=key +
 * ": "; String[] propertyArray=propPrint.getProperty(key).split("&");
 * Map<String, String> m = new HashMap<>(); for(String s:propertyArray){
 * String[] keyVal=s.split(":"); m.put(keyVal[0], keyVal[1]); } retour +=
 * " login:"+key+" prenom:"+m.get("prenom")+" nom:"+m.get("nom");
 * if(m.containsKey("compte_courant")){ retour +=" nbCC:"
 * +m.get("compte_courant").split(",").length; }
 * if(m.containsKey("compte_epargne")){ retour +=" nbCE:"
 * +m.get("compte_epargne").split(",").length; } System.out.println(retour); }
 * 
 */