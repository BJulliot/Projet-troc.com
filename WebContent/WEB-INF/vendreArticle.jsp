<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<%@include file="/WEB-INF/template/head.html"%>

<body>
	<%@include file="/WEB-INF/template/nav.jsp"%>


	<div class="container col-lg-4 col-md-10 col-sm-12 portfolio-item ">
	<h1 class="my-4 text-center">Nouvelle vente</h1>
		<div class="row ">

			<form class="FormAjoutArticle" action="./VendreArticleServlet" method="post">

				<label>Article : </label> <input type="text" name="nomArticle"
					id="nomArticle" required placeholder="Nom de l'article"> <label>Description
					: </label>
				<textarea style="resize: none" name=description id="description" required
					placeholder="Description de l'article"></textarea>
					<label>Catégorie : </label>
				<select class="form-select" id="cateVente" name="cateVente"
					aria-label="Default select example">
					<c:forEach var="categories" items="${categories}">
						<option value="${categories.noCategorie}">${categories.libelle}</option>
					</c:forEach>
				</select> <label>Mise a prix : </label> <input type="number" name="prix"
					id="prix" required value="50"> <label>Début de
					l'enchère : </label> <input type="date" name="dateDebut" id="dateDebut"
					required> <label>Fin de l'enchère : </label> <input
					type="date" name="dateFin" id="dateFin" required>
				<fieldset class="fieldArticle">
					<legend>Retrait</legend>
					<label>Rue : </label> <input type="text" name="rue" id="rue"
						required="required" value="${utilisateurEnSession.rue}"> <label>Code
						postal : </label> <input type="number" name="codePostal" id="codePostal"
						required="required" value="${utilisateurEnSession.codePostal}">
					<label>Ville :</label> <input type="text" name="ville" id="ville"
						required="required" value="${utilisateurEnSession.ville}">
				</fieldset>
				<div class="boutonArticle">
				<input class="btn btn-primary" type="submit" value="Enregistrer">
				<input class="btn btn-primary" type="reset" value="Annuler"> 
				</div>
			</form>
		</div>
	</div>




</body>
<script type="text/javascript">
	let today = new Date().toISOString().substr(0, 10);
	document.querySelector("#dateDebut").value = today;
	document.getElementsByName("dateDebut")[0].setAttribute('min', today);
	document.querySelector("#dateFin").value = today;
	document.getElementsByName("dateFin")[0].setAttribute('min', today);
</script>
</html>