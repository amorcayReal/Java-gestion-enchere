package projet.commun.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@SuppressWarnings("serial")
public class DtoUtilisateur implements Serializable  {

	
	// Champs
	
	private int			id;
	
	private String		identifiant;
	
	private String		motDePasse;
	
	private String		email;
	
	private List<String> role = new ArrayList<>();
	
	
	// Constructeurs
	
	public DtoUtilisateur() {
	}


	public DtoUtilisateur(int id, String identifiant, String motDePasse, String email, List<String> role) {
		super();
		this.id = id;
		this.identifiant = identifiant;
		this.motDePasse = motDePasse;
		this.email = email;
		this.role = role;
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


	public List<String> getRole() {
		return role;
	}


	public void setRole(List<String> role) {
		this.role = role;
	}

}
