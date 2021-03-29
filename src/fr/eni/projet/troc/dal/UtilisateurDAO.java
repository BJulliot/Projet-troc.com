package fr.eni.projet.troc.dal;

import fr.eni.projet.troc.bo.Utilisateur;
import fr.eni.projet.troc.exception.BusinessException;

public interface UtilisateurDAO {
	public void create(Utilisateur utilisateur) throws BusinessException;
}
