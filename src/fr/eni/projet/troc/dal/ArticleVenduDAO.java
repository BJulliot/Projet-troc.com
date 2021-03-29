package fr.eni.projet.troc.dal;

import java.util.List;

import fr.eni.projet.troc.bo.ArticleVendu;

public interface ArticleVenduDAO {

		public List<ArticleVendu> selectAll(int idUtilisateur, int idCategorie) throws Exception;
}
