package metier;

import java.util.List;
import java.io.IOException;
import java.util.Map;

import com.bankonet.Client;
import com.bankonet.Compte;
import com.bankonet.dao.client.ClientDao;
import com.bankonet.dao.client.ClientException;
import com.bankonet.dao.compte.CompteDao;

public abstract class ClientService {
	
	private ClientDao daoClient;
	private CompteDao daoCompte;
	
	public ClientService(ClientDao daoClient, CompteDao daoCompte) {
		this.daoClient = daoClient;
		this.daoCompte = daoCompte;
	};
	
	public void init(){};
	
	public void creerCompte(String login){};
	
	public boolean exist(Client c) throws IOException{
		return false;};
	
	public void creerClient(String nom, String prenom, String login,String password) throws IOException{};
	
	public List<Compte> findAllCompte(String login){
		return null;
		}
	public Map<String,Client> findAllClient() throws ClientException{
		return null;
		}
	
	public ClientDao getClientDao(){
		return this.daoClient;
	}
	
	public CompteDao getCompteDao(){
		return this.daoCompte;
	}
	
	//public Client getClient();
	//Set<Client> findAll();
	//void delete();
}
