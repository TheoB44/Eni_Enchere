<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<jsp:include page="fragments/meta.html"></jsp:include>
<title>Mon Profil</title>
</head>
<body>
	<h1>ENI-Ench�res</h1>

<!-- Afficher les infos de l'utilisateurs -->
	<form action="MonProfil" method="get">
		<div>
			Pseudo : ${Utilisateur.pseudo}<br> 
			Nom : ${Utilisateur.nom}<br> 
			Pr�nom : ${Utilisateur.prenom}<br> 
			Email : ${Utilisateur.email}<br>
			T�l�phone : ${Utilisateur.telephone}<br> 
			Rue : ${Utilisateur.rue}<br> 
			Code postal : ${Utilisateur.code_postal}<br> 
			Ville : ${Utilisateur.ville}
			<br>
		</div>
	</form>
	<c:if test="${MonProfil}">
		<button onclick = "window.location.href = '${pageContext.request.contextPath}/ModifierProfil'">Modifier</button>
	</c:if>
	
</body>
</html>