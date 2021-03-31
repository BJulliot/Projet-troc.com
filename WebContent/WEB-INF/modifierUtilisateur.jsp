<%@page import="fr.eni.projet.troc.bo.Utilisateur"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
		<%@include file="/WEB-INF/template/head.html"%>
<body>
		<%@include file="/WEB-INF/template/nav.jsp"%>

	<div class="container">
		<div class="col-12">
			<h2 class="my-5 text-center">Modifier votre profil</h2>
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
			
        <div class="col-md-10 mx-auto">
            <form action="./ModifierUtilisateurServlet" method="post">
                <div class="form-group row">
                    <div class="col-sm-6">
                        <label for="pseudo">Pseudo</label>
                        <input type="text" class="form-control" id="pseudo" name="pseudo" placeholder="Pseudo" value="${utilisateurEnSession.pseudo}" required>
                    </div>
                    <div class="col-sm-6">
                        <label for="nom">Nom</label>
                        <input type="text" class="form-control" id="nom" name="nom" placeholder="Nom" value="${utilisateurEnSession.nom}" required>
                    </div>
                </div>
                <div class="form-group row">
                    <div class="col-sm-6">
                        <label for="prenom">Prénom</label>
                        <input type="text" class="form-control" id="prenom" name="prenom" placeholder="Prénom" value="${utilisateurEnSession.prenom}" required>
                    </div>
                    <div class="col-sm-6">
                        <label for="email">Email</label>
                        <input type="email" class="form-control" id="email" name="email" placeholder="Email" value="${utilisateurEnSession.email}" required>
                    </div>
                </div>
                <div class="form-group row">
                    <div class="col-sm-6">
                        <label for="telephone">Téléphone</label>
                        <input type="tel" class="form-control" id="telephone" name="telephone" placeholder="Téléphone" value="${utilisateurEnSession.telephone}">
                    </div>
                </div>
                <div class="form-group row">
                	<div class="col-sm-6">
                        <label for="rue">Adresse</label>
                        <input type="text" class="form-control" id="rue" name="rue" placeholder="Adresse" value="${utilisateurEnSession.rue}" required>
                    </div>
                    <div class="col-sm-3">
                        <label for="codePostal">Code Postal</label>
                        <input type="text" class="form-control" id="codePostal" name="codePostal" placeholder="Code Postal" value="${utilisateurEnSession.codePostal}"required>
                    </div>
                    <div class="col-sm-3">
                        <label for="ville">Ville</label>
                        <input type="text" class="form-control" id="ville" name="ville" placeholder="Ville" value="${utilisateurEnSession.ville}" required>
                    </div>
                </div>
                <div class=" p-3 mb-2 bg-secondary">
                <div class="form-group row">
                    <div class="col-sm-6">
                        <label class="text-white" for="ancienMotDePasse">Mot de passe actuel</label>
                        <input type="password" class="form-control" id="ancienMotDePasse" name="ancienMotDePasse" placeholder="Ancien mot de passe" required>
                    </div>
                </div>
                <div class="form-group row">
                    <div class="col-sm-6">
                        <label class="text-white" for="nouveauMotDePasse">Nouveau mot de passe</label>
                        <input type="password" class="form-control" id="nouveauMotDePasse" name="nouveauMotDePasse" placeholder="Nouveau mot de passe" required>
                    </div>
                    <div class="col-sm-6">
                        <label class="text-white" for="confirmationMotDePasse">Confirmation</label>
                        <input type="password" class="form-control" id="confirmationMotDePasse" name="confirmationMotDePasse" placeholder="Confirmer le mot de passe" required>
                    </div>
                </div>
                </div>
                
                <div class="form-group mb-2">
                	<button type="" class="btn btn-secondary">Crédit : ${utilisateurEnSession.credit}</button>
                </div>
				
                <div class="text-center mb-2">
	                <button type="submit" class="btn btn-secondary">Enregistrer modifications</button>
	                <button type="button" href="./AccueilServlet" class="btn btn-secondary">Annuler</button>
            	</div>
            </form>
        </div>
    </div>
</div>

</body>
</html>