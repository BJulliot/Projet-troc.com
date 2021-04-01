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
			<h2 class="my-5 text-center">Profil</h2>
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
            <table class="table table-striped table-hover">
				<thead>
				    <tr>
				      <th scope="col">Pseudo</th>
				      <th scope="col">${utilisateurEnSession.pseudo}</th>
					</tr>
				</thead>
				<tbody>
					<tr>
				    	<td>Nom :</td>
				    	<td>${utilisateurEnSession.nom}</td>
				    </tr>
				    <tr>
						<td>Prenom :</td>
						<td>${utilisateurEnSession.prenom}</td>
				    </tr>
				    <tr>
						<td>Email :</td>
						<td>${utilisateurEnSession.email}</td>
				    </tr>
				    <tr>
						<td>Telephone :</td>
						<td>${utilisateurEnSession.telephone}</td>
				    </tr>
				    <tr>
						<td>Adresse :</td>
						<td>${utilisateurEnSession.rue}</td>
				    </tr>
				    <tr>
						<td>Code postal :</td>
						<td>${utilisateurEnSession.codePostal}</td>
				    </tr>
				    <tr>
						<td>Ville :</td>
						<td>${utilisateurEnSession.ville}</td>
				    </tr>
				  </tbody>
			</table>
			
			<div class="container">
				<div class="row">
			    <div class="col-12 col-md-6">
			       <form action="./ModifierUtilisateurServlet" method="get">
						<div class="text-center">
							<button type="submit" class="btn btn-outline-secondary">Modifier compte</button>
						</div>
		            </form>
			    </div>
			    <div class="col-12 col-md-6">
			    	<form action="./SupprimerUtilisateurServlet" method="post">
						<div class="text-center">
							<button type="submit" class="btn btn-outline-danger" onclick="return confirm('Confirmer la suppression du compte utilisateur ${utilisateurEnSession.pseudo}?')"
							>Supprimer</button>
			            </div>
					</form>
			    </div>
			  </div>
			</div>
		</div>
</div>
</body>
</html>