package projet.ejb.data;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Time;
import java.util.List;


/**
 * The persistent class for the cours database table.
 * 
 */
@Entity
@Table(name="cours")
@NamedQuery(name="Cour.findAll", query="SELECT c FROM Cour c")
public class Cour implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer idcours;

	@Column(name="creneau_debut")
	private Time creneauDebut;

	@Column(name="creneau_fin")
	private Time creneauFin;

	private Integer idsalle;

	@Column(name="jour_samedi")
	private Boolean jourSamedi;

	@Column(name="nbr_eleve")
	private Integer nbrEleve;

	@Column(name="nbr_max_eleve")
	private Integer nbrMaxEleve;

	private Integer niveau;

	private Integer salle;

	//bi-directional many-to-one association to Salle
	@ManyToOne
	@JoinColumn(name="idniveau")
	private Salle salleBean;

	//bi-directional many-to-one association to Enfant
	@OneToMany(mappedBy="cour")
	private List<Enfant> enfants;

	public Cour() {
	}

	public Integer getIdcours() {
		return this.idcours;
	}

	public void setIdcours(Integer idcours) {
		this.idcours = idcours;
	}

	public Time getCreneauDebut() {
		return this.creneauDebut;
	}

	public void setCreneauDebut(Time creneauDebut) {
		this.creneauDebut = creneauDebut;
	}

	public Time getCreneauFin() {
		return this.creneauFin;
	}

	public void setCreneauFin(Time creneauFin) {
		this.creneauFin = creneauFin;
	}

	public Integer getIdsalle() {
		return this.idsalle;
	}

	public void setIdsalle(Integer idsalle) {
		this.idsalle = idsalle;
	}

	public Boolean getJourSamedi() {
		return this.jourSamedi;
	}

	public void setJourSamedi(Boolean jourSamedi) {
		this.jourSamedi = jourSamedi;
	}

	public Integer getNbrEleve() {
		return this.nbrEleve;
	}

	public void setNbrEleve(Integer nbrEleve) {
		this.nbrEleve = nbrEleve;
	}

	public Integer getNbrMaxEleve() {
		return this.nbrMaxEleve;
	}

	public void setNbrMaxEleve(Integer nbrMaxEleve) {
		this.nbrMaxEleve = nbrMaxEleve;
	}

	public Integer getNiveau() {
		return this.niveau;
	}

	public void setNiveau(Integer niveau) {
		this.niveau = niveau;
	}

	public Integer getSalle() {
		return this.salle;
	}

	public void setSalle(Integer salle) {
		this.salle = salle;
	}

	public Salle getSalleBean() {
		return this.salleBean;
	}

	public void setSalleBean(Salle salleBean) {
		this.salleBean = salleBean;
	}

	public List<Enfant> getEnfants() {
		return this.enfants;
	}

	public void setEnfants(List<Enfant> enfants) {
		this.enfants = enfants;
	}

	public Enfant addEnfant(Enfant enfant) {
		getEnfants().add(enfant);
		enfant.setCour(this);

		return enfant;
	}

	public Enfant removeEnfant(Enfant enfant) {
		getEnfants().remove(enfant);
		enfant.setCour(null);

		return enfant;
	}

}