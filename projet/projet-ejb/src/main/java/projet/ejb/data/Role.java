package projet.ejb.data;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the role database table.
 * 
 */
@Entity
@NamedQuery(name="Role.findAll", query="SELECT r FROM Role r")
public class Role implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer idrole;

	private Boolean admin;

	private Integer niveau;

	//bi-directional many-to-one association to Utilisateur
	@OneToMany(mappedBy="roleBean")
	private List<Utilisateur> utilisateurs;

	public Role() {
	}

	public Integer getIdrole() {
		return this.idrole;
	}

	public void setIdrole(Integer idrole) {
		this.idrole = idrole;
	}

	public Boolean getAdmin() {
		return this.admin;
	}

	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}

	public Integer getNiveau() {
		return this.niveau;
	}

	public void setNiveau(Integer niveau) {
		this.niveau = niveau;
	}

	public List<Utilisateur> getUtilisateurs() {
		return this.utilisateurs;
	}

	public void setUtilisateurs(List<Utilisateur> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}

	public Utilisateur addUtilisateur(Utilisateur utilisateur) {
		getUtilisateurs().add(utilisateur);
		utilisateur.setRoleBean(this);

		return utilisateur;
	}

	public Utilisateur removeUtilisateur(Utilisateur utilisateur) {
		getUtilisateurs().remove(utilisateur);
		utilisateur.setRoleBean(null);

		return utilisateur;
	}

}