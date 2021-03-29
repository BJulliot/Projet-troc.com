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
		articleVendu.setNoUtilisateur(rs.getInt("no_utilisateur"));
		articleVendu.setNoCategorie(rs.getInt("no_categorie"));
		return articleVendu;
	}

	@Override
	public List<ArticleVendu> selectAll(int idUtilisateur, int idCategorie) throws Exception {
		List<ArticleVendu> articleVendus = new ArrayList<ArticleVendu>();
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement requete = cnx.prepareStatement(
					"SELECT * FROM `articles_vendus` INNER JOIN utilisateurs ON utilisateurs.no_utilisateur = articles_vendus.no_utilisateur INNER JOIN categories ON categories.no_categorie = articles_vendus.no_categorie WHERE utilisateurs.no_utilisateur = ? AND categories.no_categorie = ?");
			requete.setInt(1, idUtilisateur);
			requete.setInt(2, idCategorie);
			ResultSet rs = requete.executeQuery();

			while (rs.next()) {
				articleVendus.add(itemBuilder(rs));
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		return articleVendus;
	}

}
