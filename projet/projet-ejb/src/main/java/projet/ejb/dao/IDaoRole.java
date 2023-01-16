package projet.ejb.dao;

import java.util.List;

import projet.ejb.data.Role;


public interface IDaoRole {

	int			inserer( Role role );

	void 		modifier( Role role );

	void 		supprimer( int idRole );

	Role 		retrouver( int idRole );

	List<Role> listerTout();
}
