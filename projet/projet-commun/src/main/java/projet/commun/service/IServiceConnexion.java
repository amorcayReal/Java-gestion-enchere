package projet.commun.service;

import projet.commun.dto.DtoUtilisateur;

public interface IServiceConnexion {

	DtoUtilisateur	sessionUtilisateurOuvrir( String identifiant, String motDePasse );

	void		sessionUtilisateurFermer();

}
