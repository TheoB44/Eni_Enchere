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
	<div id="Titre-Centre">Mon Profil</div>


	<div id="Modification-input" style="float:left;">
		<div Id = "Inscription-Input" style="float:left;">
		
			Pseudo : <input type = "text" name = "pseudo" id="pseudo" style="float:right;"></input>		
			<br>
			<br>
			Prénom : <input type = "text" name = "prenom" id="prenom" style="float:right;"></input>		
			<br>
			<br>
			Téléphone : <input type = "text" name = "telephone" id="telephone" style="float:right;"></input>	
			<br>
			<br>	
			Code Postal : <input type = "text" name = "codePostal" id="codePostal" style="float:right;"></input>		
			<br>
			<br>
			Mot de passe actuel : <input type = "password" name = "passwordActuel" id="passwordActuel" style="float:right;"></input>
			<br>
			<br>
			Mot de passe : <input type = "password" name = "passwordNew" id="passwordNew" style="float:right;"></input>	
			<br>	
			<br>
			Crédit : ${ credit}	
		</div>
		
		<div Id = "Inscription-Input" style="float:right;   margin-left: 20px;">
		
			Nom : <input type = "text" name = "nom" id="nom" style="float:right;"></input>
			<br>
			<br>
			Email : <input type = "text" name = "email" id="email" style="float:right;"></input>
			<br>
			<br>
			Rue : <input type = "text" name = "rue" id="rue" style="float:right;"></input>
			<br>
			<br>
			Ville : <input type = "text" name = "ville" id="ville" style="float:right;"></input>
			<br>
			<br>
			<br>
			<br>
			Confirmation : <input type = "password" name = "passwordConfirmation" id="passwordConfirmation" style="float:right;"></input>

		</div>
		
		<br>
		<br>
		<br>
			<div id="Isncription-Button" style="float:left;">
				<br>
				<form method = "post" action = "ModifierProfil" style="float: left;">
					<button style="float:left;">Enregistrer</button> 
				</form>
				
				<form method = "delete" action = "SupprimerProfil" style="float: left; margin-left: 5px;">
					<button onclick = "window.location.href = '${pageContext.request.contextPath}/Accueil'" style="float:left;">Supprimer</button>
				</form>
			</div>
	</div>


</body>
</html>