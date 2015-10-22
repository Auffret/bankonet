package classes;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@NamedQueries({
@NamedQuery(name="client.findByLogin", query="Select c from Client c where c.identifiant=:name"),
@NamedQuery(name="client.findByFirstName", query="Select c from Client c where c.prenom=:name"),
@NamedQuery(name="client.findByLastName", query="Select c from Client c where c.nom=:name")
})
//@NamedQuery(name="client.findByLastName", query="Select c from Client c where c.nom=:name")
@Table(name="client")
public class Client {
	

	
	//private Civilite civilite;
	@Column(name = "nom", length = 30, nullable = false, unique = false)
	@ToString (uppercase = true) private String nom;
	@Column(name = "prenom", length = 30, nullable = false, unique = false)
	@ToString private String prenom;
	@Id
	@Column(name = "login", length = 15, nullable = false, unique = true)
	private String identifiant;
	@Column(name = "mdp", length = 15, nullable = false, unique = false)
	private String password;
	
	@Transient
	@OneToMany(mappedBy="client")
	private Set<Compte> comptesSet = new TreeSet<Compte>();

	public Client(String nom, String prenom, String identifiant,String password) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.identifiant = identifiant;
		this.password=password;
	}
	
	
	
	/*public Client(Civilite civilite, String nom, String prenom, String identifiant) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.identifiant = identifiant;
		this.civilite = civilite;
	}
	*/
	public Client(){
		
	}
	
	public void creerCompte(Compte compte) {
		comptesSet.add(compte);
	}
	
	public void supprimerCompte(Compte compte) {
		comptesSet.remove(compte);
	}
	
	public Compte retournerCompte(String numero) throws CompteNonTrouveException {
		for(Compte c:comptesSet){
			if(c.getNumero()==numero){
				return c;
			}
		}
		return null;
	}
	
	
	public void supprimerCompte(String numero) throws CompteNonTrouveException {
		supprimerCompte(retournerCompte(numero));
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}

	public Set<Compte> getComptesList() {
		return comptesSet;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("Client [");
		
		for(Field champ : Client.class.getDeclaredFields()) {
			ToString toStringAnn = champ.getAnnotation(ToString.class) ;
			if(toStringAnn != null) {
				sb.append(champ.getName());
				sb.append("=");
				try {
					if(toStringAnn.uppercase()) {
						sb.append(champ.get(this).toString().toUpperCase());
					} else {
						sb.append(champ.get(this));
					}
				} catch (IllegalArgumentException | IllegalAccessException e) {
					e.printStackTrace();
				}
				sb.append(",");
			}
		}
		sb.append("login="+getIdentifiant());
		sb.append("]");
		
		return sb.toString();
	}

}
