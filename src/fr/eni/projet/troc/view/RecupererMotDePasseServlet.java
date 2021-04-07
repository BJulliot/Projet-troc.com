package fr.eni.projet.troc.view;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.projet.troc.bll.UtilisateursManager;
import fr.eni.projet.troc.exception.BusinessException;

/**
 * Servlet implementation class RecupererMotDePasseServlet
 */
@WebServlet("/RecupererMotDePasseServlet")
public class RecupererMotDePasseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/oubliMotDePasse.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Récupération de la saisie
		request.setCharacterEncoding("UTF-8");
		String email = request.getParameter("email");

		try {
			UtilisateursManager.getInstance().validerEmailEnBDD(email);
			request.setAttribute("victories", "bravo");
			request.getRequestDispatcher("/WEB-INF/oubliMotDePasse.jsp").forward(request, response);
		} catch (BusinessException e) {
			e.printStackTrace();
			request.setAttribute("errors", e.getErrors());
			request.getRequestDispatcher("/WEB-INF/oubliMotDePasse.jsp").forward(request, response);
		}

	}

}
