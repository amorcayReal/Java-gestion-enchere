package projet.ejb.dao.jpa;

import static javax.ejb.TransactionAttributeType.MANDATORY;
import static javax.ejb.TransactionAttributeType.NOT_SUPPORTED;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import projet.ejb.dao.IDaoRole;
import projet.ejb.data.Role;


@Stateless
@Local
@TransactionAttribute( MANDATORY )
public class DaoRole implements IDaoRole {

	
	// Champs
	
	@PersistenceContext
	private EntityManager	em;
	
	
	// Actions
	
	@Override
	public int inserer(Role role) {
		em.persist(role);
		em.flush();
		return role.getIdutilisateur();
	}

	@Override
	public void modifier(Role role) {
		em.merge( role );
	}

	@Override
	public void supprimer(int Idutilisateur) {
		em.remove( retrouver(Idutilisateur) );
	}

	@Override
	@TransactionAttribute( NOT_SUPPORTED )
	public Role retrouver(int Idutilisateur) {
		return em.find( Role.class, Idutilisateur );
	}

	@Override
	@TransactionAttribute( NOT_SUPPORTED )
	public List<Role> listerTout() {
		em.clear();
		var jpql = "SELECT c FROM Role c ORDER BY c.niveau";
		var query = em.createQuery( jpql, Role.class );
		return query.getResultList();
	}
}
