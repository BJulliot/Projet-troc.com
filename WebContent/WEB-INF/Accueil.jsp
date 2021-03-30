<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<!DOCTYPE html>
<html>
<%@include file="/WEB-INF/template/head.html"%>
<body>
	<%@include file="/WEB-INF/template/nav.html"%>

	<div class="container">
		<h1 class="my-4">Liste des enchères</h1>
		<div class="col-lg-4 col-md-4 col-sm-6 portfolio-item">
			<div class="col-lg-4 col-md-4 col-sm-6 portfolio-item">
				<select class="form-select" aria-label="Default select example">
					<option selected>Catégories</option>
					<c:forEach var="categories" items="${categories}">
					
				
					<option value="1">${categories.libelle}</option>
				</c:forEach>
				</select>
			</div>

			<div class="card h-100">
				<c:forEach var="articles" items="${articles}">
					${articles.nom} ${articles.description}
					<p>Prix : ${articles.prixInitial} Points</p>
					<p>Fin de l'enchère : ${articles.dateFinEnchere}</p>
					<p>Vendeur : ${articles.noUtilisateur}</p>
				</c:forEach>

			</div>
		</div>
	</div>

	<%@include file="/WEB-INF/template/script.html"%>

</body>
</html>