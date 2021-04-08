<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<%@include file="/WEB-INF/template/head.jsp"%>

<body>
	<%@include file="/WEB-INF/template/nav.jsp"%>


	<div class="container col-lg-10 col-md-10 col-sm-12 portfolio-item ">
		<h2 class="my-4 text-center">Nouvelle vente</h2>
		<div class="col-lg-10 col-md-10 col-sm-12 mx-auto">

			<form class="FormAjoutArticle" action="./VendreArticleServlet"
				method="post">
				<h5>Article :</h5>
				<div class="form-group row">
					<div class="col-sm-6">
						<label for="nomArticle">Nom</label> <input type="text"
							class="form-control" id="nomArticle" name="nomArticle"
							placeholder="Nom de l'article" required>
					</div>
					<div class="col-sm-6">
						<label for="exampleFormControlSelect1">Catégorie</label> <select
							class="form-control" id="cateVente" name="cateVente">
							<c:forEach var="categories" items="${categories}">
								<option value="${categories.noCategorie}">${categories.libelle}</option>
							</c:forEach>
						</select>
					</div>
				</div>
				<div class="form-group row">
					<div class="col-sm-12">
						<label for="nom">Description</label>
						<textarea class="form-control" id="description" name="description"
							placeholder="Description de l'article" required></textarea>
					</div>
				</div>

				<h5>Enchère :</h5>
				<div class="form-group row">
					<div class="col-sm-12 col-lg-6">
						<label for="prix">Prix initial</label> <input class="form-control"
							type="number" id="prix" name="prix" required="required">
					</div>
					<div class="col-sm-6 col-lg-3">
						<label for="dateDebut">Début</label> <input type="date"
							class="form-control" id="dateDebut" name="dateDebut">
					</div>
					<div class="col-sm-6 col-lg-3">
						<label for="dateFin">Fin</label> <input type="date"
							class="form-control" id="dateFin" name="dateFin" value="dateDebut">
					</div>
				</div>

				<h5>Retrait :</h5>
				<!-- On recupere l'adresse deja mise en BDD -->
				<div class="form-group row">
					<div class="col-sm-12 col-lg-6">
						<label for="rue">Adresse</label> <input type="text"
							class="form-control" id="rue" name="rue" placeholder="Adresse"
							value="${utilisateurEnSession.rue}" required>
					</div>
					<div class="col-sm-6 col-lg-3">
						<label for="codePostal">Code Postal</label> <input type="text"
							class="form-control" id="codePostal" name="codePostal"
							placeholder="Code Postal"
							value="${utilisateurEnSession.codePostal}" required>
					</div>
					<div class="col-sm-6 col-lg-3">
						<label for="ville">Ville</label> <input type="text"
							class="form-control" id="ville" name="ville" placeholder="Ville"
							value="${utilisateurEnSession.ville}" required>
					</div>
				</div>

				<div class="text-center mb-2">
					<input class="btn btn-secondary" type="submit" value="Enregistrer">
					<input class="btn btn-primary" type="reset" value="Annuler">
				</div>
			</form>
		</div>
	</div>




</body>
<!-- Script qui permet de mettre le calendrier a la date du jour et empeche de selectionner une date anterieure -->
<script type="text/javascript">
	let today = new Date().toISOString().substr(0, 10);
	document.querySelector("#dateDebut").value = today;
	document.getElementsByName("dateDebut")[0].setAttribute('min', today);
	document.querySelector("#dateFin").value = today;
	document.getElementsByName("dateFin")[0].setAttribute('min', today);
</script>
</html>