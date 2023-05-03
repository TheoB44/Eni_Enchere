<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>


<link href="styles/style.css" rel="stylesheet" type="text/css">

<head>
<meta charset="ISO-8859-1">
<jsp:include page="fragments/meta.html"></jsp:include>
<title>Accueil</title>
</head>
<body>
	<h3>ENI-Ench�res</h3>

	<div id="Inscription-connexion" ><a href="${pageContext.request.contextPath}/Connexion" >S'inscrire - Se connecter</a></div>
	
	
	<div id="Titre-Centre">Liste des ench�res</div>
	
	
	<div>
		Filtres : <br> 
		<input type="text" placeholder=" Le nom de l'article contient"></input>
		<br> 
		<br> Cat�gorie : <select name="Encheres"
			id="Enchere-select">
			<option value="all">Toutes</option>
			<option value="all">Informatiques</option>
			<option value="all">Ameublement</option>
			<option value="all">V�tement</option>
			<option value="all">Sport&Loisir</option>
			
			
			
			



			
	</div>
	
	<div id="bouton">
		<button  href="">Rechercher</button>
	</div>
	
		<div id="Liste-Enchere">Afficher la liste des ench�res ici.</div>
	


</body>
</html>