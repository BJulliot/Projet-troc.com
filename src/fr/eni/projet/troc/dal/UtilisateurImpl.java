package fr.eni.projet.troc.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.eni.projet.troc.bo.Utilisateur;
import fr.eni.projet.troc.exception.BusinessException;
import fr.eni.projet.troc.exception.Errors;

public class UtilisateurImpl implements UtilisateurDAO {
	private static final String INSERT = "INSERT INTO utilisateurs (pseudo,nom,prenom,email,telephone,rue,code_postal,ville,mot_de_passe,credit,administrateur) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
	private static final String CONNECTION = "SELECT * FROM utilisateurs WHERE mot_de_passe=? AND (pseudo=? OR email=?)";
	private static final String GET_UTILISATEUR_PASSWORD = "SELECT mot_de_passe FROM utilisateurs WHERE no_utilisateur=?";
	private static final String UPDATE_UTILISATEUR = "UPDATE utilisateurs SET pseudo=?, nom=?, prenom=?, email=?, telephone=?, rue=?, code_postal=?, ville=?, mot_de_passe=? WHERE no_utilisateur=?";
	private static final String DELETE_UTILISATEUR = "DELETE FROM utilisateurs where no_utilisateur=?";
	private static final String GET_UTILISATEUR_PSEUDO = "SELECT pseudo FROM utilisateurs WHERE pseudo=?";
	private static final String GET_UTILISATEUR_BY_PSEUDO = "SELECT * FROM utilisateurs WHERE pseudo=?";

	@Override
	public void create(Utilisateur utilisateur) throws BusinessException {
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement requete = cnx.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
			requete.setString(1, utilisateur.getPseudo());
			requete.setString(2, utilisateur.getNom());
			requete.setString(3, utilisateur.getPrenom());
			requete.setString(4, utilisateur.getEmail());
			requete.setString(5, utilisateur.getTelephone());
			requete.setString(6, utilisateur.getRue());
			requete.setString(7, utilisateur.getCodePostal());
			requete.setString(8, utilisateur.getVille());
			requete.setString(9, utilisateur.getMotDePasse());
			requete.setInt(10, utilisateur.getCredit());
			requete.setBoolean(11, utilisateur.isAdministrateur());
			requete.executeUpdate();
			ResultSet rs = requete.getGeneratedKeys();
			if (rs.next()) {
				utilisateur.setNoUtilisateur(rs.getInt(1));
			} else {
				BusinessException be = new BusinessException();
				be.addError(Errors.INSERT_UTILISATEUR_ECHEC);
				throw be;
			}

		} catch (Exception e) {
			e.printStackTrace();
			BusinessException be = new BusinessException();
			be.addError(Errors.INSERT_UTILISATEUR_ECHEC);
			throw be;
		}

	}

	public Utilisateur find(String pseudo, String motDePasse) throws BusinessException {
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement requete = cnx.prepareStatement(CONNECTION);
			requete.setString(1, motDePasse);
			requete.setString(2, pseudo);
			requete.setString(3, pseudo);

			ResultSet rs = requete.executeQuery();

			if (rs.next()) {
				Utilisateur utilisateur = utilisateurBuilder(rs);
				return utilisateur;
			} else {
				// Utilisateur non trouvé en BDD
				BusinessException be = new BusinessException();
				be.addError(Errors.SELECT_UTILISATEUR_ECHEC);
				throw be;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			BusinessException be = new BusinessException();
			be.addError("ERROR DB - " + e.getMessage());
			throw be;
		}

	}

	public Utilisateur selectByPseudo(String pseudo) throws BusinessException {
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement requete = cnx.prepareStatement(GET_UTILISATEUR_BY_PSEUDO);
			requete.setString(1, pseudo);

			ResultSet rs = requete.executeQuery();

			if (rs.next()) {
				Utilisateur utilisateur = utilisateurBuilder(rs);
				return utilisateur;
			} else {
				// Utilisateur non trouvï¿½
				BusinessException be = new BusinessException();
				be.addError("Pseudo ou Mot de passe inconnu");
				throw be;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			BusinessException be = new BusinessException();
			be.addError("ERROR DB - " + e.getMessage());
			throw be;
		}

	}

	private Utilisateur utilisateurBuilder(ResultSet rs) throws SQLException {
		Utilisateur utilisateur = new Utilisateur();
		utilisateur.setNoUtilisateur(rs.getInt("no_utilisateur"));
		utilisateur.setPseudo(rs.getString("pseudo"));
		utilisateur.setNom(rs.getString("nom"));
		utilisateur.setPrenom(rs.getString("prenom"));
		utilisateur.setEmail(rs.getString("email"));
		utilisateur.setTelephone(rs.getString("telephone"));
		utilisateur.setRue(rs.getString("rue"));
		utilisateur.setCodePostal(rs.getString("code_postal"));
		utilisateur.setVille(rs.getString("ville"));
		utilisateur.setMotDePasse(rs.getString("mot_de_passe"));
		utilisateur.setCredit(rs.getInt("credit"));
		utilisateur.setAdministrateur(rs.getBoolean("administrateur"));
		return utilisateur;
	}

	public String getPasswordBynoUtilisateur(int noUtilisateur) throws BusinessException {
		String result;

		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement requete = cnx.prepareStatement(GET_UTILISATEUR_PASSWORD);
			requete.setInt(1, noUtilisateur);

			ResultSet rs = requete.executeQuery();

			if (rs.next()) {
				result = rs.getString("mot_de_passe");
				System.out.println("ancien mot de passe en BDD : " + result);
				return result;
			} else {
				// Utilisateur non trouvï¿½
				BusinessException be = new BusinessException();
				be.addError(Errors.SELECT_PASSWORD_UTILISATEUR_ECHEC);
				throw be;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			BusinessException be = new BusinessException();
			be.addError("ERROR DB - " + e.getMessage());
			throw be;
		}
	}

	@Override
	public void update(int noUtilisateur, String pseudo, String nom, String prenom, String email, String telephone,
			String rue, String codePostal, String ville, String nouveauMotDePasse) throws BusinessException {

		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement requete = cnx.prepareStatement(UPDATE_UTILISATEUR);
			requete.setString(1, pseudo);
			requete.setString(2, prenom);
			requete.setString(3, prenom);
			requete.setString(4, email);
			requete.setString(5, telephone);
			requete.setString(6, rue);
			requete.setString(7, codePostal);
			requete.setString(8, ville);
			requete.setString(9, nouveauMotDePasse);
			requete.setInt(10, noUtilisateur);
			requete.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			BusinessException be = new BusinessException();
			be.addError(Errors.INSERT_UTILISATEUR_ECHEC);
			throw be;
		}
	}

	@Override
	public void delete(int noUtilisateur) throws BusinessException {
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement requete = cnx.prepareStatement(DELETE_UTILISATEUR);
			requete.setInt(1, noUtilisateur);
			requete.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			BusinessException be = new BusinessException();
			be.addError(Errors.SUPPRESSION_UTILISATEUR_ERREUR);
			throw be;
		}

	}

	@Override
	public boolean isPseudoUnique(String pseudo) throws BusinessException {
		boolean result = true;
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement requete = cnx.prepareStatement(GET_UTILISATEUR_PSEUDO);
			requete.setString(1, pseudo);
			ResultSet rs = requete.executeQuery();
			if (rs.next()) {
				result = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			BusinessException be = new BusinessException();
			be.addError("ERROR DB - " + e.getMessage());
			throw be;
		}
		return result;
	}

}
