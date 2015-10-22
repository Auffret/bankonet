package metier;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import com.bankonet.Client;
import com.bankonet.Compte;
import com.bankonet.dao.client.ClientDao;
import com.bankonet.dao.client.ClientException;
import com.bankonet.dao.compte.CompteDao;

public class ClientServiceImpl extends ClientService {

	
	
	public ClientServiceImpl(ClientDao daoClient, CompteDao daoCompte) {
		super(daoClient, daoCompte);
	};

	public void creerClient(String nom, String prenom, String login, String password) throws IOException{
		Client client = new Client(nom, prenom, login, password);
		exist(client);
		getClientDao().save(client);
		//daoCompte.
		// dao.save(client);
	}

	public void init(){
		
	}
	
	public ArrayList<Compte> findAllCompte(String login){
		return (ArrayList<Compte>) getCompteDao().findAll(login);
	}
	public Map<String,Client> findAllClient(){
		try {
			return getClientDao().findAll();
		} catch (ClientException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	};
	
	public boolean exist(Client c) throws IOException{
		// Verifie existence de client et charge les données au besoin
		return getClientDao().exist(c);
		
		
	};

}
