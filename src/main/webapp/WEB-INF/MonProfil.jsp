<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<jsp:include page="fragments/meta.html"></jsp:include>
<c:if test="${connected == true }">
<jsp:include page="fragments/HeaderConnected.jsp"></jsp:include>
</c:if>
<c:if test="${connected == false }">
<jsp:include page="fragments/HeaderDisconnected.jsp"></jsp:include>
</c:if>
<title>Mon Profil</title>
</head>
<body>

	<!-- Afficher les infos de l'utilisateurs -->
	<div style ="padding-left:25px;">
		Pseudo : ${Utilisateur.pseudo}<br> 
		Nom : ${Utilisateur.nom}<br>
		Prénom : ${Utilisateur.prenom}<br> 
		Email : ${Utilisateur.email}<br>
		Téléphone : ${Utilisateur.telephone}<br> 
		Rue : ${Utilisateur.rue}<br>
		Code postal : ${Utilisateur.code_postal}<br> 
		Ville : ${Utilisateur.ville} <br>
	</div>
	<% if((boolean)(request.getAttribute("MonProfil")))
	{
		%>
	<form method = "get" action = "infoProfil">
		<button  style ="margin-left:25px;">Modifier</button>
	</form>
		<%}%>

</body>
</html>