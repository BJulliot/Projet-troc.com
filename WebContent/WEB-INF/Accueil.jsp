<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<%@include file="/WEB-INF/template/head.html"%>
<body>
	<%@include file="/WEB-INF/template/nav.html"%>

	<c:forEach var="articles" items="${articles}">
		<li>${articles}</li>
	</c:forEach>
</body>
</html>