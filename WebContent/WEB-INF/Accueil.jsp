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

	<div class="container global col-sm-12">
		<h1 class="my-4 text-center">Liste des enchères</h1>
		<div class="col-lg-8 col-md-4 col-sm-6 portfolio-item formPlacement">

			<form action="./AccueilServlet" class="formSearch" method="post">
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
					<!-- Si l'utilisateur n'est pas connecte, il ne pourra pas clique sur la checkbox, sinon il pourra cliquer et voirs les enchère qui lui appartiennent -->
					<c:choose>
						<c:when test="${utilisateurEnSession == null}">
							<label>Voir mes ventes en cours : </label>
							<input type="checkbox" id="voirAnnonce" name="voirAnnonce"
								disabled="disabled">
						</c:when>
						<c:otherwise>
							<label>Voir mes ventes en cours : </label>
							<input type="checkbox" id="voirAnnonce" name="voirAnnonce">
						</c:otherwise>
					</c:choose>
				</div>
				<input class="btn btn-primary" type="submit" value="Rechercher">

			</form>
		</div>

		<div
			class="container articleContenus col-lg-6 col-md-4 col-sm-6 portfolio-item">
			<c:choose>
				<%-- Si la checkbox est coche au moment du submit, on va récupere la liste des enchere du user connecte  --%>
				<c:when test="${mesAnnonces == 'on' }">
					<c:forEach var="articleIdUser" items="${articleIdUser}">
						<c:choose>
							<%-- Si le user est pas connecte, et qu'il clique pour voir un article il est redirige vers la page de connection --%>
							<c:when test="${utilisateurEnSession == null}">
								<p>Vous n'etes pas connecte !</p>
							</c:when>
							<c:otherwise>
								<%-- Si le user est connecté il est redirigé vers la page de description de l'article ou il pourra faire une enchere --%>
								<a class="lienEnchere"
									href="<%=application.getContextPath()%>/DetailVenteServlet?a=${articleIdUser.noArticle}">
									<div class="card h-100 articleCase">
										${articleIdUser.nom}
										<p>Prix : ${articleIdUser.prixInitial} Points</p>
										<p>Fin de l'enchère : ${articleIdUser.dateFinEnchere}</p>
										<p>Vendeur : ${articleIdUser.pseudoUtilisateur}</p>
									</div>
								</a>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</c:when>
				<%-- Test quand on cherche par mot cle, si le nom de l'article est present on l'affiche sinon on affiche un message --%>
				<c:when test="${not empty search}">
					<c:choose>
						<c:when test="${fn:contains(nameArticle,search)}">
							<c:forEach var="nameArticle" items="${nameArticle}">
								<c:choose>
									<%-- Si le user est pas connecte, et qu'il clique pour voir un article il est redirige vers la page de connection --%>
									<c:when test="${utilisateurEnSession == null}">
										<a class="lienEnchere"
											href="<%=application.getContextPath()%>/ConnectionServlet">
											<div class="card h-100 articleCase">
												${nameArticle.nom}
												<p>Prix : ${nameArticle.prixInitial} Points</p>
												<p>Fin de l'enchère : ${nameArticle.dateFinEnchere}</p>
												<p>Vendeur : ${nameArticle.pseudoUtilisateur}</p>
											</div>
										</a>
									</c:when>
									<c:otherwise>
										<%-- Si le user est connecté il est redirigé vers la page de description de l'article ou il pourra faire une enchere --%>
										<a class="lienEnchere"
											href="<%=application.getContextPath()%>/DetailVenteServlet?a=${nameArticle.noArticle}">
											<div class="card h-100 articleCase">
												${nameArticle.nom}
												<p>Prix : ${nameArticle.prixInitial} Points</p>
												<p>Fin de l'enchère : ${nameArticle.dateFinEnchere}</p>
												<p>Vendeur : ${nameArticle.pseudoUtilisateur}</p>
											</div>
										</a>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</c:when>
						<c:when test="${!fn:contains(nameArticle,search)}">
							<p>Pas d'enchère avec ce produit en cours</p>
						</c:when>
					</c:choose>
				</c:when>
				<%-- En fonction du numéro de catégorie on recupere les article avec ce meme numero, null = page de base, 0=tout les articles 1=informatique --%>
				<c:when test="${Cat == null }">
					<c:forEach var="articles" items="${articles}">
						<c:choose>
							<c:when test="${utilisateurEnSession == null}">
								<a class="lienEnchere"
									href="<%=application.getContextPath()%>/ConnectionServlet">
									<div class="card h-100 articleCase">
										${articles.nom}
										<p>Prix : ${articles.prixInitial} Points</p>
										<p>Fin de l'enchère : ${articles.dateFinEnchere}</p>
										<p>Vendeur : ${articles.pseudoUtilisateur}</p>
									</div>
								</a>
							</c:when>
							<c:otherwise>
								<a class="lienEnchere"
									href="<%=application.getContextPath()%>/DetailVenteServlet?a=${articles.noArticle}">

									<div class="card h-100 articleCase">

										${articles.nom}
										<p>Prix : ${articles.prixInitial} Points</p>
										<p>Fin de l'enchère : ${articles.dateFinEnchere}</p>
										<p>Vendeur : ${articles.pseudoUtilisateur}</p>
									</div>
								</a>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</c:when>
				<c:when test="${Cat == '0' && empty search}">
					<c:choose>
						<c:when test="${empty articles }">
							<p>Il n'y as pas d'enchère de ce type en cours</p>
						</c:when>
						<c:otherwise>
							<c:forEach var="articles" items="${articles}">
								<c:choose>
									<c:when test="${utilisateurEnSession == null}">
										<a class="lienEnchere"
											href="<%=application.getContextPath()%>/ConnectionServlet">
											<div class="card h-100 articleCase">
												${articles.nom}
												<p>Prix : ${articles.prixInitial} Points</p>
												<p>Fin de l'enchère : ${articles.dateFinEnchere}</p>
												<p>Vendeur : ${articles.pseudoUtilisateur}</p>
											</div>
										</a>
									</c:when>
									<c:otherwise>
										<a class="lienEnchere"
											href="<%=application.getContextPath()%>/DetailVenteServlet?a=${articles.noArticle}">

											<div class="card h-100 articleCase">
												${articles.nom}
												<p>Prix : ${articles.prixInitial} Points</p>
												<p>Fin de l'enchère : ${articles.dateFinEnchere}</p>
												<p>Vendeur : ${articles.pseudoUtilisateur}</p>
											</div>
										</a>
									</c:otherwise>
								</c:choose>
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
								<c:choose>
									<c:when test="${utilisateurEnSession == null}">
										<a class="lienEnchere"
											href="<%=application.getContextPath()%>/ConnectionServlet">
											<div class="card h-100 articleCase">
												${cateNum.nom}
												<p>Prix : ${cateNum.prixInitial} Points</p>
												<p>Fin de l'enchère : ${cateNum.dateFinEnchere}</p>
												<p>Vendeur : ${cateNum.pseudoUtilisateur}</p>
											</div>
										</a>
									</c:when>
									<c:otherwise>
										<a class="lienEnchere"
											href="<%=application.getContextPath()%>/DetailVenteServlet?a=${cateNum.noArticle}">

											<div class="card h-100 articleCase">
												${cateNum.nom}
												<p>Prix : ${cateNum.prixInitial} Points</p>
												<p>Fin de l'enchère : ${cateNum.dateFinEnchere}</p>
												<p>Vendeur : ${cateNum.pseudoUtilisateur}</p>
											</div>
										</a>
									</c:otherwise>
								</c:choose>
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
								<c:choose>
									<c:when test="${utilisateurEnSession == null}">
										<a class="lienEnchere"
											href="<%=application.getContextPath()%>/ConnectionServlet">
											<div class="card h-100 articleCase">
												${cateNum.nom}
												<p>Prix : ${cateNum.prixInitial} Points</p>
												<p>Fin de l'enchère : ${cateNum.dateFinEnchere}</p>
												<p>Vendeur : ${cateNum.pseudoUtilisateur}</p>
											</div>
										</a>
									</c:when>
									<c:otherwise>
										<a class="lienEnchere"
											href="<%=application.getContextPath()%>/DetailVenteServlet?a=${cateNum.noArticle}">

											<div class="card h-100 articleCase">
												${cateNum.nom}
												<p>Prix : ${cateNum.prixInitial} Points</p>
												<p>Fin de l'enchère : ${cateNum.dateFinEnchere}</p>
												<p>Vendeur : ${cateNum.pseudoUtilisateur}</p>
											</div>
										</a>
									</c:otherwise>
								</c:choose>
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
								<c:choose>
									<c:when test="${utilisateurEnSession == null}">
										<a class="lienEnchere"
											href="<%=application.getContextPath()%>/ConnectionServlet">
											<div class="card h-100 articleCase">
												${cateNum.nom}
												<p>Prix : ${cateNum.prixInitial} Points</p>
												<p>Fin de l'enchère : ${cateNum.dateFinEnchere}</p>
												<p>Vendeur : ${cateNum.pseudoUtilisateur}</p>
											</div>
										</a>
									</c:when>
									<c:otherwise>
										<a class="lienEnchere"
											href="<%=application.getContextPath()%>/DetailVenteServlet?a=${cateNum.noArticle}">

											<div class="card h-100 articleCase">
												${cateNum.nom}
												<p>Prix : ${cateNum.prixInitial} Points</p>
												<p>Fin de l'enchère : ${cateNum.dateFinEnchere}</p>
												<p>Vendeur : ${cateNum.pseudoUtilisateur}</p>
											</div>
										</a>
									</c:otherwise>
								</c:choose>
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
								<c:choose>
									<c:when test="${utilisateurEnSession == null}">
										<a class="lienEnchere"
											href="<%=application.getContextPath()%>/ConnectionServlet">
											<div class="card h-100 articleCase">
												${cateNum.nom}
												<p>Prix : ${cateNum.prixInitial} Points</p>
												<p>Fin de l'enchère : ${cateNum.dateFinEnchere}</p>
												<p>Vendeur : ${cateNum.pseudoUtilisateur}</p>
											</div>
										</a>
									</c:when>
									<c:otherwise>
										<a class="lienEnchere"
											href="<%=application.getContextPath()%>/DetailVenteServlet?a=${cateNum.noArticle}">

											<div class="card h-100 articleCase">
												${cateNum.nom}
												<p>Prix : ${cateNum.prixInitial} Points</p>
												<p>Fin de l'enchère : ${cateNum.dateFinEnchere}</p>
												<p>Vendeur : ${cateNum.pseudoUtilisateur}</p>
											</div>
										</a>
									</c:otherwise>
								</c:choose>
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