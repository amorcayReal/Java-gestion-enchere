package projet.jsf.data.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import projet.commun.dto.DtoUtilisateur;
import projet.jsf.data.Utilisateur;


@Mapper( componentModel = "cdi" )
public interface IMapper {
  

	// Compte
	
	Utilisateur    map( DtoUtilisateur source );
	
	DtoUtilisateur map( Utilisateur source );
	
	Utilisateur duplicate( Utilisateur source );

	Utilisateur update( @MappingTarget Utilisateur target, Utilisateur source );

}
