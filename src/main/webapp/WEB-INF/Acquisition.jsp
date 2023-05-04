<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<link href="styles/style.css" rel="stylesheet" type="text/css">
<head>
<meta charset="ISO-8859-1">
<jsp:include page="fragments/meta.html"></jsp:include>
<title>Acquisition</title>
</head>
<body>
	<h3>ENI-Enchères</h3>
	
	<div id="Titre-Centre">Vous avez remporté la vente</div>
	
		<div id = "Acquisition-Image">
	<img></img>
	</div>
	
	<div id = "Acquisition-Info">
	<!--Nom de l'article -->
	
	<br>
	Description : <!-- Description de l'article -->
	<br>

	Meilleure offre : <!-- Meilleur offre -->
	<br>

	Retrait : <!-- adresse -->
	<br>
	Vendeur : <!-- pseudo -->
	<br>
	Tel : <!-- Tel -->
	<br>
	
	<button id = "Acquisition-Back" onclick = "window.location.href = '${pageContext.request.contextPath}/ListeEncheres'">Back</button>
	</div>
	
	

</body>
</html>