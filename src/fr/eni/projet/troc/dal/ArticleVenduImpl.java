/**
 * 
 */
package fr.eni.projet.troc.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.projet.troc.bo.ArticleVendu;
import fr.eni.projet.troc.bo.Categorie;
import fr.eni.projet.troc.bo.Utilisateur;

/**
 * Classe en charge
 * 
 * @author Bastien
 * @version Troc.com - v1.0
 * @date 29 mars 2021 - 14:12:34
 */
public class ArticleVenduImpl implements ArticleVenduDAO {

	public static ArticleVendu itemBuilder(ResultSet rs) throws SQLException {
		ArticleVendu articleVendu = new ArticleVendu();
		articleVendu.setNoArticle(rs.getInt("no_article"));
		articleVendu.setNom(rs.getString("nom_article"));
		articleVendu.setDescription(rs.getString("description"));
		articleVendu.setDateDebutEnchere(rs.getDate("date_debut_encheres").toLocalDate());
		articleVendu.setDateFinEnchere(rs.getDate("date_fin_encheres").toLocalDate());
		articleVendu.setPrixInitial(rs.getInt("prix_initial"));
		articleVendu.setPrixVente(rs.getInt("prix_vente"));
		articleVendu.setNoUtilisateur((Utilisateur) rs.getObject("no_utilisateur"));
		articleVendu.setNoCategorie((Categorie) rs.getObject("no_categorie"));
		return articleVendu;
	}

	@Override
	public List<ArticleVendu> selectAll() throws Exception {
		 List<ArticleVendu> articleVendus = new ArrayList<ArticleVendu>();
	        try (Connection cnx = ConnectionProvider.getConnection()) {
	            PreparedStatement requete = cnx.prepareStatement("SELECT * FROM articles_vendus");
	            ResultSet rs = requete.executeQuery();

	            while (rs.next()) {
	                articleVendus.add(itemBuilder(rs));
	            }
	        } catch (Exception e) {

	            throw new Exception();
	        }
	        return articleVendus;
	}

}
