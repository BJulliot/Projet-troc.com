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
		
	<!-- Bootstrap core JavaScript -->
	<%@include file="/WEB-INF/template/script.html"%>
</body>
</html>