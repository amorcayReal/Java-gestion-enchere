package projet.jsf.util;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import projet.jsf.data.Utilisateur;

@SuppressWarnings("serial")
@SessionScoped
@Named
public class CompteActif extends Utilisateur {
	
	public boolean isLoggedIn() {
		System.out.println(isRole());
		return getIdentifiant() != null;
	}	
	
	public boolean isUtilisateur() {
		return isLoggedIn() && !isRole();
	}
	
	public boolean isAdmininstrateur() {
		return isLoggedIn() && isRole();
	}

	public String disconnect() {
	    UtilJsf.sessionInvalidate();
        UtilJsf.messageInfo( "Vous avez été déconnecté" );
	    return "connexion";
	}

}
