/**
 * 
 */
package fr.eni.projet.troc.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import fr.eni.projet.troc.bo.Enchere;

/**
 * Classe en charge
 * @author Bastien
 * @version Troc.com - v1.0
 * @date 1 avr. 2021 - 15:39:13
 */
public class EnchereImpl implements EnchereDAO {

	/**
	* {@inheritDoc}
	*/
	@Override
	public void create(Enchere enchere) throws Exception {
		   try (Connection cnx = ConnectionProvider.getConnection()) {
	            PreparedStatement requete = cnx.prepareStatement("INSERT INTO encheres (date_enchere,montant_enchere,no_article,no_utilisateur) VALUES (?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
	            requete.setDate(1,java.sql.Date.valueOf(enchere.getDateEnchere().toLocalDate()));	            
	            requete.setInt(2, enchere.getMontantEnchere());
	            requete.setInt(3, enchere.getNoArticle());
	            requete.setInt(4,enchere.getNoUtilisateur());
	            requete.executeUpdate();
	            ResultSet rs = requete.getGeneratedKeys();
				if (rs.next()) {
					enchere.setNoArticle(rs.getInt(1));
				} else {
					throw new Exception();
				}
	        } catch (Exception e) {
	            e.printStackTrace();
	        }		
	}

}
