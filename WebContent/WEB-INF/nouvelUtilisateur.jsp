<%@page import="fr.eni.projet.troc.bo.Utilisateur"%>
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
			<h2 class="my-5 text-center">Nouveau profil</h2>
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
			
			<%//Récupérer l'attribut userInSession sur la Session
			Utilisateur nouvelUtilisateur = (Utilisateur)session.getAttribute("nouvelUtilisateur");
			%>
        <div class="col-md-10 mx-auto">
            <form action="./NouvelUtilisateurServlet" method="post">
                <div class="form-group row">
                    <div class="col-sm-6">
                        <label for="pseudo">Pseudo</label>
                        <input type="text" class="form-control" id="pseudo" name="pseudo" placeholder="Pseudo" value="${nouvelUtilisateur.pseudo}" required>
                    </div>
                    <div class="col-sm-6">
                        <label for="nom">Nom</label>
                        <input type="text" class="form-control" id="nom" name="nom" placeholder="Nom" value="${nouvelUtilisateur.nom}" required>
                    </div>
                </div>
                <div class="form-group row">
                    <div class="col-sm-6">
                        <label for="prenom">Prénom</label>
                        <input type="text" class="form-control" id="prenom" name="prenom" placeholder="Prénom" value="${nouvelUtilisateur.prenom}" required>
                    </div>
                    <div class="col-sm-6">
                        <label for="email">Email</label>
                        <input type="email" class="form-control" id="email" name="email" placeholder="Email" value="${nouvelUtilisateur.email}" required>
                    </div>
                </div>
                <div class="form-group row">
                    <div class="col-sm-6">
                        <label for="telephone">Téléphone</label>
                        <input type="tel" class="form-control" id="telephone" name="telephone" placeholder="Téléphone" value="${nouvelUtilisateur.telephone}">
                    </div>
                </div>
                <div class="form-group row">
                	<div class="col-sm-6">
                        <label for="rue">Adresse</label>
                        <input type="text" class="form-control" id="rue" name="rue" placeholder="Adresse" value="${nouvelUtilisateur.rue}" required>
                    </div>
                    <div class="col-sm-3">
                        <label for="codePostal">Code Postal</label>
                        <input type="text" class="form-control" id="codePostal" name="codePostal" placeholder="Code Postal" value="${nouvelUtilisateur.codePostal}"required>
                    </div>
                    <div class="col-sm-3">
                        <label for="ville">Ville</label>
                        <input type="text" class="form-control" id="ville" name="ville" placeholder="Ville" value="${nouvelUtilisateur.ville}" required>
                    </div>
                </div>
                <div class="form-group row">
                    <div class="col-sm-6">
                        <label for="motDePasse">Mot de passe</label>
                        <input type="password" class="form-control" id="motDePasse" name="motDePasse" placeholder="Mot de passe" required>
                    </div>
                    <div class="col-sm-6">
                        <label for="confirmationMotDePasse">Confirmation</label>
                        <input type="password" class="form-control" id="confirmationMotDePasse" name="confirmationMotDePasse" placeholder="Confirmer le mot de passe" required>
                    </div>
                </div>
                <div class="text-center">
	                <button type="submit" class="btn btn-secondary">Créer</button>
	                <button type="button" href="index.jsp" class="btn btn-secondary">Annuler</button>
            	</div>
            </form>
        </div>
    </div>
</div>

</body>
</html>