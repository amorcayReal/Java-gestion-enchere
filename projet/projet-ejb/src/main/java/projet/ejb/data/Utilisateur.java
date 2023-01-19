package projet.ejb.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import static javax.persistence.FetchType.EAGER;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;


/**
 * The persistent class for the utilisateur database table.
 * 
 */
@Entity
@NamedQuery(name="Utilisateur.findAll", query="SELECT u FROM Utilisateur u")
public class Utilisateur implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer idutilisateur;

	private String email;

	private String identifiant;

	private String motdepasse;

	private String nom;

	private double paiement;

	private String prenom;
	
	@ElementCollection( fetch = EAGER )
	@CollectionTable( name = "role", joinColumns = @JoinColumn( name = "idutilisateur" ) )
	@Column( name = "role")
	private List<String> role = new ArrayList<>();	
	
	//bi-directional many-to-one association to Mouvement
	@OneToMany(mappedBy="utilisateur")
	private List<Mouvement> mouvements;

	//bi-directional many-to-one association to Enfant
	@ManyToOne
	@JoinColumn(name="idenfant")
	private Enfant enfant;
	
	public Utilisateur() {
	}

	public Utilisateur(Integer idutilisateur, String email, String identifiant, String motdepasse, String nom,
			double paiement, String prenom, List<String> roles, List<Mouvement> mouvements, Enfant enfant) {
		super();
		this.idutilisateur = idutilisateur;
		this.email = email;
		this.identifiant = identifiant;
		this.motdepasse = motdepasse;
		this.nom = nom;
		this.paiement = paiement;
		this.prenom = prenom;
		this.role = roles;
		this.mouvements = mouvements;
		this.enfant = enfant;
	}

	public Integer getIdutilisateur() {
		return idutilisateur;
	}

	public void setIdutilisateur(Integer idutilisateur) {
		this.idutilisateur = idutilisateur;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}

	public String getMotdepasse() {
		return motdepasse;
	}

	public void setMotdepasse(String motdepasse) {
		this.motdepasse = motdepasse;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public double getPaiement() {
		return paiement;
	}

	public void setPaiement(double paiement) {
		this.paiement = paiement;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public List<String> getRoles() {
		return role;
	}

	public void setRoles(List<String> roles) {
		this.role = roles;
	}

	public List<Mouvement> getMouvements() {
		return mouvements;
	}

	public void setMouvements(List<Mouvement> mouvements) {
		this.mouvements = mouvements;
	}

	public Enfant getEnfant() {
		return enfant;
	}

	public void setEnfant(Enfant enfant) {
		this.enfant = enfant;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


}