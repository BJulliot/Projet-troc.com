<%@page import="fr.eni.projet.troc.bo.Utilisateur"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<!-- Navigation -->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top text-white">
		<div class="container">
			<a class="navbar-brand" href="#">ENI-Enchère</a>
			
			<%//Récupérer l'attribut userInSession sur la Session
			Utilisateur utilisateur = (Utilisateur)session.getAttribute("utilisateurEnSession");
			%>
			<c:choose>
    		<c:when test="${utilisateur != null}">
				<div class="text-end">
					<a class="btn btn-outline-light me-2" href="AfficherEncheres" type="button">Enchères</a>
					<a class="btn btn-outline-light me-2" href="/VendreArticle" type="button">Vendre un objet</a>
					<a class="btn btn-outline-light me-2" href="/AfficherProfilUtilisateur" type="button">Mon profil</a>
					<a class="btn btn-outline-light me-2" href="/Deconnexion" type="button">Déconnexion</a>
				</div>
			</c:when>   
			<c:otherwise>
				<div class="text-end">
					<a class="btn btn-outline-light me-2" href="./PoolConnectionServlet" type="button">Se connecter</a>
					<a class="btn btn-outline-light me-2" href="./NouvelUtilisateurServlet" type="button">Créer un compte</a>
				</div>
			</c:otherwise>
			</c:choose>
		</div>
	</nav>