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

		<h2 class="my-3 text-center">Espace admin</h2>

		<!-- Gestion erreurs -->
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

		<!-- Affichage de tous les utilisateurs avec la possibilité : d'afficher, de supprimer -->
		<div class="mx-auto col-lg-12 col-md-6 col-sm-6 portfolio-item">
			<div class="card h-100">
				<div class="card-body">
					<!-- Si la liste est vide on dit qu'il n'y a pas d'utilisateurs -->
					<c:choose>
						<c:when test="${empty listeUtilisateur}">
							<div class="alert alert-info" role="alert">Il n'y aucun
								utilisateur.</div>
						</c:when>
						<c:otherwise>

							<table class="table">
								<thead>
									<tr>
										<th scope="col">Pseudo</th>
										<th scope="col">Prénom</th>
										<th scope="col">Nom</th>
										<th scope="col">Détails</th>
										<th scope="col">Supprimer</th>
									</tr>
								</thead>
								<tbody>
									<!-- Dynamique -->
									<c:forEach var="utilisateur" items="${listeUtilisateur}">
										<tr>
											<td>${utilisateur.pseudo}</td>
											<td>${utilisateur.prenom}</td>
											<td>${utilisateur.nom}</td>
											<td>
												<button class="btn btn-secondary" type="button"
													data-toggle="collapse"
													data-target="#detail${utilisateur.noUtilisateur}"
													aria-expanded="false"
													aria-controls="detaildetail${utilisateur.noUtilisateur}">détail</button>
											</td>
											<td>
												<form action="./SupprimerUtilisateurServlet" method="post">
													<button type="submit" class="btn btn-outline-danger"
														onclick="return confirm('Confirmer la suppression du compte utilisateur ${utilisateur.pseudo}?')">Supprimer</button>
												</form>

												
											</td>
										</tr>


										<!-- détails utilisateur -->
										<tr>
											<td colspan="5">
												<div class="collapse"
													id="detail${utilisateur.noUtilisateur}">
													<div
														class="list-group-item list-group-item-action list-group-item-secondary">
														<h5>Contact :</h5>
														email : ${utilisateur.email} // telephone :
														${utilisateur.telephone}
													</div>
													<div
														class="list-group-item list-group-item-action list-group-item-secondary">
														<h5>Adresse :</h5>
														${utilisateur.rue}, ${utilisateur.codePostal},
														${utilisateur.ville}
													</div>
													<div
														class="list-group-item list-group-item-action list-group-item-secondary">
														<h5>Confidentiel :</h5>
														motDePasse : ${utilisateur.motDePasse}
													</div>
												</div>
											</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</c:otherwise>
					</c:choose>
				</div>
			</div>
		</div>

		<!-- Bootstrap core JavaScript -->
		<%@include file="/WEB-INF/template/script.html"%>
</body>
</html>