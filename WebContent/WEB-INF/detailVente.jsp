<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<%@include file="/WEB-INF/template/head.html"%>

<body>
	<%@include file="/WEB-INF/template/nav.jsp"%>


	<!-- affichage erreur
 -->
	<c:if test="${!empty errors}">
		<div class="row">
			<div class="col-lg-12 col-md-6 col-sm-6 portfolio-item">
				<div class="card h-100">
					<div class="card-body">

						<div class="alert alert-danger" role="alert">
							<h2>Erreur!</h2>
							<ul>
								<c:forEach var="msg" items="${errors}">
									<li>${msg}</li>
								</c:forEach>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</c:if>

	<c:choose>
		<c:when
			test="${article.pseudoUtilisateur == utilisateurEnSession.pseudo}">
			<h2 class="my-3 text-center">Votre annonce</h2>
		</c:when>
		<c:otherwise>
			<h2 class="my-3 text-center">Détails de l'annonce</h2>
		</c:otherwise>
	</c:choose>

	<!-- 	On appelle l'article en fonction du numéro d'article qu'on a recupere via l'url -->

	<div class="container">
		<h3>${article.nom}</h3>
		<p>Description : ${article.description}</p>
		<p>Categorie : ${article.nomCategorie}</p>
		<p>Meilleur offre : ${article.prixVente} points</p>
		<p>Mise a prix ${article.prixInitial} Points</p>
		<p>Fin de l'enchère : ${article.dateFinEnchere}</p>
		<p>Retrait : ${retrait.rue} ${retrait.codePostal} ${retrait.ville}</p>


		<!-- 	Sert a afficher le profil de l'utilisateur -->
		<a
			href="<%=application.getContextPath()%>/AfficherProfilUtilisateurServlet?u=${article.pseudoUtilisateur}">
			<p>Vendeur : ${article.pseudoUtilisateur}</p>
		</a>

		<!-- Popose d'enchérir seulement si l'utilisateur ne possède pas l'annonce : -->
		<c:choose>
			<c:when
				test="${article.pseudoUtilisateur == utilisateurEnSession.pseudo}">
			</c:when>
			<c:otherwise>
				<form class="form-outline" action="./DetailVenteServlet"
					method="post">
					<label class="form-label" for="prixEnchere">Ma proposition</label>
					<input type="number" name="prixEnchere" id="prixEnchere"> <input
						type="submit" value="Valider enchere">
				</form>
			</c:otherwise>
		</c:choose>

	</div>
	<!-- Popose d'enchérir seulement si l'utilisateur ne possède pas l'annonce : -->
	<c:choose>
		<c:when
			test="${article.pseudoUtilisateur == utilisateurEnSession.pseudo}">
			<div class="container">
				<div class="row text-center">
					<div class="col-12">
						<a class="lienEnchere"
							href="<%=application.getContextPath()%>/ModifierAnnonceServlet?a=${article.noArticle}">
							<div class="text-center">
								<button type="submit" class="btn btn-outline-secondary">Modifier
									l'annonce</button>
							</div>
						</a>
					</div>
				</div>
			</div>

		</c:when>
		<c:otherwise>

		</c:otherwise>
	</c:choose>


	<!-- Bootstrap core JavaScript -->
	<%@include file="/WEB-INF/template/script.html"%>
</body>
</html>