package metier;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import com.bankonet.Client;
import com.bankonet.dao.DaoFactory;
import com.bankonet.dao.client.ClientDao;
import com.bankonet.dao.compte.CompteDao;

public class ClientServiceImpl implements ClientService {

	private ClientDao daoClient;
	private CompteDao daoCompte;
	
	public ClientServiceImpl(ClientDao daoClient, CompteDao daoCompte) {
		super();
		this.daoClient = daoClient;
		this.daoCompte = daoCompte;
	};

	public void creerClient(String nom, String prenom, String login, String password) throws IOException{
		Client client = new Client(nom, prenom, login, password);
		exist(client);
		daoClient.save(client);
		//daoCompte.
		// dao.save(client);
	}

	public boolean exist(Client c) throws IOException{
		// Verifie existence de client et charge les données au besoin
		return daoClient.exist(c);
		
		
	};

	@Override
	public void creerCompte() {

		// TODO Auto-generated method stub

	}

}
