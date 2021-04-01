package fr.eni.projet.troc.dal;

import java.util.List;

import fr.eni.projet.troc.bo.ArticleVendu;
import fr.eni.projet.troc.bo.Retrait;
import fr.eni.projet.troc.bo.Utilisateur;
import fr.eni.projet.troc.exception.BusinessException;

public interface ArticleVenduDAO {

		public List<ArticleVendu> selectAll() throws Exception;
		
		public List<ArticleVendu> selectById(int catNum) throws Exception;
		
		public List<ArticleVendu> selectByName(String name) throws Exception;

		public void create(ArticleVendu articleVendu,Retrait retrait) throws Exception;

}
