package projet.commun.service;

import projet.commun.dto.DtoUtilisateur;

public interface IServiceConnexion {

	DtoUtilisateur	sessionUtilisateurOuvrir( String pseudo, String motDePasse );

	void		sessionUtilisateurFermer();

}
