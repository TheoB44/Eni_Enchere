<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<link href="styles/style.css" rel="stylesheet" type="text/css">
<head>
<meta charset="ISO-8859-1">
<jsp:include page="fragments/meta.html"></jsp:include>
<title>Acqu�reur</title>
</head>
<body>
	<h3>ENI-Ench�res</h3>
	
	<div id="Titre-Centre">[Ins�rer nom] a remport� l'ench�re</div>
	
		<div id = "Acquisition-Image">
	<img></img>
	</div>
	
	<div id = "Acquereur-Info">
	<!--Nom de l'article -->
	
	<br>
	Description : <!-- Description de l'article -->
	<br>

	Meilleure offre : <!-- Meilleur offre --> [Montant] par [pseudo du vainqueur]
	<br>
		Mise � prix : <!-- offre de base -->
	<br>
		Fin de l'ench�re : <!-- date -->
	<br>

	Retrait : <!-- adresse -->
	<br>
	Vendeur : <!-- pseudo -->
	<br>
		<button id = "Acquereur-Retrait" href = "">Retrait effectu�</button>
	</div>
	


</body>
</html>