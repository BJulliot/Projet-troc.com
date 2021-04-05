<%@page import="fr.eni.projet.troc.bo.Utilisateur"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<%@include file="/WEB-INF/template/head.html"%>
<body>
	<%@include file="/WEB-INF/template/nav.jsp"%>

	<div class="container">
		<div class="col-12">
			<h2 class="my-3 text-center">Modifier votre annonce</h2>
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

			<div class="col-lg-10 col-md-10 col-sm-12 mx-auto">
				<form action="ModifierAnnonceServlet" method="post">
					<h5>Article :</h5>
					<div class="form-group row">
						<div class="col-sm-6">
							<label for="nomArticle">Nom</label> <input type="text"
								class="form-control" id="nomArticle" name="nomArticle"
								placeholder="Nom de l'article" value="${article.nom}" required>
						</div>
						<div class="col-sm-6">
							<label for="exampleFormControlSelect1">Catégorie</label> <select
								class="form-control" id="cateVente" name="cateVente">
								<c:forEach var="categories" items="${categories}">
									<option value="${categories.noCategorie}"
										<c:choose>
											<c:when test="${article.nomCategorie == categories.libelle}">
												selected
											</c:when>
											<c:otherwise>
											</c:otherwise>
										</c:choose>>
										${categories.libelle}</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="form-group row">
						<div class="col-sm-12">
							<label for="nom">Description</label>
							<textarea class="form-control" id="description"
								name="description" placeholder="Description de l'article"
								required>${article.description}</textarea>
						</div>
					</div>

					<h5>Enchère :</h5>
					<div class="form-group row">
						<div class="col-sm-6">
							<label for="prix">Prix initial</label> <input
								class="form-control" type="number"
								value="${article.prixInitial}" id="prix" name="prix">
						</div>
						<div class="col-sm-3">
							<label for="dateDebut">Début</label> <input type="date"
								class="form-control" id="dateDebut" name="dateDebut"
								value="${article.dateDebutEnchere}">
						</div>
						<div class="col-sm-3">
							<label for="dateFin">Fin</label> <input type="date"
								class="form-control" id="dateFin" name="dateFin"
								value="${article.dateFinEnchere}">
						</div>
					</div>

					<h5>Retrait :</h5>
					<div class="form-group row">
						<div class="col-sm-6">
							<label for="rue">Adresse</label> <input type="text"
								class="form-control" id="rue" name="rue" placeholder="Adresse"
								value="${utilisateurEnSession.rue}" required>
						</div>
						<div class="col-sm-3">
							<label for="codePostal">Code Postal</label> <input type="text"
								class="form-control" id="codePostal" name="codePostal"
								placeholder="Code Postal" value="${utilisateurEnSession.codePostal}" required>
						</div>
						<div class="col-sm-3">
							<label for="ville">Ville</label> <input type="text"
								class="form-control" id="ville" name="ville" placeholder="Ville"
								value="${utilisateurEnSession.ville}" required>
						</div>
					</div>
					
					<div class="col-12 d-flex justify-content-center text-center mb-3">
						<div class="col-sm-6 p-2 bg-secondary">
							<div class="form-group align-items-center">
								<div class="col-sm-12">
									<label class="text-white" for="motDePasse">Confirmer
										mot de passe</label> <input type="password" class="form-control"
										id="motDePasse" name="motDePasse" placeholder="Mot de passe"
										required>
								</div>
							</div>

							<div class="text-center mb-2">
								<button type="submit" class="btn btn-secondary">Enregistrer</button>
								<a
									href="<%=application.getContextPath()%>/DetailVenteServlet?a=${article.noArticle}">
									<button type="button" class="btn btn-secondary">Annuler</button>
								</a>
							</div>
				</form>
			</div>
		</div>
	</div>

</body>

<!-- Bootstrap core JavaScript -->
<%@include file="/WEB-INF/template/script.html"%>
</html>