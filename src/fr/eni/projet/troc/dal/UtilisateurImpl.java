package fr.eni.projet.troc.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;

import fr.eni.projet.troc.bo.Utilisateur;

public class UtilisateurImpl implements UtilisateurDAO {
	private static final String INSERT = "INSERT INTO utilisateurs (pseudo,nom,prenom,email,telephone,rue,code_postal,ville,mot_de_passe,credit,administrateur)"
			+ "  VALUES (?,?,?,?,?,?,?,?,?,?,?)";

	@Override
	public void create(Utilisateur utilisateur) throws Exception {

		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement requete = cnx.prepareStatement(INSERT);
			requete.setString(1, utilisateur.getPseudo());
			requete.setString(2, utilisateur.getNom());
			requete.setString(3, utilisateur.getPrenom());
			requete.setString(4, utilisateur.getEmail());
			requete.setString(5, utilisateur.getTelephone());
			requete.setString(6, utilisateur.getRue());
			requete.setString(7, utilisateur.getCodePostal());
			requete.setString(8, utilisateur.getVille());
			requete.setString(9, utilisateur.getMotDePasses());
			requete.setInt(10, utilisateur.getCredit());
			requete.setBoolean(11, utilisateur.isAdministrateur());
			requete.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
