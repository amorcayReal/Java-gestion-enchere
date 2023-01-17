package projet.ejb.service.standard;

import static javax.ejb.TransactionAttributeType.NOT_SUPPORTED;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.inject.Inject;

import projet.commun.dto.DtoUtilisateur;
import projet.commun.exception.ExceptionValidation;
import projet.commun.service.IServiceUtilisateur;
import projet.ejb.dao.IDaoUtilisateur;
import projet.ejb.data.Utilisateur;
import projet.ejb.data.mapper.IMapperEjb;

@Stateless
@Remote
public class ServiceUtilisateur implements IServiceUtilisateur {

	// Champs
	@Inject
	private IMapperEjb mapper;
	@Inject
	private IDaoUtilisateur daoUtilisateur;

	// Actions

	@Override
	public int inserer(DtoUtilisateur dtoUtilisateur) throws ExceptionValidation {
		verifierValiditeDonnees(dtoUtilisateur);
		int id = daoUtilisateur.inserer(mapper.map(dtoUtilisateur));
		return id;
	}

	@Override
	public void modifier(DtoUtilisateur dtoUtilisateur) throws ExceptionValidation {
		verifierValiditeDonnees(dtoUtilisateur);
		daoUtilisateur.modifier(mapper.map(dtoUtilisateur));
	}

	@Override
	public void supprimer(int idUtilisateur) throws ExceptionValidation {
		daoUtilisateur.supprimer(idUtilisateur);
	}

	@Override
	@TransactionAttribute(NOT_SUPPORTED)
	public DtoUtilisateur retrouver(int idUtilisateur) {
		return mapper.map(daoUtilisateur.retrouver(idUtilisateur));
	}

	@Override
	@TransactionAttribute(NOT_SUPPORTED)
	public List<DtoUtilisateur> listerTout() {
		List<DtoUtilisateur> liste = new ArrayList<>();
		for (Utilisateur utilisateur : daoUtilisateur.listerTout()) {
			liste.add(mapper.map(utilisateur));
		}
		return liste;
	}

	// Méthodes auxiliaires

	private void verifierValiditeDonnees(DtoUtilisateur dtoUtilisateur) throws ExceptionValidation {

		StringBuilder message = new StringBuilder();

		if (dtoUtilisateur.getIdentifiant() == null || dtoUtilisateur.getIdentifiant().isEmpty()) {
			message.append("\nLe pseudo est absent.");
		} else if (dtoUtilisateur.getIdentifiant().length() < 3) {
			message.append("\nLe pseudo est trop court.");
		} else if (dtoUtilisateur.getIdentifiant().length() > 25) {
			message.append("\nLe pseudo est trop long.");
		} else if (!daoUtilisateur.verifierUnicitePseudo(dtoUtilisateur.getIdentifiant(), dtoUtilisateur.getId())) {
			message.append("\nLe pseudo " + dtoUtilisateur.getIdentifiant() + " est déjà utilisé.");
		}

		if (dtoUtilisateur.getMotDePasse() == null || dtoUtilisateur.getMotDePasse().isEmpty()) {
			message.append("\nLe mot de passe est absent.");
		} else if (dtoUtilisateur.getMotDePasse().length() < 3) {
			message.append("\nLe mot de passe est trop court.");
		} else if (dtoUtilisateur.getMotDePasse().length() > 25) {
			message.append("\nLe mot de passe est trop long.");
		}

		if (dtoUtilisateur.getEmail() == null || dtoUtilisateur.getEmail().isEmpty()) {
			message.append("\nL'adresse e-mail est absente.");
		}

		if (message.length() > 0) {
			throw new ExceptionValidation(message.toString().substring(1));
		}
	}

}
