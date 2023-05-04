<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<jsp:include page="fragments/meta.html"></jsp:include>
<link href="styles/style.css" rel="stylesheet" type="text/css">
<title>Inscription</title>
</head>
<body>
	<h1>ENI-Enchères</h1>
	
	
	<div id="Titre-Centre">Mon Profil</div>
<br>
<form action="Inscription" method ="post">
	<div Id = "Inscription-Input-gauche">
	Pseudo : <input type = "text" name = "pseudo" id="pseudo"></input>		
	<br>
	<br>
	Prénom : <input type = "text" name = "prenom" id="prenom"></input>		
	<br>
	<br>
	Téléphone : <input type = "text" name = "telephone" id="telephone"></input>		
	<br>
	<br>
	Code Postal : <input type = "text" name = "codePostal" id="codePostal"></input>		
	<br>
	<br>
	Mot de passe : <input type = "password" name = "password" id="password"></input>		
	<br>
	</div>
	<div Id = "Inscription-Input-droite">
	Nom : <input type = "text" name = "nom" id="nom"></input>
	<br>
	<br>
	
	Email : <input type = "text" name = "email" id="email"></input>
	<br>
	<br>
	
	Rue : <input type = "text" name = "rue" id="rue"></input>
	<br>
	<br>
	
	Ville : <input type = "text" name = "ville" id="ville"></input>
	<br>
	<br>
	
	Confirmation : <input type = "password" name = "passwordConfirmation" id="passwordConfirmation"></input>
	<br>
	
	</div>
	
	<div id="Inscription-Button">
	<br>
	<button>Créer</button>
	
	</div>
</form>

<button onclick = "window.location.href = '${pageContext.request.contextPath}/Accueil'">Annuler</button>

</body>
</html>