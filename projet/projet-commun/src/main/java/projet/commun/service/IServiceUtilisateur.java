package projet.commun.service;

import java.util.List;

import projet.commun.dto.DtoUtilisateur;
import projet.commun.exception.ExceptionValidation;


public interface IServiceUtilisateur {
	
	int				inserer( DtoUtilisateur dtoUtilisateur ) throws ExceptionValidation;

	void			modifier( DtoUtilisateur dtoUtilisateur ) throws ExceptionValidation; 

	void			supprimer( int idDtoUtilisateur ) throws ExceptionValidation;

	DtoUtilisateur 		retrouver( int isDtoUtilisateur ) ;

	List<DtoUtilisateur>	listerTout() ;

}
