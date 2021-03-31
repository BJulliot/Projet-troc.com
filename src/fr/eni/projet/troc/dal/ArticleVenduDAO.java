package fr.eni.projet.troc.dal;

import java.util.List;

import fr.eni.projet.troc.bo.ArticleVendu;

public interface ArticleVenduDAO {

		public List<ArticleVendu> selectAll() throws Exception;
		
		public List<ArticleVendu> selectById(int catNum) throws Exception;
		
		public List<ArticleVendu> selectByName(String name) throws Exception;
}
