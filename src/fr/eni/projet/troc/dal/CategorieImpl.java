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

/**
 * Classe en charge
 * 
 * @author Bastien
 * @version Troc.com - v1.0
 * @date 30 mars 2021 - 10:41:05
 */
public class CategorieImpl implements CategorieDAO {

	public static Categorie itemBuilder(ResultSet rs) throws SQLException {
		Categorie categorie = new Categorie();

		categorie.setNoCategorie(rs.getInt("no_categorie"));
		categorie.setLibelle(rs.getString("libelle"));

		return categorie;
	}

	@Override
	public List<Categorie> selectAll() throws Exception {
		List<Categorie> categories = new ArrayList<Categorie>();
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement requete = cnx.prepareStatement("SELECT * FROM categories");

			ResultSet rs = requete.executeQuery();

			while (rs.next()) {
				categories.add(itemBuilder(rs));
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		return categories;
	}

}
