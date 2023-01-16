package projet.ejb.dao.jpa;

import static javax.ejb.TransactionAttributeType.MANDATORY;
import static javax.ejb.TransactionAttributeType.NOT_SUPPORTED;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import projet.ejb.dao.IDaoModePaiement;
import projet.ejb.data.ModePaiement;


@Stateless
@Local
@TransactionAttribute( MANDATORY )
public class DaoModePaiement implements IDaoModePaiement {

	
	// Champs
	
	@PersistenceContext
	private EntityManager	em;
	
	
	// Actions
	
	@Override
	public int inserer(ModePaiement modePaiement) {
		em.persist(modePaiement);
		em.flush();
		return modePaiement.getIdmodePaiement();
	}

	@Override
	public void modifier(ModePaiement modePaiement) {
		em.merge( modePaiement );
	}

	@Override
	public void supprimer(int idmodePaiement) {
		em.remove( retrouver(idmodePaiement) );
	}

	@Override
	@TransactionAttribute( NOT_SUPPORTED )
	public ModePaiement retrouver(int idmodePaiement) {
		return em.find( ModePaiement.class, idmodePaiement );
	}

	@Override
	@TransactionAttribute( NOT_SUPPORTED )
	public List<ModePaiement> listerTout() {
		em.clear();
		var jpql = "SELECT c FROM mode_paiement c ORDER BY c.mode_paiement";
		var query = em.createQuery( jpql, ModePaiement.class );
		return query.getResultList();
	}
}
