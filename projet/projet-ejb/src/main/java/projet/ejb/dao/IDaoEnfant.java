package projet.ejb.dao;

import java.util.List;

import projet.ejb.data.Enfant;


public interface IDaoEnfant {

	int			inserer( Enfant enfant );

	void 		modifier( Enfant enfant );

	void 		supprimer( int idenfant );

	Enfant 		retrouver( int idenfant );

	List<Enfant> listerTout();
}
