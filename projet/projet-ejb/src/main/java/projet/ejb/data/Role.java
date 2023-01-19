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
	private Integer idutilisateur;

	@Column(name = "role")
	private String role;


	public Role() {
	}


	public Integer getIdutilisateur() {
		return idutilisateur;
	}


	public void setIdutilisateur(Integer idutilisateur) {
		this.idutilisateur = idutilisateur;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


}