package projet.ejb.data;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the mode_paiement database table.
 * 
 */
@Entity
@Table(name="mode_paiement")
@NamedQuery(name="ModePaiement.findAll", query="SELECT m FROM ModePaiement m")
public class ModePaiement implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="idmode_paiement")
	private Integer idmodePaiement;

	@Column(name="mode_paiement")
	private String modePaiement;

	//bi-directional many-to-one association to Enfant
	@OneToMany(mappedBy="modePaiementBean")
	private List<Enfant> enfants;

	public ModePaiement() {
	}

	public Integer getIdmodePaiement() {
		return this.idmodePaiement;
	}

	public void setIdmodePaiement(Integer idmodePaiement) {
		this.idmodePaiement = idmodePaiement;
	}

	public String getModePaiement() {
		return this.modePaiement;
	}

	public void setModePaiement(String modePaiement) {
		this.modePaiement = modePaiement;
	}

	public List<Enfant> getEnfants() {
		return this.enfants;
	}

	public void setEnfants(List<Enfant> enfants) {
		this.enfants = enfants;
	}

	public Enfant addEnfant(Enfant enfant) {
		getEnfants().add(enfant);
		enfant.setModePaiementBean(this);

		return enfant;
	}

	public Enfant removeEnfant(Enfant enfant) {
		getEnfants().remove(enfant);
		enfant.setModePaiementBean(null);

		return enfant;
	}

}