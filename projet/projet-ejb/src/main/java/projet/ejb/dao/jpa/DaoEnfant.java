package projet.ejb.dao.jpa;

import static javax.ejb.TransactionAttributeType.MANDATORY;
import static javax.ejb.TransactionAttributeType.NOT_SUPPORTED;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import projet.ejb.dao.IDaoEnfant;
import projet.ejb.data.Enfant;


@Stateless
@Local
@TransactionAttribute( MANDATORY )
public class DaoEnfant implements IDaoEnfant {

	
	// Champs
	
	@PersistenceContext
	private EntityManager	em;
	
	
	// Actions
	
	@Override
	public int inserer(Enfant enfant) {
		em.persist(enfant);
		em.flush();
		return enfant.getIdenfant();
	}

	@Override
	public void modifier(Enfant enfant) {
		em.merge( enfant );
	}

	@Override
	public void supprimer(int idenfant) {
		em.remove( retrouver(idenfant) );
	}

	@Override
	@TransactionAttribute( NOT_SUPPORTED )
	public Enfant retrouver(int idenfant) {
		return em.find( Enfant.class, idenfant );
	}

	@Override
	@TransactionAttribute( NOT_SUPPORTED )
	public List<Enfant> listerTout() {
		em.clear();
		var jpql = "SELECT c FROM enfant c ORDER BY c.niveau";
		var query = em.createQuery( jpql, Enfant.class );
		return query.getResultList();
	}
}
