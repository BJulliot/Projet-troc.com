<%@page import="fr.eni.projet.troc.bo.Utilisateur"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<!-- Navigation -->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top text-white">
		<div class="container">
			<a class="navbar-brand" href="./AccueilServlet">ENI-Enchère</a>
			
			<%//Récupérer l'attribut userInSession sur la Session
			Utilisateur utilisateurEnSession = (Utilisateur)session.getAttribute("utilisateurEnSession");
			%>
			<c:choose>
    		<c:when test="${utilisateurEnSession != null}">
				<div class="text-end">
					<a class="btn btn-outline-light me-2" href="./AfficherEncheresServlet" type="button">Enchères</a>
					<a class="btn btn-outline-light me-2" href="./VendreArticleServlet" type="button">Vendre un objet</a>
					<a class="btn btn-outline-light me-2" href="./AfficherProfilUtilisateurServlet" type="button">Mon profil</a>
					<a class="btn btn-outline-light me-2" href="./DeconnectionServlet" type="button">Déconnexion</a>
				</div>
			</c:when>   
			<c:otherwise>
				<div class="text-end">
					<a class="btn btn-outline-light me-2" href="./ConnectionServlet" type="button">Se connecter</a>
					<a class="btn btn-outline-light me-2" href="./NouvelUtilisateurServlet" type="button">Créer un compte</a>
				</div>
			</c:otherwise>
			</c:choose>
		</div>
	</nav>