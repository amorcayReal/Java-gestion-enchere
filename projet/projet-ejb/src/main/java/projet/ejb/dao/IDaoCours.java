package projet.ejb.dao;

import java.util.List;

import projet.ejb.data.Cour;


public interface IDaoCours {

	int			inserer( Cour compte );

	void 		modifier( Cour compte );

	void 		supprimer( int idCompte );

	Cour 		retrouver( int idCompte );

	List<Cour> listerTout();
}
