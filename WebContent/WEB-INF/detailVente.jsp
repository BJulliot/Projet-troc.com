<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<%@include file="/WEB-INF/template/head.jsp"%>

<body>
	<%@include file="/WEB-INF/template/nav.jsp"%>



	<c:choose>
		<c:when
			test="${article.pseudoUtilisateur == utilisateurEnSession.pseudo}">
			<h2 class="my-3 text-center">Votre annonce</h2>
		</c:when>
		<c:otherwise>
			<h2 class="my-3 text-center">Détails de l'annonce</h2>

		</c:otherwise>
	</c:choose>

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

	<!-- 	On appelle l'article en fonction du numéro d'article qu'on a recupere via l'url -->

	<div class="container col-lg-12 col-md-12 col-sm-12">

		<h3>${article.nom}</h3>
		<p>Description : ${article.description}</p>
		<p>Categorie : ${article.nomCategorie}</p>
		<!-- Si il n'y a pas d'offre, on affiche un message qui le precise -->
		<c:choose>
			<c:when test="${article.prixVente == 0}">
				<p>Meilleure offre : Pas d'enchère pour le moment</p>
			</c:when>
			<c:otherwise>
				<p>Meilleure offre : ${article.prixVente} points par
					${UserEnchere.pseudo}</p>
			</c:otherwise>
		</c:choose>
		<p>Mise a prix ${article.prixInitial} Points</p>
		<p>Fin de l'enchère : ${article.dateFinEnchere}</p>
		<p>Retrait : ${retrait.rue} ${retrait.codePostal} ${retrait.ville}</p>


		<!-- 	Sert a afficher le profil de l'utilisateur -->
		<p>
			<a
				href="<%=application.getContextPath()%>/AfficherProfilUtilisateurServlet?u=${article.pseudoUtilisateur}">
				Vendeur : ${article.pseudoUtilisateur} </a>
		</p>

		<!-- Popose d'enchérir seulement si l'utilisateur ne possède pas l'annonce : -->
		<c:choose>
			<c:when
				test="${article.pseudoUtilisateur == utilisateurEnSession.pseudo}">
			</c:when>
			<c:otherwise>
				<form class="form-outline" action="./DetailVenteServlet"
					method="post">
					<label class="form-label" for="prixEnchere">Ma proposition : </label>
					<c:choose>
					<c:when test="${article.dateFinEnchere < dateDuJour}">
						<h3 class="win">Cher·e ${UserEnchere.pseudo}, cette enchère est terminée vous avez gagné !!! </h3>
						<h5 class="win">Prenez contact avec <a
				href="<%=application.getContextPath()%>/AfficherProfilUtilisateurServlet?u=${article.pseudoUtilisateur}">${article.pseudoUtilisateur}</a> pour convenir de l'échange.</h5>
					</c:when>
						<c:when
							test="${utilisateurEnSession.credit le article.prixInitial || utilisateurEnSession.credit le article.prixVente}">
							<input type="number" name="prixEnchere" id="prixEnchere"
								required="required" min="${article.prixVente +1}"
								max="${utilisateurEnSession.credit}">
							<input type="submit" onClick='return confirmSubmit()'
								value="Valider enchere" disabled="disabled">
							<p>Vous n'avez pas assez de crédit pour participer à cette
								enchère</p>
						</c:when>
						<c:when test="${article.prixVente == 0}">
							<input type="number" name="prixEnchere" id="prixEnchere"
								required="required" value="${article.prixInitial + 1}"
								min="${article.prixInitial +1}"
								max="${utilisateurEnSession.credit}">
							<input type="submit" onClick='return confirmSubmit()'
								value="Valider enchere">
						</c:when>
						<c:otherwise>
							<input type="number" name="prixEnchere" id="prixEnchere"
								required="required" value="${article.prixVente + 1}"
								min="${article.prixVente +1}"
								max="${utilisateurEnSession.credit}">
							<input type="submit" onClick='return confirmSubmit()'
								value="Valider enchere">
						</c:otherwise>
					</c:choose>


				</form>
			</c:otherwise>
		</c:choose>

	</div>

	<!-- Afficher le gagnant de l'enchère si la date de fin d'enchere est dépassée -->
	<c:choose>
		<c:when test="${article.dateFinEnchere < dateDuJour}">
			<div class="container">
				<div class="row text-center">
					<div class="col-lg-12 col-md-12 col-sm-12 mb-2 ">
						<h5 class="text-center">
							L'heureux·se gagnant·e de cette annonce est <a
								href="<%=application.getContextPath()%>/AfficherProfilUtilisateurServlet?u=${UserEnchere.pseudo}">${UserEnchere.pseudo}</a>
						</h5>
					</div>
				</div>
			</div>
		</c:when>
		<c:otherwise>
		<div class="container text-center col col-lg-6 col-md-8 col-sm-12">
		<c:choose>
			<c:when
				test="${article.pseudoUtilisateur == utilisateurEnSession.pseudo}">
				<c:choose>
					<c:when test="${article.dateDebutEnchere > dateDuJour}">
						<div class="container">
							<div class="row text-center">
								<div class="col-lg-6 col-md-6 mb-2">
									<div class="text-center">
										<a class="lienEnchere"
											href="<%=application.getContextPath()%>/ModifierAnnonceServlet?a=${article.noArticle}">
											<button class="btn btn-outline-secondary">Modifier
												l'annonce</button>
										</a>
									</div>
								</div>
								<div class="col-12 col-md-6 mb-2">
									<form action="./SupprimerAnnonceServlet?a=${article.noArticle}"
										method="post">
										<div class="text-center">
											<button class="btn btn-outline-danger" type="submit"
												onClick='return confirmDelete()'>Supprimer
												l'annonce</button>
										</div>
									</form>
								</div>
							</div>
						</div>
					</c:when>
					<c:otherwise>
						<div class="container d-flex justify-content-center">
							<div class="col-lg-8 col-md-10 col-sm-12">
								<div
									class="col-lg-12 col-md-12 col-sm-12 text-center alert alert-warning">
									<p>Vous ne pouvez plus modifier l'annonce car les enchères
										ont déjà commencées.</p>
								</div>
							</div>
						</div>

					</c:otherwise>
				</c:choose>
			</c:when>
		</c:choose>
	</div>
		</c:otherwise>
	</c:choose>	

	<!-- Bootstrap core JavaScript -->
	<%@include file="/WEB-INF/template/script.html"%>
</body>
<script>
	function confirmSubmit() {
		var inputVal = document.getElementById("prixEnchere").value;
		var agree = confirm("Voulez vous valider votre enchère de : "
				+ inputVal + " points ? ");
		if (agree)
			return true;
		else
			return false;
	}
	function confirmDelete() {
		var agree = confirm("Voulez vous supprimer votre annonce ? ");
		if (agree)
			return true;
		else
			return false;
	}
</script>
</html>