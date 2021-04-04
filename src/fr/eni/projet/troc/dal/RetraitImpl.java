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

import fr.eni.projet.troc.bo.Retrait;

/**
 * Classe en charge
 * 
 * @author Bastien
 * @version Troc.com - v1.0
 * @date 1 avr. 2021 - 15:14:56
 */
public class RetraitImpl implements RetraitDAO {

	public static Retrait itemBuilder(ResultSet rs) throws SQLException {
		Retrait retrait = new Retrait();
		retrait.setNoArticles(rs.getInt("no_article"));
		retrait.setRue(rs.getString("rue"));
		retrait.setCodePostal(rs.getString("code_postal"));
		retrait.setVille(rs.getString("ville"));
		return retrait;
	}

	@Override
	public List<Retrait> selectById(int idArticle) throws Exception {
		List<Retrait> retrait = new ArrayList<Retrait>();
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement requete = cnx
					.prepareStatement("SELECT no_article,rue,code_postal,ville FROM retraits WHERE no_article = ?");
			requete.setInt(1, idArticle);

			ResultSet rs = requete.executeQuery();

			while (rs.next()) {
				retrait.add(itemBuilder(rs));
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		return retrait;
	}

	@Override
	public Retrait selectRetraitById(int idArticle) {
		Retrait retrait = new Retrait();
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement requete = cnx
					.prepareStatement("SELECT no_article,rue,code_postal,ville FROM retraits WHERE no_article = ?");
			requete.setInt(1, idArticle);

			ResultSet rs = requete.executeQuery();

			while (rs.next()) {
				retrait = itemBuilder(rs);
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		return retrait;
	}

}
