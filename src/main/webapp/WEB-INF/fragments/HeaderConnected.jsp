<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<include page="fragments/meta.html"></include>

<div id="div-Header" name = "div-Header">

	<a href="Accueil"><image style ="width:100px;" src="$../../img/home.png" href="Accueil"></image></a>

		
	<div id="ListeEnchere-Lien">
				<table id = "Table-Bouton-Connecter" name = "Table-Bouton-Connecter" align="right">
					<tr>
						<td>
							<form method="get" action="NouvelleVente" name="NouvelleVente"
								id="NouvelleVente">
								<button class="btn btn-outline-dark">Vendre un article</button>
							</form>
						</td>
						<td>
							<form method="get" action="MonProfil" value="true" name="MyProfil"
								id="MyProfil">
								<button class="btn btn-outline-dark">Mon Profil</button>
								<input type="hidden" value="${Id_Utils}" name="IDUtilisateur"
									id="IDUtilisateur" />
							</form>
						</td>	
						<td>
							<form method="get" action="Deconnexion">
								<button class="btn btn-outline-dark">Deconnexion</button>
							</form>
						</td>
					</tr>
				</table>
			</div>
	
	</div>


</body>
</html>