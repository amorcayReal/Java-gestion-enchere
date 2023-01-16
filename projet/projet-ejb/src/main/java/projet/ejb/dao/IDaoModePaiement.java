package projet.ejb.dao;

import java.util.List;

import projet.ejb.data.ModePaiement;


public interface IDaoModePaiement {

	int			inserer( ModePaiement modePaiement );

	void 		modifier( ModePaiement modePaiement );

	void 		supprimer( int idModePaiement );

	ModePaiement 		retrouver( int idModePaiement );

	List<ModePaiement> listerTout();
}
