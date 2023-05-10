<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<jsp:include page="fragments/meta.html"></jsp:include>
<jsp:include page="fragments/HeaderConnected.jsp"></jsp:include>
<title>Modifier ou supprimer mon profil</title>
</head>
<body>
	<h1>ENI-Enchères</h1>
	
	
	<div id="Titre-Centre">Mon Profil</div>

<form method = "post" action = "ModifierProfil">
<div Id = "Inscription-Input">

Pseudo : <input type = "text" name = "pseudo" id="pseudo"></input>		Nom : <input type = "text" name = "nom" id="nom"></input>
<br>
Prénom : <input type = "text" name = "prenom" id="prenom"></input>		Email : <input type = "text" name = "email" id="email"></input>
<br>
Téléphone : <input type = "text" name = "telephone" id="telephone"></input>		Rue : <input type = "text" name = "rue" id="rue"></input>
<br>
Code Postal : <input type = "text" name = "codePostal" id="codePostal"></input>		Ville : <input type = "text" name = "ville" id="ville"></input>
<br>
Mot de passe actuel : <input type = "password" name = "passwordActuel" id="passwordActuel"></input>
<br>
Mot de passe : <input type = "password" name = "passwordNew" id="passwordNew"></input>		Confirmation : <input type = "password" name = "passwordConfirmation" id="passwordConfirmation"></input>
<br>

Crédit : <!-- Afficher nombre crédit -->


</div>

	<div id="Isncription-Button">
	
	<button>Enregistrer</button> 
	
	</div>
</form>

<form method = "delete" action = "SupprimerProfil">
<button onclick = "window.location.href = '${pageContext.request.contextPath}/Accueil'">Supprimer</button>
</form>
</body>
</html>