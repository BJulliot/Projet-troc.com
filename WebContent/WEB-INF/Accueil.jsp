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

				<form action="./AccueilServlet" method="get">
					<input type="search" id="search" name="search"
						placeholder="Recherche une enchère"> <input
						class="btn btn-primary" type="submit">
				</form>
			</div>
			<div class="card h-100">
				<c:choose>
					<c:when test="${Cat == null}">

						<c:forEach var="articles" items="${articles}">
					${articles.nom} ${articles.description}
					<p>Prix : ${articles.prixInitial} Points</p>
							<p>Fin de l'enchère : ${articles.dateFinEnchere}</p>
							<p>Vendeur : ${articles.noUtilisateur}</p>
							<p>cat : ${articles.noCategorie}</p>
						</c:forEach>

					</c:when>
					<c:when test="${Cat == '0'}">
						<c:choose>
							<c:when test="${empty articles }">
								<p>Il n'y as pas d'enchère de ce type en cours</p>
							</c:when>
							<c:otherwise>
								<c:forEach var="articles" items="${articles}">
					${articles.nom} ${articles.description}
					<p>Prix : ${articles.prixInitial} Points</p>
									<p>Fin de l'enchère : ${articles.dateFinEnchere}</p>
									<p>Vendeur : ${articles.noUtilisateur}</p>
									<p>cat : ${articles.noCategorie}</p>
								</c:forEach>
							</c:otherwise>
						</c:choose>
					</c:when>
					<c:when test="${Cat == '1' }">
						<c:choose>
							<c:when test="${empty cateNum }">
								<p>Il n'y as pas d'enchère de ce type en cours</p>
							</c:when>
							<c:otherwise>
								<c:forEach var="cateNum" items="${cateNum}">
					${cateNum.nom} ${cateNum.description}
					<p>Prix : ${cateNum.prixInitial} Points</p>
									<p>Fin de l'enchère : ${cateNum.dateFinEnchere}</p>
									<p>Vendeur : ${cateNum.noUtilisateur}</p>
									<p>cat : ${cateNum.noCategorie}</p>
								</c:forEach>
							</c:otherwise>
						</c:choose>
					</c:when>

					<c:when test="${Cat == '2' }">
						<c:choose>
							<c:when test="${empty cateNum}">
								<p>Il n'y as pas d'enchère de ce type en cours</p>
							</c:when>
							<c:otherwise>
								<c:forEach var="cateNum" items="${cateNum}">
					${cateNum.nom} ${cateNum.description}
					<p>Prix : ${cateNum.prixInitial} Points</p>
									<p>Fin de l'enchère : ${cateNum.dateFinEnchere}</p>
									<p>Vendeur : ${cateNum.noUtilisateur}</p>
									<p>cat : ${cateNum.noCategorie}</p>
								</c:forEach>
							</c:otherwise>
						</c:choose>
					</c:when>

					<c:when test="${Cat == '3' }">
						<c:choose>
							<c:when test="${empty cateNum }">
								<p>Il n'y as pas d'enchère de ce type en cours</p>
							</c:when>
							<c:otherwise>
								<c:forEach var="cateNum" items="${cateNum}">
					${cateNum.nom} ${cateNum.description}
					<p>Prix : ${cateNum.prixInitial} Points</p>
									<p>Fin de l'enchère : ${cateNum.dateFinEnchere}</p>
									<p>Vendeur : ${cateNum.noUtilisateur}</p>
									<p>cat : ${cateNum.noCategorie}</p>
								</c:forEach>
							</c:otherwise>
						</c:choose>
					</c:when>
					<c:when test="${Cat == '4' }">
						<c:choose>
							<c:when test="${empty cateNum }">
								<p>Il n'y as pas d'enchère de ce type en cours</p>
							</c:when>
							<c:otherwise>
								<c:forEach var="cateNum" items="${cateNum}">
					${cateNum.nom} ${cateNum.description}
					<p>Prix : ${cateNum.prixInitial} Points</p>
									<p>Fin de l'enchère : ${cateNum.dateFinEnchere}</p>
									<p>Vendeur : ${cateNum.noUtilisateur}</p>
									<p>cat : ${cateNum.noCategorie}</p>
								</c:forEach>
							</c:otherwise>
						</c:choose>
					</c:when>

					<c:when test="${fn:contains(articles,search)}">
						<c:forEach var="cateNum" items="${cateNum}">
					${cateNum.nom} ${cateNum.description}
					<p>Prix : ${cateNum.prixInitial} Points</p>
							<p>Fin de l'enchère : ${cateNum.dateFinEnchere}</p>
							<p>Vendeur : ${cateNum.noUtilisateur}</p>
							<p>cat : ${cateNum.noCategorie}</p>
						</c:forEach>
					</c:when>>
				</c:choose>
			</div>

		</div>
	</div>

	<%@include file="/WEB-INF/template/script.html"%>

</body>
</html>