package fr.eni.projet.troc.view;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.projet.troc.bll.UtilisateursManager;
import fr.eni.projet.troc.bo.Utilisateur;
import fr.eni.projet.troc.dal.ConnectionProvider;
import fr.eni.projet.troc.exception.BusinessException;

/**
 * Servlet implementation class PoolConnectionServlet
 */
@WebServlet("/PoolConnectionServlet")
public class PoolConnectionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// testPoolConnection();
		request.getRequestDispatcher("/WEB-INF/connexion.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		// Récupération de la saisie
		request.setCharacterEncoding("UTF-8");
		String login = request.getParameter("login");
		String password = request.getParameter("password");

		// Appelle a la BLL
		try {
			Utilisateur utilisateur = UtilisateursManager.getInstance().validateConnection(login, password);
			// Transmettre les informations pour la page de welcome
			request.setAttribute("user", utilisateur);
			request.getRequestDispatcher("/WEB-INF/welcome.jsp").forward(request, resp);
		} catch (BusinessException e) {
			e.printStackTrace();
			request.setAttribute("errors", e.getErrors());
			request.getRequestDispatcher("/WEB-INF/poolConnectionForm.jsp").forward(request, resp);
		}
	}

	/**
	 * Méthode pour valider la configuration de la base de données
	 */
	private void testPoolConnection() {
		try {
			Connection cnx = ConnectionProvider.getConnection();
			System.out.println("La connexion est " + (cnx.isClosed() ? "FERMEE" : "OUVERTE"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
