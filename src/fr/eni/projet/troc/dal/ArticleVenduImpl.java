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
import fr.eni.projet.troc.bo.Retrait;
import fr.eni.projet.troc.exception.BusinessException;
import fr.eni.projet.troc.exception.Errors;

/**
 * Classe en charge
 * 
 * @author Bastien
 * @version Troc.com - v1.0
 * @date 29 mars 2021 - 14:12:34
 */
public class ArticleVenduImpl implements ArticleVenduDAO {

	private static final String UPDATE_ARTICLE = "UPDATE articles_vendus SET nom_article=?, description=?, date_debut_encheres=?, date_fin_encheres=?, prix_initial=?, no_categorie=? WHERE no_article =?";
	private static final String UPDATE_RETRAIT = "UPDATE retraits SET rue=?, code_postal=?, ville=? WHERE no_article =?";

	public static ArticleVendu itemBuilder(ResultSet rs) throws SQLException {
		ArticleVendu articleVendu = new ArticleVendu();
		articleVendu.setNoArticle(rs.getInt("no_article"));
		articleVendu.setNom(rs.getString("nom_article"));
		articleVendu.setDescription(rs.getString("description"));
		articleVendu.setDateDebutEnchere(rs.getDate("date_debut_encheres").toLocalDate());
		articleVendu.setDateFinEnchere(rs.getDate("date_fin_encheres").toLocalDate());
		articleVendu.setPrixInitial(rs.getInt("prix_initial"));
		articleVendu.setPrixVente(rs.getInt("prix_vente"));
		articleVendu.setPseudoUtilisateur(rs.getString("pseudo"));
		articleVendu.setNomCategorie(rs.getString("libelle"));
		articleVendu.setNoUtilisateur(rs.getInt("no_utilisateur"));

		return articleVendu;
	}

	public static ArticleVendu itemBuilderSell(ResultSet rs) throws SQLException {
		ArticleVendu articleVendu = new ArticleVendu();
		articleVendu.setPrixVente(rs.getInt("prix_vente"));
		return articleVendu;
	}

	@Override
	public List<ArticleVendu> selectAll() throws Exception {
		List<ArticleVendu> articleVendus = new ArrayList<ArticleVendu>();
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement requete = cnx.prepareStatement(
					"SELECT no_article, nom_article,description,date_debut_encheres,date_fin_encheres,prix_initial,prix_vente,pseudo,libelle, articles_vendus.no_utilisateur FROM `articles_vendus` INNER JOIN utilisateurs ON utilisateurs.no_utilisateur = articles_vendus.no_utilisateur INNER JOIN categories ON categories.no_categorie = articles_vendus.no_categorie GROUP BY articles_vendus.no_article");

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
	public List<ArticleVendu> selectByIdCat(int cateNum) throws Exception {
		List<ArticleVendu> articleVendus = new ArrayList<ArticleVendu>();
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement requete = cnx.prepareStatement(
					"SELECT no_article, nom_article,description,date_debut_encheres,date_fin_encheres,prix_initial,prix_vente,pseudo,libelle, articles_vendus.no_utilisateur FROM `articles_vendus` INNER JOIN utilisateurs ON utilisateurs.no_utilisateur = articles_vendus.no_utilisateur INNER JOIN categories ON categories.no_categorie = articles_vendus.no_categorie WHERE categories.no_categorie = ?");
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

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<ArticleVendu> selectByName(String name) throws Exception {
		List<ArticleVendu> articleVendus = new ArrayList<ArticleVendu>();
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement requete = cnx.prepareStatement(
					"SELECT no_article, nom_article,description,date_debut_encheres,date_fin_encheres,prix_initial,prix_vente, articles_vendus.no_utilisateur, GROUP_CONCAT(utilisateurs.pseudo SEPARATOR \" \") AS pseudo,GROUP_CONCAT(categories.libelle SEPARATOR \" \") AS libelle FROM `articles_vendus` INNER JOIN utilisateurs ON utilisateurs.no_utilisateur = articles_vendus.no_utilisateur INNER JOIN categories ON categories.no_categorie = articles_vendus.no_categorie WHERE nom_article LIKE '%' ? '%'");

			requete.setString(1, name);

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
	 * 
	 * @throws Exception
	 */
	@Override
	public void create(ArticleVendu articleVendu, Retrait retrait) throws Exception {
		try (Connection cnx = ConnectionProvider.getConnection()) {

			cnx.setAutoCommit(false);
			PreparedStatement requete = cnx.prepareStatement(
					"INSERT INTO articles_vendus (nom_article,description,date_debut_encheres,date_fin_encheres,prix_initial,no_categorie,no_utilisateur) VALUES (?,?,?,?,?,?,?)",
					PreparedStatement.RETURN_GENERATED_KEYS);
			requete.setString(1, articleVendu.getNom());
			requete.setString(2, articleVendu.getDescription());
			requete.setDate(3, java.sql.Date.valueOf(articleVendu.getDateDebutEnchere()));
			requete.setDate(4, java.sql.Date.valueOf(articleVendu.getDateFinEnchere()));
			requete.setInt(5, articleVendu.getPrixInitial());
			requete.setString(6, articleVendu.getNomCategorie());
			requete.setInt(7, articleVendu.getNoUtilisateur());
			requete.executeUpdate();
			ResultSet rs = requete.getGeneratedKeys();
			if (rs.next()) {
				articleVendu.setNoArticle(rs.getInt(1));
			} else {
				throw new Exception();
			}
			rs.close();
			requete.close();

			requete = cnx.prepareStatement("INSERT INTO retraits (no_article,rue,code_postal,ville) VALUES(?,?,?,?)");
			requete.setInt(1, articleVendu.getNoArticle());
			requete.setString(2, retrait.getRue());
			requete.setString(3, retrait.getCodePostal());
			requete.setString(4, retrait.getVille());
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
	public List<ArticleVendu> selectById(int id) throws Exception {
		List<ArticleVendu> articleVendu = new ArrayList<ArticleVendu>();
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement requete = cnx.prepareStatement(
					"SELECT no_article, nom_article,description,date_debut_encheres,date_fin_encheres,prix_initial,prix_vente,pseudo,libelle,articles_vendus.no_utilisateur FROM `articles_vendus` INNER JOIN utilisateurs ON utilisateurs.no_utilisateur = articles_vendus.no_utilisateur INNER JOIN categories ON categories.no_categorie = articles_vendus.no_categorie WHERE no_article = ?");
			requete.setInt(1, id);

			ResultSet rs = requete.executeQuery();

			while (rs.next()) {
				articleVendu.add(itemBuilder(rs));
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		return articleVendu;
	}
	
	
	

	@Override
	public ArticleVendu selectByIdSell(int id) throws BusinessException {
		ArticleVendu articleVendu = null;
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement requete = cnx
					.prepareStatement("SELECT prix_vente from articles_vendus WHERE no_article = ?");
			requete.setInt(1, id);

			ResultSet rs = requete.executeQuery();

			while (rs.next()) {
				articleVendu = (itemBuilderSell(rs));
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		return articleVendu;
	}

	@Override
	public ArticleVendu selectArticleById(int idArticle) {
		ArticleVendu articleVendu = new ArticleVendu();
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement requete = cnx.prepareStatement(
					"SELECT no_article, nom_article,description,date_debut_encheres,date_fin_encheres,prix_initial,prix_vente,pseudo,libelle,articles_vendus.no_utilisateur FROM `articles_vendus` INNER JOIN utilisateurs ON utilisateurs.no_utilisateur = articles_vendus.no_utilisateur INNER JOIN categories ON categories.no_categorie = articles_vendus.no_categorie WHERE no_article = ?");
			requete.setInt(1, idArticle);

			ResultSet rs = requete.executeQuery();

			while (rs.next()) {
				articleVendu = itemBuilder(rs);
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		return articleVendu;
	}

	@Override
	public void update(ArticleVendu articleAModifier, Retrait retrait) throws BusinessException {
		try (Connection cnx = ConnectionProvider.getConnection()) {
			cnx.setAutoCommit(false);
			PreparedStatement requete = cnx.prepareStatement(UPDATE_ARTICLE);
			requete.setString(1, articleAModifier.getNom());
			requete.setString(2, articleAModifier.getDescription());
			requete.setDate(3, java.sql.Date.valueOf(articleAModifier.getDateDebutEnchere()));
			requete.setDate(4, java.sql.Date.valueOf(articleAModifier.getDateFinEnchere()));
			requete.setInt(5, articleAModifier.getPrixInitial());
			requete.setString(6, articleAModifier.getNomCategorie());
			requete.setInt(7, articleAModifier.getNoArticle());
			requete.executeUpdate();
			requete.close();

			requete = cnx.prepareStatement(UPDATE_RETRAIT);
			requete.setString(1, retrait.getRue());
			requete.setString(2, retrait.getCodePostal());
			requete.setString(3, retrait.getVille());
			requete.setInt(4, retrait.getNoArticles());
			requete.executeUpdate();
			requete.close();
			cnx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			BusinessException be = new BusinessException();
			be.addError(Errors.UPDATE_ARTICLE_ECHEC);
			throw be;
		}
	}

	/**
	* {@inheritDoc}
	*/
	@Override
	public List<ArticleVendu> selectByIdUser(int id) throws Exception {
		List<ArticleVendu> articleVendu = new ArrayList<ArticleVendu>();
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement requete = cnx.prepareStatement(
					"SELECT no_article, nom_article,description,date_debut_encheres,date_fin_encheres,prix_initial,prix_vente,pseudo,libelle,articles_vendus.no_utilisateur FROM `articles_vendus` INNER JOIN utilisateurs ON utilisateurs.no_utilisateur = articles_vendus.no_utilisateur INNER JOIN categories ON categories.no_categorie = articles_vendus.no_categorie WHERE articles_vendus.no_utilisateur = ?");
			requete.setInt(1, id);

			ResultSet rs = requete.executeQuery();

			while (rs.next()) {
				articleVendu.add(itemBuilder(rs));
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		return articleVendu;
	}
}
