package metier;

import java.util.List;

import com.bankonet.Compte;
import com.bankonet.dao.client.ClientDao;
import com.bankonet.dao.compte.CompteDao;

public abstract class CompteService implements ServiceBase{

	private CompteDao daoCompte;
	
	public CompteService(ClientDao daoClient, CompteDao daoCompte) {//TODO: remove daoClient?
		this.daoCompte = daoCompte;
	}
	
	public void creerCompte(Compte compte){};
	
	public List<Compte> findAllCompte(){
		return null;
	}
	
	public CompteDao getCompteDao(){
		return this.daoCompte;
	}
}
