package classes;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

public abstract class Compte implements CompteStat {
	
	@Id
	@Column(name = "numero", length = 5, nullable = false, unique = true)
	private String numero;
	@Column(name = "intitule", length = 30, nullable = false, unique = false)
	private String intitule;
	@Column(name = "solde", length = 30, nullable = false, unique = false)
	private double solde;
	@ManyToOne
	@JoinColumn(name="login")//TODO: doute
	@Column(name = "login", length = 15, nullable = false, unique = false)
	private String login;
	
	public Compte(String numero, String intitule, double solde,String login) {
		super();
		this.numero = numero;
		this.intitule = intitule;
		if(solde >= 0.0) {
			this.solde = solde;
		} else {
			System.out.println("Impossible de creer un compte avec un solde negatif");
		}
		this.login=login;
	}
	
	public Compte(){
		
	};
	
	abstract protected double calculerDebitMaximum();
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getIntitule() {
		return intitule;
	}
	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}
	public double getSolde() {
		return solde;
	}
	public void setSolde(double solde) {
		this.solde = solde;
	}
	
	
	public void crediter(double montant) throws CompteException {
		solde = solde + montant;
	}
	
	public void debiter(double montant) throws CompteException {
		double debitMax = calculerDebitMaximum();
		if(montant <= debitMax) {
			solde = solde - montant;
		} else {
			throw new DebitException("Debit maximum atteint : " + debitMax);
		}
	}
	
	public void effectuerVirement(Compte compte, double montant) throws CompteException {
		this.debiter(montant);
		compte.crediter(montant);
	}
	
	@Override
	public String toString() {
		return String.format("CompteCourant [numero=%s, intitule=%s, solde=%s]", numero,
				intitule, solde);
	}

}
