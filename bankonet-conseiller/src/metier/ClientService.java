package metier;

import java.io.IOException;

import com.bankonet.Client;
import com.bankonet.dao.DaoFactory;
import com.bankonet.dao.client.ClientDao;

public interface ClientService {
	
	public void creerCompte();
	
	public boolean exist(Client c) throws IOException;
	
	public void creerClient(String nom, String prenom, String login,String password) throws IOException;
	//Set<Client> findAll();
	//void delete();
}
