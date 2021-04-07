<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<%@include file="/WEB-INF/template/head.jsp"%>
<body>
	<%@include file="/WEB-INF/template/nav.jsp"%>

	<div class="container">
		<div class="col-12">
		<!-- gestion des erreurs : -->
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
			<!-- gestion des résuites : -->
			<c:if test="${!empty victories}">
				<div class="row">
					<div class="col-lg-12 col-md-6 col-sm-6 portfolio-item">
						<div class="card h-100">
							<div class="card-body">
								<div class="alert alert-success" role="alert">
									<h2>Well done!</h2>
									<ul>
									<c:forEach var="msg" items="${victories}">
											<h5>Nous venons de vous envoyer un mail pour réinitialiser votre mot de passe.</h5>
										</c:forEach>
									</ul>
								</div>

							</div>
						</div>
					</div>
				</div>
			</c:if>
			
			<h2 class="my-5 text-center">Mot de passe oublié?</h2>
			<h5 class="my-3 text-center">Saisissez votre mail :</h5>
			<div class="col-md-6 mx-auto">
				<form action="./RecupererMotDePasseServlet" method="post">
					<div class="form-group row">
							<label for="email">Email :</label>
							<input type="text" class="form-control" id="email" name="email" placeholder="prenom.nom@nomdedomaine.com" required>
						</div>
				
					<div class="text-center mt-3 mb-1">
						<button type="submit" class="btn btn-outline-dark">Récupérer mon mot de passe</button>
					</div>
				</form>
			</div>
		</div>
	</div>


	<!-- Bootstrap core JavaScript -->
	<%@include file="/WEB-INF/template/script.html"%>
</body>
</html>