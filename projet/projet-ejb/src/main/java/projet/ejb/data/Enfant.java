package projet.ejb.data;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Time;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the enfant database table.
 * 
 */
@Entity
@NamedQuery(name="Enfant.findAll", query="SELECT e FROM Enfant e")
public class Enfant implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer idenfant;

	private Time creneau;

	@Temporal(TemporalType.DATE)
	@Column(name="date_naissance")
	private Date dateNaissance;

	private String detail;

	private String etablissement;

	@Column(name="jour_samedi")
	private Boolean jourSamedi;

	@Column(name="mode_paiement")
	private String modePaiement;

	private Integer niveau;

	private String nom;

	private String prenom;

	//bi-directional many-to-one association to Cour
	@ManyToOne
	@JoinColumn(name="idcours")
	private Cour cour;

	//bi-directional many-to-one association to ModePaiement
	@ManyToOne
	@JoinColumn(name="idmode_paiement")
	private ModePaiement modePaiementBean;

	//bi-directional many-to-one association to Utilisateur
	@OneToMany(mappedBy="enfant")
	private List<Utilisateur> utilisateurs;

	public Enfant() {
	}

	public Integer getIdenfant() {
		return this.idenfant;
	}

	public void setIdenfant(Integer idenfant) {
		this.idenfant = idenfant;
	}

	public Time getCreneau() {
		return this.creneau;
	}

	public void setCreneau(Time creneau) {
		this.creneau = creneau;
	}

	public Date getDateNaissance() {
		return this.dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getDetail() {
		return this.detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getEtablissement() {
		return this.etablissement;
	}

	public void setEtablissement(String etablissement) {
		this.etablissement = etablissement;
	}

	public Boolean getJourSamedi() {
		return this.jourSamedi;
	}

	public void setJourSamedi(Boolean jourSamedi) {
		this.jourSamedi = jourSamedi;
	}

	public String getModePaiement() {
		return this.modePaiement;
	}

	public void setModePaiement(String modePaiement) {
		this.modePaiement = modePaiement;
	}

	public Integer getNiveau() {
		return this.niveau;
	}

	public void setNiveau(Integer niveau) {
		this.niveau = niveau;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Cour getCour() {
		return this.cour;
	}

	public void setCour(Cour cour) {
		this.cour = cour;
	}

	public ModePaiement getModePaiementBean() {
		return this.modePaiementBean;
	}

	public void setModePaiementBean(ModePaiement modePaiementBean) {
		this.modePaiementBean = modePaiementBean;
	}

	public List<Utilisateur> getUtilisateurs() {
		return this.utilisateurs;
	}

	public void setUtilisateurs(List<Utilisateur> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}

	public Utilisateur addUtilisateur(Utilisateur utilisateur) {
		getUtilisateurs().add(utilisateur);
		utilisateur.setEnfant(this);

		return utilisateur;
	}

	public Utilisateur removeUtilisateur(Utilisateur utilisateur) {
		getUtilisateurs().remove(utilisateur);
		utilisateur.setEnfant(null);

		return utilisateur;
	}

}