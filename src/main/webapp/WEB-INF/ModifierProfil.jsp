<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<jsp:include page="fragments/meta.html"></jsp:include>
<title>Modifier ou supprimer mon profil</title>
</head>
<body>
	<h1>ENI-Ench�res</h1>
	
	
	<div id="Titre-Centre">Mon Profil</div>


<div Id = "Inscription-Input">

Pseudo : <input type = "text"></input>		Nom : <input type = "text"></input>
<br>
Pr�nom : <input type = "text"></input>		Email : <input type = "text"></input>
<br>
T�l�phone : <input type = "text"></input>		Rue : <input type = "text"></input>
<br>
Code Postal : <input type = "text"></input>		Ville : <input type = "text"></input>
<br>
Mot de passe actuel : <input type = "password"></input>
<br>
Mot de passe : <input type = "password"></input>		Confirmation : <input type = ""password""></input>
<br>

Cr�dit : <!-- Afficher nombre cr�dit -->


</div>

<div id="Isncription-Button">

<button onclick = "window.location.href = '${pageContext.request.contextPath}/ListeEncheres'">Enregistrer</button> <button onclick = "window.location.href = '${pageContext.request.contextPath}/Accueil'">Supprimer</button>

</div>


</body>
</html>