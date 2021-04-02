<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<%@include file="/WEB-INF/template/head.html"%>
<body>
	<%@include file="/WEB-INF/template/nav.jsp"%>

	<div class="container">
		<div class="col-12">
			<h2 class="my-5 text-center">Connexion</h2>

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
			<div class="col-md-6 mx-auto">
				<form action="./ConnectionServlet" method="post">
					<div class="form-group row">
						<div class="col-sm-12">
							<label for="pseudo">Pseudo ou email :</label> <input type="text"
								class="form-control" id="pseudo" name="pseudo"
								placeholder="Pseudo" required
								value="<%Cookie[] cookiesTab = request.getCookies();
										if (cookiesTab != null) {
											for (Cookie cookie : cookiesTab) {
												if (cookie.getName().equals("infoUtilisateurPseudo")) {
													out.println(cookie.getValue());
												}
											}
}%>">

						</div>
					</div>
					<div class="form-group row">
						<div class="col-sm-12">
							<label for="motDePasse">Mot de passe :</label> <input
								type="password" class="form-control" id="motDePasse"
								name="motDePasse" placeholder="Mot de passe" required
								value="<%if (cookiesTab != null) {
	for (Cookie cookie : cookiesTab) {
		if (cookie.getName().equals("infoUtilisateurMotDePasse")) {
			out.println(cookie.getValue());
		}
	}
}%>">
						</div>
					</div>
					<div class="text-center mb-1">
						<button type="submit" class="btn btn-outline-dark">Se
							connecter</button>
					</div>
					<div class="form-check text-center">
						<input class="form-check-input" type="checkbox"
							name="cookieConnexion" id="acceptCookieConnexion"> <label
							class="form-check-label" for="acceptCookieConnexion">Se
							souvenir de moi</label>
					</div>
				</form>
				<div class="text-center">
					<a class="btn btn-outline-secondary mt-3"
						href="./NouvelUtilisateurServlet" type="button">Créer un
						compte</a>
				</div>
			</div>
		</div>
	</div>


	<!-- Bootstrap core JavaScript -->
	<%@include file="/WEB-INF/template/script.html"%>
</body>
</html>