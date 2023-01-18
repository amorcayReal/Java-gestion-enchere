package projet.ejb.data;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


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

	//bi-directional many-to-one association to Mouvement
	@OneToMany(mappedBy="utilisateur")
	private List<Mouvement> mouvements;

	//bi-directional many-to-one association to Enfant
	@ManyToOne
	@JoinColumn(name="idenfant")
	private Enfant enfant;

	//bi-directional many-to-one association to Enfant
	@ManyToOne
	@JoinColumn(name="idrole")
	private Role role;

	
	public Utilisateur() {
	}

	public Integer getIdutilisateur() {
		return this.idutilisateur;
	}

	public void setIdutilisateur(Integer idutilisateur) {
		this.idutilisateur = idutilisateur;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIdentifiant() {
		return this.identifiant;
	}

	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}

	public String getMotdepasse() {
		return this.motdepasse;
	}

	public void setMotdepasse(String motdepasse) {
		this.motdepasse = motdepasse;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public double getPaiement() {
		return this.paiement;
	}

	public void setPaiement(double paiement) {
		this.paiement = paiement;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public List<Mouvement> getMouvements() {
		return this.mouvements;
	}

	public void setMouvements(List<Mouvement> mouvements) {
		this.mouvements = mouvements;
	}

	public Mouvement addMouvement(Mouvement mouvement) {
		getMouvements().add(mouvement);
		mouvement.setUtilisateur(this);

		return mouvement;
	}

	public Mouvement removeMouvement(Mouvement mouvement) {
		getMouvements().remove(mouvement);
		mouvement.setUtilisateur(null);

		return mouvement;
	}

	public Enfant getEnfant() {
		return this.enfant;
	}

	public void setEnfant(Enfant enfant) {
		this.enfant = enfant;
	}

}