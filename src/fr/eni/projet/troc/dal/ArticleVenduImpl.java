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
		articleVendu.setNoUtilisateur(rs.getString("pseudo"));
		articleVendu.setNoCategorie(rs.getString("libelle"));
		return articleVendu;
	}

	@Override
	public List<ArticleVendu> selectAll() throws Exception {
		List<ArticleVendu> articleVendus = new ArrayList<ArticleVendu>();
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement requete = cnx.prepareStatement(
					"SELECT no_article, nom_article,description,date_debut_encheres,date_fin_encheres,prix_initial,prix_vente,GROUP_CONCAT(utilisateurs.pseudo SEPARATOR \" \") AS pseudo,GROUP_CONCAT(categories.libelle SEPARATOR \" \") AS libelle FROM `articles_vendus` INNER JOIN utilisateurs ON utilisateurs.no_utilisateur = articles_vendus.no_utilisateur INNER JOIN categories ON categories.no_categorie = articles_vendus.no_categorie GROUP BY articles_vendus.no_article");
	
			ResultSet rs = requete.executeQuery();

			while (rs.next()) {
				articleVendus.add(itemBuilder(rs));
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		return articleVendus;
	}

	/**
	* {@inheritDoc}
	*/
	@Override
	public List<ArticleVendu> selectById(int cateNum) throws Exception {
		List<ArticleVendu> articleVendus = new ArrayList<ArticleVendu>();
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement requete = cnx.prepareStatement(
					"SELECT no_article, nom_article,description,date_debut_encheres,date_fin_encheres,prix_initial,prix_vente,GROUP_CONCAT(utilisateurs.pseudo SEPARATOR \" \") AS pseudo,GROUP_CONCAT(categories.libelle SEPARATOR \" \") AS libelle FROM `articles_vendus` INNER JOIN utilisateurs ON utilisateurs.no_utilisateur = articles_vendus.no_utilisateur INNER JOIN categories ON categories.no_categorie = articles_vendus.no_categorie WHERE categories.no_categorie = ?");
			requete.setInt(1, cateNum);

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
