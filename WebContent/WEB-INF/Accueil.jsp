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
		<h1 class="my-4 text-center">Liste des ench�res</h1>
		<div class="col-lg-6 col-md-4 col-sm-6 portfolio-item">
			<div class="col-lg-8 col-md-4 col-sm-6 portfolio-item">
				<h2 class="my-4">Filtres :</h2>
				<form action="./AccueilServlet" method="get">
					<div class="col-lg-12 col-md-4 col-sm-6 portfolio-item">
						<input class="search-bar" type="search" id="search" name="search"
							placeholder="Recherche une ench�re">
					</div>
					<div class="col-lg-12 col-md-4 col-sm-6 portfolio-item">
						<select class="form-select" id="Categories" name="Categories"
							aria-label="Default select example">
							<option value="0" Selected>Toutes les cat�gories</option>
							<c:forEach var="categories" items="${categories}">
								<option value="${categories.noCategorie}">${categories.libelle}</option>
							</c:forEach>
						</select>
					</div>
					<input class="btn btn-primary" type="submit">
				</form>
			</div>
			<c:choose>
				<c:when test="${not empty search}">
					<c:choose>
						<c:when test="${fn:contains(nameArticle,search)}">
							<c:forEach var="nameArticle" items="${nameArticle}">
								<div class="card h-100">

									${nameArticle.nom} ${nameArticle.description}
									<p>Prix : ${nameArticle.prixInitial} Points</p>
									<p>Fin de l'ench�re : ${nameArticle.dateFinEnchere}</p>
									<p>Vendeur : ${nameArticle.noUtilisateur}</p>
								</div>
							</c:forEach>
						</c:when>
						<c:when test="${!fn:contains(nameArticle,search)}">
							<p>Pas d'ench�re avec ce produit en cours</p>
						</c:when>
					</c:choose>
				</c:when>
				<c:when test="${Cat == null }">
					<c:forEach var="articles" items="${articles}">
						<div class="card h-100">
							${articles.nom} ${articles.description}
							<p>Prix : ${articles.prixInitial} Points</p>
							<p>Fin de l'ench�re : ${articles.dateFinEnchere}</p>
							<p>Vendeur : ${articles.noUtilisateur}</p>
						</div>
					</c:forEach>
				</c:when>
				<c:when test="${Cat == '0' && empty search}">
					<c:choose>
						<c:when test="${empty articles }">
							<p>Il n'y as pas d'ench�re de ce type en cours</p>
						</c:when>
						<c:otherwise>
							<c:forEach var="articles" items="${articles}">
								<div class="card h-100">
									${articles.nom} ${articles.description}
									<p>Prix : ${articles.prixInitial} Points</p>
									<p>Fin de l'ench�re : ${articles.dateFinEnchere}</p>
									<p>Vendeur : ${articles.noUtilisateur}</p>
								</div>
							</c:forEach>
						</c:otherwise>
					</c:choose>
				</c:when>
				<c:when test="${Cat == '1' && empty search }">
					<c:choose>
						<c:when test="${empty cateNum }">
							<p>Il n'y as pas d'ench�re de ce type en cours</p>
						</c:when>
						<c:otherwise>
							<c:forEach var="cateNum" items="${cateNum}">
								<div class="card h-100">
									${cateNum.nom} ${cateNum.description}
									<p>Prix : ${cateNum.prixInitial} Points</p>
									<p>Fin de l'ench�re : ${cateNum.dateFinEnchere}</p>
									<p>Vendeur : ${cateNum.noUtilisateur}</p>
								</div>
							</c:forEach>
						</c:otherwise>
					</c:choose>
				</c:when>
				<c:when test="${Cat == '2' && empty search }">
					<c:choose>
						<c:when test="${empty cateNum}">
							<p>Il n'y as pas d'ench�re de ce type en cours</p>
						</c:when>
						<c:otherwise>
							<c:forEach var="cateNum" items="${cateNum}">
								<div class="card h-100">
									${cateNum.nom} ${cateNum.description}
									<p>Prix : ${cateNum.prixInitial} Points</p>
									<p>Fin de l'ench�re : ${cateNum.dateFinEnchere}</p>
									<p>Vendeur : ${cateNum.noUtilisateur}</p>
								</div>
							</c:forEach>
						</c:otherwise>
					</c:choose>
				</c:when>
				<c:when test="${Cat == '3' && empty search }">
					<c:choose>
						<c:when test="${empty cateNum }">
							<p>Il n'y as pas d'ench�re de ce type en cours</p>
						</c:when>
						<c:otherwise>
							<c:forEach var="cateNum" items="${cateNum}">
								<div class="card h-100">
									${cateNum.nom} ${cateNum.description}
									<p>Prix : ${cateNum.prixInitial} Points</p>
									<p>Fin de l'ench�re : ${cateNum.dateFinEnchere}</p>
									<p>Vendeur : ${cateNum.noUtilisateur}</p>
								</div>
							</c:forEach>
						</c:otherwise>
					</c:choose>
				</c:when>
				<c:when test="${Cat == '4' && empty search }">
					<c:choose>
						<c:when test="${empty cateNum }">
							<p>Il n'y as pas d'ench�re de ce type en cours</p>
						</c:when>
						<c:otherwise>
							<c:forEach var="cateNum" items="${cateNum}">
								<div class="card h-100">
									${cateNum.nom} ${cateNum.description}
									<p>Prix : ${cateNum.prixInitial} Points</p>
									<p>Fin de l'ench�re : ${cateNum.dateFinEnchere}</p>
									<p>Vendeur : ${cateNum.noUtilisateur}</p>
								</div>
							</c:forEach>
						</c:otherwise>
					</c:choose>
				</c:when>
			</c:choose>
		</div>
	</div>
	<%@include file="/WEB-INF/template/script.html"%>
</body>
</html>