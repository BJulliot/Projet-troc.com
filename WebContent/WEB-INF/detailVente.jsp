<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<%@include file="/WEB-INF/template/head.html"%>

<body>
	<%@include file="/WEB-INF/template/nav.jsp"%>


	

	<c:forEach var="article" items="${article}">
		<div class="card h-100 articleCase">
			${article.nom}
			<p>Prix : ${article.prixInitial} Points</p>
			<p>Fin de l'enchère : ${article.dateFinEnchere}</p>
			<p>Vendeur : ${article.pseudoUtilisateur}</p>
		</div>

	</c:forEach>

	<%@include file="/WEB-INF/template/script.html"%>
</body>
</html>