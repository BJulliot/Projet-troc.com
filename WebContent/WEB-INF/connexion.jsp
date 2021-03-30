<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
		<%@include file="/WEB-INF/template/head.html"%>
<body>
		<%@include file="/WEB-INF/template/nav.html"%>

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
                        <label for="pseudo">Pseudo</label>
                        <input type="text" class="form-control" id="pseudo" name="pseudo" placeholder="Pseudo" required>
                    </div>
                </div>
                <div class="form-group row">
                    <div class="col-sm-12">
                        <label for="motDePasse">Mot de passe</label>
                        <input type="password" class="form-control" id="motDePasse" name="motDePasse" placeholder="Mot de passe" required>
                    </div>
                </div>
                <div class="text-center">
	                <button type="button" href="./AccueilServlet" class="btn btn-outline-secondary">Annuler</button>
					<button type="submit" class="btn btn-outline-dark">Se connecter</button>
            	</div>
            </form>
        </div>
    </div>
</div>


			<!-- Bootstrap core JavaScript -->
		<%@include file="/WEB-INF/template/script.html"%>
</body>
</html>