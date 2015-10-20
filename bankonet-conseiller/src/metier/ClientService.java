package metier;

import java.util.List;
import java.io.IOException;
import java.util.Map;

import com.bankonet.Client;
import com.bankonet.Compte;

public interface ClientService {
	
	public void creerCompte(String login);
	
	public boolean exist(Client c) throws IOException;
	
	public void creerClient(String nom, String prenom, String login,String password) throws IOException;
	
	public List<Compte> findAllCompte(String login);
	public Map<String,Client> findAllClient();
	//public Client getClient();
	//Set<Client> findAll();
	//void delete();
}
