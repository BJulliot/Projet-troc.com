/**
 * 
 */
package fr.eni.projet.troc.dal;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import fr.eni.projet.troc.bo.ArticleVendu;
import fr.eni.projet.troc.bo.Enchere;

/**
 * Classe en charge
 * 
 * @author Bastien
 * @version Troc.com - v1.0
 * @date 1 avr. 2021 - 15:39:13
 */
public class EnchereImpl implements EnchereDAO {

	public static Enchere itemBuilder(ResultSet rs) throws SQLException {
		Enchere enchere = new Enchere();
		enchere.setNoEnchere(rs.getInt("no_enchere"));
		enchere.setDateEnchere(rs.getTimestamp("date_enchere").toLocalDateTime());
		enchere.setMontantEnchere(rs.getInt("montant_enchere"));
		enchere.setNoArticle(rs.getInt("no_article"));
		enchere.setNoUtilisateur(rs.getInt("no_utilisateur"));

		return enchere;
	}

	@Override
	public void create(Enchere enchere) throws Exception {
		try (Connection cnx = ConnectionProvider.getConnection()) {
			cnx.setAutoCommit(false);
			PreparedStatement requete = cnx.prepareStatement(
					"INSERT INTO encheres (date_enchere,montant_enchere,no_article,no_utilisateur) VALUES (?,?,?,?)",
					PreparedStatement.RETURN_GENERATED_KEYS);
			requete.setDate(1, java.sql.Date.valueOf(enchere.getDateEnchere().toLocalDate()));
			requete.setInt(2, enchere.getMontantEnchere());
			requete.setInt(3, enchere.getNoArticle());
			requete.setInt(4, enchere.getNoUtilisateur());
			requete.executeUpdate();
			ResultSet rs = requete.getGeneratedKeys();
			if (rs.next()) {
				enchere.setNoEnchere(rs.getInt(1));
			} else {
				throw new Exception();
			}

			rs.close();
			requete.close();

			requete = cnx.prepareStatement("UPDATE articles_vendus SET prix_vente = ? WHERE no_article = ?");
			requete.setInt(1, enchere.getMontantEnchere());
			requete.setInt(2, enchere.getNoArticle());
			requete.executeUpdate();
			rs.close();
			requete.close();
			cnx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Enchere selectById(int id) throws Exception {
		Enchere enchere = null;
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement requete = cnx.prepareStatement(
					"SELECT no_enchere,date_enchere,montant_enchere,no_article,no_utilisateur FROM encheres WHERE no_enchere = ?");
			requete.setInt(1, id);
			ResultSet rs = requete.executeQuery();
			if (rs.next()) {
				enchere = itemBuilder(rs);
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
		return enchere;
	}
	
	
	
	
	public Enchere selectByArticle(int id) throws Exception {
		Enchere enchere = null;
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement requete = cnx.prepareStatement(
					"SELECT montant_enchere FROM encheres WHERE no_article = ?");
			requete.setInt(1, id);
			ResultSet rs = requete.executeQuery();
			if (rs.next()) {
				enchere = itemBuilder(rs);
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
		return enchere;

	}


}
