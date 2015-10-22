package metier;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.bankonet.dao.client.ClientDao;
import com.bankonet.dao.client.ClientException;
import com.bankonet.dao.compte.CompteDao;

import classes.Client;
import classes.Compte;

public class InitService extends ClientService{
	
	public InitService(ClientDao daoClient, CompteDao daoCompte) {
		super(daoClient, daoCompte);

	};

	public void init(){//throws CLientException
		System.out.println("I try");
		try {
			creerClient("nom1", "prenom1", "log1", "pass1");
			creerClient("nom2", "prenom2", "log2", "pass2");
			creerClient("nom3", "prenom3", "log3", "pass3");
			creerClient("nom4", "prenom4", "log3", "pass3");// existe deja
			creerClient("nom4", "prenom4", "log4", "pass4");
			creerClient("nom5", "prenom5", "log5", "pass5");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	
	@Override
	public void creerCompte(String login) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean exist(Client c) throws IOException {
		return getClientDao().exist(c);
		// TODO Auto-generated method stub
	}

	@Override
	public void creerClient(String nom, String prenom, String login, String password) throws IOException {
		Client c=new Client(nom,prenom,login,password);
		if(!exist(c)){
			getClientDao().save(c);
		}
	}

	@Override
	public List<Compte> findAllCompte(String login) {
		
		return null;
	}

	@Override
	public Map<String, Client> findAllClient() throws ClientException {
		return getClientDao().findAll();
	}

	
}
