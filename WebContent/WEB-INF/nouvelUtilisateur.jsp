<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
		<%@include file="/WEB-INF/template/head.html"%>
<body>
		<%@include file="/WEB-INF/template/nav.html"%>

	<div class="container">
		<div class="col-12">
			<h2 class="my-5 text-center">Nouveau profil</h2>
			
        <div class="col-md-10 mx-auto">
            <form>
                <div class="form-group row">
                    <div class="col-sm-6">
                        <label for="pseudo">Pseudo</label>
                        <input type="text" class="form-control" id="pseudo" placeholder="Pseudo" required>
                    </div>
                    <div class="col-sm-6">
                        <label for="nom">Nom</label>
                        <input type="text" class="form-control" id="nom" placeholder="Nom" required>
                    </div>
                </div>
                <div class="form-group row">
                    <div class="col-sm-6">
                        <label for="prenom">Prénom</label>
                        <input type="text" class="form-control" id="prenom" placeholder="Prénom" required>
                    </div>
                    <div class="col-sm-6">
                        <label for="email">Email</label>
                        <input type="email" class="form-control" id="email" placeholder="Email" required>
                    </div>
                </div>
                <div class="form-group row">
                    <div class="col-sm-6">
                        <label for="telephone">Téléphone</label>
                        <input type="tel" class="form-control" id="telephone" placeholder="Téléphone" required>
                    </div>
                </div>
                <div class="form-group row">
                   <div class="col-sm-6">
                        <label for="adresse">Adresse</label>
                        <input type="text" class="form-control" id="adresse" placeholder="Adresse" required>
                    </div>
                    <div class="col-sm-3">
                        <label for="codePostal">Code Postal</label>
                        <input type="text" class="form-control" id="codePostal" placeholder="Code Postal" required>
                    </div>
                    <div class="col-sm-3">
                        <label for="ville">Ville</label>
                        <input type="text" class="form-control" id="ville" placeholder="Ville" required>
                    </div>
                </div>
                <div class="form-group row">
                    <div class="col-sm-6">
                        <label for="motDePasse">Mot de passe</label>
                        <input type="password" class="form-control" id="motDePasse" placeholder="Mot de passe" required>
                    </div>
                    <div class="col-sm-6">
                        <label for="confirmationMotDePasse">Confirmation</label>
                        <input type="password" class="form-control" id="confirmationMotDePasse" placeholder="Confirmer le mot de passe" required>
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