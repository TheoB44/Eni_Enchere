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

<div Id = "Inscription-Input-gauche">
Pseudo : <input type = "text"></input>		
<br>
<br>
Prénom : <input type = "text"></input>		
<br>
<br>
Téléphone : <input type = "text"></input>		
<br>
<br>
Code Postal : <input type = "text"></input>		
<br>
<br>
Mot de passe : <input type = "password"></input>		
<br>
</div>
<div Id = "Inscription-Input-droite">
Nom : <input type = "text"></input>
<br>
<br>

Email : <input type = "text"></input>
<br>
<br>

Rue : <input type = "text"></input>
<br>
<br>

Ville : <input type = "text"></input>
<br>
<br>

Confirmation : <input type = "password"></input>
<br>

</div>

<div id="Inscription-Button">
<br>
<button honclick = "window.location.href = '${pageContext.request.contextPath}/ListeEncheres'">Créer</button> <button onclick = "window.location.href = '${pageContext.request.contextPath}/Accueil'">Annuler</button>

</div>


</body>
</html>