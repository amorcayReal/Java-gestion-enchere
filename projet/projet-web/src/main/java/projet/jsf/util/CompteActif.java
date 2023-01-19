package projet.jsf.util;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import static projet.commun.dto.Roles.ADMINISTRATEUR;
import static projet.commun.dto.Roles.UTILISATEUR;
import projet.jsf.data.Utilisateur;

@SuppressWarnings("serial")
@SessionScoped
@Named
public class CompteActif extends Utilisateur {
	
	public boolean isLoggedIn() {
		return getIdentifiant() != null;
	}	
	
	public boolean isUtilisateur() {
		return isLoggedIn() && isInRole ( UTILISATEUR );
	}
	
	public boolean isAdmininstrateur() {
		return isLoggedIn() && isInRole( ADMINISTRATEUR );
	}

	public String disconnect() {
	    UtilJsf.sessionInvalidate();
        UtilJsf.messageInfo( "Vous avez été déconnecté" );
	    return "connexion";
	}

}
