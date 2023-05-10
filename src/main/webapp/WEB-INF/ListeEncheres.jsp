<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<jsp:include page="fragments/meta.html"></jsp:include>
<jsp:include page="fragments/HeaderConnected.jsp"></jsp:include>
</head>
<body>

	<h1>ENI-Enchères</h1>

	<h2>Liste des enchères</h2>
	
	

	<div id="ListeEnchere-Lien">
	
	<a href="${pageContext.request.contextPath}/Encherir" >Enchère	</a>
	<a href="${pageContext.request.contextPath}/NouvelleVente" >Vendre un article</a>	
	
			<form  method = "post" action="ListeEncheres">
					<button>Mon Profil	</button>
					<input type="hidden" value="${Id_Utils}" name="IDUtilisateur" id="IDUtilisateur"/> 
			</form>
		
	<a href="${pageContext.request.contextPath}/Accueil" >Déconnexion</a>
	</div>


	<div>
		<h3>Filtres :</h3>
		<input type="search" placeholder="Le nom de l'article contient"></input>

		<h3>Catégorie :</h3>

		<select name="categorie" id="categorie">
			<option value="all">Toutes</option>
			<option value="autres">Autres</option>
		</select> 
		<input type="radio" name="achatVente"> Achats</input>
		<div id="checkAchats">
			<input type="checkbox"> enchères ouvertes</input> <input
				type="checkbox"> mes enchères</input> <input type="checkbox">mes
			enchères reportées</input>
		</div>

		<input type="radio" name="achatVente"> Mes Ventes</input>
		<div id="checkVentes">
			<input type="checkbox" id="checkVenteEC"> mes ventes en cours</input>
			<input type="checkbox"> ventes non débutées</input> <input
				type="checkbox"> ventes terminées</input>
		</div>

		<button>Rechercher</button>

	</div>

	<div id="resultSearch">
	
		<div>
			<img></img>
			<h2>Pc Gamer</h2>
			<p>Prix : 210 Points</p>
			<p>Fin de l'enchère : 10/08/2018</p>>
			<br>
			<p>Vendeur : <p href ="">jojo44</p> </p>
		</div>
	
		<div>
			<img></img>
			<h2>Pc Gamer</h2>
			<p>Prix : 210 Points</p>
			<p>Fin de l'enchère : 10/08/2018</p>>
			<br>
			<p>Vendeur : <p href ="">jojo44</p> </p>
		</div>
	
	</div>

</body>
</html>