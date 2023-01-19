package projet.ejb.dao.jpa;

import static javax.ejb.TransactionAttributeType.MANDATORY;
import static javax.ejb.TransactionAttributeType.NOT_SUPPORTED;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import projet.ejb.dao.IDaoUtilisateur;
import projet.ejb.data.Utilisateur;

@Stateless
@Local
@TransactionAttribute( MANDATORY )
public class DaoUtilisateur implements IDaoUtilisateur {

	
	// Champs
	
	@PersistenceContext
	private EntityManager	em;
	
	
	// Actions
	
	@Override
	public int inserer(Utilisateur utilisateur) {
		em.persist(utilisateur);
		em.flush();
		return utilisateur.getIdutilisateur();
	}

	@Override
	public void modifier(Utilisateur utilisateur) {
		em.merge( utilisateur );
	}

	@Override
	public void supprimer(int idUtilisateur) {
		em.remove( retrouver(idUtilisateur) );
	}

	@Override
	@TransactionAttribute( NOT_SUPPORTED )
	public Utilisateur retrouver(int idUtilisateur) {
		return em.find( Utilisateur.class, idUtilisateur );
	}

	@Override
	@TransactionAttribute( NOT_SUPPORTED )
	public List<Utilisateur> listerTout() {
		em.clear();
		var jpql = "SELECT c FROM Utilisateur c ORDER BY c.identifiant";
		var query = em.createQuery( jpql, Utilisateur.class );
		return query.getResultList();
	}


	@Override
	@TransactionAttribute( NOT_SUPPORTED )
	public Utilisateur validerAuthentification( String identifiant, String motDePasse )  {
	    var jpql = "SELECT c FROM Utilisateur c WHERE c.identifiant=:identifiant AND c.motdepasse = :motDePasse ";
	    var query = em.createQuery( jpql, Utilisateur.class );
	    query.setParameter( "identifiant", identifiant );
	    query.setParameter( "motDePasse", motDePasse );
	    try {
	        return query.getSingleResult();
	    } catch ( NoResultException e ) {
	        return null;
	    }
	}


	@Override
	@TransactionAttribute( NOT_SUPPORTED )
	public boolean verifierUnicitePseudo( String pseudo, int idCompte )  {
	    var jpql = "SELECT COUNT(c) FROM Utilisateur c WHERE c.identifiant=:pseudo AND c.id <> :idCompte ";
	    var query = em.createQuery( jpql, Long.class );
	    query.setParameter( "pseudo", pseudo );
	    query.setParameter( "idCompte", idCompte );
        return query.getSingleResult() == 0;
	}
	
}
