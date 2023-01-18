package projet.commun.dto;

import java.io.Serializable;


@SuppressWarnings("serial")
public class DtoUtilisateur implements Serializable  {

	
	// Champs
	
	private int			id;
	
	private String		identifiant;
	
	private String		motDePasse;
	
	private String		email;
	
	private int role;
	
	
	// Constructeurs
	
	public DtoUtilisateur() {
	}

	public DtoUtilisateur(int id, String identifiant, String motDePasse, String email, int roles ) {
		this.id = id;
		this.identifiant = identifiant;
		this.motDePasse = motDePasse;
		this.email = email;
		this.role = roles;
	}
	
	
	// Getters & setters

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
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
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public int getRoles() {
		return role;
	}

	public void setRoles(int roles) {
		this.role = roles;
	}
}
