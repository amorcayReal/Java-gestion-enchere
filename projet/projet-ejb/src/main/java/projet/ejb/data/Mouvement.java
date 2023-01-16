package projet.ejb.data;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the mouvement database table.
 * 
 */
@Entity
@NamedQuery(name="Mouvement.findAll", query="SELECT m FROM Mouvement m")
public class Mouvement implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer idmouvement;

	@Temporal(TemporalType.DATE)
	private Date dateh;

	private double montant;

	//bi-directional many-to-one association to Utilisateur
	@ManyToOne
	@JoinColumn(name="idutilisateur")
	private Utilisateur utilisateur;

	public Mouvement() {
	}

	public Integer getIdmouvement() {
		return this.idmouvement;
	}

	public void setIdmouvement(Integer idmouvement) {
		this.idmouvement = idmouvement;
	}

	public Date getDateh() {
		return this.dateh;
	}

	public void setDateh(Date dateh) {
		this.dateh = dateh;
	}

	public double getMontant() {
		return this.montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public Utilisateur getUtilisateur() {
		return this.utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

}