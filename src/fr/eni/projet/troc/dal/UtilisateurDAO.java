package fr.eni.projet.troc.dal;

import java.util.List;

import fr.eni.projet.troc.bo.Utilisateur;
import fr.eni.projet.troc.exception.BusinessException;

public interface UtilisateurDAO {
	public void create(Utilisateur utilisateur) throws BusinessException;

	public Utilisateur find(String pseudo, String motDePasse) throws BusinessException;

	public String getPasswordBynoUtilisateur(int noUtilisateur) throws BusinessException;

	public void update(int noUtilisateur, String pseudo, String nom, String prenom, String email, String telephone,
			String rue, String codePostal, String ville, String nouveauMotDePasse) throws BusinessException;

	public void delete(int noUtilisateur) throws BusinessException;

	public boolean isPseudoUnique(String pseudo) throws BusinessException;

	public Utilisateur selectByPseudo(String pseudo) throws BusinessException;

	public Utilisateur selectEnchereByPseudo(int idArticle) throws Exception;

	public List<Utilisateur> selectAll() throws BusinessException;

	public boolean validerEmailEnBDD(String email) throws BusinessException;

}
