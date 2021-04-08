<%@page import="fr.eni.projet.troc.bo.Utilisateur"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<%@include file="/WEB-INF/template/head.jsp"%>
<body>
	<%@include file="/WEB-INF/template/nav.jsp"%>

	<div class="container">
		<c:choose>
			<c:when test="${utilisateurEnSession.pseudo == utilisateur.pseudo}">
				<h2 class="my-3 text-center">Votre profil</h2>
			</c:when>
			<c:otherwise>
				<h2 class="my-3 text-center">Profil du vendeur</h2>
			</c:otherwise>
		</c:choose>


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

		<div class="col-md-6 mx-auto">
			<table class="table table-striped table-hover">
				<thead>
					<tr>
						<th scope="col">Pseudo</th>
						<th scope="col">${utilisateur.pseudo}</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>Nom :</td>
						<td>${utilisateur.nom}</td>
					</tr>
					<tr>
						<td>Prenom :</td>
						<td>${utilisateur.prenom}</td>
					</tr>
					<tr>
						<td>Email :</td>
						<td>${utilisateur.email}</td>
					</tr>
					<tr>
						<td>Telephone :</td>
						<td>${utilisateur.telephone}</td>
					</tr>
					<tr>
						<td>Adresse :</td>
						<td>${utilisateur.rue}</td>
					</tr>
					<tr>
						<td>Code postal :</td>
						<td>${utilisateur.codePostal}</td>
					</tr>
					<tr>
						<td>Ville :</td>
						<td>${utilisateur.ville}</td>
					</tr>
				</tbody>
			</table>

			<div class="form-group text-center mb-3">
				<button class="btn btn-secondary">Crédit :
					${utilisateurEnSession.credit}</button>
			</div>

			<c:choose>
				<c:when test="${utilisateurEnSession.pseudo == utilisateur.pseudo}">
					<div class="container">
						<div class="row">
							<div class="col-lg-6 col-md-6 mb-2">
								<form action="./ModifierUtilisateurServlet" method="get">
									<div class="text-center">
										<button type="submit" class="btn btn-outline-secondary">Modifier
											compte</button>
									</div>
								</form>
							</div>
							<div class="col-lg-6 col-md-6">
								<form action="./SupprimerUtilisateurServlet" method="post">
									<div class="text-center">
										<button type="submit" class="btn btn-outline-danger"
											onclick="return confirm('Confirmer la suppression du compte utilisateur ${utilisateurEnSession.pseudo}?')">Supprimer</button>
									</div>
								</form>
							</div>
						</div>
					</div>
				</c:when>
				<c:otherwise>
					<div class="container">
						<div class="row text-center">
							<div class="col-12 col-md-12 ">
								<div class="text-center">
									<a href="./AccueilServlet"><button type="button"
											class="btn btn-outline-secondary">Retour accueil</button></a>
								</div>
							</div>

						</div>
					</div>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
	<!-- Bootstrap core JavaScript -->
	<%@include file="/WEB-INF/template/script.html"%>
</body>
</html>