package fr.eni.projet.troc.dal;

import java.util.List;

import fr.eni.projet.troc.bo.ArticleVendu;
import fr.eni.projet.troc.bo.Retrait;
import fr.eni.projet.troc.exception.BusinessException;

public interface ArticleVenduDAO {

	public List<ArticleVendu> selectAll() throws Exception;

	public List<ArticleVendu> selectByIdCat(int catNum) throws Exception;

	public List<ArticleVendu> selectByName(String name) throws Exception;

	public void create(ArticleVendu articleVendu, Retrait retrait) throws Exception;

	public List<ArticleVendu> selectById(int id) throws Exception;

	public int selectByIdSell(int id) throws BusinessException;

	public ArticleVendu selectArticleById(int idArticle);

	public void update(ArticleVendu articleAModifier, Retrait retrait) throws BusinessException;

	public List<ArticleVendu> selectByIdUser(int id) throws Exception;

	public List<ArticleVendu> selectEnchereParticipe(int idUser) throws Exception;

	/**
	 * Permet de recupere une liste de tous les articles encore en vente aujourd'hui
	 * {@inheritDoc}
	 */
	List<ArticleVendu> selectAllArticlesStillInSell() throws Exception;

	/**
	 * Permet de recuperer une liste d'article d'un meme utilisateur {@inheritDoc}
	 */
	void deleteBynoUtilisateur(int noUtilisateur) throws BusinessException;

	/**
	 * Permet de supprimer l'articles en fonction de son noArticle {@inheritDoc}
	 */
	public void deleteByNoArticle(int noArticle) throws BusinessException;
	
	public List<ArticleVendu> selectEnchereNonCommence(int idUser) throws Exception;
}
