package projet.ejb.dao;

import java.util.List;

import projet.ejb.data.Salle;


public interface IDaoSalle {

	int			inserer( Salle salle );

	void 		modifier( Salle salle );

	void 		supprimer( int idSalle );

	Salle 		retrouver( int idSalle );

	List<Salle> listerTout();
}
