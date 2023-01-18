package projet.jsf.model.standard;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import projet.commun.dto.DtoUtilisateur;
import projet.commun.service.IServiceConnexion;
import projet.jsf.data.Utilisateur;
import projet.jsf.util.CompteActif;
import projet.jsf.util.UtilJsf;


@RequestScoped
@Named
public class ModelConnexion {

	// Champs

	private Utilisateur			courant;

	@Inject
	private CompteActif		utilisateurActif;
	@Inject
	private ModelInfo		modelInfo;
	@EJB
	private IServiceConnexion serviceConnexion;


	// Getters 
	
	public Utilisateur getCourant() {
		if ( courant == null ) {
			courant = new Utilisateur();
		}
		return courant;
	}

	
	// Actions
	
	public String connect() {
	    
	    DtoUtilisateur dto = serviceConnexion.sessionUtilisateurOuvrir( courant.getIdentifiant(), courant.getMotDePasse() );
	    
	    if ( dto != null ){
	    	
//		    try {
//			    ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
//				( (HttpServletRequest) ec.getRequest() ).login( courant.getPseudo(), courant.getMotDePasse() );
//			} catch (ServletException e) {
//				throw new RuntimeException( e );
//			}

	    	utilisateurActif.setIdentifiant(dto.getIdentifiant());
	    	utilisateurActif.setRole(dto.getRoles());
	        
	    	modelInfo.setTitre( "Bienvenue" );
	    	modelInfo.setTexte( "Vous êtes connecté en tant que '" + courant.getIdentifiant() +"'.");
		    return "info";

	    } else {
	        UtilJsf.messageError( "Pseudo ou mot de passe invalide." );
	    	return null;
	    }
	}	
}
