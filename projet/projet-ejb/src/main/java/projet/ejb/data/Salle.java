package projet.ejb.data;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the salle database table.
 * 
 */
@Entity
@NamedQuery(name="Salle.findAll", query="SELECT s FROM Salle s")
public class Salle implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer idniveau;

	private String detail;

	private Integer niveau;

	//bi-directional many-to-one association to Cour
	@OneToMany(mappedBy="salleBean")
	private List<Cour> cours;

	public Salle() {
	}

	public Integer getIdniveau() {
		return this.idniveau;
	}

	public void setIdniveau(Integer idniveau) {
		this.idniveau = idniveau;
	}

	public String getDetail() {
		return this.detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public Integer getNiveau() {
		return this.niveau;
	}

	public void setNiveau(Integer niveau) {
		this.niveau = niveau;
	}

	public List<Cour> getCours() {
		return this.cours;
	}

	public void setCours(List<Cour> cours) {
		this.cours = cours;
	}

	public Cour addCour(Cour cour) {
		getCours().add(cour);
		cour.setSalleBean(this);

		return cour;
	}

	public Cour removeCour(Cour cour) {
		getCours().remove(cour);
		cour.setSalleBean(null);

		return cour;
	}

}