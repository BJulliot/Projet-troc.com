<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<%@include file="/WEB-INF/template/head.html"%>

<body>
	<%@include file="/WEB-INF/template/nav.jsp"%>

	<h1 class="my-4 text-center">Details vente</h1>
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

	<c:forEach var="article" items="${article}">
		
		${article.nom}
		<p>Description : ${article.description}</p>
		<p>Categorie : ${article.nomCategorie}</p>
		<p>Meilleur offre : ${article.prixVente} points</p>
		<p>Mise a prix ${article.prixInitial} Points</p>
		<p>Fin de l'enchère : ${article.dateFinEnchere}</p>
		<c:forEach var="retrait" items="${retrait}">
		${retrait.rue}
		${retrait.codePostal}
		${retrait.ville}
	</c:forEach>
		<a
			href="<%=application.getContextPath()%>/AfficherProfilUtilisateurServlet?u=${article.pseudoUtilisateur}">
			<p>Vendeur : ${article.pseudoUtilisateur}</p>
		</a>
	</c:forEach>



	<form action="./DetailVenteServlet" method="post">
		<label>Ma proposition</label> <input type="number" name="prixEnchere"
			id="prixEnchere"> <input type="submit"
			value="Valider enchere">
	</form>



	<!-- Bootstrap core JavaScript -->
	<%@include file="/WEB-INF/template/script.html"%>
</body>
</html>