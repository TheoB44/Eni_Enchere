<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<jsp:include page="fragments/meta.html"></jsp:include>
<title>Accueil</title>
</head>
<body>
	<h1>ENI-Enchères</h1>

	<div id="Inscription-connexion" href="">S'inscrire - Se connecter</div>
	
	
	<div id="Titre-Centre">Liste des enchères</div>
	
	
	<div>
		Filtres : <br> 
		<input type="text" placeholder=" Le nom de l'article contient"></input>
		<br> 
		<br> Catégorie : <select name="Encheres"
			id="Enchere-select">
			<option value="all">Toutes</option>
			<option value="all">Informatiques</option>
			<option value="all">Ameublement</option>
			<option value="all">Vêtement</option>
			<option value="all">Sport&Loisir</option>
	</div>

	<div id="bouton">
		<button>Rechercher</button>
	</div>

	<div id="Liste-Enchere">Afficher la liste des enchères ici.</div>


</body>
</html>