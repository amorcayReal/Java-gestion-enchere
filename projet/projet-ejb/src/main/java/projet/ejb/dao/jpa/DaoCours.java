package projet.ejb.dao.jpa;

import static javax.ejb.TransactionAttributeType.MANDATORY;
import static javax.ejb.TransactionAttributeType.NOT_SUPPORTED;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import projet.ejb.dao.IDaoCours;
import projet.ejb.data.Cour;


@Stateless
@Local
@TransactionAttribute( MANDATORY )
public class DaoCours implements IDaoCours {
	
	// Champs
	
	@PersistenceContext
	private EntityManager	em;
	
	
	// Actions
	
	@Override
	public int inserer(Cour cours) {
		em.persist(cours);
		em.flush();
		return cours.getIdcours();
	}

	@Override
	public void modifier(Cour cours) {
		em.merge( cours );
	}

	@Override
	public void supprimer(int idCours) {
		em.remove( retrouver(idCours) );
	}

	@Override
	@TransactionAttribute( NOT_SUPPORTED )
	public Cour retrouver(int idCours) {
		return em.find( Cour.class, idCours );
	}

	@Override
	@TransactionAttribute( NOT_SUPPORTED )
	public List<Cour> listerTout() {
		em.clear();
		var jpql = "SELECT c FROM cours c ORDER BY c.niveau";
		var query = em.createQuery( jpql, Cour.class );
		return query.getResultList();
	}
}
