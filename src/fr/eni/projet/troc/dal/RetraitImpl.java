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
import fr.eni.projet.troc.exception.BusinessException;
import fr.eni.projet.troc.exception.Errors;

/**
 * Classe en charge
 * 
 * @author Bastien
 * @version Troc.com - v1.0
 * @date 1 avr. 2021 - 15:14:56
 */
public class RetraitImpl implements RetraitDAO {
	
	private static final String DELETE_RETRAITS_BY_NO_UTILISATEUR = "DELETE * FROM retraits WHERE no_utilisateur = ?";

	
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

	/**
	 * Permet de supprimer tous les retraits liés à un même utilisateur
	* {@inheritDoc}
	*/
	@Override
	public void deleteBynoUtilisateur(int noUtilisateur) throws BusinessException {
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement requete = cnx.prepareStatement(DELETE_RETRAITS_BY_NO_UTILISATEUR);
			requete.setInt(1, noUtilisateur);
			requete.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
			BusinessException be = new BusinessException();
			be.addError(Errors.SUPPRESSION_RETRAIT_ERREUR);
			throw be;
		}
	}
	
}
