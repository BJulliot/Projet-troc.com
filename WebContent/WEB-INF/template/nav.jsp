<%@page import="fr.eni.projet.troc.bo.Utilisateur"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<% //Récupérer l'attribut userInSession sur la Session
Utilisateur utilisateurEnSession = (Utilisateur) session.getAttribute("utilisateurEnSession");
%>
<!-- Navigation -->
<nav class="navbar navbar-expand-md navbar-dark bg-dark fixed-top text-white justify-content-between">
 <img  src="<%=getServletContext().getContextPath()%>/images/JB_logo.gif" width="3%" alt="Logo" />
<a class="navbar-brand" href="./AccueilServlet">Jean-Bastien, Auction&Sales</a>
 	
  <button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarSupportedContent"
		aria-controls="navbarSupportedContent" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>


	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<c:choose>
			<c:when test="${utilisateurEnSession != null}">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item active"><a class="btn btn-outline-light me-2" href="./AfficherEncheresServlet" type="button">Enchères</a></li>
					<li class="nav-item"><a class="btn btn-outline-light me-2" href="./VendreArticleServlet" type="button">Vendre un objet</a></li>
					<li class="nav-item"><a class="btn btn-outline-light me-2" href="./AfficherProfilUtilisateurServlet?u=${utilisateurEnSession.pseudo}" type="button">Mon profil</a></li>
					<li class="nav-item"><a class="btn btn-outline-light me-2" href="./DeconnectionServlet" type="button">Déconnexion</a></li>
				</ul>
			
			</c:when>
			<c:otherwise>
			<ul class="navbar-nav ml-auto">
					<li class="nav-item active"><a class="btn btn-outline-light me-2" href="./ConnectionServlet" type="button">Se connecter</a> </li>
					<li class="nav-item"><a class="btn btn-outline-light me-2" href="./NouvelUtilisateurServlet" type="button">Créer un compte</a></li>
				</ul>
					</c:otherwise>
		</c:choose>

</div>


</nav>