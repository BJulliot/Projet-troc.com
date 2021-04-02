<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>


<!DOCTYPE html>
<html>
<%@include file="/WEB-INF/template/head.html"%>
<body>
	<%@include file="/WEB-INF/template/nav.jsp"%>

	<div class="container global">
		<h1 class="my-4 text-center">Liste des enchères</h1>
		<div class="col-lg-8 col-md-4 col-sm-6 portfolio-item formPlacement">

			<form action="./AccueilServlet" class="formSearch" method="get">
				<div class="col-lg-12 col-md-4 col-sm-6 portfolio-item">
					<h3 class="my-4">Filtres :</h3>
					<input class="search-bar" type="search" id="search" name="search"
						placeholder="Rechercher une enchère">
				</div>
				<div class="col-lg-12 col-md-4 col-sm-6 portfolio-item">
					<h3 class="my-4">Catégorie :</h3>
					<select class="form-select" id="Categories" name="Categories"
						aria-label="Default select example">
						<option value="0" Selected>Toutes les catégories</option>
						<c:forEach var="categories" items="${categories}">
							<option value="${categories.noCategorie}">${categories.libelle}</option>
						</c:forEach>
					</select>
				</div>
				<input class="btn btn-primary" type="submit" value="Rechercher">
			</form>
		</div>

		<div
			class="container articleContenus col-lg-6 col-md-4 col-sm-6 portfolio-item">
			<c:choose>
				<c:when test="${not empty search}">
					<c:choose>
						<c:when test="${fn:contains(nameArticle,search)}">
							<c:forEach var="nameArticle" items="${nameArticle}">
								<a class="lienEnchere"
									href="<%=application.getContextPath()%>/DetailVenteServlet?a=${nameArticle.noArticle}">
									<div class="card h-100 articleCase">
										${nameArticle.nom}
										<p>Prix : ${nameArticle.prixInitial} Points</p>
										<p>Fin de l'enchère : ${nameArticle.dateFinEnchere}</p>
										<p>Vendeur : ${nameArticle.pseudoUtilisateur}</p>
									</div>
								</a>
							</c:forEach>
						</c:when>
						<c:when test="${!fn:contains(nameArticle,search)}">
							<p>Pas d'enchère avec ce produit en cours</p>
						</c:when>
					</c:choose>
				</c:when>
				<c:when test="${Cat == null }">
					<c:forEach var="articles" items="${articles}">
						<a class="lienEnchere"
							href="<%=application.getContextPath()%>/DetailVenteServlet?a=${articles.noArticle}">

							<div class="card h-100 articleCase">

								${articles.nom}
								<p>Prix : ${articles.prixInitial} Points</p>
								<p>Fin de l'enchère : ${articles.dateFinEnchere}</p>
								<p>Vendeur : ${articles.pseudoUtilisateur}</p>
							</div>
						</a>
					</c:forEach>
				</c:when>
				<c:when test="${Cat == '0' && empty search}">
					<c:choose>
						<c:when test="${empty articles }">
							<p>Il n'y as pas d'enchère de ce type en cours</p>
						</c:when>
						<c:otherwise>
							<c:forEach var="articles" items="${articles}">
								<a class="lienEnchere"
									href="<%=application.getContextPath()%>/DetailVenteServlet?a=${articles.noArticle}">

									<div class="card h-100 articleCase">
										${articles.nom}
										<p>Prix : ${articles.prixInitial} Points</p>
										<p>Fin de l'enchère : ${articles.dateFinEnchere}</p>
										<p>Vendeur : ${articles.pseudoUtilisateur}</p>
									</div>
								</a>
							</c:forEach>
						</c:otherwise>
					</c:choose>
				</c:when>
				<c:when test="${Cat == '1' && empty search }">
					<c:choose>
						<c:when test="${empty cateNum }">
							<p>Il n'y as pas d'enchère de ce type en cours</p>
						</c:when>
						<c:otherwise>
							<c:forEach var="cateNum" items="${cateNum}">
								<a class="lienEnchere"
									href="<%=application.getContextPath()%>/DetailVenteServlet?a=${cateNum.noArticle}">

									<div class="card h-100 articleCase">
										${cateNum.nom}
										<p>Prix : ${cateNum.prixInitial} Points</p>
										<p>Fin de l'enchère : ${cateNum.dateFinEnchere}</p>
										<p>Vendeur : ${cateNum.pseudoUtilisateur}</p>
									</div>
								</a>
							</c:forEach>
						</c:otherwise>
					</c:choose>
				</c:when>
				<c:when test="${Cat == '2' && empty search }">
					<c:choose>
						<c:when test="${empty cateNum}">
							<p>Il n'y as pas d'enchère de ce type en cours</p>
						</c:when>
						<c:otherwise>
							<c:forEach var="cateNum" items="${cateNum}">
								<a class="lienEnchere"
									href="<%=application.getContextPath()%>/DetailVenteServlet?a=${cateNum.noArticle}">

									<div class="card h-100 articleCase">
										${cateNum.nom}
										<p>Prix : ${cateNum.prixInitial} Points</p>
										<p>Fin de l'enchère : ${cateNum.dateFinEnchere}</p>
										<p>Vendeur : ${cateNum.pseudoUtilisateur}</p>
									</div>
								</a>
							</c:forEach>
						</c:otherwise>
					</c:choose>
				</c:when>
				<c:when test="${Cat == '3' && empty search }">
					<c:choose>
						<c:when test="${empty cateNum }">
							<p>Il n'y as pas d'enchère de ce type en cours</p>
						</c:when>
						<c:otherwise>
							<c:forEach var="cateNum" items="${cateNum}">
								<a class="lienEnchere"
									href="<%=application.getContextPath()%>/DetailVenteServlet?a=${cateNum.noArticle}">

									<div class="card h-100 articleCase">
										${cateNum.nom}
										<p>Prix : ${cateNum.prixInitial} Points</p>
										<p>Fin de l'enchère : ${cateNum.dateFinEnchere}</p>
										<p>Vendeur : ${cateNum.pseudoUtilisateur}</p>
									</div>
								</a>
							</c:forEach>
						</c:otherwise>
					</c:choose>
				</c:when>
				<c:when test="${Cat == '4' && empty search }">
					<c:choose>
						<c:when test="${empty cateNum }">
							<p>Il n'y as pas d'enchère de ce type en cours</p>
						</c:when>
						<c:otherwise>
							<c:forEach var="cateNum" items="${cateNum}">
								<a class="lienEnchere"
									href="<%=application.getContextPath()%>/DetailVenteServlet?a=${cateNum.noArticle}">

									<div class="card h-100 articleCase">
										${cateNum.nom}
										<p>Prix : ${cateNum.prixInitial} Points</p>
										<p>Fin de l'enchère : ${cateNum.dateFinEnchere}</p>
										<p>Vendeur : ${cateNum.pseudoUtilisateur}</p>
									</div>
								</a>
							</c:forEach>
						</c:otherwise>
					</c:choose>
				</c:when>
			</c:choose>
		</div>

	</div>
	<!-- Bootstrap core JavaScript -->
	<%@include file="/WEB-INF/template/script.html"%>
</body>
</html>