package projet.jsf.data;

import java.io.Serializable;
import java.util.Objects;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@SuppressWarnings("serial")
public class Utilisateur implements Serializable  {

	
	// Champs
		
	private int idRole;	
	
	private float paiement;
	
	@NotBlank( message = "L'adresse e-mail doit être renseigné")
	@Size(max=100, message = "Valeur trop longue pour l'adresse e-mail : 100 car. maxi" )
	@Email( message = "Adresse e-mail invalide" )
	private String email;
	
	@NotBlank( message = "Le prenom doit être renseigné")
	@Size(max=25, message = "Valeur trop longue pour le nom : 25 car. maxi" )
	private String prenom;
	
	@NotBlank( message = "Le nom doit être renseigné")
	@Size(max=25, message = "Valeur trop longue pour le nom : 25 car. maxi" )
	private String nom;

	@NotBlank( message = "Le identifiant doit être renseigné")
	@Size(max=25, message = "Valeur trop longue pour le identifiant : 25 car. maxi" )
	private String		identifiant;

	@NotBlank( message = "Le mot de passe doit être renseigné")
	@Size(max=25, message = "Valeur trop longue pour le mot de passe : 25 car. maxi" )
	private String		motDePasse;
	

	
	// Constructeurs
	
	public Utilisateur() {
	}


	public Utilisateur(float paiement, String email, String prenom, String nom, String identifiant,
			String motDePasse, int role) {
		super();
		this.paiement = paiement;
		this.email = email;
		this.prenom = prenom;
		this.nom = nom;
		this.identifiant = identifiant;
		this.motDePasse = motDePasse;
		this.idRole = role;
	}

	public float getPaiement() {
		return paiement;
	}


	public void setPaiement(float paiement) {
		this.paiement = paiement;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getIdentifiant() {
		return identifiant;
	}


	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}


	public String getMotDePasse() {
		return motDePasse;
	}


	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}


	public int getRole() {
		return idRole;
	}


	public void setRole(int role) {
		this.idRole = role;
	}


	@Override
	public int hashCode() {
		return Objects.hash(email, identifiant, motDePasse, nom, paiement, prenom, idRole);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Utilisateur other = (Utilisateur) obj;
		return Objects.equals(email, other.email) && Objects.equals(identifiant, other.identifiant)
				&& Objects.equals(motDePasse, other.motDePasse)
				&& Objects.equals(nom, other.nom)
				&& Float.floatToIntBits(paiement) == Float.floatToIntBits(other.paiement)
				&& Objects.equals(prenom, other.prenom);
	}
	

}
