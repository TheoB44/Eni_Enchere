<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<jsp:include page="fragments/meta.html"></jsp:include>
<title>Accueil</title>
</head>
<body>
	<h1>ENI-Enchères</h1>

	<div id="Inscription-connexion" ><a href="${pageContext.request.contextPath}/Connexion" >S'inscrire - Se connecter</a></div>

	<div id="ListeEnchere-Lien">
		<a href="${pageContext.request.contextPath}/Encherir">Enchère </a> 
		<a href="${pageContext.request.contextPath}/NouvelleVente">Vendre un article</a>
			<form  method = "get" action="MonProfil">
				<button>Mon Profil	</button>
				<input type="hidden" value="${Id_Utils}" name="IDUtilisateur" id="IDUtilisateur"/> 
			</form>
		<a href="${pageContext.request.contextPath}/Accueil">Déconnexion</a>
	</div>


	<div id="Titre-Centre">Liste des enchères</div>

	<form class="justify-content-center" method="post" action="Accueil">
		<div>
			Filtres : <br>
			<div class="input-group">
				<input type="search" placeholder="Le nom de l'article contient"
					name="searchNomArticle"> <span class="input-group-append">
				</span>
			</div>
			<br> <br> Catégorie : <select name="categorieEnchere"
				id="categorieEnchere">
				<option value="all">Toutes</option>
				<c:forEach var="current" items="${listeCategories}">
					<option value="${current.no_categorie}">${current.libelle}</option>
				</c:forEach>
			</select>
		</div>

		<div id="bouton">
			<button>Rechercher</button>
		</div>
	</form>
	<br>

	<div class="row">

		<c:forEach var="current" items="${listeEncheres}">

			<div class="card" style="width: 18rem;">
				<img class="card-img-top" src="..." alt="Card image cap">
				<div class="card-body">
					<h6 class="card-title">${current.article.nom_article}</h6>
					<p class="card-text">Prix : ${current.montant_enchere} points</p>
					<p class="card-text">Fin de l'enchère :
						${current.article.date_fin_enchere}</p>
					Vendeur :<a href="#" class="card-text">
						${current.utilisateur.pseudo}</a>
				</div>
			</div>

		</c:forEach>

	</div>


</body>
</html>