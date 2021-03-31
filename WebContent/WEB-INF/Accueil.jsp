<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>


<!DOCTYPE html>
<html>
<%@include file="/WEB-INF/template/head.html"%>
<body>
	<%@include file="/WEB-INF/template/nav.jsp"%>

	<div class="container">
		<h1 class="my-4">Liste des enchères</h1>
		<div class="col-lg-4 col-md-4 col-sm-6 portfolio-item">
			<div class="col-lg-6 col-md-4 col-sm-6 portfolio-item">
				<form action="./AccueilServlet" method="get">
					<select class="form-select" id="Categories" name="Categories"
						aria-label="Default select example">
						<option value="0" Selected>Toutes les enchères</option>
						<c:forEach var="categories" items="${categories}">
							<option value="${categories.noCategorie}">${categories.libelle}</option>
						</c:forEach>
					</select> <input class="btn btn-primary" type="submit">
				</form>
			</div>

			<div class="col-lg-5 col-md-4 col-sm-6 portfolio-item">

				<div class="input-group">
					<input type="search" class="form-control rounded"
						placeholder="Rechercher une enchère" aria-label="Search"
						aria-describedby="search-addon" />
					<button type="button" class="btn btn-outline-primary">Rechercher</button>
				</div>
			</div>
			<div class="card h-100">
			<c:if test="${Cat == null}">
					<c:forEach var="articles" items="${articles}">
					${articles.nom} ${articles.description}
					<p>Prix : ${articles.prixInitial} Points</p>
						<p>Fin de l'enchère : ${articles.dateFinEnchere}</p>
						<p>Vendeur : ${articles.noUtilisateur}</p>
						<p>cat : ${articles.noCategorie}</p>
					</c:forEach>
				</c:if>
				<c:if test="${Cat == '0'}">
					<c:forEach var="articles" items="${articles}">
					${articles.nom} ${articles.description}
					<p>Prix : ${articles.prixInitial} Points</p>
						<p>Fin de l'enchère : ${articles.dateFinEnchere}</p>
						<p>Vendeur : ${articles.noUtilisateur}</p>
						<p>cat : ${articles.noCategorie}</p>
					</c:forEach>
				</c:if>
				<c:if test="${Cat == '1' }">
					<c:forEach var="cateNum" items="${cateNum}">
					${cateNum.nom} ${cateNum.description}
					<p>Prix : ${cateNum.prixInitial} Points</p>
						<p>Fin de l'enchère : ${cateNum.dateFinEnchere}</p>
						<p>Vendeur : ${cateNum.noUtilisateur}</p>
						<p>cat : ${cateNum.noCategorie}</p>
					</c:forEach>
				</c:if>

				<c:if test="${Cat == '2' }">
					<c:forEach var="cateNum" items="${cateNum}">
					${cateNum.nom} ${cateNum.description}
					<p>Prix : ${cateNum.prixInitial} Points</p>
						<p>Fin de l'enchère : ${cateNum.dateFinEnchere}</p>
						<p>Vendeur : ${cateNum.noUtilisateur}</p>
						<p>cat : ${cateNum.noCategorie}</p>
					</c:forEach>
				</c:if>

				<c:if test="${Cat == '3' }">
					<c:forEach var="cateNum" items="${cateNum}">
					${cateNum.nom} ${cateNum.description}
					<p>Prix : ${cateNum.prixInitial} Points</p>
						<p>Fin de l'enchère : ${cateNum.dateFinEnchere}</p>
						<p>Vendeur : ${cateNum.noUtilisateur}</p>
						<p>cat : ${cateNum.noCategorie}</p>
					</c:forEach>
				</c:if>
				<c:if test="${Cat == '4' }">
					<c:forEach var="cateNum" items="${cateNum}">
					${cateNum.nom} ${cateNum.description}
					<p>Prix : ${cateNum.prixInitial} Points</p>
						<p>Fin de l'enchère : ${cateNum.dateFinEnchere}</p>
						<p>Vendeur : ${cateNum.noUtilisateur}</p>
						<p>cat : ${cateNum.noCategorie}</p>
					</c:forEach>
				</c:if>

			</div>

		</div>
	</div>

	<%@include file="/WEB-INF/template/script.html"%>

</body>
</html>