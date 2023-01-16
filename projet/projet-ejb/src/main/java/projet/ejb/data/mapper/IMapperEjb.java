package projet.ejb.data.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import projet.commun.dto.DtoUtilisateur;
import projet.ejb.data.Utilisateur;

 
@Mapper( componentModel = "cdi" )
public interface IMapperEjb {  
	
	static final IMapperEjb INSTANCE = Mappers.getMapper( IMapperEjb.class );
	
	
	// Compte
	
	Utilisateur map( DtoUtilisateur source );
	
	DtoUtilisateur map( Utilisateur source );
	
}
